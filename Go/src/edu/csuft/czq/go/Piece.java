package edu.csuft.czq.go;


import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Æå×Ó
 * 
 * @author czq
 *
 */

public class Piece {
	GoModel goModel;
	int x;
	int y;
	Color color;
	int size =30;
	boolean isBlack  = true;
	public Piece(int x, int y) {
		this.x  = x-size/2;
		this.y  = y-size/2;
		
	}


	public void panit(Graphics2D g) {
		int newx =( x  / 50) * 48+18 ;
		int newy =( y  / 50) * 48+18 ;
	
		
		g.setColor(isBlack?Color.black:Color.white);
		g.fillOval(newx, newy, size, size);
	
		
	}


}
