package ui;

import controller.AgenciaGestor;
import data.ManejadorArchivos;
import exception.RutInvalidoException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class VentanaApp extends JFrame {

    private final AgenciaGestor gestor;

    private JTextArea txtConsola;
    private JComboBox<Guia> comboGuias;
    private JComboBox<String> comboTipoServicio;
    private JLabel lblAtributoEspecifico;

    private JTextField txtGuiaRut, txtGuiaNombre, txtGuiaEspecialidad;
    private JTextField txtVehiculoPatente, txtVehiculoModelo, txtVehiculoCapacidad;
    private JTextField txtColabNombre, txtColabRubro, txtColabTarifa;
    private JTextField txtServicioNombre, txtServicioDuracion, txtServicioPrecio, txtServicioAtributo;

    public VentanaApp() {
        this.gestor = new AgenciaGestor();
        configurarVentana();
        inicializarComponentes();

        File f = new File("resources/datos_agencia.txt");
        if (f.exists() && f.length() > 0) {
            gestor.setListaEntidades(ManejadorArchivos.leerDesdeArchivo());
        } else {
            inicializarDatosPruebaYArchivo();
        }

        actualizarComboGuias();
        actualizarConsolaTexto();
    }

    private void configurarVentana() {
        setTitle("Llanquihue Tour - Panel de Administracion");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    private void determinarPestanas(JTabbedPane pestañas) {
        pestañas.addTab("Registrar Guia", crearPanelGuia());
        pestañas.addTab("Registrar Vehiculo", crearPanelVehiculo());
        pestañas.addTab("Registrar Colaborador", crearPanelColaborador());
        pestañas.addTab("Registrar Servicio", crearPanelServicio());
    }

    private void inicializarComponentes() {
        JTabbedPane pestañas = new JTabbedPane();
        determinarPestanas(pestañas);
        add(pestañas, BorderLayout.NORTH);

        JPanel panelConsola = new JPanel(new BorderLayout(5, 5));
        panelConsola.setBorder(BorderFactory.createTitledBorder("Registros en Sistema (resources/datos_agencia.txt)"));
        txtConsola = new JTextArea();
        txtConsola.setEditable(false);
        txtConsola.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panelConsola.add(new JScrollPane(txtConsola), BorderLayout.CENTER);

        add(panelConsola, BorderLayout.CENTER);
    }

    private JPanel crearPanelGuia() {
        JPanel p = new JPanel(new GridLayout(4, 2, 5, 5));
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        p.add(new JLabel("RUT (sin puntos con guion):"));
        txtGuiaRut = new JTextField();
        p.add(txtGuiaRut);

        p.add(new JLabel("Nombre Completo:"));
        txtGuiaNombre = new JTextField();
        p.add(txtGuiaNombre);

        p.add(new JLabel("Especialidad:"));
        txtGuiaEspecialidad = new JTextField();
        p.add(txtGuiaEspecialidad);

        JButton btnGuardar = new JButton("Guardar Guia");
        btnGuardar.addActionListener(e -> accionGuardarGuia());
        p.add(new JLabel());
        p.add(btnGuardar);

        return p;
    }

    private JPanel crearPanelVehiculo() {
        JPanel p = new JPanel(new GridLayout(4, 2, 5, 5));
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        p.add(new JLabel("Patente (ej: HGDF-44):"));
        txtVehiculoPatente = new JTextField();
        p.add(txtVehiculoPatente);

        p.add(new JLabel("Modelo / Marca:"));
        txtVehiculoModelo = new JTextField();
        p.add(txtVehiculoModelo);

        p.add(new JLabel("Capacidad Pasajeros:"));
        txtVehiculoCapacidad = new JTextField();
        p.add(txtVehiculoCapacidad);

        JButton btnGuardar = new JButton("Guardar Vehiculo");
        btnGuardar.addActionListener(e -> accionGuardarVehiculo());
        p.add(new JLabel());
        p.add(btnGuardar);

        return p;
    }

    private JPanel crearPanelColaborador() {
        JPanel p = new JPanel(new GridLayout(4, 2, 5, 5));
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        p.add(new JLabel("Nombre Empresa:"));
        txtColabNombre = new JTextField();
        p.add(txtColabNombre);

        p.add(new JLabel("Rubro / Servicio:"));
        txtColabRubro = new JTextField();
        p.add(txtColabRubro);

        p.add(new JLabel("Tarifa Convenio ($):"));
        txtColabTarifa = new JTextField();
        p.add(txtColabTarifa);

        JButton btnGuardar = new JButton("Guardar Colaborador");
        btnGuardar.addActionListener(e -> accionGuardarColaborador());
        p.add(new JLabel());
        p.add(btnGuardar);

        return p;
    }

    private JPanel crearPanelServicio() {
        JPanel p = new JPanel(new GridLayout(7, 2, 5, 5));
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        p.add(new JLabel("Tipo de Servicio:"));
        comboTipoServicio = new JComboBox<>(new String[]{"Ruta Gastronomica", "Paseo Lacustre", "Excursion Cultural"});
        comboTipoServicio.addActionListener(e -> cambiarEtiquetaAtributo());
        p.add(comboTipoServicio);

        p.add(new JLabel("Nombre del Tour:"));
        txtServicioNombre = new JTextField();
        p.add(txtServicioNombre);

        p.add(new JLabel("Duracion (Horas):"));
        txtServicioDuracion = new JTextField();
        p.add(txtServicioDuracion);

        p.add(new JLabel("Precio ($):"));
        txtServicioPrecio = new JTextField();
        p.add(txtServicioPrecio);

        p.add(new JLabel("Asignar Guia:"));
        comboGuias = new JComboBox<>();
        p.add(comboGuias);

        lblAtributoEspecifico = new JLabel("Cantidad de Paradas:");
        p.add(lblAtributoEspecifico);
        txtServicioAtributo = new JTextField();
        p.add(txtServicioAtributo);

        JButton btnGuardar = new JButton("Guardar Servicio");
        btnGuardar.addActionListener(e -> accionGuardarServicio());
        p.add(new JLabel());
        p.add(btnGuardar);

        return p;
    }

    private void cambiarEtiquetaAtributo() {
        String seleccion = (String) comboTipoServicio.getSelectedItem();
        if ("Ruta Gastronomica".equals(seleccion)) {
            lblAtributoEspecifico.setText("Cantidad de Paradas:");
        } else if ("Paseo Lacustre".equals(seleccion)) {
            lblAtributoEspecifico.setText("Tipo de Embarcacion:");
        } else {
            lblAtributoEspecifico.setText("Lugar Historico:");
        }
    }

    private void accionGuardarGuia() {
        try {
            Guia g = new Guia(txtGuiaRut.getText().trim(), txtGuiaNombre.getText().trim(), txtGuiaEspecialidad.getText().trim());
            gestor.agregarEntidad(g);
            ManejadorArchivos.guardarTodo(gestor.getListaEntidades());

            JOptionPane.showMessageDialog(this, "Guia registrado y archivo actualizado.");
            txtGuiaRut.setText(""); txtGuiaNombre.setText(""); txtGuiaEspecialidad.setText("");
            actualizarComboGuias();
            actualizarConsolaTexto();
        } catch (RutInvalidoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Critico", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void accionGuardarVehiculo() {
        try {
            String patente = txtVehiculoPatente.getText().trim();
            String modelo = txtVehiculoModelo.getText().trim();
            int cap = Integer.parseInt(txtVehiculoCapacidad.getText().trim());

            Vehiculo v = new Vehiculo(patente, modelo, cap);
            gestor.agregarEntidad(v);
            ManejadorArchivos.guardarTodo(gestor.getListaEntidades());

            JOptionPane.showMessageDialog(this, "Vehiculo registrado con exito.");
            txtVehiculoPatente.setText(""); txtVehiculoModelo.setText(""); txtVehiculoCapacidad.setText("");
            actualizarConsolaTexto();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La capacidad debe ser un numero entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void accionGuardarColaborador() {
        try {
            String nombre = txtColabNombre.getText().trim();
            String rubro = txtColabRubro.getText().trim();
            int tarifa = Integer.parseInt(txtColabTarifa.getText().trim());

            ColaboradorExterno c = new ColaboradorExterno(nombre, rubro, tarifa);
            gestor.agregarEntidad(c);
            ManejadorArchivos.guardarTodo(gestor.getListaEntidades());

            JOptionPane.showMessageDialog(this, "Colaborador externo guardado.");
            txtColabNombre.setText(""); txtColabRubro.setText(""); txtColabTarifa.setText("");
            actualizarConsolaTexto();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La tarifa debe ser numerica.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void accionGuardarServicio() {
        try {
            String tipo = (String) comboTipoServicio.getSelectedItem();
            String nombre = txtServicioNombre.getText().trim();
            int duracion = Integer.parseInt(txtServicioDuracion.getText().trim());
            int precio = Integer.parseInt(txtServicioPrecio.getText().trim());
            Guia copiaGuia = (Guia) comboGuias.getSelectedItem();
            String atrib = txtServicioAtributo.getText().trim();

            Registrable s;
            if ("Ruta Gastronomica".equals(tipo)) {
                s = new RutaGastronomica(nombre, duracion, precio, copiaGuia, Integer.parseInt(atrib));
            } else if ("Paseo Lacustre".equals(tipo)) {
                s = new PaseoLacustre(nombre, duracion, precio, copiaGuia, atrib);
            } else {
                s = new ExcursionCultural(nombre, duracion, precio, copiaGuia, atrib);
            }

            gestor.agregarEntidad(s);
            ManejadorArchivos.guardarTodo(gestor.getListaEntidades());

            JOptionPane.showMessageDialog(this, "Servicio turistico guardado con exito.");
            txtServicioNombre.setText(""); txtServicioDuracion.setText(""); txtServicioPrecio.setText(""); txtServicioAtributo.setText("");
            actualizarConsolaTexto();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Revise los campos numericos (Precio/Duracion/Paradas).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarComboGuias() {
        comboGuias.removeAllItems();
        for (Registrable r : gestor.getListaEntidades()) {
            if (r instanceof Guia) {
                comboGuias.addItem((Guia) r);
            }
        }
    }

    private void actualizarConsolaTexto() {
        txtConsola.setText("");
        for (Registrable r : gestor.getListaEntidades()) {
            txtConsola.append(r.mostrarResumen() + "\n");
        }
    }

    private void inicializarDatosPruebaYArchivo() {
        try {
            Guia g1 = new Guia("15224311-K", "Ana Maria Lopez", "Gastronomica");
            Guia g2 = new Guia("18765432-1", "Carlos Plaza", "Navegacion");

            gestor.agregarEntidad(g1);
            gestor.agregarEntidad(g2);
            gestor.agregarEntidad(new Vehiculo("HGDF-44", "Mercedes Benz Sprinter", 17));
            gestor.agregarEntidad(new ColaboradorExterno("Transportes del Lago S.A.", "Traslados Fluviales", 75000));
            gestor.agregarEntidad(new RutaGastronomica("Kuchen Tour Frutillar", 3, 22000, g1, 4));
            gestor.agregarEntidad(new PaseoLacustre("Navegacion Rio Maullin", 2, 35000, g2, "Lancha a Motor"));

            ManejadorArchivos.guardarTodo(gestor.getListaEntidades());
        } catch (RutInvalidoException ignored) {}
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new VentanaApp().setVisible(true);
        });
    }
}