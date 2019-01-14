/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu2
 */
package q2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * this class create the menu for the dictionary
 * @author eorbach
 *
 */
public class Menu extends JFrame implements ActionListener {
	Dictionary dictionary;
	JMenuBar bar;
	JMenu file;
	JMenuItem show;
	JMenuItem add;
	JMenuItem update;
	JMenuItem remove;
	JMenuItem write;
	UpdatePanel updatePanel;
	ShowPanel showPanel;
	
	/**
	 * menu constructor
	 * @param dictionary
	 */
	public Menu(Dictionary dictionary) {
		this.dictionary = dictionary;
		bar = new JMenuBar();
		file = new JMenu("File");
		show = new JMenuItem("Show dict");
		add = new JMenuItem("Add");
		update = new JMenuItem("Update");
		remove = new JMenuItem("Remove");
		write = new JMenuItem("Write to file");
				
		show.addActionListener(this);
		add.addActionListener(this);
		update.addActionListener(this);
		remove.addActionListener(this);
		write.addActionListener(this);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showPanel = new ShowPanel(dictionary);
		add(showPanel);
		refreshFrame();
	}
	
	/**
	 * this function determine the react for every menu option
	 */
	public void actionPerformed(ActionEvent e) {
		  if (e.getSource()==show) {
			  getContentPane().removeAll();
			  showPanel = new ShowPanel(dictionary);
			  add(showPanel);
			  refreshFrame();
		  }
		  else if (e.getSource()==update) {
			  getContentPane().removeAll();
			  updatePanel = new UpdatePanel(dictionary);
			  add(updatePanel);
			  refreshFrame();
		  }
		  else if (e.getSource()==write) {
			  try {
				Test.fileHandler.writeToFile(dictionary);
			  } catch (FileNotFoundException e1) {
				e1.printStackTrace();
			  }
			  getContentPane().removeAll();
			  showPanel = new ShowPanel(dictionary);
			  add(showPanel);
			  refreshFrame();
		  }
		  else if (e.getSource()==add) {
			  dictionary.add(new Term(JOptionPane.showInputDialog(this,"Enter new term", "Input", JOptionPane.INFORMATION_MESSAGE),
					JOptionPane.showInputDialog(this,"Enter the meaning", "Input", JOptionPane.INFORMATION_MESSAGE)));
			  getContentPane().removeAll();
			  showPanel = new ShowPanel(dictionary);
			  add(showPanel);
			  refreshFrame();
		  }
		  else if (e.getSource()==remove) {
			  ArrayList<Term> terms = new ArrayList<Term>(dictionary.getDict());
			  String[] keys = new String[terms.size()];
			  for(int index=0;index<terms.size();index++) {
				  keys[index] = terms.get(index).getKey();
			  }
			  String removedOption = (String)JOptionPane.showInputDialog(null,"What word do you want to remove?","Remove",JOptionPane.QUESTION_MESSAGE,null,keys,keys[0]);
			  dictionary.remove(removedOption);
			  getContentPane().removeAll();
			  showPanel = new ShowPanel(dictionary);
			  add(showPanel);
			  refreshFrame();
			  } 
		  else System.exit(0); 
		  }
		    
	/**
	 * re-adding the menu to the frame
	 */
	public void refreshFrame() {
		file.add(show);
		file.add(add);
		file.add(update);
		file.add(remove);
		file.add(write);
		bar.add(file);
		setJMenuBar(bar);
		this.pack();
		this.setVisible(true);
	}
}
	
	
	
	

