module prestimo{
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;
    
    exports prestimo.controllers; 
    exports prestimo.models.local;
    exports prestimo;
}