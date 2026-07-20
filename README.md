# Llanquihue Tour - Panel de Administración Integrado (EFT)

Sistema de gestión y administración para la agencia de turismo Llanquihue Tour. Este software ha sido desarrollado en Java (Swing) aplicando buenas prácticas de Programación Orientada a Objetos (POO), con un diseño enfocado en la modularidad, la reutilización de código, la persistencia en disco y la consistencia de datos a través de interfaces, polimorfismo y manejo de excepciones personalizadas.

---

## Arquitectura y Diseño de Software

El proyecto demuestra el uso avanzado de abstracciones y separación de responsabilidades en Java mediante los siguientes pilares de diseño:

### 1. La Interfaz (Registrable)
Establece un contrato de comportamiento para cualquier entidad que requiera ser reportada por el sistema.
* **Propósito:** Permite el tratamiento polimórfico en el motor de reportes y colecciones.
* **Clases que la implementan:** Guia, Vehiculo, Colaborador y la clase abstracta ServicioTuristico.
* **Método requerido:** `mostrarResumen()`.

### 2. La Clase Abstracta (ServicioTuristico)
Representa la identidad común de los servicios que ofrece la agencia (relación de herencia "es un...").
* **Propósito:** Agrupar atributos comunes (nombre, duracion, precio, Guia) y evitar la duplicación de código. No puede ser instanciada directamente.
* **Especializaciones (Subclases):** 
  * RutaGastronomica (añade cantidadParadas)
  * PaseoLacustre (añade tipoEmbarcacion)

### 3. Persistencia con Algoritmo de Doble Pasada (ManejadorArchivos)
Garantiza el almacenamiento continuo en el archivo local `datos_agencia.txt` y la reconstrucción exacta de objetos en memoria.
* **Primera Pasada:** Instancia las entidades independientes (`GUIA`, `VEHICULO`, `COLABORADOR`).
* **Segunda Pasada:** Lee los servicios (`RUTA_GASTRO`, `PASEO_LACUSTRE`), busca en memoria al guía correspondiente mediante su RUT y reconstruye la relación de composición de forma exacta.

### 4. Validaciones y Excepciones de Negocio (RutInvalidoException)
* **Validación por Regex:** La clase `Guia` valida el RUT mediante el patrón `^\d{7,8}-[0-9Kk]$`.
* **Control de Errores:** Si el formato es incorrecto, lanza `RutInvalidoException`, permitiendo que la interfaz gráfica detenga la operación y notifique al usuario sin interrumpir la ejecución del sistema.

---

## Estructura del Proyecto

El código está organizado bajo un patrón de arquitectura modular de 5 capas para independizar completamente la lógica de negocio, la persistencia y la interfaz gráfica:

```text
src/
├── model/                  # Capa de Modelo (Entidades de Negocio)
│   ├── Registrable.java          # Interfaz base polimorfica
│   ├── ServicioTuristico.java    # Clase abstracta principal
│   ├── RutaGastronomica.java     # Subclase de Servicio
│   ├── PaseoLacustre.java        # Subclase de Servicio
│   ├── Guia.java                 # Entidad independiente
│   ├── Vehiculo.java             # Entidad independiente
│   └── Colaborador.java          # Socio o proveedor externo
│
├── controller/             # Capa de Control y Lógica de Negocio
│   └── AgenciaGestor.java        # Administrador central de la coleccion en memoria
│
├── data/                   # Capa de Persistencia I/O
│   └── ManejadorArchivos.java    # Lectura y escritura en datos_agencia.txt
│
├── exception/              # Capa de Excepciones Personalizadas
│   └── RutInvalidoException.java # Excepcion verificada para validacion de RUT
│
└── ui/                     # Capa de Presentacion (Interfaz Grafica)
    └── VentanaApp.java           # GUI interactiva construida en Swing

Características Principales
Interfaz de Usuario Dinámica y Reactiva: Panel interactivo dividido en pestañas (JTabbedPane) para el registro en tiempo real de cada entidad:

Guías: Registro de personal interno con validación estricta de RUT y especialidad.

Vehículos: Control de flota terrestre con capacidad de pasajeros.

Servicios: Creación dinámica de rutas y paseos, con filtrado automático mediante instanceof para listar solo guías registrados en el selector.

Colaboradores: Registro de convenios con proveedores externos.

Consola Monitora en Tiempo Real: Panel inferior (JTextArea) que refresca y muestra automáticamente el contenido físico del archivo de datos tras cada operación de guardado.

Portabilidad y Estándar ASCII Universal: Todo el código fuente y sus cadenas internas están estandarizadas bajo caracteres ASCII puros. Esto previene errores de compilación (unmappable character for encoding) en cualquier sistema operativo o IDE.

Auto-Bootstrap de Datos de Prueba: Al ejecutar por primera vez, si el sistema no detecta el archivo datos_agencia.txt, autogenera un conjunto de datos iniciales ambientados en la cuenca del Lago Llanquihue (Frutillar, Puerto Varas, etc.).

Formato del Archivo de Persistencia (datos_agencia.txt)
Los datos se almacenan en texto plano utilizando el punto y coma (;) como delimitador de campos:

Plaintext
GUIA;15224311-K;Ana Maria Lopez;Gastronomica
VEHICULO;AB123CD;Mercedes Sprinter;19
COLABORADOR;76123456-1;Catering Sur;Alimentacion
RUTA_GASTRO;Kuchen Tour Frutillar;3;22000;15224311-K;4
PASEO_LACUSTRE;Navegacion Llanquihue;2;35000;15224311-K;Catamaran
Requisitos del Sistema
Java Development Kit (JDK): Versión 8 o superior.

Entorno de Desarrollo (IDE): NetBeans, Eclipse, IntelliJ IDEA o VS Code con soporte para Java.

Ejecución del Proyecto
Clone el repositorio o extraiga los archivos fuente.

Abra el proyecto en su IDE de preferencia.

Asegúrese de que la carpeta src esté configurada como raíz del código fuente (Source Root).

Compile y ejecute desde la clase principal:

javac ui/VentanaApp.java
java ui/VentanaApp

(Nota: En entornos IDE, simplemente busque la clase VentanaApp.java dentro del paquete ui, haga clic derecho y seleccione Run File).
