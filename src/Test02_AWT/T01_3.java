package Test02_AWT;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T01_3 extends Frame implements WindowListener{
	public T01_3() {
		setTitle("AWT Frame");
		setSize(300, 250);	// 프레이므이 크기(폭, 높이)
		setVisible(true);
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new T01_3();
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
