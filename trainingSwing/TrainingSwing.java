package trainingSwing;
import javax.swing.JFrame;

public class TrainingSwing {
    private static JFrame frame;
    
	public static void main(String[] args) {
		//フレームを生成
	    frame = new JFrame();
	    //フレームのタイトル指定
	    frame.setTitle("SampleSwing");
	    //フレームのサイズ指定
	    frame.setSize(640,480);
	    //フレームを閉じたときの動作を指定
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //フレームを表示
	    frame.setVisible(true);

	}

}
