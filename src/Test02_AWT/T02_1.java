package Test02_AWT;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T02_1 extends Frame implements WindowListener{
	public T02_1() {
		setTitle("AWT Frame");
//		setSize(300, 250);	// 프레임의 크기(폭, 높이)
		setBounds(2000, 100, 400, 350);	// x좌표, y좌표, 폭, 높이
		setVisible(true);
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new T02_1();
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
}
