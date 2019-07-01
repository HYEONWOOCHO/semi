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


class JPanel011 extends JPanel { //1번 패널
	
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
	"발라드", "힙합", "팝송", "일렉", "트로트"
	};
	
	private JTextArea talntroduce;
	private JButton buttonSelect, buttondelete;
	
	
	public JPanel011() { //1번 패널 생성자   음악찾기
		setLayout(null);
		
		//라벨
				labelName = new JLabel("가수이름");
				labelName.setBounds(20, 50, 100, 20);
				labelSex = new JLabel("노래제목");
				labelSex.setBounds(20,100,100,20);
				labelHobby=new JLabel("인원");
				labelHobby.setBounds(20,150,100,20);
				labelNation = new JLabel("장르");
				labelNation.setBounds(20,200,100,20);
				labellntroduce = new JLabel("추가내용");
				labellntroduce.setBounds(20,250,100,20);
				
				
				
				
				//텍스트 필드
				ttName = new JTextField(); //이름 입력 부분
				ttName.setBounds(100,50,200,20); //위치와 사이즈
				qqName = new JTextField();
				qqName.setBounds(100,100,200,20);
				

				
				

				
				//체크 박스 
				checkbox[0] =new JCheckBox("솔로");
				checkbox[0].setBounds(100,150,60,20);
				checkbox[1] = new JCheckBox("듀엣");
				checkbox[1].setBounds(160,150,60,20);
				checkbox[2] = new JCheckBox("그룹");
				checkbox[2].setBounds(220,150,80,20);
				
				//콤보박스
				comboxNation = new JComboBox(nationlist);
				comboxNation.setBounds(100,200,80,20);
				
				//텍스트 에어리어,결과 출력 부분
				talntroduce = new JTextArea();
				talntroduce.setEditable(false);
				
				//JTextArea는 JScrollPane를 써야 스크롤 바가 생긴다
				JScrollPane scrollPane = new JScrollPane(talntroduce);
				scrollPane.setBounds(100,255,200,150);
				
				
				//버튼
				BevelBorder eborder = new BevelBorder(BevelBorder.RAISED);
				buttonSelect = new JButton("찾기");
				buttonSelect.setBounds(100,430,100,20);
				buttonSelect.setContentAreaFilled(false); //내용채우기 x
				buttonSelect.setFocusPainted(false);
				buttonSelect.setBorder(eborder);
				
				buttonSelect.addActionListener(new EventHandlerSave()); //? 버튼리스너 등록
				buttondelete = new JButton("지우기");
				buttondelete.setBounds(200,430,100,20);
				buttondelete.setContentAreaFilled(false); //내용채우기 x
				buttondelete.setFocusPainted(false);
				buttondelete.setBorder(eborder);
				buttondelete.setForeground(Color.RED);
				buttondelete.addActionListener(new EventHandlerSave()); //? 버튼리스너 등록
				
				
				//프레임 컨테이너의 각종 컴포넌트들을 등록
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
			//텍스트 필드값 가져오기
			String a = ttName.getText();
			String b=  qqName.getText();
			
			String two [] = new String[2];
			
			music_DB mu = new music_DB();
			if(e.getSource() == buttonSelect) {
				talntroduce.append("---입력값---------"+"\n");
		try {
				Connection con = mu.getDB();
				mu.getDB();
				
				two =mu.selectmusic(ttName.getText(), qqName.getText());
				
			} catch (Exception e1) {
				System.out.println("연결 실패 : panel 1");
			}
			}
			
			
			
			
			//체크박스 값 가져오기
			if(checkbox[0].isSelected())
				check[0]="솔로";
			else check[0]="";
			if(checkbox[1].isSelected())
				check[1]="듀엣";
			else check[1]="";
			if(checkbox[2].isSelected())
				check[2]="그룹";
			else check[2]="";
			
			//콤보박스 값 가져오기 
			String d= (String) comboxNation.getSelectedItem();
			
			
			//TextArea 필드에 출럭 보이기
			talntroduce.append("가수이름 =" +a+"\n");
			talntroduce.append("노래제목 =" +b+"\n");
			talntroduce.append("인원 =" +check[0]+ check[1]+check[2]+"\n");
			talntroduce.append("장르 =" +d+"\n");
			talntroduce.append("--------------------"+"\n");
			talntroduce.append("===찾은값==="+"\n");
			talntroduce.append("가수이름 ="+two[0]+"\n");
			talntroduce.append("노래제목 ="+two[1]+"\n");
			talntroduce.append("===========");
			
			//삭제버튼 눌렀을때 전체 초기화
			if(e.getSource() == buttondelete) {
				talntroduce.setText("");
				
			}
}
}
}


