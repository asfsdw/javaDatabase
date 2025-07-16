package Test02_AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T02_2 extends Frame implements WindowListener, ActionListener {
	public T02_2() {
//		사용자 인터페이스 구역
		setTitle("AWT Frame");
//		setSize(300, 250);	// 프레임의 크기(폭, 높이)
		setBounds(2000, 50, 400, 350);	// x좌표, y좌표, 폭, 높이
		
		Label lblTitle = new Label("레이블 테스트");
		add(lblTitle);
		Button btnExit = new Button("Exit");
		add(btnExit);
		
		addWindowListener(this);
		btnExit.addActionListener(this);
		
		setVisible(true);
//		method(동작) 처리
	}
	
	public static void main(String[] args) {
		new T02_2();
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
		System.exit(0);
	}
}
