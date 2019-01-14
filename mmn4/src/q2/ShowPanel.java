/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu2
 */
package q2;

import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * this class create panel for showing the dictionary
 * @author eorbach
 *
 */
public class ShowPanel extends JPanel{
	Dictionary dictionary;
	JList<String> list;
	TextArea textArea;
	
	/**
	 * constructor of show panel
	 * @param dictionary
	 */
	public ShowPanel(Dictionary dictionary) {
		this.setLayout(new GridBagLayout());
		this.dictionary = dictionary;
		ArrayList<Term> terms = new ArrayList<Term>(dictionary.getDict());
		String[] keys = new String[terms.size()];
		for(int index=0;index<terms.size();index++) {
			keys[index] = terms.get(index).getKey();
		}
		
		GridBagConstraints constraints = new GridBagConstraints();
	     
		list = new JList<String>(keys);
		list.setVisibleRowCount(10);
		list.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				textArea.setText(terms.get(list.getSelectedIndex()).getValue());
			}
		});
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		JScrollPane scrolllist = new JScrollPane(list);
		scrolllist.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.add(scrolllist,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		
		textArea = new TextArea();
		textArea.setEditable(false);
		JScrollPane scrolltext  = new JScrollPane(textArea);
		scrolltext.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.add(scrolltext,constraints);
	}
}
