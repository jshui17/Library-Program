import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.*;

public class LoanDialog extends GBDialog{
	
	JLabel Title = addLabel ("Enter Book Title",1,1,1,1);
	JLabel Borrower = addLabel ("Enter Borrower name",2,1,1,1);
	JLabel Day = addLabel ("Enter Day Borrowed ",3,1,1,1);
	JLabel Month = addLabel ("Enter Month Borrowed (uppercase first letter)",4,1,1,1);
	JLabel Year = addLabel ("Enter Year Borrowed",5,1,1,1);

	JTextField TitleField= addTextField ("",1,2,1,1);
	JTextField BorrowerField= addTextField ("",2,2,1,1);
	IntegerField DayField= addIntegerField (3,3,2,1,1);
	JTextField MonthField= addTextField ("December",4,2,1,1);
	IntegerField YearField= addIntegerField (2019,5,2,1,1);

    JButton SubmitButton = addButton ("Submit", 7,1,1,1);
	
	BookCollection Collection;
	public void buttonClicked(JButton buttonObj){
//error check for improper date and send info to collectionclass
	       if (buttonObj == SubmitButton){
	    	try {
	    	if(TitleField.getText().isEmpty()==false && Collection.searchLoanedBook(TitleField.getText())==true) {
	    	if((BorrowerField.getText().isEmpty()==false) &&(DayField.getNumber()>0 && DayField.getNumber()<32)&&(YearField.getNumber()>0)&&((MonthField.getText().compareTo("January")==0 ||MonthField.getText().compareTo("Febuary")==0||MonthField.getText().compareTo("March")==0)||MonthField.getText().compareTo("April")==0|| MonthField.getText().compareTo("May")==0 || MonthField.getText().compareTo("June")==0 || MonthField.getText().compareTo("July")==0 || MonthField.getText().compareTo("August")==0 || MonthField.getText().compareTo("September")==0 || MonthField.getText().compareTo("October")==0 || MonthField.getText().compareTo("November")==0|| MonthField.getText().compareTo("December")==0)) {	 
	    	 if(MonthField.getText().compareTo("Febuary")==0) {
	    		 if(YearField.getNumber()%4==0 && DayField.getNumber()<=29) {
	    			 Collection.searchLoanedBook(TitleField.getText());
	    	    	 Collection.loanBook(TitleField.getText(),BorrowerField.getText(),DayField.getNumber(),MonthField.getText(),YearField.getNumber());
	    		 }
	    		 else {
	    			 messageBox("This is not a leap year/there is less than 29 days in febuary");
	    		 }
	    	 }
	    	 if(MonthField.getText().compareTo("January")==0 || MonthField.getText().compareTo("March")==0 || MonthField.getText().compareTo("May")==0 || MonthField.getText().compareTo("July")==0 || MonthField.getText().compareTo("August")==0 || MonthField.getText().compareTo("October")==0 || MonthField.getText().compareTo("December")==0) {
	    		 if(DayField.getNumber()<=31) {
	    	 Collection.searchLoanedBook(TitleField.getText());
	    	 Collection.loanBook(TitleField.getText(),BorrowerField.getText(),DayField.getNumber(),MonthField.getText(),YearField.getNumber());
	    		 	}
	    		 else {
	    			 messageBox("Days should be between 1 and 31 for this month");
	    		 }
	    	 	}
	    
	    		 if(MonthField.getText().compareTo("April")==0 || MonthField.getText().compareTo("June")==0 || MonthField.getText().compareTo("September")==0 || MonthField.getText().compareTo("November")==0 ) {
	    			 if(DayField.getNumber()<=30) {
	    			 Collection.searchLoanedBook(TitleField.getText());
	    	    	 Collection.loanBook(TitleField.getText(),BorrowerField.getText(),DayField.getNumber(),MonthField.getText(),YearField.getNumber());
	    			 }
	    			 else {
		    			 messageBox("Days should be between 1 and 30 for this month");
		    		 }
	    		}
	    		
	    	 	
	    	 }
	    		 else {
	    			 messageBox("Days should be between 1 and 31, Month should be a month that is January-December and Year should be greater than 0 and Borrower Field must be entered");
	    		 }
	    	}
	    	else {
	    		messageBox("Book not found/Book is already borrowed");
	    	}
	    	 }catch(NumberFormatException e) {
	    		 messageBox("Improper Input (Day and Year should be integers)");
	    	 }
	     	}
	       dispose();     
			}
	
	public LoanDialog(JFrame parent, BookCollection c) {
		super(parent);
		setTitle ("Loan Book");
	    setDlgCloseIndicator ("Cancel");                
	    setSize (300, 200);   
	    Collection = c;
	}
}
