package edu.csuft.czq.go;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

/**
 * 
 * @author czq
 *
 */
public class GameFrame extends JFrame {
	/**
	 * 
	 */
	GamePanel gamePanel;

	/**
	 * 
	 */
	GoModel goModel;
	
	/**
	 * 定义游戏窗口
	 */
	public GameFrame(GoModel goModel)
	{
		this.goModel=goModel;
		
		setTitle("五子棋--czq");
		setSize(464, 512);
		//屏幕大小不可改变
		setResizable(false);
		//屏幕正中间
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		gamePanel =new GamePanel(goModel);
		
		add(gamePanel);
		initMenu();
	
		setVisible(true);
	}

	/**
	 * 添加菜单栏
	 */
	public void initMenu()
	{
		//设置菜单栏
		JMenuBar bar =new JMenuBar();
		setJMenuBar(bar);
		
		//添加菜单选项

		JMenu menu2 = new JMenu("设置");
		JMenu menu3 = new JMenu("帮助");
		JMenu menu4 = new JMenu("对战模式");
		
		//
		JMenuItem item3 = new JMenuItem("重开游戏");
		

		item3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				gamePanel.begin();
			
					
			}
		});
		//对战模式添加到设置中
		menu2.add(menu4);
		//设置对战模式下的子目录
		JRadioButtonMenuItem item1 = new JRadioButtonMenuItem("人人对战");
		JRadioButtonMenuItem item2 = new JRadioButtonMenuItem("人机对战");
		menu4.add(item1);
		menu4.add(item2);
		
		//难度选择
		JRadioButtonMenuItem item4 = new JRadioButtonMenuItem("傻瓜人机");
		JRadioButtonMenuItem item5 = new JRadioButtonMenuItem("普通人机");

		//
		ButtonGroup bg = new ButtonGroup();
		bg.add(item1);
		bg.add(item2);
		item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object[] options = { "保存并重新开始游戏", "不，谢谢" };
				
				int n = JOptionPane.showOptionDialog(null,  "你选择了人人对战是否保存设置并重新开始", "对战设置", 0, 1, null, options, "保存并重新开始游戏");
				if(n == 0)
				{
					goModel.isManAgainst = false;
                    gamePanel.begin();
                    item4.setEnabled(false);
                    item5.setEnabled(false);
                  

					item1.setSelected(true);
				}
			
				
			}
		});
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object[] options = { "保存并重新开始游戏", "不，谢谢" };
				
				int n = JOptionPane.showOptionDialog(null,  "你选择了人机对战是否保存设置并重新开始", "对战设置", 0, 1, null, options, "保存并重新开始游戏");
				if(n == 0)
				{
			        item4.setEnabled(true);
                    item5.setEnabled(true);
					goModel.isManAgainst = true;
					item4.setSelected(true );
					gamePanel.begin();
	
				}
				
			}
		});

		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(item4);
		bg1.add(item5);
		item4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object[] options = { "重开游戏", "不，谢谢" };
				int n = JOptionPane.showOptionDialog(null,  "普通人机", "对战设置", 0, 1, null, options, "保存并重新开始游戏");
				if(n == 0)
				{
					goModel.isManAgainst = true;
                    item4.setEnabled(true);
                    item5.setEnabled(true);
                    item4.setSelected(true );
                    gamePanel.level = 0;
					 gamePanel.begin();
					
				}
				
			}
		});
		item5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object[] options = { "重开游戏", "不，谢谢" };
				int n = JOptionPane.showOptionDialog(null,  "普通人机", "对战设置", 0, 1, null, options, "保存并重新开始游戏");
				if(n == 0)
				{
					goModel.isManAgainst = true;
                    item4.setEnabled(true);
                    item5.setEnabled(true);
                    item5.setSelected(true );
                    gamePanel.level = 1;
					 gamePanel.begin();
					
				}
				
			}
		});
		
	

		bar.add(menu2);

		
		
		bar.add(item4);
		bar.add(item5);
		bar.add(item3);
		bar.add(menu3);
		}
	
	

}
