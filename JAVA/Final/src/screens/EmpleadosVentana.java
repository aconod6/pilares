package screens;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import db.repositorys.EmpleadoRepository;
import db.repositorys.GeneroRepository;
import models.Empleado;
import models.Genero;

public class EmpleadosVentana extends JFrame implements ActionListener {

    GeneroRepository generoRepository = new GeneroRepository();
    EmpleadoRepository empleadoRepository = new EmpleadoRepository();

    JLabel textJLabel;
    JLabel numeroEmpleadoJLabel;
    JLabel nombrJLabel;
    JLabel domicilioJLabe;
    JLabel telefonoJLabel;
    JLabel emailJLabel;
    JLabel fechaJLabel;
    JLabel generoJLabel;
    JComboBox<Long> numeroEmpleadoJComboBox;
    JTextField nombreJTextField;
    JTextField domicilioJTextField;
    JTextField telefonoJTextField;
    JTextField emailJTextField;
    JDateChooser fehcaJDateChooser;
    JComboBox<Genero> generoJComboBox;
    JButton buscarJButton;
    JButton guardarJButton;
    JButton modificarJButton;
    JButton eliminarJButton;
    JButton limpiarJButtonF;

    public EmpleadosVentana() {
        super("Empleados CRUD");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        crearComponentes();
        llenarConboBox();
    }

    private void crearComponentes() {
        textJLabel = new JLabel("Empleados");
        textJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numeroEmpleadoJLabel = new JLabel("# Empleado");
        nombrJLabel = new JLabel("Nombre: ");
        domicilioJLabe = new JLabel("Domicilio: ");
        telefonoJLabel = new JLabel("Telefono: ");
        emailJLabel = new JLabel("Email: ");
        fechaJLabel = new JLabel("Fecha de Nacimiento: ");
        generoJLabel = new JLabel("Genero: ");
        numeroEmpleadoJComboBox = new JComboBox<Long>();
        nombreJTextField = new JTextField(100);// poner macimo de caracteres a poner
        domicilioJTextField = new JTextField(500);
        telefonoJTextField = new JTextField(10);
        emailJTextField = new JTextField(100);
        fehcaJDateChooser = new JDateChooser();
        generoJComboBox = new JComboBox<Genero>();
        buscarJButton = new JButton("Buscar");
        guardarJButton = new JButton("Guardar");
        modificarJButton = new JButton("Modificar");
        eliminarJButton = new JButton("Eliminar");
        limpiarJButtonF = new JButton("Limpiar");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(textJLabel, gbc);

        // gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(numeroEmpleadoJLabel, gbc);

        gbc.gridx = 1;
        // gbc.gridy = 1;
        gbc.gridwidth = 1;
        // iniciarButton.addActionListener(this);
        add(numeroEmpleadoJComboBox, gbc);

        gbc.gridx = 2; // columna donde inicia
        // gbc.gridy = 1; // fila donde inicia
        // gbc.gridwidth = 1; // numero de columnas que abarca
        buscarJButton.addActionListener(this);// ! agregar la acción al componente
        add(buscarJButton, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 2; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(nombrJLabel, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 2; // fila donde inicia
        gbc.gridwidth = 2; // numero de columnas que abarca
        add(nombreJTextField, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 3; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(domicilioJLabe, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 3; // fila donde inicia
        gbc.gridwidth = 2; // numero de columnas que abarca
        add(domicilioJTextField, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 4; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(telefonoJLabel, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 4; // fila donde inicia
        gbc.gridwidth = 2; // numero de columnas que abarca
        add(telefonoJTextField, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 5; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(emailJLabel, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 5; // fila donde inicia
        gbc.gridwidth = 2; // numero de columnas que abarca
        add(emailJTextField, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 6; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(fechaJLabel, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 6; // fila donde inicia
        gbc.gridwidth = 2; // numero de columnas que abarca
        add(fehcaJDateChooser, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 7; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(generoJLabel, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 7; // fila donde inicia
        gbc.gridwidth = 2; // numero de columnas que abarca
        add(generoJComboBox, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 8; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(guardarJButton, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 8; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        modificarJButton.addActionListener(this);
        add(modificarJButton, gbc);

        gbc.gridx = 2; // columna donde inicia
        gbc.gridy = 8; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(eliminarJButton, gbc);

        gbc.gridx = 3; // columna donde inicia
        gbc.gridy = 8; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(limpiarJButtonF, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modificarJButton) {
            System.out.println("Modificar");
           /*  if (empleado = null) return;
            empleado = dameEmpleado();
 */
        }
        if(e.getSource() == buscarJButton){
            System.out.println("Buscando ...");
          recuperarEmpleado();
        }
    }

    public void recuperarEmpleado() {
        Long id = Long.parseLong(numeroEmpleadoJComboBox.getSelectedItem().toString());
        Empleado empleado = empleadoRepository.recuperarId(id);
        nombreJTextField.setText(empleado.getNombe());
        domicilioJTextField.setText(empleado.getDomicilio());
        telefonoJTextField.setText(empleado.getTelefono());
        emailJTextField.setText(empleado.getEmail());
        fehcaJDateChooser.setDate(empleado.getFechadeNacimiento());
        generoJComboBox.setSelectedItem(empleado.getGenero());
        System.out.println(empleado.getGenero());
    }

    public Empleado dameEmpleado() {
        Long l = (Long) (generoJComboBox.getSelectedItem());
        Genero genero = generoRepository.recuperarId(l);
        java.util.Date utilDate = fehcaJDateChooser.getDate();
        java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
        Empleado empleado = new Empleado(
                l,
                nombreJTextField.getName(),
                domicilioJTextField.getText(),
                telefonoJTextField.getText(),
                emailJTextField.getText(),
                fecha,
                genero);
        return empleado;
    }
        public void llenarConboBox () {
            List<Empleado> empleados = empleadoRepository.recuperarTodos();
            for (Empleado empleado : empleados ) {
            numeroEmpleadoJComboBox.addItem(empleado.getId());
            }
            List<Genero> generos = generoRepository.recuperarTodos();
            for (Genero genero : generos ) {
            generoJComboBox.addItem(genero);
    

    }

        }
    }
    