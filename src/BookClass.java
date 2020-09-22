
public class BookClass {
	
private String title;
private String author;
private String borrower;
private String BookInfo;
private int day;
private String month;
private int year;

	public BookClass(String t, String a) {
		title=t;
		author=a;
	}
	public void setDay(int d) {
		day=d;
	}
	public void setMonth(String m) {
		month=m;
	}
	public void setYear(int y) {
		year=y;
	}
	public void setBorrower(String b) {
		borrower=b;
	}

	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getBorrower() {
		return borrower;
	}
	
	public int getDay(){
		return day;
	}
	
	public String getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public String toString() {
		if(borrower==null) {
		BookInfo="Title: "+title+"\n"+"Author: "+author+"\n"+"\n";
		}
		else {
		BookInfo="Title: "+title+"\n"+"Author: "+author+"\n"+"Borrower: "+borrower+"\n"+"Date Borrowed:" + day+" "+month+" "+year+"\n"+"\n";
		}
		return BookInfo;
	}
	
}








