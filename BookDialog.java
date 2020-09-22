import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBDialog;

public class BookDialog extends GBDialog{

	JLabel Title = addLabel ("Enter Book Title",1,1,1,1);
	JLabel Author = addLabel ("Enter Author Name",2,1,1,1);

	JTextField TitleField= addTextField ("",1,2,1,1);
	JTextField AuthorField= addTextField ("",2,2,1,1);
	
	JButton SubmitButton = addButton ("Submit", 7,1,1,1);
	
	BookCollection Collection=new BookCollection();


	
	public void buttonClicked(JButton buttonObj){

	       if (buttonObj == SubmitButton){
	    	 if(TitleField.getText().isEmpty()==true||AuthorField.getText().isEmpty()==true) {
	    		 messageBox("A Title and Author must be entered");
	    	 }
	    	 else { 
	    	 Collection.addBook(TitleField.getText().trim(), AuthorField.getText().trim());
	    	 Collection.addBookTitles(TitleField.getText().trim());
	         setDlgCloseIndicator ("OK");
	    	 }
	     	}
	       dispose();     
			}
	
	public BookDialog(JFrame parent, BookCollection c) {
		super(parent);
		setTitle ("Add Book");
	    setDlgCloseIndicator ("Cancel");                
	    setSize (300, 200);   
	    this.Collection = c;
	}


}







