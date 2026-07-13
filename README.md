# LlanquihueTourApp - Sistema de Gestión de Servicios Turísticos

Este proyecto es una aplicación de consola en Java diseñada para digitalizar, estructurar y automatizar las operaciones de la agencia de turismo **Llanquihue Tour**. El sistema permite procesar datos estructurados, manejar colecciones en memoria y clasificar dinámicamente los servicios ofrecidos empleando los pilares de la Programación Orientada a Objetos (POO).

## Objetivo de la Semana 7
El objetivo principal de esta etapa consiste en implementar principios de **Polimorfismo Dinámico** y la manipulación de **Colecciones Genéricas** dentro del sistema. Se busca almacenar los diferentes tipos de servicios turísticos dentro de una estructura lineal de tipo `List`, recorriendo la colección mediante un bucle `for-each` para invocar comportamientos especializados desde referencias de la superclase. Adicionalmente, se mantienen y adaptan los filtros de búsqueda lógica y segmentación numérica para operar sobre la nueva estructura genérica.

---

## Estructura del Proyecto y Clases Creadas
El código fuente se organiza de manera lógica y modular dividiéndose en paquetes según su responsabilidad:

### 1. Paquete `model/` (Capa de Dominio y Jerarquía)
* **`Guia.java`**: Representa al guía de turismo con sus atributos base (`rut`, `nombre`, `especialidad`). Es utilizado como componente dentro de los servicios mediante composición.
* **`ServicioTuristico.java` (Superclase)**: Contiene la información básica común compartida por todos los servicios: `nombre`, `duracionHoras`, `precio` y un objeto `guiaAsignado`. Incorpora el método polimórfico base `mostrarInformacion()`.
* **`RutaGastronomica.java` (Subclase)**: Extiende de `ServicioTuristico`, añade el atributo específico `numeroDeParadas` y sobrescribe el método `mostrarInformacion()` para exponer el detalle completo de su categoría.
* **`PaseoLacustre.java` (Subclase)**: Extiende de `ServicioTuristico`, añade el atributo específico `tipoEmbarcacion` y sobrescribe el método `mostrarInformacion()` para exponer el detalle completo de su categoría.
* **`ExcursionCultural.java` (Subclase)**: Extiende de `ServicioTuristico`, añade el atributo específico `lugarHistorico` y sobrescribe el método `mostrarInformacion()` para exponer el detalle completo de su categoría.

*Nota: Todas las subclases reutilizan el constructor del padre mediante la instrucción `super(...)` y redefinen el comportamiento de visualización mediante la anotación `@Override`.*

### 2. Paquete `data/` (Capa de Persistencia y Datos Internos)
* **`GestorServicios.java`**: Encargado de centralizar el almacenamiento de los datos utilizando la colección genérica `List<ServicioTuristico>`. Instancia y añade de forma automatizada un mínimo de 5 objetos de prueba combinando equilibradamente las diferentes subclases de la jerarquía para simular la persistencia de la agencia.

### 3. Paquete `ui/` (Capa de Interfaz de Usuario)
* **`Main.java`**: Clase de arranque principal. Recupera la colección polimórfica desde el gestor de servicios y ejecuta consecutivamente el listado polimórfico general, la búsqueda automatizada por coincidencia de texto (guías específicos) y la segmentación numérica (filtrado por umbrales de precio).

---

## Requisitos del Sistema
* **Java Development Kit (JDK)**: Versión 11 o superior.
* **Entorno de Desarrollo (IDE)**: IntelliJ IDEA, Eclipse, NetBeans o VS Code.
* **Colecciones**: Uso exclusivo de estructuras genéricas del entorno de ejecución de Java (`java.util.List` / `java.util.ArrayList`).

---

## Instrucciones para Ejecutar el Programa

1. **Compilar el Proyecto**:
   A través de tu terminal de comandos desde la raíz del directorio `src/` o mediante las herramientas de compilación de tu IDE:
   ```bash
   javac ui/Main.java data/GestorServicios.java model/*.java

   Ejecutar la Clase Main:
1. Lanza la aplicación ejecutando la interfaz desde la consola del sistema:

Bash
java ui.Main

2. Resultados en Consola:
Al ejecutarse correctamente, el sistema mostrará de forma secuencial:
El listado general polimórfico invocando dinámicamente el método mostrarInformacion() para cada uno de los 5 servicios de prueba.
La lista filtrada de servicios asignados exclusivamente al guía especificado (ej: Juan Pérez).
La filtración automatizada de aquellos servicios cuyos costos superan el límite establecido de $30.000.
