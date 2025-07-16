package Test02_AWT;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T03_FlowLayou extends Frame implements WindowListener, ActionListener {
	Label lblTitle = null;
	public T03_FlowLayou() {
//		사용자 인터페이스 구역
		setLayout(new FlowLayout());
		setTitle("AWT Frame");
//		setSize(300, 250);	// 프레임의 크기(폭, 높이)
		setBounds(2000, 50, 400, 350);	// x좌표, y좌표, 폭, 높이
		
		lblTitle = new Label("레이블 테스트");
		add(lblTitle);
		
		Button btn1 = new Button("btn1");
		add(btn1);
		Button btn2 = new Button("btn2");
		add(btn2);
		Button btn3 = new Button("btn3");
		add(btn3);
		Button btn4 = new Button("btn4");
		add(btn4);
		Button btnExit = new Button("Exit");
		add(btnExit);
		
		addWindowListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btnExit.addActionListener(this);
		
		setVisible(true);
//		method(동작) 처리
	}
	
	public static void main(String[] args) {
		new T03_FlowLayou();
	}

	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btnText = (Button) e.getSource();
		if(btnText.getLabel().equals("btn1")) {
			System.out.println("1번 버튼입니다.");
		}
		else if(btnText.getLabel().equals("btn2")) {
			System.out.println("2번 버튼입니다.");
		}
		else if(btnText.getLabel().equals("btn3")) {
			lblTitle.setText("3번 버튼입니다.");
		}
		else if(btnText.getLabel().equals("btn4")) {
			lblTitle.setText("4번 버튼입니다.");
		}
		else if(btnText.getLabel().equals("Exit")) {
			System.exit(0);
		}
	}
}
