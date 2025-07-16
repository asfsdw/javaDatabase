package Test03_Swing;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class T02_Radio2 extends JFrame {
	public T02_Radio2() {
		super("스윙 연습");
		designView();
	}
	private void designView() {
		setSize(400, 350);
		setLocationRelativeTo(null);	// 윈도우 중앙에 배치
//		setDefaultCloseOperation(3);	// 윈도우 닫기버튼을 클릭해서 창닫기 수행
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 위와 똑같은 기능이다.
		setResizable(false);	// 윈도우창 크기 고정(변경 불가), 기본 True
		
		setLayout(new GridLayout(4,1));
		JPanel pn1 = new JPanel();
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		JPanel pn4 = new JPanel();
		pn1.setBackground(Color.BLUE);
		pn2.setBackground(Color.GREEN);
		pn3.setBackground(Color.YELLOW);
		pn4.setBackground(Color.CYAN);
		
		JLabel lbl1 = new JLabel("스윙연습하기");
		pn1.add(lbl1);
		
//		체크박스		
		JCheckBox checkBox1 = new JCheckBox("등산");
		JCheckBox checkBox2 = new JCheckBox("낚시");
		JCheckBox checkBox3 = new JCheckBox("수영");
		JCheckBox checkBox4 = new JCheckBox("바둑");
		JCheckBox checkBox5 = new JCheckBox("기타");
		
		pn2.add(checkBox1);
		pn2.add(checkBox2);
		pn2.add(checkBox3);
		pn2.add(checkBox4);
		pn2.add(checkBox5);
		
//		라디오 버튼
		CheckboxGroup gender = new CheckboxGroup();
		Checkbox chkMale = new Checkbox("Male", gender, false);
		Checkbox chkFemale = new Checkbox("Female",gender, true);
		
		pn3.add(chkMale);
		pn3.add(chkFemale);
		
		JButton btnExit = new JButton("종료");
		pn4.add(btnExit);
		
		add(pn1);
		add(pn2);
		add(pn3);
		add(pn4);
		
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
		new T03_DialogBox();
	}
}
