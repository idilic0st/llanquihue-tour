# Llanquihue Tour - Panel de Administración Integrado

Sistema de gestión y administración para la agencia de turismo Llanquihue Tour. Este software ha sido desarrollado en Java (Swing) aplicando buenas prácticas de Programación Orientada a Objetos (POO), con un diseño enfocado en la modularidad, la reutilización de código y la consistencia de datos a través de interfaces y polimorfismo.

---

## Arquitectura y Diseño de Software

El proyecto demuestra el uso avanzado de abstracciones en Java mediante la implementación de dos conceptos fundamentales de la POO:

### 1. La Interfaz (Registrable)
Establece un contrato de comportamiento para cualquier entidad que requiera ser reportada por el sistema.
* **Propósito:** Permite el tratamiento polimórfico en el motor de reportes.
* **Clases que la implementan:** Guia, Vehiculo, ColaboradorExterno y la clase abstracta ServicioTuristico.
* **Método requerido:** mostrarResumen().

### 2. La Clase Abstracta (ServicioTuristico)
Representa la identidad común y el "ADN" de los servicios que ofrece la agencia (relación de herencia "es un...").
* **Propósito:** Agrupar atributos comunes (nombre, duracion, precio, Guia) y evitar la duplicación de código. No puede ser instanciada directamente.
* **Especializaciones (Subclases):** 
  * RutaGastronomica (añade cantidadParadas)
  * PaseoLacustre (añade tipoEmbarcacion)
  * ExcursionCultural (añade lugarHistorico)

---

## Estructura del Proyecto

El código está organizado bajo el patrón de diseño multicapa para separar la lógica de negocio de la interfaz de usuario:

```text
src/
├── model/                  # Capa de Modelo (Entidades de Negocio)
│   ├── Registrable.java          # Interfaz base
│   ├── ServicioTuristico.java    # Clase abstracta principal
│   ├── RutaGastronomica.java     # Subclase de Servicio
│   ├── PaseoLacustre.java        # Subclase de Servicio
│   ├── ExcursionCultural.java    # Subclase de Servicio
│   ├── Guia.java                 # Entidad independiente
│   ├── Vehiculo.java             # Entidad independiente
│   └── ColaboradorExterno.java   # Socio o proveedor externo
│
├── data/                   # Capa de Datos y Control
│   └── GestorEntidades.java      # Manejo de colecciones y reportes polimórficos
│
└── ui/                     # Capa de Presentación (Interfaz Gráfica)
    └── VentanaApp.java           # GUI interactiva construida en Swing
```

---

## Características Principales

* **Interfaz de Usuario Dinámica:** Panel interactivo dividido en 4 pestañas (JTabbedPane) que permite registrar en tiempo real cada una de las entidades del modelo de negocios:
  1. **Guías:** Registro de personal interno con su respectiva especialidad.
  2. **Vehículos:** Control de flota terrestre con validación de capacidad de pasajeros.
  3. **Servicios:** Creación dinámica de rutas, paseos y excursiones con asignación directa de guías registrados.
  4. **Socios Externos:** Registro y control de tarifas de convenios con terceros (ej. transporte fluvial, catering).
* **Validación Robusta y Control de Excepciones:** Los campos críticos como tarifas, precios, duración y capacidades cuentan con bloques try-catch para interceptar errores de formato (NumberFormatException) y asegurar que los valores ingresados sean lógicos.
* **Consola de Reportes Polimórficos:** Un motor centralizado recorre una sola lista genérica de tipo Registrable, invocando el método de manera dinámica y generando un reporte clasificado por categorías en tiempo real.
* **Persistencia en Memoria:** El sistema se inicializa con datos de prueba realistas basados en la geografía y oferta de la cuenca del Lago Llanquihue (Frutillar, Río Maullín, etc.).

---

## Requisitos del Sistema

* **Java Development Kit (JDK):** Versión 8 o superior.
* **Entorno de Desarrollo (IDE):** NetBeans, Eclipse, IntelliJ IDEA o VS Code con soporte para Java.

---

## Ejecución del Proyecto

1. Clone el repositorio o descargue los archivos fuente.
2. Abra el proyecto en su IDE de preferencia.
3. Asegúrese de que la estructura de carpetas coincida con la declaración de paquetes (model, data, ui).
4. Compile y ejecute el archivo principal:
   ```bash
   javac ui/VentanaApp.java
   java ui/VentanaApp
   ```
*(Nota: Si utiliza un IDE, simplemente localice la clase VentanaApp.java, haga clic derecho y seleccione Run).*
