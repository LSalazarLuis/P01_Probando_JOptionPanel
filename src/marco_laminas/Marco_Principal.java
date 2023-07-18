package marco_laminas;
import javax.swing.*;
import java.awt.*;

public class Marco_Principal extends JFrame{
	
	public Marco_Principal() {
		
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
		
		// Creando las instancias del JPanel (Lamina_Botones)
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
		lamina_boton.add(btnMostrar);
		
		// Agregando los JPanel al JFrame principal
		add(lamina_cuadricula, BorderLayout.CENTER);
		add(lamina_boton, BorderLayout.SOUTH);
		
	}
	
	private Lamina_Botones lamina_tipo, lamina_tipo_mensaje, lamina_mensaje, 
						   lamina_tipo_opcion, lamina_opciones, lamina_entrada;
	
	

}
