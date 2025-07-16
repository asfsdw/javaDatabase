package Test02_AWT;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T08_KeyboardEvent extends Frame implements WindowListener, ActionListener, KeyListener {
	Label lblTitle = null;
	public T08_KeyboardEvent() {
//		사용자 인터페이스 구역
		designView();
//		method(동작) 처리
	}
	
	private void designView() {
		setTitle("AWT Frame");
		setBounds(2000, 50, 400, 350);	// x좌표, y좌표, 폭, 높이
		
		addWindowListener(this);
		addKeyListener(this);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new T08_KeyboardEvent();
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
	public void actionPerformed(ActionEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("키보드 입력 중");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("키보드 누르고 있는 중");
		char keyCode = e.getKeyChar();
		System.out.println("입력된 Key:"+e.getKeyCode());
		if(keyCode == 'E') System.exit(0);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("키보드 누른 후, 놓음");
	}
}
