package Mugic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import Mugic.JPanel033.EventHandlerSave;
import save.save;


class JPanel011 extends JPanel { //1�� �г�
	
	private JButton jButton1;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JLabel labelName;
	private JLabel labelSex;
	private JLabel labelHobby;
	private JLabel labelNation;
	private JLabel labellntroduce;
	
	JTextField ttName, qqName;
	
	private JRadioButton radioBoy;
	private JRadioButton radioGirl;
	private JRadioButton [] sex=new JRadioButton[2];
	private String sexx = "";
	
	private JCheckBox [] checkbox = new JCheckBox[3];
	private JCheckBox checkMovie;
	private JCheckBox checkReding;
	private JCheckBox checkCicle;
	private String [] check = {"","",""};
	
	private JComboBox comboxNation;
	private String []nationlist= {
	"�߶��", "����", "�˼�", "�Ϸ�", "Ʈ��Ʈ"
	};
	
	private JTextArea talntroduce;
	private JButton buttonSelect, buttondelete;
	
	
	public JPanel011() { //1�� �г� ������   ����ã��
		setLayout(null);
		
		//��
				labelName = new JLabel("�����̸�");
				labelName.setBounds(20, 50, 100, 20);
				labelSex = new JLabel("�뷡����");
				labelSex.setBounds(20,100,100,20);
				labelHobby=new JLabel("�ο�");
				labelHobby.setBounds(20,150,100,20);
				labelNation = new JLabel("�帣");
				labelNation.setBounds(20,200,100,20);
				labellntroduce = new JLabel("�߰�����");
				labellntroduce.setBounds(20,250,100,20);
				
				
				
				
				//�ؽ�Ʈ �ʵ�
				ttName = new JTextField(); //�̸� �Է� �κ�
				ttName.setBounds(100,50,200,20); //��ġ�� ������
				qqName = new JTextField();
				qqName.setBounds(100,100,200,20);
				

				
				

				
				//üũ �ڽ� 
				checkbox[0] =new JCheckBox("�ַ�");
				checkbox[0].setBounds(100,150,60,20);
				checkbox[1] = new JCheckBox("�࿧");
				checkbox[1].setBounds(160,150,60,20);
				checkbox[2] = new JCheckBox("�׷�");
				checkbox[2].setBounds(220,150,80,20);
				
				//�޺��ڽ�
				comboxNation = new JComboBox(nationlist);
				comboxNation.setBounds(100,200,80,20);
				
				//�ؽ�Ʈ �����,��� ��� �κ�
				talntroduce = new JTextArea();
				talntroduce.setEditable(false);
				
				//JTextArea�� JScrollPane�� ��� ��ũ�� �ٰ� �����
				JScrollPane scrollPane = new JScrollPane(talntroduce);
				scrollPane.setBounds(100,255,200,150);
				
				
				//��ư
				BevelBorder eborder = new BevelBorder(BevelBorder.RAISED);
				buttonSelect = new JButton("ã��");
				buttonSelect.setBounds(100,430,100,20);
				buttonSelect.setContentAreaFilled(false); //����ä��� x
				buttonSelect.setFocusPainted(false);
				buttonSelect.setBorder(eborder);
				
				buttonSelect.addActionListener(new EventHandlerSave()); //? ��ư������ ���
				buttondelete = new JButton("�����");
				buttondelete.setBounds(200,430,100,20);
				buttondelete.setContentAreaFilled(false); //����ä��� x
				buttondelete.setFocusPainted(false);
				buttondelete.setBorder(eborder);
				buttondelete.setForeground(Color.RED);
				buttondelete.addActionListener(new EventHandlerSave()); //? ��ư������ ���
				
				
				//������ �����̳��� ���� ������Ʈ���� ���
				add(labelName);
				add(labelSex);
				add(labelHobby);
				add(labelNation);
				add(labellntroduce);
				add(ttName);
				add(qqName);
				add(checkbox[0]);
				add(checkbox[1]);
				add(checkbox[2]);
				add(comboxNation);
				
				add(scrollPane);
				add(buttonSelect);
				add(buttondelete);
				
				
				ImageIcon icon = new ImageIcon("music2.png");
				JLabel img_l = new JLabel(icon);
				img_l.setBounds(0, 0, 700, 500);
				JPanel panel = new JPanel(null);
				panel.setBounds(0,0,700,500);
				panel.add(img_l);
				add(panel);
					
	}
class  EventHandlerSave implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//�ؽ�Ʈ �ʵ尪 ��������
			String a = ttName.getText();
			String b=  qqName.getText();
			
			String two [] = new String[2];
			
			music_DB mu = new music_DB();
			if(e.getSource() == buttonSelect) {
				talntroduce.append("---�Է°�---------"+"\n");
		try {
				Connection con = mu.getDB();
				mu.getDB();
				
				two =mu.selectmusic(ttName.getText(), qqName.getText());
				
			} catch (Exception e1) {
				System.out.println("���� ���� : panel 1");
			}
			}
			
			
			
			
			//üũ�ڽ� �� ��������
			if(checkbox[0].isSelected())
				check[0]="�ַ�";
			else check[0]="";
			if(checkbox[1].isSelected())
				check[1]="�࿧";
			else check[1]="";
			if(checkbox[2].isSelected())
				check[2]="�׷�";
			else check[2]="";
			
