package Bomberman;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class JLevelauswahl extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JComboBox levellist;

	public JLevelauswahl() {
		// Verfuegbare Level
		String[] data = { "test1", "test2" };
		levellist = new JComboBox(data);
		levellist.setSelectedIndex(-1);
		JScrollPane listScroller = new JScrollPane(levellist);
		listScroller.setPreferredSize(new Dimension(250, 80));
		setTitle("Levelauswahl");
		setResizable(false);
		setSize(250, 50);
		add(levellist);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				Start.M.setVisible(true);
			}
		});
	}

	public String getChoice() {
		return (String) levellist.getSelectedItem();
	}
}
