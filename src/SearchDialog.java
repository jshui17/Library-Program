import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBDialog;
public class SearchDialog extends GBDialog {
	
	JTextField SearchField= addTextField ("",1,2,1,1);
	JLabel TitleLabel= addLabel("Enter Book title to be searched",1,1,1,1);
	JButton SubmitButton = addButton ("Submit", 2,2,1,1);
	
	BookCollection Collection;

	public void buttonClicked(JButton buttonObj){

	       if (buttonObj == SubmitButton){
	    	  Collection.searchBook(SearchField.getText().trim()); 
	          setDlgCloseIndicator ("OK");
	     	}
	       dispose();     
			}
	
	
	public SearchDialog(JFrame parent, BookCollection c) {
		super(parent);
		setTitle ("Search Book");
	    setDlgCloseIndicator ("Cancel");                
	    setSize (300, 200);   
	    Collection = c;
	}
	
}



