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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * this class implement panel for updating terms
 * @author eorbach
 *
 */
public class UpdatePanel extends JPanel{
	Dictionary dictionary;
	JList<String> list;
	TextArea textArea;
	JButton updateButton;
	Term tmpTerm;
	ArrayList<Term> terms;
	
	/**
	 * update panel constructor get dictionary to update
	 * @param dictionary
	 */
	public UpdatePanel(Dictionary dictionary) {
		this.setLayout(new GridBagLayout());
		this.dictionary = dictionary;
		terms = new ArrayList<Term>(dictionary.getDict());
		String[] keys = new String[terms.size()];
		for(int index=0;index<terms.size();index++) {
			keys[index] = terms.get(index).getKey();
		}
		
		GridBagConstraints constraints = new GridBagConstraints();
	    
		tmpTerm = new Term();
		list = new JList<String>(keys);
		list.setVisibleRowCount(10);
		list.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				textArea.setText(terms.get(list.getSelectedIndex()).getValue());
				tmpTerm = terms.get(list.getSelectedIndex());
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
		textArea.setEditable(true);
	
		JScrollPane scrolltext  = new JScrollPane(textArea);
		scrolltext.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.add(scrolltext,constraints);
		
		updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == updateButton) {
					tmpTerm.setValue(textArea.getText());
				}
			}
		});
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(updateButton, constraints);
	}
}
