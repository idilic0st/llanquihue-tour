package ui;

import data.GestorEntidades;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaApp extends JFrame {
    private GestorEntidades gestor;

    // Elementos de la consola de visualización
    private JTextArea txtAreaReporte;
    private JButton btnActualizar;

    // Componentes: Registro de Guía
    private JTextField txtGuiaRut;
    private JTextField txtGuiaNombre;
    private JTextField txtGuiaEspecialidad;
    private JButton btnRegistrarGuia;

    // Componentes: Registro de Vehículo
    private JTextField txtVehiculoPatente;
    private JTextField txtVehiculoModelo;
    private JTextField txtVehiculoCapacidad;
    private JButton btnRegistrarVehiculo;

    // Componentes: Registro de Servicio Turístico
    private JComboBox<String> comboTipoServicio;
    private JTextField txtServicioNombre;
    private JTextField txtServicioDuracion;
    private JTextField txtServicioPrecio;
    private JLabel lblAtributoEspecífico;
    private JTextField txtServicioAtributo;
    private JComboBox<Guia> comboGuias;
    private JButton btnRegistrarServicio;

    // Componentes: Registro de Colaborador Externo (¡Rescatado!)
    private JTextField txtColabNombre;
    private JTextField txtColabRubro;
    private JTextField txtColabTarifa;
    private JButton btnRegistrarColab;

    public VentanaApp() {
        gestor = new GestorEntidades();
        configurarVentana();
        inicializarComponentes();
        inicializarDatosPrueba();
        actualizarComboGuias();
        actualizarConsolaTexto();
    }

    private void configurarVentana() {
        setTitle("Llanquihue Tour - Panel de Administración Integrado");
        setSize(1020, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    private void inicializarComponentes() {
        // Panel Izquierdo: Pestañas para Formularios de Registro
        JTabbedPane pestañasFormularios = new JTabbedPane();
        pestañasFormularios.setPreferredSize(new Dimension(440, 600));

        // Pestaña 1: Registro de Guías
        JPanel panelGuia = new JPanel(new GridLayout(4, 2, 8, 8));
        panelGuia.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelGuia.add(new JLabel("RUT del Guía:"));
        txtGuiaRut = new JTextField();
        panelGuia.add(txtGuiaRut);
        panelGuia.add(new JLabel("Nombre Completo:"));
        txtGuiaNombre = new JTextField();
        panelGuia.add(txtGuiaNombre);
        panelGuia.add(new JLabel("Especialidad:"));
        txtGuiaEspecialidad = new JTextField();
        panelGuia.add(txtGuiaEspecialidad);
        btnRegistrarGuia = new JButton("Registrar Guía");
        panelGuia.add(new JLabel());
        panelGuia.add(btnRegistrarGuia);
        pestañasFormularios.addTab("Guías", panelGuia);

        // Pestaña 2: Registro de Vehículos
        JPanel panelVehiculo = new JPanel(new GridLayout(4, 2, 8, 8));
        panelVehiculo.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelVehiculo.add(new JLabel("Patente del Vehículo:"));
        txtVehiculoPatente = new JTextField();
        panelVehiculo.add(txtVehiculoPatente);
        panelVehiculo.add(new JLabel("Modelo / Marca:"));
        txtVehiculoModelo = new JTextField();
        panelVehiculo.add(txtVehiculoModelo);
        panelVehiculo.add(new JLabel("Capacidad Pasajeros:"));
        txtVehiculoCapacidad = new JTextField();
        panelVehiculo.add(txtVehiculoCapacidad);
        btnRegistrarVehiculo = new JButton("Registrar Vehículo");
        panelVehiculo.add(new JLabel());
        panelVehiculo.add(btnRegistrarVehiculo);
        pestañasFormularios.addTab("Vehículos", panelVehiculo);

        // Pestaña 3: Registro de Servicios Turísticos
        JPanel panelServicio = new JPanel(new GridLayout(7, 2, 8, 8));
        panelServicio.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panelServicio.add(new JLabel("Tipo de Servicio:"));
        comboTipoServicio = new JComboBox<>(new String[]{"Ruta Gastronómica", "Paseo Lacustre", "Excursión Cultural"});
        panelServicio.add(comboTipoServicio);

        panelServicio.add(new JLabel("Nombre Servicio:"));
        txtServicioNombre = new JTextField();
        panelServicio.add(txtServicioNombre);

        panelServicio.add(new JLabel("Duración (Horas):"));
        txtServicioDuracion = new JTextField();
        panelServicio.add(txtServicioDuracion);

        panelServicio.add(new JLabel("Precio (CLP):"));
        txtServicioPrecio = new JTextField();
        panelServicio.add(txtServicioPrecio);

        lblAtributoEspecífico = new JLabel("Número de Paradas:");
        panelServicio.add(lblAtributoEspecífico);
        txtServicioAtributo = new JTextField();
        panelServicio.add(txtServicioAtributo);

        panelServicio.add(new JLabel("Guía Responsable:"));
        comboGuias = new JComboBox<>();
        panelServicio.add(comboGuias);

        btnRegistrarServicio = new JButton("Registrar Servicio");
        panelServicio.add(new JLabel());
        panelServicio.add(btnRegistrarServicio);
        pestañasFormularios.addTab("Servicios", panelServicio);

        // Pestaña 4: Registro de Socios/Colaboradores Externos (¡NUEVO!)
        JPanel panelColaborador = new JPanel(new GridLayout(4, 2, 8, 8));
        panelColaborador.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelColaborador.add(new JLabel("Nombre Empresa:"));
        txtColabNombre = new JTextField();
        panelColaborador.add(txtColabNombre);
        panelColaborador.add(new JLabel("Rubro o Servicio:"));
        txtColabRubro = new JTextField();
        panelColaborador.add(txtColabRubro);
        panelColaborador.add(new JLabel("Tarifa Convenio ($):"));
        txtColabTarifa = new JTextField();
        panelColaborador.add(txtColabTarifa);
        btnRegistrarColab = new JButton("Registrar Colaborador");
        panelColaborador.add(new JLabel());
        panelColaborador.add(btnRegistrarColab);
        pestañasFormularios.addTab("Socios Externos", panelColaborador);

        // Panel Derecho: Consola de Visualización
        JPanel panelConsola = new JPanel(new BorderLayout(5, 5));
        panelConsola.setBorder(BorderFactory.createTitledBorder("Consola de Operaciones de Llanquihue Tour"));

        txtAreaReporte = new JTextArea();
        txtAreaReporte.setEditable(false);
        txtAreaReporte.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtAreaReporte);
        panelConsola.add(scrollPane, BorderLayout.CENTER);

        btnActualizar = new JButton("Sincronizar Datos");
        panelConsola.add(btnActualizar, BorderLayout.SOUTH);

        add(pestañasFormularios, BorderLayout.WEST);
        add(panelConsola, BorderLayout.CENTER);

        // --- LÓGICA DE CONTROLADORES Y ACCIONES ---

        // Dinamismo del atributo específico de servicios
        comboTipoServicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) comboTipoServicio.getSelectedItem();
                if ("Ruta Gastronómica".equals(seleccion)) {
                    lblAtributoEspecífico.setText("Número de Paradas:");
                } else if ("Paseo Lacustre".equals(seleccion)) {
                    lblAtributoEspecífico.setText("Tipo Embarcación:");
                } else if ("Excursión Cultural".equals(seleccion)) {
                    lblAtributoEspecífico.setText("Lugar Histórico:");
                }
            }
        });

        // Registrar Guía
        btnRegistrarGuia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rut = txtGuiaRut.getText().trim();
                String nombre = txtGuiaNombre.getText().trim();
                String esp = txtGuiaEspecialidad.getText().trim();

                if (rut.isEmpty() || nombre.isEmpty() || esp.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaApp.this, "Por favor, complete todos los campos del guía.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                gestor.agregarEntidad(new Guia(rut, nombre, esp));
                JOptionPane.showMessageDialog(VentanaApp.this, "Guía registrado correctamente.");
                limpiarCamposGuia();
                actualizarComboGuias();
                actualizarConsolaTexto();
            }
        });

        // Registrar Vehículo
        btnRegistrarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patente = txtVehiculoPatente.getText().trim();
                String modelo = txtVehiculoModelo.getText().trim();
                String capStr = txtVehiculoCapacidad.getText().trim();

                if (patente.isEmpty() || modelo.isEmpty() || capStr.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaApp.this, "Por favor, complete todos los campos del vehículo.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int capacidad = Integer.parseInt(capStr);
                    if (capacidad <= 0) {
                        JOptionPane.showMessageDialog(VentanaApp.this, "La capacidad debe ser un número positivo.", "Error de Valor", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    gestor.agregarEntidad(new Vehiculo(patente, modelo, capacidad));
                    JOptionPane.showMessageDialog(VentanaApp.this, "Vehículo registrado en la flota con éxito.");
                    limpiarCamposVehiculo();
                    actualizarConsolaTexto();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaApp.this, "La capacidad debe ser un valor numérico entero.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Registrar Servicio Turístico
        btnRegistrarServicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) comboTipoServicio.getSelectedItem();
                String nombre = txtServicioNombre.getText().trim();
                String duracionStr = txtServicioDuracion.getText().trim();
                String precioStr = txtServicioPrecio.getText().trim();
                String atributo = txtServicioAtributo.getText().trim();
                Guia guiaSeleccionado = (Guia) comboGuias.getSelectedItem();

                if (nombre.isEmpty() || duracionStr.isEmpty() || precioStr.isEmpty() || atributo.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaApp.this, "Complete todos los campos del servicio.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int duracion = Integer.parseInt(duracionStr);
                    int precio = Integer.parseInt(precioStr);
                    if (duracion <= 0 || precio <= 0) {
                        JOptionPane.showMessageDialog(VentanaApp.this, "Duración y precio deben ser mayores a cero.", "Error de Valor", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    Registrable nuevoServicio = null;

                    if ("Ruta Gastronómica".equals(tipo)) {
                        int paradas = Integer.parseInt(atributo);
                        nuevoServicio = new RutaGastronomica(nombre, duracion, precio, guiaSeleccionado, paradas);
                    } else if ("Paseo Lacustre".equals(tipo)) {
                        nuevoServicio = new PaseoLacustre(nombre, duracion, precio, guiaSeleccionado, atributo);
                    } else if ("Excursión Cultural".equals(tipo)) {
                        nuevoServicio = new ExcursionCultural(nombre, duracion, precio, guiaSeleccionado, atributo);
                    }

                    if (nuevoServicio != null) {
                        gestor.agregarEntidad(nuevoServicio);
                        JOptionPane.showMessageDialog(VentanaApp.this, "Servicio registrado correctamente.");
                        limpiarCamposServicio();
                        actualizarConsolaTexto();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaApp.this, "Verifique que los valores numéricos ingresados sean correctos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Registrar Colaborador Externo (¡NUEVO!)
        btnRegistrarColab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtColabNombre.getText().trim();
                String rubro = txtColabRubro.getText().trim();
                String tarifaStr = txtColabTarifa.getText().trim();

                if (nombre.isEmpty() || rubro.isEmpty() || tarifaStr.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaApp.this, "Por favor, complete todos los campos del colaborador.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int tarifa = Integer.parseInt(tarifaStr);
                    if (tarifa <= 0) {
                        JOptionPane.showMessageDialog(VentanaApp.this, "La tarifa convenio debe ser un número positivo.", "Error de Valor", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    gestor.agregarEntidad(new ColaboradorExterno(nombre, rubro, tarifa));
                    JOptionPane.showMessageDialog(VentanaApp.this, "Socio externo registrado con éxito.");
                    limpiarCamposColaborador();
                    actualizarConsolaTexto();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaApp.this, "La tarifa debe ser un número entero válido (sin puntos ni símbolos).", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Botón Sincronizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarConsolaTexto();
            }
        });
    }

    private void inicializarDatosPrueba() {
        Guia guiaAna = new Guia("15.224.311-K", "Ana María López", "Gastronomía");
        Guia guiaCarlos = new Guia("18.765.432-1", "Carlos Plaza", "Navegación");

        gestor.agregarEntidad(guiaAna);
        gestor.agregarEntidad(guiaCarlos);

        gestor.agregarEntidad(new RutaGastronomica("Kuchen Tour Frutillar", 3, 22000, guiaAna, 4));
        gestor.agregarEntidad(new PaseoLacustre("Navegación Río Maullín", 2, 35000, guiaCarlos, "Lancha a Motor"));
        gestor.agregarEntidad(new PaseoLacustre("Vuelta al Lago Llanquihue", 4, 45000, guiaCarlos, "Catamarán"));
        gestor.agregarEntidad(new ExcursionCultural("Teatro del Lago e Historia", 2, 15000, guiaAna, "Frutillar Bajo"));

        gestor.agregarEntidad(new Vehiculo("HGDF-44", "Mercedes Benz Sprinter", 17));
        gestor.agregarEntidad(new ColaboradorExterno("Transportes del Lago S.A.", "Traslados Fluviales", 75000));
    }

    private void actualizarComboGuias() {
        comboGuias.removeAllItems();
        comboGuias.addItem(null);
        for (Registrable r : gestor.getListaEntidades()) {
            if (r instanceof Guia) {
                comboGuias.addItem((Guia) r);
            }
        }
    }

    private void actualizarConsolaTexto() {
        txtAreaReporte.setText(gestor.generarReporteDiferenciado());
    }

    private void limpiarCamposGuia() {
        txtGuiaRut.setText("");
        txtGuiaNombre.setText("");
        txtGuiaEspecialidad.setText("");
    }

    private void limpiarCamposVehiculo() {
        txtVehiculoPatente.setText("");
        txtVehiculoModelo.setText("");
        txtVehiculoCapacidad.setText("");
    }

    private void limpiarCamposServicio() {
        txtServicioNombre.setText("");
        txtServicioDuracion.setText("");
        txtServicioPrecio.setText("");
        txtServicioAtributo.setText("");
        comboTipoServicio.setSelectedIndex(0);
        comboGuias.setSelectedIndex(0);
    }

    private void limpiarCamposColaborador() {
        txtColabNombre.setText("");
        txtColabRubro.setText("");
        txtColabTarifa.setText("");
    }
}