import java.util.ArrayList;

public class BookCollection {
	private ArrayList<BookClass> Collection;
	private String[] BookTitles;
	private String searched;
	private boolean searchloanedbook;
	private boolean isAvailable;
	private int Titlecounter;
	private int[] LoanIndex;
	private int LoanAmount;
	private String LoanedBooks;
	private String BooksinLibrary;
	private String overdue;
	
	public BookCollection() {
		Collection=new ArrayList<BookClass>();
		BookTitles=new String[50];
		searched="";
		searchloanedbook=false;
		isAvailable=false;
		Titlecounter=0;
		LoanIndex= new int[50];
		LoanAmount=0;
		LoanedBooks="";
		BooksinLibrary="";
		overdue="";
	}
	
	public void addBook(String a, String t) {
		Collection.add(new BookClass(a,t));
	}
	
	public String getCollection() {
		BooksinLibrary="";
		for(int i=0;i<Collection.size();i++) {
			if(Collection.get(i).getBorrower()==null) {
				BooksinLibrary+=Collection.get(i);
			}
		}
		if(BooksinLibrary=="") {
			BooksinLibrary="There are no books in the library";
		}
		return BooksinLibrary;
	}
	
	public String setOverdue(int d,String m,int y) {
		DateClass Date = new DateClass(d,m,y);
		overdue="";
		for(int i=0;i<Collection.size();i++) {
			if(Collection.get(i).getBorrower()!=null) {	
			if(Date.isOverdue(Collection.get(i).getDay(),Collection.get(i).getMonth(),Collection.get(i).getYear())==true) {
				overdue+=Collection.get(i) +"\n"+"\n";
				}
			}
		}
		return overdue;
	}
	
	public String getOverdue() {
		return overdue;
	}
	
	
	public void addBookTitles(String titles) {
		for(int i=Titlecounter;i<BookTitles.length;i++) {
			BookTitles[i]="";
		}
		BookTitles[Titlecounter]+=titles;
		Titlecounter++;
	}
	
	public void searchBook(String SearchedBook){
		searched="";
		if(Collection.isEmpty()==false && SearchedBook.compareToIgnoreCase(" ")!=0 && SearchedBook.compareToIgnoreCase("")!=0) {
		for(int i=0;i<BookTitles.length;i++) {
			if(BookTitles[i]!=null) {
			if(SearchedBook.compareTo(BookTitles[i])==0) {
				if(Collection.get(i)!=null) {
				searched+=Collection.get(i) +"\n"+"\n";
						}
					}
				}
			}
		}
		if(searched=="") {
			searched="Book not found";
		}
		
	}
	
	public String returnSearchedBook() {
		return searched;
	}
	
	public boolean searchLoanedBook(String SearchLoanedBook) {
		LoanIndex= new int[BookTitles.length];
		for(int i=0;i<LoanIndex.length;i++) {
			LoanIndex[i]=100;
		}
		searchloanedbook=false;
		LoanAmount=0;
		if(BookTitles[0]==null) {
			searchloanedbook=false;
		}
		else {
		for(int i=0;i<BookTitles.length;i++) {
			if(SearchLoanedBook.compareTo(BookTitles[i])==0) {
				if(Collection.get(i).getBorrower()==null) {
				searchloanedbook=true;
				LoanIndex[LoanAmount]=i;
				LoanAmount++;
				}
			}
			
		}
	}
		return searchloanedbook;
	}
	
	public void loanBook(String t,String b,int d, String m, int y) {
	if(searchloanedbook==true) {
		for(int i=0;i<LoanIndex.length;i++) {
			if(LoanIndex[i]!=100){
			if(Collection.get(LoanIndex[i]).getBorrower()==null) {
			Collection.get(LoanIndex[i]).setBorrower(b);
			Collection.get(LoanIndex[i]).setDay(d);
			Collection.get(LoanIndex[i]).setMonth(m);
			Collection.get(LoanIndex[i]).setYear(y);
					}
				}
			}
		}
	}
	
	public String getloanedBooks() {
		LoanedBooks="";
		if(searchloanedbook==true) {
		for(int i=0;i<Collection.size();i++) {
			if(Collection.get(i).getBorrower()!=null) {
				LoanedBooks+=Collection.get(i);
				}
			}
		if(LoanedBooks=="") {
			LoanedBooks="There are no loaned books";
		}
		}
		return LoanedBooks;
	}
	
	public boolean isAvailable(String t) {
		isAvailable=false;
		if(Collection.isEmpty()==false && t.compareToIgnoreCase(" ")!=0 && t.compareToIgnoreCase("")!=0) {
		for(int i=0;i<BookTitles.length;i++) {
			if(t.compareTo(BookTitles[i])==0) {
				if(Collection.get(i).getBorrower()==null) {
				isAvailable=true;
				}
			}
			}
		}
		return isAvailable;
	}
	public void returnBook(String t) {
		for(int i=0;i<Collection.size();i++) {
			if(Collection.get(i).getTitle().compareTo(t)==0) {
				Collection.get(i).setBorrower(null);
			}
		}
	}
}








