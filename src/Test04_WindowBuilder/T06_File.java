package Test04_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class T06_File {
	private JFrame frame;
	public static void main(String[] args) {
		new T06_File();
	}
	public T06_File() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("파일연습");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("이미지 선택");
		btnImage.setFont(new Font("굴림", Font.BOLD, 20));
		btnImage.setBounds(12, 10, 193, 56);
		frame.getContentPane().add(btnImage);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(12, 76, 760, 360);
		frame.getContentPane().add(lblImage);
		
		JTextArea taMessage = new JTextArea();
		taMessage.setFont(new Font("굴림", Font.BOLD, 20));
		taMessage.setBounds(12, 450, 760, 101);
		frame.getContentPane().add(taMessage);
		
		frame.setVisible(true);
		
//		이미지선택 버튼
		btnImage.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg, gif, png Images", "jpg", "gif", "png");
				
				chooser.setFileFilter(filter);
				int res = chooser.showOpenDialog(null);
				
				if(res != chooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(frame, "파일을 선택해주세요.","경고",JOptionPane.WARNING_MESSAGE);
				}
				else {
					String filePath = chooser.getSelectedFile().getPath();
					String fileName = chooser.getSelectedFile().getName();
					
					lblImage.setIcon(new ImageIcon(filePath));
					
					String fileInfo = "경로명과 파일명 :"+filePath+", \n파일명 :"+fileName;
					taMessage.setText(fileInfo);
				}
			}
		});
	}
}
