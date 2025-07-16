package Test03_Swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class T02_Radio1라디오안씀 extends JFrame {
	public T02_Radio1라디오안씀() {
		super("스윙 연습");
		designView();
	}
	private void designView() {
		setSize(400, 350);
		setLocationRelativeTo(null);	// 윈도우 중앙에 배치
//		setDefaultCloseOperation(3);	// 윈도우 닫기버튼을 클릭해서 창닫기 수행
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 위와 똑같은 기능이다.
		setResizable(false);	// 윈도우창 크기 고정(변경 불가), 기본 True
		
		setLayout(new FlowLayout());
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.BLUE);
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.GREEN);
		
		JLabel lbl1 = new JLabel("스윙연습하기");
		pn1.add(lbl1);
		
		JButton btnExit = new JButton("종료");
		pn2.add(btnExit);
		
		setVisible(true);	// 화면 출력(없으면 view 화면 안 나옴)
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		});
	}
	public static void main(String[] args) {
		new T02_Radio1라디오안씀();
	}
}
