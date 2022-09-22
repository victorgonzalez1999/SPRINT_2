import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class VentanaFrame extends JFrame{

	private JLabel etiqueta;
	private JTextField campoTexto;
	private JPasswordField campoContrasena;
	private JButton botonSimple;


	public VentanaFrame(){

		super("prueba de graficos"); //invoca constructor de la clase padre
		setLayout(new FlowLayout()); //establece un esquema dentro del marco 

		Icon insecto = new ImageIcon(getClass().getResource("insecto1.gif"));


		etiqueta = new JLabel("Etiqueta con texto y con icono",insecto,SwingConstants.LEFT);
		etiqueta.setToolTipText("esta es una etiqueta 09/08/2022"); // si me paro con el mouse me muetra informacion
		add(etiqueta);
		

		campoTexto = new JTextField("ingrese el texto");
		add(campoTexto);


		campoContrasena = new JPasswordField("Texto oculto");
		add(campoContrasena);



		
		botonSimple = new JButton("un simple boton");
		add(botonSimple);


		ManejadorCampoTexto manejadorTxt = new ManejadorCampoTexto();
		campoTexto.addActionListener(manejadorTxt);
		campoContrasena.addActionListener(manejadorTxt);

		ManejadorBoton manejadorboton = new ManejadorBoton();
		botonSimple.addActionListener(manejadorboton);

}// fin _metodo_ventanaframe

//***************************************************************************************************
		private class ManejadorCampoTexto implements ActionListener{


			public void actionPerformed(ActionEvent evento){

				String cadena = "";


				if(evento.getSource()== campoTexto)
					cadena = String.format("campoTexto : %s",evento.getActionCommand());


				else if (evento.getSource() == campoContrasena)
					cadena = String.format("campoContrasena: %s", new String(campoContrasena.getPassword()));
					
				JOptionPane.showMessageDialog(null,cadena);	
			

			}// fin metodo campo texto 

		}// finalizacion de la clase privada

private class ManejadorBoton implements ActionListener{



	public void actionPerformed(ActionEvent evento){

		JOptionPane.showMessageDialog(VentanaFrame.this,String.format("usted oprimio: %s",evento.getActionCommand()));



	}// fin metodo boton





}// fin clase privada	


}// fin_clase_ventanaframe