class JPanel022 extends JPanel{ //2번째 패널
	
	private JTextArea talntroduce;
	private JLabel Name1;
	private JLabel Name2;
	 JTextField box1;
	 JTextField box2;
	 
	 private JButton button;
	 
	 public JPanel022() {
		 
		 setLayout(null); 
		Name1= new JLabel("삭제하고 싶은 노래");
		Name1.setBounds(20, 50, 120, 20);
		Name1.setForeground(Color.DARK_GRAY);
		Name2 = new JLabel("입력내용");
		Name2.setBounds(20,200,100,20);
		
		box1=new JTextField();
		box1.setBounds(150,50,200,20);
//		box2=new JTextField();

		
		BevelBorder eborder = new BevelBorder(BevelBorder.RAISED);
		button=new JButton("삭제");
		button.setBounds(370,45,120,25);
		button.setContentAreaFilled(false); //내용채우기 x
		button.setFocusPainted(false);
		button.setBorder(eborder);
		button.setForeground(Color.blue);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				music_DB db = new music_DB();
			
				try {
					 db.delete(box1.getText());
					JOptionPane.showMessageDialog(null , "삭제 성공");
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null , "삭제 실패");
				}
			}
		});
		
		talntroduce = new JTextArea();
		talntroduce.setEditable(false);
		//JTextArea는 JScrollPane를 써야 스크롤 바가 생긴다
		JScrollPane scrollPane = new JScrollPane(talntroduce);
		scrollPane.setBounds(90,200,255,200);
		
		
		add(Name1);
		add(Name2);
		add(box1);
		add(button);
		add(scrollPane);
		
		
		//음악넣기
		ImageIcon icon = new ImageIcon("music2.png");
		JLabel img_l = new JLabel(icon);
		img_l.setBounds(0, 0, 700, 500);
		JPanel panel = new JPanel(null);
		panel.setBounds(0,0,700,488);
		panel.add(img_l);
		add(panel);
	 }

	

	private ActionListener ActionListener() {
		//텍스트 필드값 가져오기
		String a = box1.getText();
		String b=  box2.getText();
		
		music_DB mu = new music_DB();
		
		return null;
		}
	}
	
	
	
//}

