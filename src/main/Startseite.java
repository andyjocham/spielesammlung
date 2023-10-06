package main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import drei_gewinnt.Drei_gewinnt;
import stein_schere_papier.SSP;

public class Startseite extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel[] zellen;
	private SSP ssp;
	private Drei_gewinnt drei;
	private JPanel panelCards = new JPanel(new CardLayout());
	private JPanel panelDrei = new JPanel();
	private JPanel start = new JPanel();
	private JPanel panelSSP = new JPanel();

	public Startseite() {
		this.drei = new Drei_gewinnt();
		panelDrei.add(drei);

		this.ssp = new SSP();
		panelSSP.add(ssp);

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(Startseite.this);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {

			e1.printStackTrace();
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 900);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		CardLayout cards = new CardLayout();
		getContentPane().add(panelCards);

		JLabel label = new JLabel("Spielesammlung", JLabel.CENTER);
		label.setFont(new Font("Cambria", Font.BOLD, 28));
		label.setPreferredSize(new Dimension(900, 80));
		start.add(label);

		JPanel gridGames = new JPanel(new GridLayout(3, 3, 0, 0));
		zellen = new JPanel[9];
		for (int i = 0; i < zellen.length; i++) {
			zellen[i] = new JPanel();
			zellen[i].setBackground(Color.white);
			gridGames.add(zellen[i]);
		}
		start.add(gridGames);

		JButton btnSSP = new JButton(new ImageIcon("images/ssp.png"));
		btnSSP.setBounds(40, 50, 200, 200);
		btnSSP.addActionListener(this);
		btnSSP.setActionCommand("SSP");
		zellen[0].add(btnSSP);

		JButton btnDrei = new JButton("Drei");
		btnDrei.setBounds(40, 50, 200, 200);
		btnDrei.addActionListener(this);
		btnDrei.setActionCommand("Drei");
		zellen[1].add(btnDrei);

		panelCards.add(start, "Start");
		panelCards.add(panelDrei, "Drei");
		panelCards.add(panelSSP, "SSP");

		// Menuleiste
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenuItem menuItem = new JMenuItem("Startseite", 'R');
		menuItem.addActionListener(this);
		menuItem.setActionCommand("back");
		menuBar.add(menuItem);
	}

	public static void main(String[] args) {
		new Startseite();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "SSP") {
			((CardLayout) panelCards.getLayout()).show(panelCards, "SSP");
		} else if (e.getActionCommand() == "Drei") {
			((CardLayout) panelCards.getLayout()).show(panelCards, "Drei");
		} else if (e.getActionCommand() == "back") {
			((CardLayout) panelCards.getLayout()).show(panelCards, "Start");
		}
	}
}
