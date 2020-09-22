//Jonathan Shui
//B Block
//3 December 2019
//This program takes in books, stores them in a arraylist and can determine if they are two weeks overdue

import javax.swing.*;
import BreezySwing.*;

public class MainFrame extends GBFrame{
	//instantiates buttons
	 JButton AddBook = addButton ("Add Book", 1,1,1,1);
	 JButton SearchBook = addButton ("Search Book", 2,1,1,1);
	 JButton LoanBook = addButton ("Loan Book", 3,1,1,1);
	 JButton ReturnBook = addButton ("Return Book", 4,1,1,1);
	 JButton PrintBook = addButton ("Print Books in Library", 5,1,1,1);
	 JButton PrintBorrowed= addButton("Print Loaned Books",6,1,1,1);
	 JButton PrintLateBook = addButton ("Print Books over two weeks late", 7,1,1,1);
	 JButton Exit  = addButton ("Exit", 8,1,1,1);	
	 JLabel nm = addLabel("Jonathan Shui 2019",9,1,1,1);
	 BookCollection Collection= new BookCollection();
	 //determines button actions
	 public void buttonClicked (JButton buttonobj) {
		 
		 if(buttonobj==AddBook) {
			BookDialog Add= new BookDialog(this,Collection);
			Add.setVisible(true);
		 }
		 
		 if(buttonobj==SearchBook) {
			 SearchDialog Search= new SearchDialog(this,Collection);
			 Search.setVisible(true);
			 if(Collection.returnSearchedBook()==null) {
				 messageBox("This book is not in the system");
			 }	 
			 else {
				 messageBox(Collection.returnSearchedBook());
			 }		 		
		 }
		 
		 if(buttonobj==LoanBook) {
			 LoanDialog Loan= new LoanDialog(this,Collection);
			 Loan.setVisible(true);
		 }
		  if(buttonobj==PrintBook) {
				 if(Collection==null) {
					 messageBox("There are no Books");
					}
				 else {
					 messageBox(Collection.getCollection());
				 }
				 
		  }
		  
		  if(buttonobj==PrintBorrowed) {
			
			  if(Collection.getloanedBooks()==null||Collection.getloanedBooks()=="") {
				  messageBox("There are no loaned books");
			  }
				  else {
					  messageBox(Collection.getloanedBooks());
				  }
			  }
		  
		  if(buttonobj==ReturnBook) {
			  ReturnDialog Return= new ReturnDialog(this,Collection);
			  Return.setVisible(true);
		  }
		  
		  if(buttonobj==PrintLateBook) {
			  OverdueDialog Overdue = new OverdueDialog(this,Collection);
			  Overdue.setVisible(true);
			 
			  if(Collection.getOverdue()==null||Collection.getOverdue()=="") {
				  messageBox("There are no overdue books");
			  }
			  else {
				  messageBox(Collection.getOverdue());
			  }
		  }
			  
		  if(buttonobj==Exit) {
			 System.exit(1);
			}
		 
	 }	 
	 //displays main frame
	 public static void main(String[] args){
		    JFrame frm = new MainFrame();
		    frm.setTitle ("Library");
		    frm.setSize (750, 250);
		    frm.setVisible (true);
	 }
}






















