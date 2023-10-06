package drei_gewinnt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Drei_gewinnt extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel[] zellen;
	private Font font = new Font(Font.SERIF, Font.BOLD, 24);
	private Color grau = new Color(0xc4c4c4);

	public Drei_gewinnt() {
		makeGameField();

		JLabel label = new JLabel("3 gewinnt", JLabel.CENTER);
		label.setBackground(Color.BLACK);
		label.setFont(font);
//		label.setPreferredSize(new Dimension(0, 0));

		setVisible(true);
		this.add(makeGameField());
		makeGameField().add(label, BorderLayout.NORTH);
	}

	public JPanel makeGameField() {

		JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createEmptyBorder(150, 230, 230, 230));

		zellen = new JPanel[9];
		for (int i = 0; i < zellen.length; i++) {
			zellen[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
			zellen[i].setBackground(grau);
			panel.add(zellen[i]);
		}
		return panel;

	}

//	public static void main(String[] args) {
//		new Drei_gewinnt();
//	}
}
