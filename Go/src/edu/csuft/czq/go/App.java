package edu.csuft.czq.go;

public class App {
	public static void main(String[] args) {
		//�߼�(ģ��)
		GoModel goModel =new GoModel();
		goModel.show();
	
		//����(��ͼ)
		GameFrame gameFrame =new GameFrame(goModel);


	}
}