class JPanel033 extends JPanel{ //3번째 패널 
	//클래스 맴버 필드 설정
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
	"발라드", "힙합", "팝송", "일렉", "트로트"
	};
	
	private JTextArea talntroduce;
	private JButton buttonSave, buttondelete;
	
	
	public JPanel033() { //3번째 패널 생성자
		setLayout(null);
		//라벨
		labelName = new JLabel("가수이름");
		labelName.setBounds(20, 50, 100, 20);
		labelSex = new JLabel("노래제목");
		labelSex.setBounds(20,100,100,20);
		labelHobby=new JLabel("인원");
		labelHobby.setBounds(20,150,100,20);
		labelNation = new JLabel("장르");
		labelNation.setBounds(20,200,100,20);
		labellntroduce = new JLabel("추가내용");
		labellntroduce.setBounds(20,250,100,20);
		
		//텍스트 필드
		ttName = new JTextField(); //이름 입력 부분
		ttName.setBounds(100,50,200,20); //위치와 사이즈
		qqName = new JTextField();
		qqName.setBounds(100,100,200,20);
		
		//체크 박스 
		checkbox[0] =new JCheckBox("솔로");
		checkbox[0].setBounds(100,150,60,20);
		checkbox[1] = new JCheckBox("듀엣");
		checkbox[1].setBounds(160,150,60,20);
		checkbox[2] = new JCheckBox("그룹");
		checkbox[2].setBounds(220,150,80,20);
		
		
		
		//콤보박스
		comboxNation = new JComboBox(nationlist);
		comboxNation.setBounds(100,200,80,20);
		
		//텍스트 에어리어,결과 출력 부분
		talntroduce = new JTextArea();
		talntroduce.setEditable(false);
		
		//JTextArea는 JScrollPane를 써야 스크롤 바가 생긴다
		JScrollPane scrollPane = new JScrollPane(talntroduce);
		scrollPane.setBounds(100,255,200,150);
		
		
		//버튼
		BevelBorder eborder = new BevelBorder(BevelBorder.RAISED);
		buttonSave = new JButton("저장");
		buttonSave.setBounds(100,430,100,20);
		buttonSave.setContentAreaFilled(false); //내용채우기 x
		buttonSave.setFocusPainted(false);
		buttonSave.setBorder(eborder);
		buttonSave.setForeground(Color.BLACK);
		buttonSave.addActionListener(new EventHandlerSave()); //? 버튼리스너 등록
		buttondelete = new JButton("지우기");
		buttondelete.setBounds(200,430,100,20);
		buttondelete.setContentAreaFilled(false); //내용채우기 x
		buttondelete.setFocusPainted(false); //테두리없애기
		buttondelete.setBorder(eborder);  //앞으로 튀어나오게
		buttondelete.setForeground(Color.RED);
		buttondelete.addActionListener(new EventHandlerSave()); //? 버튼리스너 등록
		
		
		//프레임 컨테이너의 각종 컴포넌트들을 등록
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
			//텍스트 필드값 가져오기
			String a = ttName.getText();
			String b=  qqName.getText();
			
			
			music_DB mu = new music_DB();
			if (e.getSource()==buttonSave) {
				
			try {
				Connection con = mu.getDB();
				mu.getDB();
				mu.savemusic(ttName.getText(), qqName.getText());
			} catch (Exception e1) {
				System.out.println("연결 실패");
			} 
			}
			
		
			//체크박스 값 가져오기
			if(checkbox[0].isSelected())
				check[0]="솔로";
			else check[0]="";
			if(checkbox[1].isSelected())
				check[1]="듀엣";
			else check[1]="";
			if(checkbox[2].isSelected())
				check[2]="그룹";
			else check[2]="";
			
			//콤보박스 값 가져오기 
			String d=  (String) comboxNation.getSelectedItem();
			
			
			//TextArea 필드에 출럭 보이기
			if (e.getSource() == buttonSave) {
				talntroduce.append("저장버튼 눌림"+"\n");
				
				talntroduce.append("----------입력값------------"+"\n");
				talntroduce.append("가수이름 =" +a+"\n");
				talntroduce.append("노래제목 =" +b+"\n");
				talntroduce.append("인원 =" +check[0]+ check[1]+check[2]+"\n");
				talntroduce.append("장르 =" +d+"\n");
				talntroduce.append("------------------------------"+"\n");
				talntroduce.append("저장되었습니다.");
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
		
		JTabbedPane jt=new JTabbedPane(); //JTabbedPane 객체 생성
		jt.setBackground(Color.CYAN);
		jt.addTab("음락저장", mg.jpanel03);
		jt.addTab("음악찾기", mg.jpanel01);
		jt.addTab("음악삭제", mg.jpanel02);
		
		
		mg.add(jt);
		mg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mg.setSize(700,550);
		mg.setVisible(true);
		
		
		
		
		
		
		
		
	}
	
	   }

