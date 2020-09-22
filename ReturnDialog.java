import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import BreezySwing.GBDialog;
public class ReturnDialog extends GBDialog{
	JLabel TitleLabel= addLabel("Enter Book title to be returned",1,1,1,1);
	JTextField SearchField= addTextField ("",1,2,1,1);
	JButton SubmitButton = addButton ("Submit", 2,1,1,1);
	
	BookCollection Collection;

	public void buttonClicked(JButton buttonObj){

	       if (buttonObj == SubmitButton){
	    	   if(Collection.isAvailable(SearchField.getText())==false) {
	    	   Collection.returnBook(SearchField.getText());
	    	   }
	    	   else {
	    		   messageBox("This book is not checked out");
	    	   }   
	     	}
	       dispose();     
			}
	
	public ReturnDialog(JFrame parent, BookCollection c) {
		super(parent);
		setTitle ("Return Book");
	    setDlgCloseIndicator ("Cancel");                
	    setSize (300, 200);   
	    Collection = c;
	}
}


