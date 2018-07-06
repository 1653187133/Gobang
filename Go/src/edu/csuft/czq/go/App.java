package edu.csuft.czq.go;

public class App {
	public static void main(String[] args) {
		//逻辑(模型)
		GoModel goModel =new GoModel();
		goModel.show();
	
		//界面(视图)
		GameFrame gameFrame =new GameFrame(goModel);


	}
}
