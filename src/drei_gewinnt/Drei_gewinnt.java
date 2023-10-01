package drei_gewinnt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Drei_gewinnt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel[] zellen;
	private Font font = new Font(Font.SERIF, Font.BOLD, 24);
	private Color grau = new Color(0xc4c4c4);

	public Drei_gewinnt() {
		super("3 gewinnt");
		getContentPane().add(makeGameField(), BorderLayout.CENTER);
		JLabel label = new JLabel("3 gewinnt", JLabel.CENTER);
		label.setBackground(Color.WHITE);
		label.setFont(font);
		label.setPreferredSize(new Dimension(900, 80));
		getContentPane().add(label, BorderLayout.NORTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 900);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public JPanel makeGameField() {

		JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createEmptyBorder(150, 230, 230, 230));

		zellen = new JPanel[9];
		for (int i = 0; i < zellen.length; i++) {
			zellen[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 10));
			zellen[i].setBackground(grau);
			panel.add(zellen[i]);
		}
		return panel;

	}

	public static void main(String[] args) {
		new Drei_gewinnt();
	}
}
