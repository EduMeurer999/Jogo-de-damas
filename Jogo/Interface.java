package Jogo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Interface extends JFrame {

	private JPanel contentPane;

	public Interface(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Novo Jogo");
		btnNewButton.setBounds(504, 35, 111, 47);
		
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 25, 400, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel a1 = new JLabel("");
		a1.setHorizontalAlignment(SwingConstants.CENTER);
		a1.setBounds(0, 0, 50, 50);
		panel.add(a1);
		
		JLabel b1 = new JLabel("");
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setBounds(50, 0, 50, 50);
		panel.add(b1);
		
		JLabel c1 = new JLabel("");
		c1.setHorizontalAlignment(SwingConstants.CENTER);
		c1.setBounds(100, 0, 50, 50);
		panel.add(c1);
		
		JLabel d1 = new JLabel("");
		d1.setBackground(new Color(0, 0, 0));
		d1.setHorizontalAlignment(SwingConstants.CENTER);
		d1.setBounds(150, 0, 50, 50);
		panel.add(d1);
		
		JLabel e1 = new JLabel("");
		e1.setHorizontalAlignment(SwingConstants.CENTER);
		e1.setBounds(200, 0, 50, 50);
		panel.add(e1);
		
		JLabel f1 = new JLabel("");
		f1.setBackground(new Color(0, 0, 0));
		f1.setHorizontalAlignment(SwingConstants.CENTER);
		f1.setBounds(250, 0, 50, 50);
		panel.add(f1);
		
		JLabel g1 = new JLabel("");
		g1.setHorizontalAlignment(SwingConstants.CENTER);
		g1.setBounds(300, 0, 50, 50);
		panel.add(g1);
		
		JLabel h1 = new JLabel("");
		h1.setBackground(new Color(0, 0, 0));
		h1.setHorizontalAlignment(SwingConstants.CENTER);
		h1.setBounds(350, 0, 50, 50);
		panel.add(h1);
		
		JLabel a2 = new JLabel("");
		a2.setHorizontalAlignment(SwingConstants.CENTER);
		a2.setBounds(0, 50, 50, 50);
		panel.add(a2);
		
		JLabel b2 = new JLabel("");
		b2.setHorizontalAlignment(SwingConstants.CENTER);
		b2.setBounds(50, 50, 50, 50);
		panel.add(b2);
		
		JLabel c2 = new JLabel("");
		c2.setHorizontalAlignment(SwingConstants.CENTER);
		c2.setBounds(100, 50, 50, 50);
		panel.add(c2);
		
		JLabel d2 = new JLabel("");
		d2.setHorizontalAlignment(SwingConstants.CENTER);
		d2.setBounds(150, 50, 50, 50);
		panel.add(d2);
		
		JLabel e2 = new JLabel("");
		e2.setHorizontalAlignment(SwingConstants.CENTER);
		e2.setBounds(200, 50, 50, 50);
		panel.add(e2);
		
		JLabel f2 = new JLabel("");
		f2.setHorizontalAlignment(SwingConstants.CENTER);
		f2.setBounds(250, 50, 50, 50);
		panel.add(f2);
		
		JLabel g2 = new JLabel("");
		g2.setHorizontalAlignment(SwingConstants.CENTER);
		g2.setBounds(300, 50, 50, 50);
		panel.add(g2);
		
		JLabel h2 = new JLabel("");
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setBounds(350, 50, 50, 50);
		panel.add(h2);
		
		JLabel h3 = new JLabel("");
		h3.setHorizontalAlignment(SwingConstants.CENTER);
		h3.setBounds(350, 100, 50, 50);
		panel.add(h3);
		
		JLabel g3 = new JLabel("");
		g3.setHorizontalAlignment(SwingConstants.CENTER);
		g3.setBounds(300, 100, 50, 50);
		panel.add(g3);
		
		JLabel f3 = new JLabel("");
		f3.setHorizontalAlignment(SwingConstants.CENTER);
		f3.setBounds(250, 100, 50, 50);
		panel.add(f3);
		
		JLabel e3 = new JLabel("");
		e3.setHorizontalAlignment(SwingConstants.CENTER);
		e3.setBounds(200, 100, 50, 50);
		panel.add(e3);
		
		JLabel d3 = new JLabel("");
		d3.setHorizontalAlignment(SwingConstants.CENTER);
		d3.setBounds(150, 100, 50, 50);
		panel.add(d3);
		
		JLabel c3 = new JLabel("");
		c3.setHorizontalAlignment(SwingConstants.CENTER);
		c3.setBounds(100, 100, 50, 50);
		panel.add(c3);
		
		JLabel b3 = new JLabel("");
		b3.setHorizontalAlignment(SwingConstants.CENTER);
		b3.setBounds(50, 100, 50, 50);
		panel.add(b3);
		
		JLabel a3 = new JLabel("");
		a3.setHorizontalAlignment(SwingConstants.CENTER);
		a3.setBounds(0, 100, 50, 50);
		panel.add(a3);
		
		JLabel a4 = new JLabel("");
		a4.setHorizontalAlignment(SwingConstants.CENTER);
		a4.setBounds(0, 150, 50, 50);
		panel.add(a4);
		
		JLabel b4 = new JLabel("");
		b4.setHorizontalAlignment(SwingConstants.CENTER);
		b4.setBounds(50, 150, 50, 50);
		panel.add(b4);
		
		JLabel c4 = new JLabel("");
		c4.setHorizontalAlignment(SwingConstants.CENTER);
		c4.setBounds(100, 150, 50, 50);
		panel.add(c4);
		
		JLabel d4 = new JLabel("");
		d4.setHorizontalAlignment(SwingConstants.CENTER);
		d4.setBounds(150, 150, 50, 50);
		panel.add(d4);
		
		JLabel e4 = new JLabel("");
		e4.setHorizontalAlignment(SwingConstants.CENTER);
		e4.setBounds(200, 150, 50, 50);
		panel.add(e4);
		
		JLabel f4 = new JLabel("");
		f4.setHorizontalAlignment(SwingConstants.CENTER);
		f4.setBounds(250, 150, 50, 50);
		panel.add(f4);
		
		JLabel g4 = new JLabel("");
		g4.setHorizontalAlignment(SwingConstants.CENTER);
		g4.setBounds(300, 150, 50, 50);
		panel.add(g4);
		
		JLabel h4 = new JLabel("");
		h4.setHorizontalAlignment(SwingConstants.CENTER);
		h4.setBounds(350, 150, 50, 50);
		panel.add(h4);
		
		JLabel h5 = new JLabel("");
		h5.setHorizontalAlignment(SwingConstants.CENTER);
		h5.setBounds(350, 200, 50, 50);
		panel.add(h5);
		
		JLabel g5 = new JLabel("");
		g5.setHorizontalAlignment(SwingConstants.CENTER);
		g5.setBounds(300, 200, 50, 50);
		panel.add(g5);
		
		JLabel f5 = new JLabel("");
		f5.setHorizontalAlignment(SwingConstants.CENTER);
		f5.setBounds(250, 200, 50, 50);
		panel.add(f5);
		
		JLabel e5 = new JLabel("");
		e5.setHorizontalAlignment(SwingConstants.CENTER);
		e5.setBounds(200, 200, 50, 50);
		panel.add(e5);
		
		JLabel d5 = new JLabel("");
		d5.setHorizontalAlignment(SwingConstants.CENTER);
		d5.setBounds(150, 200, 50, 50);
		panel.add(d5);
		
		JLabel c5 = new JLabel("");
		c5.setHorizontalAlignment(SwingConstants.CENTER);
		c5.setBounds(100, 200, 50, 50);
		panel.add(c5);
		
		JLabel b5 = new JLabel("");
		b5.setHorizontalAlignment(SwingConstants.CENTER);
		b5.setBounds(50, 200, 50, 50);
		panel.add(b5);
		
		JLabel a5 = new JLabel("");
		a5.setHorizontalAlignment(SwingConstants.CENTER);
		a5.setBounds(0, 200, 50, 50);
		panel.add(a5);
		
		JLabel a6 = new JLabel("");
		a6.setHorizontalAlignment(SwingConstants.CENTER);
		a6.setBounds(0, 250, 50, 50);
		panel.add(a6);
		
		JLabel b6 = new JLabel("");
		b6.setHorizontalAlignment(SwingConstants.CENTER);
		b6.setBounds(50, 250, 50, 50);
		panel.add(b6);
		
		JLabel c6 = new JLabel("");
		c6.setHorizontalAlignment(SwingConstants.CENTER);
		c6.setBounds(100, 250, 50, 50);
		panel.add(c6);
		
		JLabel d6 = new JLabel("");
		d6.setHorizontalAlignment(SwingConstants.CENTER);
		d6.setBounds(150, 250, 50, 50);
		panel.add(d6);
		
		JLabel e6 = new JLabel("");
		e6.setHorizontalAlignment(SwingConstants.CENTER);
		e6.setBounds(200, 250, 50, 50);
		panel.add(e6);
		
		JLabel f6 = new JLabel("");
		f6.setHorizontalAlignment(SwingConstants.CENTER);
		f6.setBounds(250, 250, 50, 50);
		panel.add(f6);
		
		JLabel g6 = new JLabel("");
		g6.setHorizontalAlignment(SwingConstants.CENTER);
		g6.setBounds(300, 250, 50, 50);
		panel.add(g6);
		
		JLabel h6 = new JLabel("");
		h6.setHorizontalAlignment(SwingConstants.CENTER);
		h6.setBounds(350, 250, 50, 50);
		panel.add(h6);
		
		JLabel h7 = new JLabel("");
		h7.setHorizontalAlignment(SwingConstants.CENTER);
		h7.setBounds(350, 300, 50, 50);
		panel.add(h7);
		
		JLabel g7 = new JLabel("");
		g7.setHorizontalAlignment(SwingConstants.CENTER);
		g7.setBounds(300, 300, 50, 50);
		panel.add(g7);
		
		JLabel f7 = new JLabel("");
		f7.setHorizontalAlignment(SwingConstants.CENTER);
		f7.setBounds(250, 300, 50, 50);
		panel.add(f7);
		
		JLabel e7 = new JLabel("");
		e7.setHorizontalAlignment(SwingConstants.CENTER);
		e7.setBounds(200, 300, 50, 50);
		panel.add(e7);
		
		JLabel d7 = new JLabel("");
		d7.setHorizontalAlignment(SwingConstants.CENTER);
		d7.setBounds(150, 300, 50, 50);
		panel.add(d7);
		
		JLabel c7 = new JLabel("");
		c7.setHorizontalAlignment(SwingConstants.CENTER);
		c7.setBounds(100, 300, 50, 50);
		panel.add(c7);
		
		JLabel b7 = new JLabel("");
		b7.setHorizontalAlignment(SwingConstants.CENTER);
		b7.setBounds(50, 300, 50, 50);
		panel.add(b7);
		
		JLabel a7 = new JLabel("");
		a7.setHorizontalAlignment(SwingConstants.CENTER);
		a7.setBounds(0, 300, 50, 50);
		panel.add(a7);
		
		JLabel a8 = new JLabel("");
		a8.setHorizontalAlignment(SwingConstants.CENTER);
		a8.setBounds(0, 350, 50, 50);
		panel.add(a8);
		
		JLabel b8 = new JLabel("");
		b8.setHorizontalAlignment(SwingConstants.CENTER);
		b8.setBounds(50, 350, 50, 50);
		panel.add(b8);
		
		JLabel c8 = new JLabel("");
		c8.setHorizontalAlignment(SwingConstants.CENTER);
		c8.setBounds(100, 350, 50, 50);
		panel.add(c8);
		
		JLabel d8 = new JLabel("");
		d8.setHorizontalAlignment(SwingConstants.CENTER);
		d8.setBounds(150, 350, 50, 50);
		panel.add(d8);
		
		JLabel e8 = new JLabel("");
		e8.setHorizontalAlignment(SwingConstants.CENTER);
		e8.setBounds(200, 350, 50, 50);
		panel.add(e8);
		
		JLabel f8 = new JLabel("");
		f8.setHorizontalAlignment(SwingConstants.CENTER);
		f8.setBounds(250, 350, 50, 50);
		panel.add(f8);
		
		JLabel g8 = new JLabel("");
		g8.setHorizontalAlignment(SwingConstants.CENTER);
		g8.setBounds(300, 350, 50, 50);
		panel.add(g8);
		
		JLabel h8 = new JLabel("");
		h8.setHorizontalAlignment(SwingConstants.CENTER);
		h8.setBounds(350, 350, 50, 50);
		panel.add(h8);
		
		
		JLabel[] tabuleiro = new JLabel[64];
		
		
		tabuleiro[0] = a1;
		tabuleiro[1] = b1;
		tabuleiro[2] = c1;
		tabuleiro[3] = d1;
		tabuleiro[4] = e1;
		tabuleiro[5] = f1;
		tabuleiro[6] = g1;
		tabuleiro[7] = h1;
		tabuleiro[8] = a2;
		tabuleiro[9] = b2;
		tabuleiro[10] = c2;
		tabuleiro[11] = d2;
		tabuleiro[12] = e2;
		tabuleiro[13] = f2;
		tabuleiro[14] = g2;
		tabuleiro[15] = h2;
		tabuleiro[16] = a3;
		tabuleiro[17] = b3;
		tabuleiro[18] = c3;
		tabuleiro[19] = d3;
		tabuleiro[20] = e3;
		tabuleiro[21] = f3;
		tabuleiro[22] = g3;
		tabuleiro[23] = h3;
		tabuleiro[24] = a4;
		tabuleiro[25] = b4;
		tabuleiro[26] = c4;
		tabuleiro[27] = d4;
		tabuleiro[28] = e4;
		tabuleiro[29] = f4;
		tabuleiro[30] = g4;
		tabuleiro[31] = h4;
		tabuleiro[32] = a5;
		tabuleiro[33] = b5;
		tabuleiro[34] = c5;
		tabuleiro[35] = d5;
		tabuleiro[36] = e5;
		tabuleiro[37] = f5;
		tabuleiro[38] = g5;
		tabuleiro[39] = h5;
		tabuleiro[40] = a6;
		tabuleiro[41] = b6;
		tabuleiro[42] = c6;
		tabuleiro[43] = d6;
		tabuleiro[44] = e6;
		tabuleiro[45] = f6;
		tabuleiro[46] = g6;
		tabuleiro[47] = h6;
		tabuleiro[48] = a7;
		tabuleiro[49] = b7;
		tabuleiro[50] = c7;
		tabuleiro[51] = d7;
		tabuleiro[52] = e7;
		tabuleiro[53] = f7;
		tabuleiro[54] = g7;
		tabuleiro[55] = h7;
		tabuleiro[56] = a8;
		tabuleiro[57] = b8;
		tabuleiro[58] = c8;
		tabuleiro[59] = d8;
		tabuleiro[60] = e8;
		tabuleiro[61] = f8;
		tabuleiro[62] = g8;
		tabuleiro[63] = h8;
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(504, 92, 111, 47);
		contentPane.add(btnNewButton_1);
		boolean pula = true;
		int i = 0;
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if(pula) {
					tabuleiro[i].setOpaque(true);
					tabuleiro[i].setBackground(Color.BLACK);
				}
				i++;
				pula = !pula;
				
			}
			pula = !pula;
		}

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Jogo(tabuleiro);
			}
		});


	}
}
