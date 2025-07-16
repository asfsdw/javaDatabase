package Test02_AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T04_BorderLayout extends Frame implements WindowListener, ActionListener {
	Label lblTitle = null;
	public T04_BorderLayout() {
//		사용자 인터페이스 구역
		designView();
//		method(동작) 처리
	}
	
	private void designView() {
		setLayout(new BorderLayout());
		setTitle("AWT Frame");
		setBounds(2000, 50, 400, 350);	// x좌표, y좌표, 폭, 높이
		
		Button btnN = new Button("북쪽");
		Button btnS = new Button("남쪽");
		Button btnW = new Button("서쪽");
		Button btnE = new Button("동쪽");
		Button btnC = new Button("중앙");
		
		add(btnN, BorderLayout.NORTH);
		add(btnS, BorderLayout.SOUTH);
		add(btnW, BorderLayout.WEST);
		add(btnE, BorderLayout.EAST);
//		add(btnC, BorderLayout.CENTER);
		add(btnC, "Center");	// 이렇게도 가능.
		
		addWindowListener(this);
		btnC.addActionListener(this);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new T04_BorderLayout();
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
		if(btnText.getLabel().equals("중앙")) {
			System.exit(0);
		}
	}
}
