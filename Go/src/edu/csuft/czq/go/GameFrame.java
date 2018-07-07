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
	 * ������Ϸ����
	 */
	public GameFrame(GoModel goModel)
	{
		this.goModel=goModel;
		
		setTitle("������--czq");
		setSize(464, 512);
		//��Ļ��С���ɸı�
		setResizable(false);
		//��Ļ���м�
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		gamePanel =new GamePanel(goModel);
		
		add(gamePanel);
		initMenu();
	
		setVisible(true);
	}

	/**
	 * ��Ӳ˵���
	 */
	public void initMenu()
	{
		//���ò˵���
		JMenuBar bar =new JMenuBar();
		setJMenuBar(bar);
		
		//��Ӳ˵�ѡ��

		JMenu menu2 = new JMenu("����");
		JMenu menu3 = new JMenu("����");
		JMenu menu4 = new JMenu("��սģʽ");
		
		//
		JMenuItem item3 = new JMenuItem("�ؿ���Ϸ");
		

		item3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				gamePanel.begin();
			
					
			}
		});
		//��սģʽ��ӵ�������
		menu2.add(menu4);
		//���ö�սģʽ�µ���Ŀ¼
		JRadioButtonMenuItem item1 = new JRadioButtonMenuItem("���˶�ս");
		JRadioButtonMenuItem item2 = new JRadioButtonMenuItem("�˻���ս");
		menu4.add(item1);
		menu4.add(item2);
		
		//�Ѷ�ѡ��
		JRadioButtonMenuItem item4 = new JRadioButtonMenuItem("ɵ���˻�");
		JRadioButtonMenuItem item5 = new JRadioButtonMenuItem("��ͨ�˻�");

		//
		ButtonGroup bg = new ButtonGroup();
		bg.add(item1);
		bg.add(item2);
		item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object[] options = { "���沢���¿�ʼ��Ϸ", "����лл" };
				
				int n = JOptionPane.showOptionDialog(null,  "��ѡ�������˶�ս�Ƿ񱣴����ò����¿�ʼ", "��ս����", 0, 1, null, options, "���沢���¿�ʼ��Ϸ");
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
				Object[] options = { "���沢���¿�ʼ��Ϸ", "����лл" };
				
				int n = JOptionPane.showOptionDialog(null,  "��ѡ�����˻���ս�Ƿ񱣴����ò����¿�ʼ", "��ս����", 0, 1, null, options, "���沢���¿�ʼ��Ϸ");
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
				Object[] options = { "�ؿ���Ϸ", "����лл" };
				int n = JOptionPane.showOptionDialog(null,  "��ͨ�˻�", "��ս����", 0, 1, null, options, "���沢���¿�ʼ��Ϸ");
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
				Object[] options = { "�ؿ���Ϸ", "����лл" };
				int n = JOptionPane.showOptionDialog(null,  "��ͨ�˻�", "��ս����", 0, 1, null, options, "���沢���¿�ʼ��Ϸ");
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
