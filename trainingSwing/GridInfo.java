package trainingSwing;

public class GridInfo {

	private int gridXNum; //マスの横数
	private int gridYNum; //マスの縦数
	private int gridFlg[][]; //マス情報
	
	//コンストラクタ
	GridInfo(int xNum,int yNum){
		//引数から渡されたマスの横幅、縦幅を保存
		gridXNum = xNum;
		gridYNum = yNum;
		
		//各マスに置かれているコマを保持する2次元配列を定義
		gridFlg = new int[gridXNum][gridYNum];
		
		//1～15までの数を格納
		for(int y = 0;y < gridYNum;y++) {
			for(int x = 0;x < gridXNum;x++) {
				gridFlg[y][x] = (y * gridYNum) + x + 1;
			}
		}
		
		//右下のマスにはコマがないことを意味する0を格納
		gridFlg[gridYNum - 1][gridXNum - 1] = 0;
	}
	
	//コマをシャッフルするメソッド
	public void shfleTile() {
		int clickTileX = 0;
		int clickTileY = 0;
		int clickedTileX = 0;
		int clickedTileY = 0;
		int randNum;
		boolean blnRet = false;
		
		//500回コマを移動させる
		for(int i = 0;i < 500;i++) {
			//コマが置かれていない空いているマスを取得
			clickTileX = getEmpGridXNum(); //横位置を取得
			clickTileY = getEmpGridYNum();//縦位置を取得
			
			//0～3までの数値をランダムに取得
			randNum = (int)(Math.random() * 4);
			
			//ランダムに得た0～3までの数値を上下左右に対応させて場合分け
			switch(randNum) {
			    //右
			case 0:
				//空いているマスの右にあるコマを移動させる
				blnRet = moveTile(clickTileX + 1,clickTileY);
				clickedTileX = clickTileX + 1;
				clickedTileY = clickTileY;
				break;
				
		         //左
			case 1:
				//空いてあるマスの左にあるコマを移動させる
				blnRet = moveTile(clickTileX - 1,clickTileY);
				clickedTileX = clickTileX - 1;
				clickedTileY = clickTileY;
				break;
				
			    //下
			case 2:
				//空いてあるマスの下にあるコマを移動させる
				blnRet = moveTile(clickTileX,clickTileY + 1);
				clickedTileX = clickTileX;
				clickedTileY = clickTileY + 1;
				break;
				
			case 3:
				//空いているマスの上にあるコマを移動させる
				blnRet = moveTile(clickTileX,clickTileY -1);
			    clickedTileX = clickTileX;
			    clickedTileY = clickTileY - 1;
			    break;
			    
			}
			
			/*なぜ呼んでいるのか
			 * if(blnRet == true) {
				clickTileX = clickedTileX;
			    clickTileY = clickedTileY;
			    moveTile(clickTileX,clickTileY);
			}*/
		}
	}
	
	//コマが置かれていないX座標(理論値)を返すメソッド
	public int getEmpGridXNum() {
		int rx = 0;
		for(int y = 0;y < gridYNum;y++) {
			for(int x = 0;x < gridXNum;x++) {
				if(gridFlg[y][x] == 0) {
					rx = x;
				}
			}
		}
	
	return rx;//コマが置かれていない空いているX座標(理論値)を返す
	}
	
	//コマが置かれていないY座標(理論値)を返すメソッド
	public int getEmpGridYNum() {
		int ry = 0;
		for(int y = 0;y < gridYNum;y++) {
			for(int x = 0;x < gridXNum;x++) {
				if(gridFlg[y][x] == 0) {
					ry = y;
				}
			}
		}
		
		return ry;//コマが置かれていない空いているY座標(理論値)を返す
	}
	
	//コマを空いているマスに移動させるメソッド
	public boolean moveTile(int clickTileX,int clickTileY) {
		boolean blnRet;
		boolean blnExist;
		blnRet = true;
		blnExist = false;
		
		while(true) {
			//右に移動できるか判別
			if(clickTileX + 1 < gridXNum && clickTileX >= 0 &&
				clickTileY >= 0 && clickTileY < gridYNum) {
				if(gridFlg[clickTileY][clickTileX +1] == 0) {
					gridFlg[clickTileY][clickTileX + 1] = 
							gridFlg[clickTileY][clickTileX];
					blnExist = true;
					break;
				}
			}
			
			//左に移動できるか判別
			if(clickTileX - 1 >= 0 && clickTileX < gridXNum &&
				clickTileY >= 0 && clickTileY < gridYNum) {
				if(gridFlg[clickTileY][clickTileX - 1] == 0) {
					gridFlg[clickTileY][clickTileX - 1] =
					gridFlg[clickTileY][clickTileX];
					blnExist = true;
					break;
				}
			}
			
			//下に移動できるか判別
			if(clickTileX  >= 0 && clickTileX < gridXNum &&
					clickTileY >= 0 && clickTileY + 1 < gridYNum) {
					if(gridFlg[clickTileY + 1][clickTileX] == 0) {
						gridFlg[clickTileY + 1][clickTileX] =
						gridFlg[clickTileY][clickTileX];
						blnExist = true;
						break;
					}
				}
			//上に移動できるか判別
			if(clickTileX >= 0 && clickTileX < gridXNum &&
					clickTileY - 1>= 0 && clickTileY < gridYNum) {
					if(gridFlg[clickTileY - 1][clickTileX] == 0) {
						gridFlg[clickTileY - 1][clickTileX] =
						gridFlg[clickTileY][clickTileX];
						blnExist = true;
						break;
					}
				}
			break;
		}
			//クリックされたマスからコマを移動させたら、そのマスを空にする
			if(blnExist == true) {
				gridFlg[clickTileY][clickTileX] = 0;
			}
			return blnRet;
		}
		
		//引数で指定されたマスに置かれているコマを返すメソッド
		public int getTileNum(int x,int y){
			return gridFlg[y][x];
		}
		
		//ゲームクリアを判断するメソッド
		public boolean getGameClearFlg() {
			boolean blnRet;
			blnRet = true;
			
			for(int y = 0;y < gridYNum;y++) {
				for(int x = 0;x < gridXNum;x++) {
					//右下のマスが空いているかどうかを判断
					if(y == gridYNum -1 && x == gridXNum -1) {
						if(gridFlg[y][x] != 0) {
							blnRet = false; //右下のマスが空いていなかったらfalseを代入
						}
					}
					
					//数字が整列されているかどうかを判断
					else if(gridFlg[y][x] != (y * gridYNum) + x + 1) {
						blnRet = false;//数字が整列されていなかったらfalseを代入
					}
				}
			}
			
			//ゲームクリアならtrue,まだならfalseを返す
			return blnRet;
			
		}
	
	
}
