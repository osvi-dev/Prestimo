package prestimo.api_consultas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase que proporciona métodos para consultar el tipo de cambio actual de divisas
 * utilizando una API externa.
 */
public class Divisa {

    /**
     * URL de la API para consultar el tipo de cambio del dólar respecto al peso mexicano.
     */
    private static final String URL_PESO_MX = "https://mx.dolarapi.com/v1/cotizaciones/usd";

    /**
     * Obtiene el tipo de cambio actual del dólar respecto al peso mexicano desde la API.
     *
     * @return el tipo de cambio como un valor double.
     * @throws RuntimeException si ocurre un error durante la consulta o el procesamiento del JSON.
     */
    public static double obtenerPrecioDivisa() {
        try {
            String jsonResponse = hacerPeticion(new URL(URL_PESO_MX));
            return parsearDivisa(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el tipo de cambio");
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
     * Extrae el tipo de cambio desde una respuesta JSON.
     *
     * @param jsonResponse la respuesta en formato JSON como String.
     * @return el tipo de cambio como un valor double.
     * @throws RuntimeException si ocurre un error al procesar el JSON.
     */
    private static double parsearDivisa(String jsonResponse) {
        try {
            // Buscamos el campo "compra" y su valor
            int compraIndex = jsonResponse.indexOf("\"compra\":") + 10;
            // Buscamos la siguiente coma o cierre de llave
            int endIndex = jsonResponse.indexOf(",", compraIndex);
            if (endIndex == -1) {
                endIndex = jsonResponse.indexOf("}", compraIndex);
            }
            // Extraemos el valor y lo convertimos a double
            String precioStr = jsonResponse.substring(compraIndex, endIndex).trim();
            return Double.parseDouble(precioStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al parsear el JSON: " + jsonResponse);
        }
    }
}
