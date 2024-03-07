package screens;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.repositorys.LoginRepository;
import models.Empleado;
import models.Login;

public class RegistroVentana extends JFrame implements ActionListener {

    JLabel textJLabel;
    JLabel nombreJLabel;
    JLabel emailJLabel;
    JLabel usuarJLabel;
    JLabel contraseniaJLabel;
    JTextField nombreJTextField;
    JTextField emailJTextField;
    JTextField usuarioJTextField;
    JPasswordField contraseniaJPasswordField;
    JRadioButton mostrar;

    JButton registrarJButton;

    GridBagConstraints gbc = new GridBagConstraints();
    LoginRepository loginRepository = new LoginRepository();
    Login login;

    public RegistroVentana() {
        super("Empleados CRUD");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        crearComponentes();
    }

    private void crearComponentes() {
        textJLabel = new JLabel("Registrarte");
        textJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreJLabel = new JLabel("Nombre");
        emailJLabel = new JLabel("Correo");
        usuarJLabel = new JLabel("Usuario");
        contraseniaJLabel = new JLabel("Contraseña");
        nombreJTextField = new JTextField(100);
        emailJTextField = new JTextField(200);
        usuarioJTextField = new JTextField(100);
        contraseniaJPasswordField = new JPasswordField(100);
        mostrar = new JRadioButton();
        registrarJButton = new JButton("Registrarte:");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(textJLabel, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 1; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(nombreJLabel, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 1; // fila donde inicia
        gbc.gridwidth = 2; // numero de columnas que abarca
        add(nombreJTextField, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 2; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(emailJLabel, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 2; // fila donde inicia
        gbc.gridwidth = 2; // numero de columnas que abarca
        add(emailJTextField, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 3; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(usuarJLabel, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 3; // fila donde inicia
        gbc.gridwidth = 2; // numero de columnas que abarca
        add(usuarioJTextField, gbc);

        gbc.gridx = 0; // columna donde inicia
        gbc.gridy = 4; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(contraseniaJLabel, gbc);

        gbc.gridx = 1; // columna donde inicia
        gbc.gridy = 4; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        mostrar.addActionListener(this);
        add(mostrar, gbc);

        gbc.gridx = 2; // columna donde inicia
        gbc.gridy = 4; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        add(contraseniaJPasswordField, gbc);

        gbc.gridx = 2; // columna donde inicia
        gbc.gridy = 5; // fila donde inicia
        gbc.gridwidth = 1; // numero de columnas que abarca
        registrarJButton.addActionListener(this);
        add(registrarJButton, gbc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarJButton) {
            int emergente = JOptionPane.showConfirmDialog(null, "Los datos son correctos?",
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            // Verificar la respuesta del usuario
            if (emergente == JOptionPane.YES_OPTION) {

                System.out.println("Registrando..");
                registrar();
                System.out.println("Registro exitoso");
                limpiarCampo();
            }
            if (e.getSource() == mostrar) {
                // Para mostrar contraseña
                contraseniaJPasswordField.setEchoChar(mostrar.isSelected() ? '\0' : '*');
            }
        }
    }

    private void registrar() {
        char pwd[] = contraseniaJPasswordField.getPassword();
        String contraseña = String.valueOf(pwd);
        Login login = new Login(
                null,
                nombreJTextField.getText(),
                emailJTextField.getText(),
                usuarioJTextField.getText(),
                contraseña);
        loginRepository.agregar(login);

    }

    private void limpiarCampo() {
        nombreJTextField.setText("");
        emailJTextField.setText("");
        usuarioJTextField.setText("");
        contraseniaJPasswordField.setText("");

    }

}
