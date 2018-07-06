package edu.csuft.czq.go;

import javax.swing.JOptionPane;

public class GoModel 
{
	/**
	 * ���̵�����
	 */
	int [][] data =new int [9][9];
	/**
	 *  �ж��Ƿ������˶�ս
	 */
	
	Boolean isManAgainst = false; 
	Boolean canPlay = false ;

	/**
	 *��ʾ ����
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
//��������
	public void update(Piece piece) {
		int x = piece.y / 50 ;
		int y = piece.x  / 50 ;

		data[x][y] = piece.isBlack ? 1 : 2;
		
		
	}
//�ж���Ӯ
	public boolean isWin(int x,int y)
	{
		//��Ӯ��ʶ
		boolean flag = false;
		/**
		 * �����ж�
		 */

		//ͳ��������
		int count1 =1;
		//ѭ��������
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
		 * �����ж�
		 */
		//ͳ��������
		int count2 =1;
		//ѭ��������
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
		 * б���ж�
		 */
		//ͳ��������
		int count3 =1;
		//ѭ��������
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
