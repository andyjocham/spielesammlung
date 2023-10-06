package drei_gewinnt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Drei_gewinnt_Frame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel[] zellen;
	private Font font = new Font(Font.SERIF, Font.BOLD, 24);
	private JButton[] btnArray;
	private Icon icon_scissors = new ImageIcon("images/scissors-icon.png");

	public Drei_gewinnt_Frame() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 900);
		setLocationRelativeTo(null);

		JLabel label = new JLabel("3 gewinnt", JLabel.CENTER);
		label.setBackground(Color.BLACK);
		label.setFont(font);

		getContentPane().add(label, BorderLayout.NORTH);
		getContentPane().add(makeGameField());
		setVisible(true);
	}

	public JPanel makeGameField() {

		JPanel panelGame = new JPanel(new GridLayout(3, 3, 0, 0));
		panelGame.setBackground(Color.WHITE);
		panelGame.setBorder(BorderFactory.createEmptyBorder(160, 200, 200, 200));

		zellen = new JPanel[9];
		btnArray = new JButton[9];
		for (int i = 0; i < zellen.length; i++) {
			zellen[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
			zellen[i].setBackground(Color.white);
			btnArray[i] = new JButton();
			btnArray[i].setPreferredSize(new Dimension(145, 145));
			btnArray[i].setActionCommand("btn" + i);
			btnArray[i].addActionListener(this);
			panelGame.add(zellen[i]);
			zellen[i].add(btnArray[i]);

		}
		return panelGame;

	}

	public static void main(String[] args) {
		new Drei_gewinnt_Frame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "btn0") {
			System.out.println("btn0");
		} else if (e.getActionCommand() == "btn1") {

		} else
			System.out.println(e);

	}
}
