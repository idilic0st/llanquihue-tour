# Llanquihue Tour App

## Descripción
Proyecto de la Semana 5 para la asignatura **Desarrollo Orientado a Objetos I**. La aplicación lee los datos de los tours desde un archivo de texto, los transforma en objetos dentro de un `ArrayList` y permite recorrerlos y filtrarlos en la consola.

## MEJORAS DE ESTA VERSIÓN

- Composición: Implementación de la clase Guia dentro de la clase Tour, reflejando una estructura de datos real.
- Robustez (try-catch): Incorporación de bloques try-catch para validar la integridad de los datos leídos del archivo, evitando errores críticos en tiempo de ejecución.
- Modularidad: Estructura organizada en paquetes funcionales según buenas prácticas de ingeniería de software.
- Documentación Técnica: Código documentado íntegramente mediante Javadoc para facilitar su mantenimiento y comprensión.

## Estructura de Carpetas
El proyecto está organizado de la siguiente manera:

```text
LlanquihueTourApp/
├── resources/
│   └── tours.txt       # Base de datos con información de Tours y Guías
└── src/
    ├── data/           # Motor de datos (Lectura y validación de archivos)
    │   └── GestorDatos.java
    ├── model/          # Entidades (Clases Tour.java y Guia.java)
    │   ├── Tour.java
    │   └── Guia.java
    └── ui/             # Interfaz (Clase principal de ejecución)
        └── Main.java

## Instrucciones para Ejecutar
1. Abre el proyecto en IntelliJ IDEA.
2. Ve a la ruta src/ui/ y abre Main.java.
3. Haz clic derecho en el codigo y selecciona Run 'Main.main()'.
4. Revisa los resultados en la consola de abajo.
