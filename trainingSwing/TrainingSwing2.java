package trainingSwing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TrainingSwing2 {
    private static JFrame frame;
    private static ImageIcon image;
    private static JLabel label;
    
	public static void main(String[] args) {
	    frame = new JFrame();
	    image = new ImageIcon("C:\\pleiades\\workspace\\SwingSample\\trainingSwing\\R.jpg");//引数に画像名(パス)を入れる
	
	    label = new JLabel(image);
	    
	    frame.getContentPane().add(label);
	    frame.getContentPane().setLayout(null);
	    label.setBounds(0,0,800,800);
	    
	    /*
	    System.out.println(image.getIconHeight());
	    System.out.println(image.getIconWidth());
	*/
	    
	    frame.setTitle("TrainingSwing");
	    frame.setSize(800,800);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);

	}

}
