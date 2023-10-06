package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import drei_gewinnt.Drei_gewinnt_Frame;
import hanghim.Hangman;
import stein_schere_papier.SSP_Frame;

public class Startseite_Frame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public Startseite_Frame() {
		super("Spielesammlung");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(900, 900);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		JLabel label = new JLabel("Spielesammlung", JLabel.CENTER);
		label.setFont(new Font("Cambria", Font.BOLD, 28));
		label.setPreferredSize(new Dimension(900, 80));
		getContentPane().add(label, BorderLayout.NORTH);

		JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

		JButton button = new JButton("Schick, Schnack, Schnuck");
		button.addActionListener(this);
		panel.add(button);

		button = new JButton("Hangman");
		button.addActionListener(this);
		panel.add(button);

		button = new JButton("3 Gewinnt");
		button.addActionListener(this);
		panel.add(button);

		button = new JButton("???");
		button.addActionListener(this);
		panel.add(button);

		button = new JButton("???");
		button.addActionListener(this);
		panel.add(button);

		button = new JButton("???");
		button.addActionListener(this);
		panel.add(button);

		getContentPane().add(panel);
	}

	public static void main(String[] args) {
		new Startseite_Frame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Schick, Schnack, Schnuck") {
			new SSP_Frame();
		} else if (e.getActionCommand() == "Hangman") {
			Vector<String> strings = new Vector<String>();
			try {
				BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] wordsLine = line.split(" ");
					for (String word : wordsLine) {
						strings.add(word.toUpperCase());
					}
					line = reader.readLine();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			new Hangman(strings);

		} else if (e.getActionCommand() == "3 Gewinnt") {
			new Drei_gewinnt_Frame();
		}

	}

}
