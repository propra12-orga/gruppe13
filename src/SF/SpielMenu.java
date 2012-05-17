package SF;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SpielMenu extends JFrame implements ActionListener {

	public SpielMenu(String t) {

		setTitle(t);
		LayoutManager manager = new FlowLayout();
		setLayout(manager);

		JButton spielstarten = new JButton("Spiel starten");
		spielstarten.setActionCommand("go");
		spielstarten.addActionListener(this);
		add(spielstarten);
		JButton spielbeenden = new JButton("Spiel beenden");
		spielbeenden.setActionCommand("exit");
		spielbeenden.addActionListener(this);
		add(spielbeenden);
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// Button "Spiel beeneden" schließt die Fenster (zur Zeit allerdings nur
		// das Menüfenster;
		// Schnittstelle zum Spiel fehlt -> Besprechen
		if (arg0.getActionCommand().equals("exit")) {
			dispose();
		}
		if (arg0.getActionCommand().equals("go")) {
			// Button "Spiel starten" startet ein neues Spiel
		}

	}

}
