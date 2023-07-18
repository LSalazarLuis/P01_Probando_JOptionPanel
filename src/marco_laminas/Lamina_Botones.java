package marco_laminas;
import javax.swing.*;

public class Lamina_Botones extends JPanel{

	public Lamina_Botones(String titulo, String[] opciones) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));//se  crea  el borde del JPanel
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		grupo = new ButtonGroup();
		
		for(int i = 0; i < opciones.length; i++) {
			
			JRadioButton bot = new JRadioButton(opciones[i]);
			
			bot.setActionCommand(opciones[i]);
			
			add(bot);//se agrega a la lamina los JRadioButtons
			grupo.add(bot);//se agrega al grupo para tener solo uno seleccionado
			bot.setSelected(i==0);//para que aparesca el primer elemento seleccionado
			
		}
		
	}
	
	public String dameSeleccion() {
		
		ButtonModel miBoton = grupo.getSelection();//el objeto miBoton tiene almacenado el radiobutton que este seleccionado
		String s = miBoton.getActionCommand();//el metodo getActionCommand devuelve el string del objeto component (en este caso el radiobutton)
	
		return s;
		
	}
	
	private ButtonGroup grupo;
	
}
