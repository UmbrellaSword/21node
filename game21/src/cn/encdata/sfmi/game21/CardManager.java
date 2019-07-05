package cn.encdata.sfmi.game21;

import java.awt.Container;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CardManager {
	public Card[] cards = new Card[52];
	public int index = 0;

	//��ʼ��һ��52��ֽ��
	public void initCards() {
		for (int type = 1; type <= 4; type++) {
			for (int value = 1; value <= 13; value++) {
				Card card = new Card();
				card.setType(type);
				card.setValue(value);
				cards[index++] = card;
			}
		}
		index = 0;

	}

	//���������52��ֽ��
	public void randomCards() {
		Random random = new Random();
		for (int index = cards.length - 1; index >= 0; index--) {
			exchange(random.nextInt(index + 1), index);
		}

	}

	//����λ��
	private void exchange(int randomIndex, int beforeIndex) {
		Card temp = cards[randomIndex];
		cards[randomIndex] = cards[beforeIndex];
		cards[beforeIndex] = temp;
	}


	//��ʾֽ��ͼƬ
	public void gameStart(JLabel game[], Container c) {
		//��������ɾ����ǩ���
		if (game[0] != null) {
			for (int i = 0; i < 52; i++) {
				c.remove(game[i]);
			}
			c.repaint();
		}
		//�������з���52����ǩ������ڷ���ͼƬ
		for (int i = 0; i < 52; i++) {
			game[i] = new JLabel();
			game[i].setBorder(javax.swing.BorderFactory.createEtchedBorder());
			game[i].setBounds(new Rectangle(100 + i * 10, 10, 101, 150));
			c.add(game[i]);
		}
		//���ñ�ǩ�����ͼƬΪrear.jpg�����Ƶı���
		for (int i = 0; i < 52; i++) {
			game[i].setIcon(new ImageIcon("images/rear.jpg"));
		}
	}
}
