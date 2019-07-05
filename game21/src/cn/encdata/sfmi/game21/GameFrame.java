package cn.encdata.sfmi.game21;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class GameFrame extends JFrame implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JButton clear_btn = new JButton("ϴ��");
	JButton compute_btn = new JButton("��ʼ��Ϸ");
	JButton game_btn = new JButton("���ץ��");
	JButton gameover_btn = new JButton("���ֽ���");
	CardManager cm = new CardManager();
	JLabel game[] = new JLabel[52];  //����52���˿��Ƶı�ǩ
	int i = 0;  //����ץ����
	int w = 0;  //��ҳ�ʼ��
	int computer_dot = 0;  //������Ե���
	int game_dot = 0;  //������ҵ���
	JLabel computerCard[] = new JLabel[19];  //�洢����ץ��ֽ��
	JLabel gameCard[] = new JLabel[19];  //�洢���ץ��ֽ��
	int g = 0;
	JLabel jLabel1 = new JLabel("������ʾ����");
	JLabel jLabel2 = new JLabel("�����ʾ����");

	public GameFrame() {
		getContentPane().setLayout(null);
		this.setTitle("��ʮһ����Ϸ");
		this.setSize(800, 500);
		// �����Ļ�Ŀ�͸�
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// ��õ�ǰ����Ŀ�͸�
		Dimension frameSize = this.getSize();
		// ���ô������
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		clear_btn.setBounds(new Rectangle(78, 388, 73, 31));
		clear_btn.addActionListener(this);
		compute_btn.setBounds(new Rectangle(233, 388, 86, 31));
		compute_btn.setEnabled(false);
		compute_btn.addActionListener(this);
		game_btn.setBounds(new Rectangle(413, 389, 91, 32));
		game_btn.setEnabled(false);
		game_btn.addActionListener(this);
		gameover_btn.setBounds(new Rectangle(625, 390, 91, 32));
		gameover_btn.setEnabled(false);
		gameover_btn.addActionListener(this);
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("�ļ�");
		JMenu help = new JMenu("����");
		JMenuItem fileExit = new JMenuItem("�˳�");
		JMenuItem helpAbout = new JMenuItem("����");
		this.setJMenuBar(menuBar);
		menuBar.add(file);
		menuBar.add(help);
		file.add(fileExit);
		fileExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		help.add(helpAbout);
		helpAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AboutFrame();
			}
		});
		jLabel1.setBounds(new Rectangle(104, 343, 95, 38));
		jLabel2.setBounds(new Rectangle(499, 343, 92, 33));
		this.getContentPane().add(jLabel1);
		this.getContentPane().add(jLabel2);
		this.getContentPane().add(clear_btn);
		this.getContentPane().add(compute_btn);
		this.getContentPane().add(game_btn);
		this.getContentPane().add(gameover_btn);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// ϴ�ư�ť
		if (arg0.getSource() == clear_btn) {
			cm.gameStart(game, this);
			// ֽ�Ƴ�ʼ��
			cm.initCards();
			// ����ֽ��˳��
			cm.randomCards();
			//��ʼ������
			computer_dot = 0;
			game_dot = 0;
			if (computerCard[0] != null) {
				for (int n = 0; n < w; n++) {
					this.remove(computerCard[n]);
				}
				this.repaint();
			}
			if (gameCard[0] != null) {
				for (int n = 0; n < g; n++) {
					this.remove(gameCard[n]);
				}
				this.repaint();
			}
			i = 0;
			w = 0;
			g = 0;
			compute_btn.setEnabled(true);
		}

		// ��ʼ��Ϸ��ť
		if (arg0.getSource() == compute_btn) {

			// ����ץ��
			for (; computer_dot < 15 && i < 52; i++) {
				if (cm.cards[i].value <= 10) {
					computer_dot += cm.cards[i].value;
				} else {
					computer_dot += 1;
				}
			}
			if (game[0] != null) {
				for (int j = 0; j <= i; j++) {
					this.remove(game[j]);
				}
				this.repaint();
			}
			// �������õ���ֽ�Ƶ����
			for (int k = 0; k < i; k++) {
				computerCard[k] = new JLabel();
				computerCard[k].setBorder(javax.swing.BorderFactory.createEtchedBorder());
				computerCard[k].setBounds(new Rectangle(100 + k * 30, 170, 101, 150));
				this.add(computerCard[k]);
			}
			// ���ñ�ǩ�����ͼƬΪrear.jpg�����Ƶı���
			for (int k = 0; k < i; k++) {
				computerCard[k].setIcon(new ImageIcon("images/rear.jpg"));
			}
			game_btn.setEnabled(true);
			clear_btn.setEnabled(false);
			compute_btn.setEnabled(false);
			w = i;

		}

		// ���ץ�ư�ť
		if (arg0.getSource() == game_btn) {
			if (cm.cards[i].value <= 10) {
				game_dot += cm.cards[i].value;
			} else {
				game_dot += 1;
			}
			if (game[i] != null) {
				this.remove(game[i]);
				this.repaint();
			}
			JLabel gam = new JLabel();
			gam.setBorder(javax.swing.BorderFactory.createEtchedBorder());
			gam.setBounds(new Rectangle(300 + i * 30, 170, 101, 150));
			this.add(gam);
			// ���ñ�ǩ�����ͼƬΪrear.jpg�����Ƶı���
			gam.setIcon(new ImageIcon("images/" + cm.cards[i].getType() + "-" + cm.cards[i].getValue() + ".jpg"));
			game[g++] = gam;
			i++;
			gameover_btn.setEnabled(true);
		}

		// ������Ϸ������ť
		if (arg0.getSource() == gameover_btn) {
			clear_btn.setEnabled(true);
			compute_btn.setEnabled(false);
			game_btn.setEnabled(false);
			gameover_btn.setEnabled(false);
			for (int k = 0; k < w; k++) {
				computerCard[k].setIcon(new ImageIcon("images/" + cm.cards[k].getType() + "-" + cm.cards[k].getValue() + ".jpg"));
			}
			if (computer_dot > 21 && game_dot > 21) {
				JOptionPane.showMessageDialog(this, "���Ե�����"+computer_dot+"\n" +
						"��ĵ�����"+game_dot+" \n" +
						"ƽ��", "�Ծֽ��", JOptionPane.WARNING_MESSAGE);
			} else if (computer_dot <= 21 && game_dot > 21) {
				JOptionPane.showMessageDialog(this, "���Ե�����"+computer_dot+"\n" +
						"��ĵ�����"+game_dot+" \n" +
						"����Ӯ", "�Ծֽ��", JOptionPane.WARNING_MESSAGE);
			} else if (computer_dot > 21 && game_dot <= 21) {
				JOptionPane.showMessageDialog(this, "���Ե�����"+computer_dot+"\n" +
						"��ĵ�����"+game_dot+" \n" +
						"��Ӯ��", "�Ծֽ��", JOptionPane.WARNING_MESSAGE);
			} else if (computer_dot > game_dot) {
				JOptionPane.showMessageDialog(this, "���Ե�����"+computer_dot+"\n" +
						"��ĵ�����"+game_dot+" \n" +
						"����Ӯ", "�Ծֽ��", JOptionPane.WARNING_MESSAGE);
			} else if (computer_dot < game_dot) {
				JOptionPane.showMessageDialog(this, "���Ե�����"+computer_dot+"\n" +
						"��ĵ�����"+game_dot+" \n" +
						"��Ӯ��", "�Ծֽ��", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "���Ե�����"+computer_dot+"\n" +
						"��ĵ�����"+game_dot+" \n" +
						"ƽ��", "�Ծֽ��", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame();
	}
}
