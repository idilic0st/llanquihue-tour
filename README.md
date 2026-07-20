# Sistema de Gestión Turística - Llanquihue Tour

Aplicación de escritorio desarrollada en **Java (Swing)** para la administración centralizada de guías, vehículos, colaboradores externos y servicios turísticos de la agencia *Llanquihue Tour*.

El proyecto está diseñado bajo el paradigma de **Programación Orientada a Objetos (POO)** y organizado en una arquitectura modular de 5 capas.

---

##  Estructura del Proyecto

El código está dividido en 5 paquetes independientes para mantener una clara separación de responsabilidades:

* `model`: Define la interfaz `Registrable` y las clases de dominio (`Guia`, `Vehiculo`, `Colaborador`, `RutaGastronomica`, `PaseoLacustre`).
* `controller`: Contiene `AgenciaGestor`, encargada de administrar la lista centralizada de entidades en memoria.
* `data`: Contiene `ManejadorArchivos`, la clase utilitaria para la lectura y escritura del archivo `.txt`.
* `exception`: Define `RutInvalidoException` para el control de errores de formato en datos de entrada.
* `ui`: Contiene `VentanaApp`, la interfaz gráfica desarrollada con componentes Java Swing.

---

## ⚙️ Soluciones Técnicas Implementadas

### 1. Persistencia mediante Algoritmo de Doble Pasada
Para mantener relaciones de composición entre objetos (asociar un servicio a un guía real) sin usar una base de datos relacional, `ManejadorArchivos` realiza dos lecturas al archivo `datos_agencia.txt`:
1. **Primera Pasada:** Lee e instancia las entidades independientes (`GUIA`, `VEHICULO`, `COLABORADOR`).
2. **Segunda Pasada:** Lee los servicios (`RUTA_GASTRO`, `PASEO_LACUSTRE`), busca en memoria al guía correspondiente mediante su RUT y reconstruye la relación.

### 2. Validación de RUT con Expresión Regular
La clase `Guia` valida el formato del RUT mediante la expresión regular `^\d{7,8}-[0-9Kk]$`. Si el formato es incorrecto, el constructor lanza la excepción verificada `RutInvalidoException`, permitiendo que la interfaz gráfica capture el error y muestre una alerta sin interrumpir la ejecución.

### 3. Interfaz Gráfica Dinámica (Swing)
* **Filtrado dinámico:** El selector de guías asignables filtra la lista general en memoria utilizando el operador `instanceof Guia`.
* **Formulario adaptativo:** Los campos del formulario ajustan sus etiquetas en tiempo real según el servicio seleccionado en el menú desplegable.
* **Monitor en tiempo real:** Un área de texto (`JTextArea`) muestra el contenido actualizado del archivo de datos en cada operación de guardado.

---

##  Formato del Archivo de Datos (`datos_agencia.txt`)

Los datos se almacenan en texto plano separados por punto y coma (`;`):

```text
GUIA;15224311-K;Ana Maria Lopez;Gastronomica
VEHICULO;AB123CD;Mercedes Sprinter;19
COLABORADOR;76123456-1;Catering Sur;Alimentacion
RUTA_GASTRO;Kuchen Tour Frutillar;3;22000;15224311-K;4

##  Compilación y Ejecución
Clonar o descargar el proyecto.

Abrir en NetBeans, Eclipse o IntelliJ IDEA configurando la carpeta src como raíz de fuentes.

Ejecutar la clase principal:

Plaintext
ui.VentanaApp
(Nota: Si el archivo datos_agencia.txt no existe al iniciar, el sistema lo creará automáticamente con registros de prueba).
