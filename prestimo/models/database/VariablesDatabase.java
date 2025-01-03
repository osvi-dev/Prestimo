package prestimo.models.database;

public class VariablesDatabase {

    private static final String DATABASE = System.getenv("DATABASE_NAME");
    private static final String USER = System.getenv("DATABASE_USER");
    private static final String PASSWORD = System.getenv("DATABASE_PASSWORD");

    public static String getDATABASE() {
        if (DATABASE == null) {
            throw new IllegalStateException("DATABASE_NAME no está configurado en el entorno");
        }
        return DATABASE;
    }

    public static String getUSER() {
        if (USER == null) {
            throw new IllegalStateException("DATABASE_USER no está configurado en el entorno");
        }
        return USER;
    }   

    public static String getPASSWORD() {
        if (PASSWORD == null) {
            throw new IllegalStateException("DATABASE_PASSWORD no está configurado en el entorno");
        }
        return PASSWORD;
    }
}
