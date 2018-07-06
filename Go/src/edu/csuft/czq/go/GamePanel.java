package edu.csuft.czq.go;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class GamePanel extends JPanel  {
	/**
	 * 棋盘
	 */
	Image bg;
	/**
	 * 一个棋子
	 */
	Piece piece;
	/**
	 * 存储所有棋子的容器
	 */
	/**
	 * 
	 */
	GoModel goModel ;

	/**
	 * 使用鼠标适配器实现点击事件的监听器
	 */
	String message = "";
	int level = 0;
	 int[][] temporaryChess = new int[9][9];

	

	
	MouseAdapter listener =new MouseAdapter() {
	@Override
		public void mouseClicked(MouseEvent e) {
	
			if(goModel.canPlay==true)	//判断游戏是否开始和结束
			{

				super.mouseClicked(e);
				piece =new Piece(e.getX(), e.getY());
				
				if (goModel.isManAgainst == false) {// 判断是否是人人对战
					manToMan(piece);
				} else { // 否则是人机对战，人机下棋
					manToMachine(piece);
				}
				

				
				goModel.show();
				System.out.println("---------------");


				
			}

		}
		
	};
	ArrayList<Piece> pieceList =new ArrayList<>();
	public GamePanel(GoModel goModel) {
		this.goModel = goModel;
		try {
			
			bg = ImageIO.read(new File("res/Blank_Go_board_9x9.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		this.setLayout(null);


		
		addMouseListener(listener);
	
	
	}

	//人人对战
	public void manToMan (Piece piece)
	{
		int x = piece.y / 50 ;
		int y = piece.x  / 50 ;
		if(goModel.data[piece.y/50][piece.x/50]== 0)//下棋的位置是否有棋子
		{	
		    piece.isBlack = pieceList.size()%2==0;

			pieceList.add(piece);
			
		//	System.out.println(getWidth()+""+getHeight());
			
			goModel.update(piece);
			
			//重新绘制画布
			repaint();

		}
		if(goModel.isWin(x,y) == true)
		{
			JOptionPane.showMessageDialog(null,"游戏结束," + (goModel.data[x][y] == 1 ? "黑方" : "白方") + "获胜!");
			goModel.canPlay = false;
		}
	}
	//人机对战
	public void manToMachine (Piece piece)
	{
		int x = piece.y / 50 ;
		int y = piece.x  / 50 ;
		if(goModel.data[x][y]== 0)//下棋的位置是否有棋子
		{	
			piece.isBlack = pieceList.size() % 2 == 0;
			pieceList.add(piece);
			goModel.update(piece);
			this.repaint();	
			if(goModel.isWin(x,y) == true )
			{
				JOptionPane.showMessageDialog(null,"游戏结束," + (goModel.data[x][y] == 1 ? "黑方" : "白方") + "获胜!");
				goModel.canPlay = false;
			}
			if(goModel.canPlay == true )
			{
				machineChess();
			}

		
		}

	

	
		
		
	}
	public void machineChess()
	{
		//简单机器人
		/*	if (gameDifficulty == 0)
			{
				
				int i = 0 ,j = 0;
				boolean chessSucceed = true;// 下棋成功的标志
				while (chessSucceed)
				{
					i = (int) (Math.random() * 7);
					j = (int) (Math.random() * 7);
					if (goModel.data[i][j] == 0)
					{
						int m = 0, n = 0;
						m = i*55+29;
						n = j*55+29;
						Piece piece =new Piece(n,m);
						piece.isBlack = pieceList.size() % 2 == 0;
						
						pieceList.add(piece);
						goModel.data[i][j] = 2;
						if(goModel.isWin(i,j) == true )
						{
							JOptionPane.showMessageDialog(null,"游戏结束," + (goModel.data[i][j] == 1 ? "黑方" : "白方") + "获胜!");
							goModel.canPlay = false;
						}
						chessSucceed = false;

					}
				}
			}*/
		
				int max = 0;
				int m = 0, n = 0;
				int figureSort[] = new int[4];// 对棋子的四个方向进行打分
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (goModel.data[i][j] == 0) {
							figureSort[0] = checkCountMachine(i, j, 0, 1, 1);
							figureSort[1] = checkCountMachine(i, j, 1, 0, 1);
							figureSort[2] = checkCountMachine(i, j, 1, -1, 1);
							figureSort[3] = checkCountMachine(i, j, 1, 1, 1);
							Arrays.sort(figureSort);
							temporaryChess[i][j] = figureSort[0] * 12 + figureSort[1] * 25 + figureSort[2] * 50// 算出空白棋子的最大分
									+ figureSort[3] * 100;
						}
					
					}
				
				}
			
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (temporaryChess[i][j] > max && goModel.data[i][j] != 2 && goModel.data[i][j] != 1) {
							m = i;
							n = j;
							max = temporaryChess[i][j];
						}
					}
				}

				Piece piece =new Piece(n*50+29,m*50+29);
				piece.isBlack = pieceList.size() % 2 == 0;
				
				pieceList.add(piece);
				goModel.data[m][n] = 2;
				if(goModel.isWin(m,n) == true )
				{
					JOptionPane.showMessageDialog(null,"游戏结束," + (goModel.data[m][n] == 1 ? "黑方" : "白方") + "获胜!");
					goModel.canPlay = false;
				}

				
		 
			
			this.repaint();

		
	}
	// 机器人判断黑棋相连的数量
	private int checkCountMachine(int x, int y, int xChange, int yChange, int color) {
		// TODO Auto-generated method stub
		int count = 0;
		int tempX = xChange;
		int tempY = yChange;
		while (x + xChange >= 0 && x + xChange <= 8 && y + yChange >= 0 && y + yChange <= 8
				&& color == goModel.data[x + xChange][y + yChange]) {
			count++;
			if (xChange != 0) {
				xChange++;
			}
			if (yChange != 0) {
				if (yChange > 0) {
					yChange++;
				} else {
					yChange--;
				}
			}
		}
		xChange = tempX;
		yChange = tempY;
		while (x - xChange >= 0 && x - xChange <= 8 && y - yChange >= 0 && y - yChange <= 8
				&& color == goModel.data[x - xChange][y - yChange]) {
			count++;
			if (xChange != 0) {
				xChange++;
			}
			if (yChange != 0) {
				if (yChange > 0) {
					yChange++;
				} else {
					yChange--;
				}
			}
		}
		return count;
	}
	
		

	public void paint(Graphics graphics) {
		super.paint(graphics);
		//2D图形渲染的抗锯齿选项
		Graphics2D g=(Graphics2D) graphics;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(bg,0, 0, getWidth(), getHeight(),null);
		//棋子
		//g.fillOval(300, 300, 50, 50);
		
		for(Piece piece:pieceList)
		{
		
			piece.panit(g);
		
		}

		
		
	}


	//开始游戏
	public void begin() {

		goModel.canPlay = true;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				goModel.data[i][j] = 0;
			}
		}
		pieceList.removeAll(pieceList);
		this.repaint();
		JOptionPane.showMessageDialog(this, "游戏开始");
		
	}

	


	

}
