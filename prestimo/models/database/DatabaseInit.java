package prestimo.models.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 
 *  Esta clase hara la crecion de un objeto para inicar y cerrar la base de datos 
 */
public class DatabaseInit implements AutoCloseable {

    private final String url;
    private final String user;
    private final String password;
    private Connection connection;

    public DatabaseInit(String database, String user, String password) {
        if (database == null || user == null || password == null) {
            throw new IllegalArgumentException("Database, user, and password cannot be null");
        }
        this.url = "jdbc:postgresql://localhost:5432" + "/" + database;
        this.user = user;
        this.password = password;
    }

    /* 
    * Retorna un objeto de la clase Connection
    * que servira para la creacion de las distintas querys    
    */
    public Connection getConnection() {
        if (connection == null || isConnectionClosed()) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException("Failed to connect to the database: " + e.getMessage(), e);
            }
        }
        return connection;
    }

    /*
     * Metodo boolean que verifica si la conexion de la bd esta cerrada
     */
    public boolean isConnectionClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to check connection status: " + e.getMessage(), e);
        }
    }

    /*
     * Metodo heredado de la interfaz AutoCLoeable
     * para cerrar la conexion
     */
    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close database connection: " + e.getMessage());
            }
        }
    }
}
