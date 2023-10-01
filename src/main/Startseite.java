package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Startseite extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Startseite() {
		super("Spielessammlung");
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(Startseite.this);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {

			e1.printStackTrace();
		}

		JLabel label = new JLabel("Spielesammlung", JLabel.CENTER);

		getContentPane().setBackground(Color.WHITE);
		label.setFont(new Font("Cambria", Font.BOLD, 28));
		label.setPreferredSize(new Dimension(900, 80));
		getContentPane().add(label, BorderLayout.NORTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 900);
		setLocationRelativeTo(null);
		setVisible(true);

		JPanel gridGames = new JPanel(new GridLayout(3, 3, 3, 3));
		getContentPane().add(gridGames);
	}

	public static void main(String[] args) {
		new Startseite();
	}

}
