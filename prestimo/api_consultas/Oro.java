package prestimo.api_consultas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase que proporciona métodos para consultar el precio actual del oro en onzas
 * a través de una API externa.
 */
public class Oro {

    /**
     * URL de la API para consultar el precio del oro.
     */
    private static final String URL_ORO = "https://api.gold-api.com/price/XAU";

    /**
     * Obtiene el precio actual del oro por onza desde la API.
     *
     * @return el precio del oro en onzas como un valor double ya en pesos mexicanos.
     * @throws RuntimeException si ocurre un error durante la consulta o el procesamiento del JSON.
     */
    public static double obtenerPrecioOnza() {
        try {
            String jsonResponse = hacerPeticion(new URL(URL_ORO));
            return parsearPrecioOnza(jsonResponse) * Divisa.obtenerPrecioDivisa();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el precio del oro");
        }
    }

    /**
     * Realiza una petición HTTP GET a la URL proporcionada y devuelve la respuesta como una cadena JSON.
     *
     * @param url el objeto URL que representa la dirección de la API.
     * @return la respuesta de la API en formato JSON como un String.
     * @throws RuntimeException si ocurre un error durante la conexión o la lectura de datos.
     */
    private static String hacerPeticion(URL url) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            InputStream inputStream = (responseCode == HttpURLConnection.HTTP_OK)
                    ? connection.getInputStream()
                    : connection.getErrorStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al hacer la petición");
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * Extrae el precio del oro en onzas desde una respuesta JSON.
     *
     * @param jsonResponse la respuesta en formato JSON como String.
     * @return el precio del oro en onzas como un valor double.
     * @throws RuntimeException si ocurre un error al procesar el JSON.
     */
    private static double parsearPrecioOnza(String jsonResponse) {
        try {
            int priceIndex = jsonResponse.indexOf("\"price\":") + 8;
            int endIndex = jsonResponse.indexOf(",", priceIndex);
            if (endIndex == -1) {
                endIndex = jsonResponse.indexOf("}", priceIndex);
            }
            return Double.parseDouble(jsonResponse.substring(priceIndex, endIndex));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al parsear el JSON: " + jsonResponse);
        }
    }
}
