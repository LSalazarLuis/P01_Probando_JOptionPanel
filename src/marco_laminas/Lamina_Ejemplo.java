package marco_laminas;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

//Se crea esta clase con el proposito de generar un rectangulo de color, para el caso que se seleccione el mensaje de tipo Component
public class Lamina_Ejemplo extends JPanel{

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(0,0,getWidth(),getHeight());
		g2.setPaint(Color.YELLOW);
		g2.fill(rectangulo);
		
	}

}
