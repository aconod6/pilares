package screens;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.repositorys.LoginRepository;

public class VentaLogin extends JFrame implements ActionListener {

    LoginRepository loginRepository = new LoginRepository();

    JLabel tituloJLabel;
    JLabel usuarioJLabel;
    JTextField usuarioJTextField;
    JLabel contraseniaJLabel;
    JPasswordField contraseniaJPasswordField;
    JButton iniciarButton;
    JButton registrarButton;

    public VentaLogin(String titulo) {
        super(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 200);
        setLayout(new GridBagLayout());
        crearComponentes();

    }

    private void crearComponentes() {
        tituloJLabel = new JLabel("Iniciar sesión");
        tituloJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usuarioJLabel = new JLabel("Usuario: ");
        usuarioJTextField = new JTextField(100);// poner maximo ce caracteres a poner
        contraseniaJLabel = new JLabel("Contraseña: ");
        contraseniaJPasswordField = new JPasswordField();
        iniciarButton = new JButton("Iniciar");
        registrarButton = new JButton("Registrar");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(tituloJLabel, gbc);

        // gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(usuarioJLabel, gbc);

        gbc.gridwidth = 3;
        gbc.gridx = 1;
        add(usuarioJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(contraseniaJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        add(contraseniaJPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        // ! agregar la acción al componente
        iniciarButton.addActionListener(this);// ! agregar la acción al componente
        add(iniciarButton, gbc);

        gbc.gridx = 2;
        // ! agregar la acción al componente
        registrarButton.addActionListener(this); // ! agregar la acción al componente
        add(registrarButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == iniciarButton) {
            System.out.println("Inciar...");
            String usuario = usuarioJTextField.getText();
            char pwd[] = contraseniaJPasswordField.getPassword();
            String contrasenia = new String(pwd);
            System.out.println("User: "+usuario);
            System.out.println("pwd: "+Arrays.toString(pwd));
             // TODO: Llama al método verificarCredenciales en tu clase LoginRepository
        boolean credencialesValidas = loginRepository.verificarCredenciales(usuario, contrasenia);

        if (credencialesValidas== true) {
            System.out.println("Acceso permitido");
            // Aquí puedes abrir la ventana de empleados u realizar otras acciones
            
            EmpleadosVentana empleadosVentana = new EmpleadosVentana();
            empleadosVentana.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Mijo, estas poniendo mal los datos");
            System.out.println("Credenciales incorrectas");
            // Aquí puedes mostrar un mensaje de error o realizar otras acciones
        }
    }
        if (e.getSource() == registrarButton) {
            System.out.println("Registrar...");
            RegistroVentana registroVentana = new RegistroVentana();
            registroVentana.setVisible(rootPaneCheckingEnabled);
        }
    }
}
