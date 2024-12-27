# Requisitos
- modulos de javafx (19 o 21) 

# Compilar
 javac --module-path "{ruta a modulos de javafx}" -d "{ruta a prestimo-out}" "{file1.java}" .. "{fileN.java}" "{ruta a module-info.java}"

# Ejecutar
 java --module-path "{ruta a modulos de javafx}" --module nombre_modulo/nombre_paquete.mainclass

