package cn.encdata.sfmi.game21;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AboutFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel jLabel1 = new JLabel("��Ϸ����");
	JLabel jLabel2 = new JLabel("����");
	JTextArea textArea1 = new JTextArea();
	JTextArea textArea2 = new JTextArea();
	public AboutFrame() {
		getContentPane().setLayout(null);
		jLabel1.setBounds(new Rectangle(27, 0, 97, 36));
		jLabel2.setBounds(new Rectangle(26, 176, 80, 27));
		textArea1.setColumns(40);
		textArea1.setEditable(false);
		textArea1.setLineWrap(true);
		textArea1.setText("������ץ�ƣ���Һ�ץ�ơ������Լ�����ֵ�������Ƚ���ֵ���������ֵ���������ڻ����21����ƽ�֣������Һ͵��Ե���ֵ������һ������21�㣬��һ��������21�㣬�򲻴���21���ΪӮ�ң������Һ͵��Ե���ֵ������������21������ֵ�������ΪӮ�ҡ�");
		textArea1.setBounds(new Rectangle(25, 36, 392, 130));
		textArea1.setFont(new Font("����", Font.PLAIN, 16));
		textArea2.setEditable(false);
		textArea2.setLineWrap(true);
		textArea2.setBounds(new Rectangle(26, 207, 398, 63));
		textArea2.setText("����Ϸ�У�ֽ�Ƶ�ͼƬ������WindowsXP��ֽ����Ϸ��ͼƬȨ����ԭ�������У�");
		textArea2.setFont(new Font("����", Font.PLAIN, 16));
		this.getContentPane().add(jLabel1);
		this.getContentPane().add(jLabel2);
		this.getContentPane().add(textArea1);
		this.getContentPane().add(textArea2);
		this.setSize(450, 300);
		this.setTitle("����");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  //�����Ļ�Ŀ�͸�
		Dimension frameSize = this.getSize();  //��õ�ǰ����Ŀ�͸�
		//���ô������
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
		this.setVisible(true);
	}
}
