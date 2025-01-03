package prestimo.models.database;

public class VariablesDatabase {
    /* TODO: Me precoupa la parte de la seguridad */

    private static final String DATABASE = "Local";
    private static final String USER = "postgres";
    private static final String PASSWORD = "top 123";

    public static String getDATABASE() {
        return DATABASE;
    }

    public static String getUSER() {
        return USER;
    }   

    public static String getPASSWORD() {
        return PASSWORD;
    }
    
}
