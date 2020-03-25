package java0324_Tr;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameEX1 extends JFrame{
	
	JPanel nP, cP, sP;
	JLabel idLabel, pwLabel;
	JTextField idField, pwdField;
	JButton loginBtn;	
	
	FrameEX1(){
		super("너와나 프로그램!"); // frame의 기본 레이아웃은 borderlayout
		this.setLayout(new BorderLayout());	
		this.setBounds(1500, 100, 300, 200);
		
		//north 패널 만들기
		nP= new JPanel();  // 패널의 기본 레이아웃은 flowlayout
		idLabel = new JLabel("아이디");
		nP.add(idLabel);
		idField = new JTextField(15);
		nP.add(idField);
		//center패널만들기
		cP = new JPanel();
		pwLabel = new JLabel("암    호");
		pwdField = new JTextField(15);
		cP.add(pwLabel);
		cP.add(pwdField);
		//South 패널만들기
		sP = new JPanel();
		loginBtn = new JButton("LogIn");
		sP.add(loginBtn);
		
		
		// frame에 패널 올리기
		this.add(nP, "North");
		this.add(cP,"Center");
		this.add(sP,"South");
		
		//this.setBackground(Color.blue);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrameEX1();

	}

}