			//�޺��ڽ� �� �������� 
			String d= (String) comboxNation.getSelectedItem();
			
			
			//TextArea �ʵ忡 �ⷰ ���̱�
			talntroduce.append("�����̸� =" +a+"\n");
			talntroduce.append("�뷡���� =" +b+"\n");
			talntroduce.append("�ο� =" +check[0]+ check[1]+check[2]+"\n");
			talntroduce.append("�帣 =" +d+"\n");
			talntroduce.append("--------------------"+"\n");
			talntroduce.append("===ã����==="+"\n");
			talntroduce.append("�����̸� ="+two[0]+"\n");
			talntroduce.append("�뷡���� ="+two[1]+"\n");
			talntroduce.append("===========");
			
			//������ư �������� ��ü �ʱ�ȭ
			if(e.getSource() == buttondelete) {
				talntroduce.setText("");
				
			}
}
}
}


class JPanel022 extends JPanel{ //2��° �г�
	
	private JTextArea talntroduce;
	private JLabel Name1;
	private JLabel Name2;
	 JTextField box1;
	 JTextField box2;
	 
	 private JButton button;
	 
	 public JPanel022() {
		 
		 setLayout(null); 
		Name1= new JLabel("�����ϰ� ���� �뷡");
		Name1.setBounds(20, 50, 120, 20);
		Name1.setForeground(Color.DARK_GRAY);
		Name2 = new JLabel("�Է³���");
		Name2.setBounds(20,200,100,20);
		
		box1=new JTextField();
		box1.setBounds(150,50,200,20);
//		box2=new JTextField();

		
		BevelBorder eborder = new BevelBorder(BevelBorder.RAISED);
		button=new JButton("����");
		button.setBounds(370,45,120,25);
		button.setContentAreaFilled(false); //����ä��� x
		button.setFocusPainted(false);
		button.setBorder(eborder);
		button.setForeground(Color.blue);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				music_DB db = new music_DB();
			
				try {
					 db.delete(box1.getText());
					JOptionPane.showMessageDialog(null , "���� ����");
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null , "���� ����");
				}
			}
		});
		
		talntroduce = new JTextArea();
		talntroduce.setEditable(false);
		//JTextArea�� JScrollPane�� ��� ��ũ�� �ٰ� �����
		JScrollPane scrollPane = new JScrollPane(talntroduce);
		scrollPane.setBounds(90,200,255,200);
		
		
		add(Name1);
		add(Name2);
		add(box1);
		add(button);
		add(scrollPane);
		
		
		//���ǳֱ�
		ImageIcon icon = new ImageIcon("music2.png");
		JLabel img_l = new JLabel(icon);
		img_l.setBounds(0, 0, 700, 500);
		JPanel panel = new JPanel(null);
		panel.setBounds(0,0,700,488);
		panel.add(img_l);
		add(panel);
	 }

	

	private ActionListener ActionListener() {
		//�ؽ�Ʈ �ʵ尪 ��������
		String a = box1.getText();
		String b=  box2.getText();
		
		music_DB mu = new music_DB();
		
		return null;
		}
	}
	
	
	
//}

class JPanel033 extends JPanel{ //3��° �г� 
	//Ŭ���� �ɹ� �ʵ� ����
	private JLabel labelName;
	private JLabel labelSex;
	private JLabel labelHobby;
	private JLabel labelNation;
	private JLabel labellntroduce;
	
	 JTextField ttName, qqName;
	
	private JRadioButton radioBoy;
	private JRadioButton radioGirl;
	private JRadioButton [] sex=new JRadioButton[2];
	private String sexx = "";
	
	private JCheckBox [] checkbox = new JCheckBox[3];
	private String [] check = {"","",""};
	
	private JComboBox comboxNation;
	private String []nationlist= {
	"�߶��", "����", "�˼�", "�Ϸ�", "Ʈ��Ʈ"
	};
	
