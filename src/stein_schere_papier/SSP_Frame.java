package stein_schere_papier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SSP_Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ROCK = "Stein";
	private static final String SCISSORS = "Schere";
	private static final String PAPER = "Papier";
	private MyListener myListener = new MyListener();
	private int userScore = 0;
	private int computerScore = 0;
	private int numberOfGames = 0;
	private String userMove;
	private String computerMove;
	private JPanel panelGame = new JPanel();
	private Icon icon_scissors = new ImageIcon("images/scissors-icon.png");
	private Icon icon_rock = new ImageIcon("images/rock-icon.png");
	private Icon icon_paper = new ImageIcon("images/paper-icon.png");
	private String result;
	private String statistik;
	private JPanel panelResult = new JPanel();
	private JPanel panelChoice = new JPanel();
	private JPanel panelStatistik = new JPanel();

	public SSP_Frame() {
		super("Schnick Schnack Schnuck");
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(SSP_Frame.this);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {

			e1.printStackTrace();
		}
		getContentPane().add(makeGameField(), BorderLayout.CENTER);
		JLabel label = new JLabel("Schnick Schnack Schnuck", JLabel.CENTER);
		getContentPane().setBackground(Color.WHITE);
		label.setFont(new Font("Cambria", Font.BOLD, 28));
		label.setPreferredSize(new Dimension(900, 80));
		getContentPane().add(label, BorderLayout.NORTH);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(900, 900);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private JPanel makeGameField() {

		panelGame.setBackground(Color.WHITE);
		panelGame.setLayout(null);

		JLabel lblChoice = new JLabel("Triff deine Wahl");
		lblChoice.setBounds(10, 40, 864, 30);
		lblChoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoice.setFont(new Font("Cambria", Font.PLAIN, 25));
		panelGame.add(lblChoice);

		JButton btnPaper = new JButton(icon_paper);
		btnPaper.setBounds(220, 112, 140, 140);
		btnPaper.addActionListener(myListener);
		btnPaper.setActionCommand(PAPER);
		panelGame.add(btnPaper);

		JButton btnRock = new JButton(icon_rock);
		btnRock.setBounds(370, 112, 140, 140);
		btnRock.addActionListener(myListener);
		btnRock.setActionCommand(ROCK);
		panelGame.add(btnRock);

		JButton btnScissors = new JButton(icon_scissors);
		btnScissors.setBounds(520, 112, 140, 140);
		btnScissors.addActionListener(myListener);
		btnScissors.setActionCommand(SCISSORS);
		panelGame.add(btnScissors);

		return panelGame;
	}

	private void makeChoiceField(String user, String computer) {

		panelChoice.setBounds(230, 273, 390, 200);
		panelChoice.setLayout(null);
		panelChoice.setBackground(Color.WHITE);
		panelGame.add(panelChoice);

		Icon userIcon = null;
		if (user == PAPER) {
			userIcon = icon_paper;
		} else if (user == ROCK) {
			userIcon = icon_rock;
		} else if (user == SCISSORS) {
			userIcon = icon_scissors;
		}

		Icon computerIcon = null;
		if (computer == PAPER) {
			computerIcon = icon_paper;
		} else if (computer == ROCK) {
			computerIcon = icon_rock;
		} else if (computer == SCISSORS) {
			computerIcon = icon_scissors;
		}

		// User Wahl anzeigen
		JButton btnUser = new JButton(userIcon);
		btnUser.setBounds(40, 40, 140, 140);
		panelChoice.add(btnUser);

		JLabel lblChoice = new JLabel("VS");
		lblChoice.setBounds(200, 90, 30, 30);
		lblChoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoice.setFont(new Font("Cambria", Font.PLAIN, 25));
		panelChoice.add(lblChoice);

		// Computer Wahl anzeigen

		JButton btnComputer = new JButton(computerIcon);
		btnComputer.setBounds(250, 40, 140, 140);
		panelChoice.add(btnComputer);
		panelChoice.repaint();
	}

	private void makeResult(String result) {

		panelResult.setBounds(0, 470, 864, 80);
		panelResult.setLayout(null);
//		panelResult.setBorder(BorderFactory.createTitledBorder("Result"));
		panelResult.setBackground(Color.WHITE);
		panelGame.add(panelResult);
		JLabel lblResult = new JLabel(result);
		lblResult.setBounds(0, 30, 864, 30);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Cambria", Font.PLAIN, 25));
		panelResult.add(lblResult);
		panelResult.setVisible(true);
		panelGame.repaint();

	}

	private void makeStatistik(String statistik) {

		panelStatistik.setBounds(0, 570, 864, 200);
		panelStatistik.setLayout(null);
		// panelStatistik.setBorder(BorderFactory.createTitledBorder("Statistik"));
		panelStatistik.setBackground(Color.WHITE);

		panelStatistik.removeAll();
		panelStatistik.repaint();

		JTextArea taStatistik = new JTextArea(statistik);
		taStatistik.setBounds(25, 30, 824, 100);
		taStatistik.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		taStatistik.setFont(new Font("Cambria", Font.PLAIN, 22));

		panelStatistik.add(taStatistik);
		panelGame.add(panelStatistik);
		panelGame.repaint();

	}

	private int compareMoves(String user, String computer) {
		// unentschieden
		if (user == computer) {
			return 0;
		}
		switch (user) {
		case ROCK:
			return (computer == SCISSORS ? 1 : -1);
		case PAPER:
			return (computer == ROCK ? 1 : -1);
		case SCISSORS:
			return (computer == PAPER ? 1 : -1);
		}
		// sollte eigentlich nie erreicht werden
		return 0;
	}

	private void startGame() {
		getComputerMove();
		// Ausgabe zum testen
//		System.out.println(computerMove);
//		System.out.println(userMove);

		int compareMoves = compareMoves(userMove, computerMove);
		switch (compareMoves) {
		case 0: // unentschieden
			makeChoiceField(userMove, computerMove);
			result = ("Unentschieden");
			makeResult(result);
			break;

		case 1: // User gewinnt
			makeChoiceField(userMove, computerMove);
			result = (userMove + " schlägt " + computerMove + ". Du hast gewonnen!\n");
			userScore++;
			makeResult(result);
			break;

		case -1: // Computer gewinnt
			makeChoiceField(userMove, computerMove);
			result = (computerMove + " schlägt " + userMove + ". Der Computer hat gewonnen!\n");
			computerScore++;
			makeResult(result);
			break;
		}
		numberOfGames++;
	}

	public static double round(double value, int decimalPoints) {
		double d = Math.pow(10, decimalPoints);
		return Math.round(value * d) / d;
	}

	private void printGameStats() {
		int ties = numberOfGames - userScore - computerScore;

		statistik = (numberOfGames + " Runde(n) gespielt.\n" + "Du hast " + userScore + "x gewonnen und "
				+ computerScore + "x verloren!\n" + ties + " x mal war es unentschieden.");
	}

	private String getComputerMove() {
		Random random = new Random();
		int x = random.nextInt(3);

		switch (x) {
		case (0):
			computerMove = PAPER;
			break;
		case (1):
			computerMove = ROCK;
			break;
		case (2):
			computerMove = SCISSORS;
			break;
		}

		return computerMove;

	}

	class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == PAPER) {
				userMove = PAPER;
			} else if (e.getActionCommand() == ROCK) {
				userMove = ROCK;
			} else if (e.getActionCommand() == SCISSORS) {
				userMove = SCISSORS;
			}
			panelResult.removeAll();
			panelResult.repaint();
			panelChoice.removeAll();
			panelChoice.repaint();
			startGame();
			printGameStats();
			makeStatistik(statistik);

		}

	}

	public static void main(String[] args) {
		new SSP_Frame();

	}
}
