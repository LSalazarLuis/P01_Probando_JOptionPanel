package marco_laminas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Marco_Principal extends JFrame{
	
	public Marco_Principal() {
		
		//caracteristicas del JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,450);
		setTitle("P01_Probando_JOptionPanel");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/iconoBall.png"));
		setLayout(new BorderLayout());
		
		// JPanel que almacenara las diferentes opciones
		JPanel lamina_cuadricula = new JPanel();
		lamina_cuadricula.setLayout(new GridLayout(2,3));
		
		// Se crean los Arrays con las diferentes opciones para los JRadioButton
		String cajaN1_tipo[] = {"Mensaje","Confirmar","Opción","Entrada"};
		String cajaN2_tipoMensaje[] = {"ERROR_MESSAGE","INFORMATION_MESSAGE","WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE"};
		String cajaN3_mensaje[] = {"Cadena","Icono","Componente","Otros","Object[]"};
		String cajaN4_confirmar[] = {"DEFAULT_OPTION","YES_NO_OPTION","YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION"};
		String cajaN5_opcion[] = {"String[]","Icon[]","Object[]"};
		String cajaN6_entrada[] = {"Campo de Texto","Combo"};
		
		// Creando las instancias del JPanel (Lamina_Botones) y pasando como argumento los arrays creados en el bloque anterior
		lamina_tipo = new Lamina_Botones("Tipo", cajaN1_tipo);
		lamina_tipo_mensaje = new Lamina_Botones("Tipo de Mensaje", cajaN2_tipoMensaje);
		lamina_mensaje = new Lamina_Botones("Mensaje", cajaN3_mensaje);
		lamina_tipo_opcion = new Lamina_Botones("Confirmar", cajaN4_confirmar);
		lamina_opciones = new Lamina_Botones("Opción", cajaN5_opcion);
		lamina_entrada = new Lamina_Botones("Entrada", cajaN6_entrada);
		
		// Agregado los JPanel(Lamina_Botones), al JPanel(lamina_cuadricula) con disposición GridLayout		
		lamina_cuadricula.add(lamina_tipo);
		lamina_cuadricula.add(lamina_tipo_mensaje);
		lamina_cuadricula.add(lamina_mensaje);
		lamina_cuadricula.add(lamina_tipo_opcion);
		lamina_cuadricula.add(lamina_opciones);
		lamina_cuadricula.add(lamina_entrada);
		
		// JPanel para el boton
		JPanel lamina_boton = new JPanel();
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new AccionMostrar());
		lamina_boton.add(btnMostrar);
		
		// Agregando los JPanel al JFrame principal
		add(lamina_cuadricula, BorderLayout.CENTER);
		add(lamina_boton, BorderLayout.SOUTH);
		
	}//fin metodo constructor------------------------------------------------------------------------------------------------
	
	//metodo para proporcionar el mensaje
	public Object dameMensaje() {
		
		String s = lamina_mensaje.dameSeleccion();
		
		if(s.equalsIgnoreCase("cadena")) {
			
			return cadenaMensaje;
			
		}
		else if(s.equalsIgnoreCase("icono")) {
			
			return iconoMensaje;
			
		}
		else if(s.equalsIgnoreCase("componente")) {
			
			return componenteMensaje;
			
		}
		else if(s.equalsIgnoreCase("otros")) {
			
			return objetoMensaje;
			
		}
		else if(s.equalsIgnoreCase("object[]")) {
			
			return new Object[] {cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje};
			
		}
		else {
			
			return null;
			
		}
		
	}//fin metodo dameMensaje()--------------------------------------------------------------------------------------------------------------
	
	// metodo para cambiar icono del JOptionPanel y tipos de botones de confirmacion
	public int dameTipo(Lamina_Botones lamina) {
		
		String s = lamina.dameSeleccion();
		// nota: para ahorrar codigo, y dado que para seleccionar el tipo de icono y los tipos de botones se utilizan constantes de tipo int
		//       se agrego todo en el mismo metodo.
		if(s.equalsIgnoreCase("ERROR_MESSAGE") || s.equalsIgnoreCase("YES_NO_OPTION")) {
			
			return 0;
			
		}
		else if(s.equalsIgnoreCase("INFORMATION_MESSAGE")|| s.equalsIgnoreCase("YES_NO_CANCEL_OPTION")) {
			
			return 1; 
			
		}
		else if(s.equalsIgnoreCase("WARNING_MESSAGE") || s.equalsIgnoreCase("OK_CANCEL_OPTION")) {
			
			return 2;	
			
		}
		else if(s.equalsIgnoreCase("QUESTION_MESSAGE")) {
			
			return 3;
			
		}
		else if(s.equalsIgnoreCase("PLAIN_MESSAGE") || s.equalsIgnoreCase("DEFAULT_OPTION")) {
			
			return -1;
			
		}
		else {
			return 0;
		}
	}// fin metodo dimetipo()----------------------------------------------------------------------------------------------------------
	
	//
	public Object[] dameOpciones(Lamina_Botones lamina) {
		
		String s = lamina.dameSeleccion();
		
		if(s.equalsIgnoreCase("String[]")) {
			
			return new String[] {"Amarillo","Azul","Rojo"};
			
		}
		
		else if(s.equalsIgnoreCase("Icon[]")) {
			
			return new Object[] {new ImageIcon("src/img/Verde.png"),new ImageIcon("src/img/Azul.png"),new ImageIcon("src/img/Rojo.png")};
			
		}
		else if(s.equalsIgnoreCase("object[]")) {
			
			return new Object[] {cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje};
			
		}
		else {
			
			return null;
			
		}
		
	}//fin metodo dameOpciones()-------------------------------------------------------------------------------------------------------
	
	//clase interna que espera a que se genere un evento (pulsando el boton) de tipo ActionListener
	private class AccionMostrar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(lamina_tipo.dameSeleccion().equalsIgnoreCase("mensaje")) {
				
				JOptionPane.showMessageDialog(Marco_Principal.this, dameMensaje(), "Titulo...", dameTipo(lamina_tipo_mensaje));
				
			}
			else if(lamina_tipo.dameSeleccion().equalsIgnoreCase("confirmar")) {
				
				JOptionPane.showConfirmDialog(Marco_Principal.this, dameMensaje(),"Titulo...",dameTipo(lamina_tipo_opcion),dameTipo(lamina_tipo_mensaje));
				
			}
			else if(lamina_tipo.dameSeleccion().equalsIgnoreCase("entrada")) {
				
				if(lamina_entrada.dameSeleccion().equalsIgnoreCase("Campo de texto")) {
					
					JOptionPane.showInputDialog(Marco_Principal.this, dameMensaje(), "Titulo", dameTipo(lamina_tipo_mensaje));
					
				}
				else{
					
					JOptionPane.showInputDialog(Marco_Principal.this, dameMensaje(), "Titulo", dameTipo(lamina_tipo_mensaje),null,new String[] {"Amarillo","Azul","Rojo"}, "Azul");
					
				}
				
			}
			else if(lamina_tipo.dameSeleccion().equalsIgnoreCase("opción")) {
				
				JOptionPane.showOptionDialog(Marco_Principal.this, dameMensaje(), "Título", 1, dameTipo(lamina_tipo_mensaje), null, dameOpciones(lamina_opciones), null);
				
			}
		}
		
	}//fin clase interna AccionMostrar---------------------------------------------------------------------------------------------
	
	
	
	
	//declaración de variables globales:
	private Lamina_Botones lamina_tipo, lamina_tipo_mensaje, lamina_mensaje, 
						   lamina_tipo_opcion, lamina_opciones, lamina_entrada;
	
	private String cadenaMensaje = "Mensaje";
	private Icon iconoMensaje = new ImageIcon("src/img/Azul.png");
	private Object objetoMensaje = new Date();
	private Component componenteMensaje = new Lamina_Ejemplo();
	
	

}
