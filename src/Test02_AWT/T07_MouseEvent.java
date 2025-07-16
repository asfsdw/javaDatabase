package Test02_AWT;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T07_MouseEvent extends Frame implements WindowListener, ActionListener, MouseListener {
	Label lblTitle = null;
	public T07_MouseEvent() {
//		사용자 인터페이스 구역
		designView();
//		method(동작) 처리
	}
	
	private void designView() {
		setTitle("AWT Frame");
		setBounds(2000, 50, 400, 350);	// x좌표, y좌표, 폭, 높이
		
		addWindowListener(this);
		addMouseListener(this);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new T07_MouseEvent();
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
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("마우스 클릭하는 순간");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("아무스 클린한 후, 놓는 순간");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("마우스가 특정 객체 안으로 들어가는 순간");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("마우스가 특정 객체 밖으로 빠져나가는 순간");
	}
}
