package Test02_AWT;

import java.awt.Frame;

@SuppressWarnings("serial")
public class T01_2 extends Frame {
	public T01_2() {
		setTitle("AWT Frame");
		setSize(300, 250);	// 프레이므이 크기(폭, 높이)
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new T01_2();
	}
}
