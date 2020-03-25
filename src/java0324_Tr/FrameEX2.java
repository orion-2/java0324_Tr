package java0324_Tr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrameEX2 extends JFrame implements ActionListener{
	JLabel titleLb, listLb, infoLb;
	JPanel wp, cp, sp;
	JButton sendBtn, clrBtn;

	JList userList;
	JTextArea userInfo;
	JTextField msgbar;
	DefaultListModel<String> lm = new DefaultListModel<String>();
	
	FrameEX2(){
		this.setBounds(1500, 200, 300, 400);
		createN();
		createW();
		createC();
		createS();
		
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
	private void createS() {
		sp = new JPanel();
		sp.setBackground(Color.red);
		msgbar = new JTextField(10);
		sendBtn = new JButton("Send");
		clrBtn = new JButton("Clear");
		sp.add(msgbar);
		sp.add(sendBtn);
		sp.add(clrBtn);
		this.add(sp,"South");
		
		msgbar.addActionListener(this);
		sendBtn.addActionListener(this);
		clrBtn.addActionListener(this);
		
	}
	private void createC() {
		cp= new JPanel();
		cp.setLayout(new BorderLayout());
		infoLb = new JLabel("   대화내용");
		userInfo = new JTextArea(10,4);
		userInfo.setBackground(Color.LIGHT_GRAY);
		userInfo.append("hahaha"+"\n");
		userInfo.append("<순호> 순호가 햄버거를 보고 있어요");
		cp.add(infoLb,"North");
		cp.add(userInfo,"Center");
		this.add(cp,"Center");
	}
	private void createW() {
		wp= new JPanel();
		wp.setLayout(new BorderLayout());
		listLb = new JLabel("친구들");
		wp.add(listLb,"North");
		
		userList = new JList(lm);
		userList.setBackground(Color.yellow);
		lm.addElement("kkk");
		lm.addElement("aaa");
		
		wp.add(userList,"Center");
		this.add(wp,"West");
		
	}
	private void createN() {
		titleLb = new JLabel(" 너와 나 ver 1.0");
		this.add(titleLb,"North");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object nowCom = e.getSource();
		if(nowCom.equals(sendBtn)||nowCom.equals(msgbar)) {
			String msg = msgbar.getText();
			//titleLb.setText(msg);
			//System.out.println(msg);
			msgbar.setText("");
			userInfo.append(msg+"\n");
			
		}else if(nowCom.equals(clrBtn)) {
			msgbar.setText("");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrameEX2();

	}
}