	private JTextArea talntroduce;
	private JButton buttonSave, buttondelete;
	
	
	public JPanel033() { //3��° �г� ������
		setLayout(null);
		//��
		labelName = new JLabel("�����̸�");
		labelName.setBounds(20, 50, 100, 20);
		labelSex = new JLabel("�뷡����");
		labelSex.setBounds(20,100,100,20);
		labelHobby=new JLabel("�ο�");
		labelHobby.setBounds(20,150,100,20);
		labelNation = new JLabel("�帣");
		labelNation.setBounds(20,200,100,20);
		labellntroduce = new JLabel("�߰�����");
		labellntroduce.setBounds(20,250,100,20);
		
		//�ؽ�Ʈ �ʵ�
		ttName = new JTextField(); //�̸� �Է� �κ�
		ttName.setBounds(100,50,200,20); //��ġ�� ������
		qqName = new JTextField();
		qqName.setBounds(100,100,200,20);
		
		//üũ �ڽ� 
		checkbox[0] =new JCheckBox("�ַ�");
		checkbox[0].setBounds(100,150,60,20);
		checkbox[1] = new JCheckBox("�࿧");
		checkbox[1].setBounds(160,150,60,20);
		checkbox[2] = new JCheckBox("�׷�");
		checkbox[2].setBounds(220,150,80,20);
		
		
		
		//�޺��ڽ�
		comboxNation = new JComboBox(nationlist);
		comboxNation.setBounds(100,200,80,20);
		
		//�ؽ�Ʈ �����,��� ��� �κ�
		talntroduce = new JTextArea();
		talntroduce.setEditable(false);
		
		//JTextArea�� JScrollPane�� ��� ��ũ�� �ٰ� �����
		JScrollPane scrollPane = new JScrollPane(talntroduce);
		scrollPane.setBounds(100,255,200,150);
		
		
		//��ư
		BevelBorder eborder = new BevelBorder(BevelBorder.RAISED);
		buttonSave = new JButton("����");
		buttonSave.setBounds(100,430,100,20);
		buttonSave.setContentAreaFilled(false); //����ä��� x
		buttonSave.setFocusPainted(false);
		buttonSave.setBorder(eborder);
		buttonSave.setForeground(Color.BLACK);
		buttonSave.addActionListener(new EventHandlerSave()); //? ��ư������ ���
		buttondelete = new JButton("�����");
		buttondelete.setBounds(200,430,100,20);
		buttondelete.setContentAreaFilled(false); //����ä��� x
		buttondelete.setFocusPainted(false); //�׵θ����ֱ�
		buttondelete.setBorder(eborder);  //������ Ƣ�����
		buttondelete.setForeground(Color.RED);
		buttondelete.addActionListener(new EventHandlerSave()); //? ��ư������ ���
		
		
		//������ �����̳��� ���� ������Ʈ���� ���
		add(labelName);
		add(labelSex);
		add(labelHobby);
		add(labelNation);
		add(labellntroduce);
		add(ttName);
		add(qqName);
		
		add(checkbox[0]);
		add(checkbox[1]);
		add(checkbox[2]);
		
		add(comboxNation);
		
		add(scrollPane);
		add(buttonSave);
		add(buttondelete);
		
		
		ImageIcon icon = new ImageIcon("music2.png");
		JLabel img_l = new JLabel(icon);
		img_l.setBounds(0, 0, 700, 500);
		JPanel panel = new JPanel(null);
		panel.setBounds(0,0,700,500);
		panel.add(img_l);
		add(panel);
		
	}
	
	class  EventHandlerSave implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//�ؽ�Ʈ �ʵ尪 ��������
			String a = ttName.getText();
			String b=  qqName.getText();
			
			
			music_DB mu = new music_DB();
			if (e.getSource()==buttonSave) {
				
			try {
				Connection con = mu.getDB();
				mu.getDB();
				mu.savemusic(ttName.getText(), qqName.getText());
			} catch (Exception e1) {
				System.out.println("���� ����");
			} 
			}
			
		
			//üũ�ڽ� �� ��������
			if(checkbox[0].isSelected())
				check[0]="�ַ�";
			else check[0]="";
			if(checkbox[1].isSelected())
				check[1]="�࿧";
			else check[1]="";
			if(checkbox[2].isSelected())
				check[2]="�׷�";
			else check[2]="";
			
			//�޺��ڽ� �� �������� 
			String d=  (String) comboxNation.getSelectedItem();
			
			
			//TextArea �ʵ忡 �ⷰ ���̱�
			if (e.getSource() == buttonSave) {
				talntroduce.append("�����ư ����"+"\n");
				
				talntroduce.append("----------�Է°�------------"+"\n");
				talntroduce.append("�����̸� =" +a+"\n");
				talntroduce.append("�뷡���� =" +b+"\n");
				talntroduce.append("�ο� =" +check[0]+ check[1]+check[2]+"\n");
				talntroduce.append("�帣 =" +d+"\n");
				talntroduce.append("------------------------------"+"\n");
				talntroduce.append("����Ǿ����ϴ�.");
				}
			if (e.getSource() == buttondelete) {
				talntroduce.setText("");
			}
			
			
				
				
			
		}
		
	}
	
	
}




public class Mugic extends JFrame{
	
	public JPanel011 jpanel01 = null;
	public JPanel022 jpanel02 = null;
	public JPanel033 jpanel03 = null;
	
	
	public static void main(String[] args) throws Exception {
		Mugic mg=new Mugic();
		mg.setTitle("Music");
		mg.jpanel01 = new JPanel011();
		mg.jpanel01.setBackground(Color.red);
		mg.jpanel02 = new JPanel022();
		mg.jpanel03 = new JPanel033();
		
		JTabbedPane jt=new JTabbedPane(); //JTabbedPane ��ü ����
		jt.setBackground(Color.CYAN);
		jt.addTab("��������", mg.jpanel03);
		jt.addTab("����ã��", mg.jpanel01);
		jt.addTab("���ǻ���", mg.jpanel02);
		
		
		mg.add(jt);
		mg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mg.setSize(700,550);
		mg.setVisible(true);
		
		
		
		
		
		
		
		
	}
	
	   }

