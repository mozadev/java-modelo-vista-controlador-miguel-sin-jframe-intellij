package vista;

import java.awt.event.* ;
import javax.swing.* ;
import java.awt.*;

public class PrgPacienteGUI extends JApplet implements ActionListener  {

    // Declaración de componentes de la interfaz gráfica de usuario
    JLabel lblNombre, lblMensaje ;
    JTextField txtNombre, txtMensaje ;
    JButton btnBienvenida ;
    JTextArea txaResultado ;

    // DISEñO DE LA GUI
    public void init( ) {
        getContentPane().setLayout(null);
// Etiqueta lblNombre
        lblNombre = new JLabel( "Nombre");
        lblNombre.setBounds(15, 15, 55, 25);
        getContentPane().add(lblNombre);
// Etiqueta lblMensaje
        lblMensaje = new JLabel( "Mensaje" );
        lblMensaje.setBounds(15, 50, 55, 25);
        getContentPane().add(lblMensaje);
// Caja de texto de una línea txtNombre
        txtNombre = new JTextField(100);
        txtNombre.setBounds(75, 15, 100, 25);
        getContentPane().add(txtNombre);
// Caja de texto de una línea txtMensaje
        txtMensaje = new JTextField(100);
        txtMensaje.setBounds(75, 50, 225, 25);
        getContentPane().add(txtMensaje);
// Botón de acción btnBienvenida
        btnBienvenida = new JButton( "Bienvenida" );
        btnBienvenida.setBounds(200, 15, 100, 25);
        btnBienvenida.addActionListener(this);
        getContentPane().add(btnBienvenida);
// Caja de texto de múltiples líneas txaResultado
        txaResultado = new JTextArea();
        txaResultado.setBounds(15, 95, 285, 150);
        txaResultado.setBackground(Color.CYAN);
        getContentPane().add(txaResultado);
    }

    // PROGRAMACIÓN DE LA GUI
    public void actionPerformed ( ActionEvent e ) {
// Declaración de variables
        String nombre, mensaje ;
// Ingreso de datos
        nombre = txtNombre.getText( ) ;
        mensaje = txtMensaje.getText( ) ;
// Mostrar información
        txaResultado.setText ( nombre + "" + mensaje) ;
        txaResultado.append ( "\n" + "...\n" + "FIN.") ;
        txtNombre.setText ( "") ;
        txtMensaje.setText( "" ) ;
    }



}
