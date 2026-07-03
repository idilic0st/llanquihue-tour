# LlanquihueTourApp - Sistema de Gestión de Servicios Turísticos

Este proyecto es una aplicación de consola en Java diseñada para digitalizar, estructurar y automatizar las operaciones de la agencia de turismo **Llanquihue Tour**. El sistema permite procesar datos externos, manejar excepciones en tiempo de ejecución y clasificar dinámicamente los servicios ofrecidos empleando los pilares de la Programación Orientada a Objetos (POO).

## Objetivo de la Semana 6
El objetivo principal de esta etapa consiste en modelar y representar jerárquicamente los distintos servicios turísticos que ofrece la agencia mediante **Herencia Simple** y **Composición entre clases**. Con esto se logra centralizar los atributos comunes en una superclase y especializar el comportamiento en subclases específicas, integrando esta arquitectura con el motor de persistencia y lectura de archivos de texto plano (`.txt`) construido previamente.

---

## Estructura del Proyecto y Clases Creadas
El código fuente se organiza de manera lógica y modular dividiéndose en paquetes según su responsabilidad:

### 1. Paquete `model/` (Capa de Dominio y Jerarquía)
* **`Guia.java`**: Representa al guía de turismo con sus atributos base (`rut`, `nombre`, `especialidad`). Es utilizado como componente dentro de los servicios.
* **`ServicioTuristico.java` (Superclase)**: Contiene la información básica común compartida por todos los servicios de la agencia: `nombre`, `duracionHoras`, `precio` y un objeto `guiaAsignado` (aplicando el concepto de **Composición**).
* **`RutaGastronomica.java` (Subclase)**: Extiende de `ServicioTuristico` y especializa la categoría incorporando el atributo específico `numeroDeParadas`.
* **`PaseoLacustre.java` (Subclase)**: Extiende de `ServicioTuristico` y especializa la categoría incorporando el atributo específico `tipoEmbarcacion`.
* **`ExcursionCultural.java` (Subclase)**: Extiende de `ServicioTuristico` y especializa la categoría incorporando el atributo específico `lugarHistorico`.

*Nota: Todas las subclases reutilizan el constructor del padre mediante la instrucción `super(...)` y sobrescriben el método `toString()` de forma personalizada para exponer su información completa.*

### 2. Paquete `data/` (Capa de Persistencia)
* **`GestorDatos.java`**: Encargado de la persistencia interna. Utiliza flujos de lectura (`BufferedReader` / `FileReader`) y deserializa el archivo plano línea por línea. Implementa condicionales lógicos para evaluar la columna de categoría e instanciar dinámicamente la subclase correspondiente en memoria, resguardando la estabilidad del flujo mediante capturas robustas de errores (`try-catch`).

### 3. Paquete `ui/` (Capa de Interfaz de Usuario)
* **`Main.java`**: Clase de arranque principal. Coordina la carga de datos mediante el gestor, despliega el listado polimórfico general, ejecuta filtros automáticos por coincidencia de texto (búsqueda de guías específicos) y realiza segmentaciones numéricas (filtrado por umbrales de precio).

---

## Requisitos del Sistema
* **Java Development Kit (JDK)**: Versión 11 o superior.
* **Entorno de Desarrollo (IDE)**: IntelliJ IDEA, Eclipse, NetBeans o VS Code.
* **Persistencia**: Archivo plano estructurado con extensión `.txt`.

---

## Instrucciones para Ejecutar el Programa

1. **Configurar el Archivo de Origen**:
   Asegúrate de tener creado tu archivo de origen en la ruta relativa del proyecto:
   `resources/tours.txt`
   
   Este archivo debe seguir la estructura delimitada por punto y coma (`;`), por ejemplo:
   ```text
   Kuchen Tour Frutillar;Gastronomico;25000;15443221-K;Ana María López;Gastronomía
   Vuelta al Lago;Lacustre;45000;18765432-1;Carlos Plaza;Navegaciónin.main()'.
4. Revisa los resultados en la consola de abajo.
