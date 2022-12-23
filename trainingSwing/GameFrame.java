package trainingSwing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFrame extends JFrame implements MouseListener {
	//ゲーム状態フラグ定数(タイトル画面時)
    private static final int GAME_WAIT = 0;
    
    //ゲーム状態フラグ定数(ゲーム中)
    private static final int GAME_ING = 1;
    
    //ボードの横マス数
    private static final int GRID_X  = 4; 
    
    //ボードの縦マス数
    private static final int GRID_Y = 4;
    
    //マスの横幅
    private static final int GRID_WIDTH = 64;
    
    //マスの縦幅
    private static final int GRID_HEIGHT = 64;
    
    //ゲーム状態フラグ
    private static int gameFlg;
    
    //グリッドクラス
    private static GridInfo GInfo;
    
    private static ImageIcon tileImage[];
    private static JLabel label1[];
    
    GameFrame(){
    	GInfo = new GridInfo(GRID_X,GRID_Y);
    	tileImage = new ImageIcon[GRID_X * GRID_Y + 1];
    	label1 = new JLabel[GRID_X * GRID_Y + 1];
    	
    	this.getContentPane().setLayout(null);
    	
    	//1～15までのコマ画像を読み込み
    	DecimalFormat decimalFormat = new DecimalFormat("00");
    	for(int i = 1;i < GRID_X * GRID_Y; i++) {
    		tileImage[i] = new ImageIcon("C:\\pleiades\\workspace\\SwingSample\\trainingSwing\\block\\" + decimalFormat.format(i) + ".gif");
    		label1[i] = new JLabel(tileImage[i]);
    		
    		this.getContentPane().add(label1[i]);
    		
    	}
    	
    	//1～15までのコマをボード上に配置
    	for(int y = 0;y < GRID_Y; y++) {
    		for(int x = 0;x < GRID_X;x++) {
    			if(GInfo.getTileNum(x,y) != 0) {
    				label1[GInfo.getTileNum(x,y)].setBounds(x * GRID_WIDTH,y * GRID_HEIGHT,GRID_WIDTH,GRID_HEIGHT);
    				
    			}
    		}
    	}
    	
    	//コンテントペインに対するマウスイベントの取得を開始する
    	this.getContentPane().addMouseListener(this);
    }
    
    //ゲーム初期化メソッド
    public void gameInit() {
    	GInfo.shfleTile();
    	gameFlg = GAME_ING;
    	
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
    	int clickTileX;
    	int clickTileY;
    	boolean blnRet;
    	
    	switch(gameFlg) {
    	    case GAME_WAIT:
    		    System.out.println("GAME START");
    		    gameInit();
    		    break;
    		
    	    case GAME_ING:
    	    //クリック座標からクリックされたコマが置いてあるマスを取得
    	    clickTileX = (int)((e.getX())/GRID_WIDTH);
    	    clickTileY = (int)((e.getY())/GRID_HEIGHT);
    	    
    	    //コマを移動させる。移動できない場合は何もしない
    	    blnRet = GInfo.moveTile(clickTileX,clickTileY);
    	    
    	    //コマが整列した場合はゲーム終了
    	    blnRet = GInfo.getGameClearFlg();
    	    
    	    if(blnRet == true) {
    	    	//ゲーム状態フラグを変更
    	    	gameFlg = GAME_WAIT;
    	    	System.out.println("GAME OVER");
    	    }
    	    break;
    	}
    	
    	//描画
    	for(int y = 0;y < GRID_Y;y++) {
    		for(int x = 0;x < GRID_X;x++) {
    			if(GInfo.getTileNum(x,y) != 0) {
    				label1[GInfo.getTileNum(x,y)].setBounds(x * GRID_WIDTH,
    						y * GRID_HEIGHT,GRID_WIDTH,GRID_HEIGHT);
    			}
    		}
    	}
    	this.setVisible(true);
    }
    	public void mouseReleased(MouseEvent e){};
    	public void mouseExited(MouseEvent e){};
    	public void mouseEntered(MouseEvent e){};
    	

	
}
