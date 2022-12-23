package trainingSwing;

import javax.swing.JFrame;

public class SlidngPuzzle {
	private static final int WIDTH = 256 + 16; //画面横幅
	private static final int HEIGHT = 256 + 38; //画面縦幅
	
	private static GridInfo GInfo;  //グリッドクラス
	
	public static void main(String[] args) {
	    GameFrame gameFrame = new GameFrame();
	    
	    gameFrame.setTitle("15Puzzle");
	    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gameFrame.setSize(WIDTH,HEIGHT);
	    gameFrame.setVisible(true);
		
	}

}
