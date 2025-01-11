#!/bin/bash
echo "Compilando el proyecto"

# Primero ejecutamos el primer comando

find . -name "*.java" | xargs javac  --module-path ~/JavaFX-21/javafx-sdk-21.0.5/lib:/prestimo/libs \
    --class-path  .:prestimo/views/styles \
    -d ../Prestimo-out


# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo -e "Compilación exitosa. \nEjecutando el programa..."
    # Ejecutar el programa
java --module-path ~/JavaFX-21/javafx-sdk-21.0.5/lib:../Prestimo-out:prestimo/libs \
     --class-path  .:prestimo/views/styles \
     --module prestimo/prestimo.Main
else
    echo "Error en la compilación. Revisar errores."
    exit 1
fi
