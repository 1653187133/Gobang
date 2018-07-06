package edu.csuft.czq.go;

import javax.swing.JOptionPane;

public class GoModel 
{
	/**
	 * 棋盘的数据
	 */
	int [][] data =new int [9][9];
	/**
	 *  判断是否是人人对战
	 */
	
	Boolean isManAgainst = false; 
	Boolean canPlay = false ;

	/**
	 *显示 矩阵
	 */



	public void show()
	{
		for( int[]row :data)
		{
			for (int e:row) {
				System.out.print(e+" \t");
				
			}
			System.out.println();
		}
	}
//更新棋子
	public void update(Piece piece) {
		int x = piece.y / 50 ;
		int y = piece.x  / 50 ;

		data[x][y] = piece.isBlack ? 1 : 2;
		
		
	}
//判断输赢
	public boolean isWin(int x,int y)
	{
		//输赢标识
		boolean flag = false;
		/**
		 * 横向判断
		 */

		//统计棋子数
		int count1 =1;
		//循环棋子数
		int i = 1;
	
		while (x+i<=8&&data[x][y]==data[x+i][y])
			{
				count1++;
				i++;
			}
				
		
	
			while((x-i)>=0&&data[x][y]==data[x-i][y])
			{
				count1++;
				i++;
			}
			
			

	
		if(count1>=5)
		{
			flag = true;
		}
		
		/**
		 * 纵向判断
		 */
		//统计棋子数
		int count2 =1;
		//循环棋子数
		int j = 1;
		while (y+j<=8&&data[x][y]==data[x][y+j])
		{
			j++;
			count2++;
		}
		while (y-j>=0&&data[x][y]==data[x][y-j])
		{
			j++;
			count2++;
		}
		if(count2>=5)
		{
			flag = true;
		}
		
		/**
		 * 斜向判断
		 */
		//统计棋子数
		int count3 =1;
		//循环棋子数
		int k = 1;
		while (x+k<=8&&y+k<=8&&data[x][y]==data[x+k][y+k])
		{
			k++;
			count3++;
		}
		while (y-k>=0&&x-k>=0&&data[x][y]==data[x-k][y-k])
		{
			k++;
			count3++;
		}
		while (x-k>=0&&y+k<=8&&data[x][y]==data[x-k][y+k])
		{
			k++;
			count3++;
		}
		while (y-k>=0&&x+k<=8&&data[x][y]==data[x+k][y-k])
		{
			k++;
			count3++;
		}
		if(count3>=5)
		{
			flag = true;
		}
	
		return flag;
		
	}
	

	
}
