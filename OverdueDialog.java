import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import BreezySwing.GBDialog;
import BreezySwing.IntegerField;

public class OverdueDialog extends GBDialog{
	
	JLabel DateLabel = addLabel ("Enter Todays Date",1,1,1,1);
	JLabel DayLabel = addLabel ("Day",2,1,1,1);
	JLabel MonthLabel = addLabel ("Month (uppercase first letter)",3,1,1,1);
	JLabel YearLabel = addLabel ("Year",4,1,1,1);
	JLabel InfoLabel = addLabel ("Note:Books that are borrowed after todays date are not considered to be late since they are not yet checked out",5,1,1,1);
	
	IntegerField DayField= addIntegerField (3,2,2,1,1);
	JTextField MonthField= addTextField ("December",3,2,1,1);
	IntegerField YearField= addIntegerField (2019,4,2,1,1);
	
	JButton SubmitButton = addButton ("Submit", 6,1,1,1);
	
	
	BookCollection Collection;
	
	public void buttonClicked(JButton buttonObj){
//error check date and send info to collectionclass
	       if (buttonObj == SubmitButton){
	    	   try {
	    		    	if((DayField.getNumber()>0 && DayField.getNumber()<32)&&(YearField.getNumber()>0)&&((MonthField.getText().compareTo("January")==0 ||MonthField.getText().compareTo("Febuary")==0||MonthField.getText().compareTo("March")==0)||MonthField.getText().compareTo("April")==0|| MonthField.getText().compareTo("May")==0 || MonthField.getText().compareTo("June")==0 || MonthField.getText().compareTo("July")==0 || MonthField.getText().compareTo("August")==0 || MonthField.getText().compareTo("September")==0 || MonthField.getText().compareTo("October")==0 || MonthField.getText().compareTo("November")==0|| MonthField.getText().compareTo("December")==0)) {	 
	    		    	 if(MonthField.getText().compareTo("Febuary")==0) {
	    		    		 if(YearField.getNumber()%4==0 && DayField.getNumber()<=29) {
	    		    			 Collection.setOverdue(DayField.getNumber(), MonthField.getText(), YearField.getNumber());
	    		    		 }
	    		    		 else {
	    		    			 messageBox("This is not a leap year/there is less than 29 days in febuary");
	    		    		 }
	    		    	 }
	    		    	 if(MonthField.getText().compareTo("January")==0 || MonthField.getText().compareTo("March")==0 || MonthField.getText().compareTo("May")==0 || MonthField.getText().compareTo("July")==0 || MonthField.getText().compareTo("August")==0 || MonthField.getText().compareTo("October")==0 || MonthField.getText().compareTo("December")==0) {
	    		    		 if(DayField.getNumber()<=31) {
	    		    			 Collection.setOverdue(DayField.getNumber(), MonthField.getText(), YearField.getNumber());
	    		    		 	}
	    		    		 else {
	    		    			 messageBox("Days should be between 1 and 31 for this month");
	    		    		 }
	    		    	 	}
	    				 if(MonthField.getText().compareTo("April")==0 || MonthField.getText().compareTo("June")==0 || MonthField.getText().compareTo("September")==0 || MonthField.getText().compareTo("November")==0 ) {
	    	    			 if(DayField.getNumber()<=30) {
	    	    				 Collection.setOverdue(DayField.getNumber(), MonthField.getText(), YearField.getNumber());
	    	    			 }
	    	    			 else {
	    		    			 messageBox("Days should be between 1 and 30 for this month");
	    		    		 }
	    	    		}
	    		    	 }
	    		    		 else {
	    		    			 messageBox("Days should be between 1 and 31, Month should be a month that is January-December and Year should be greater than 0 and Borrower Field must be entered");
	    		    		 }
	    	   }catch(NumberFormatException e) {
	    		   messageBox("Day and Year should be int and month shold be a month January-December");
	    	   }
	     	}
	       dispose();     
			}
	
	public OverdueDialog(JFrame parent, BookCollection c) {
		super(parent);
		setTitle ("Overdue Books");
	    setDlgCloseIndicator ("Cancel");                
	    setSize (300, 200);   
	    Collection = c;
	}

}
