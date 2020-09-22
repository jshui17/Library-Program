
public class DateClass {
	
	private int day;
	private String month;
	private int year;
	private int currentintegermonth;
	private int integermonth;
	private boolean currentleapyear;
	private boolean bookleapyear;
	private boolean overdue;
	
	DateClass(int d, String m, int y){
		day=d;
		month=m;
		year=y;
		integermonth=0;
		integermonth=0;
		currentleapyear=false;
		bookleapyear=false;
		overdue=false;
	}
	
	
	
	public boolean isOverdue(int d, String m, int y) {
		overdue=false;
		
		switch(month) {
		case "January": currentintegermonth=0; break;
		
		case"Febuary": currentintegermonth=31; break;
		
		case"March": if(year%4==0) {
			currentintegermonth=59;
			currentleapyear=true;
		}
		else {
			currentintegermonth=59;
			currentleapyear=false;
		}
		 break;
		
		case"April": currentintegermonth=90; break;
		
		case"May": currentintegermonth=120;break;
		
		case"June": currentintegermonth=151;break;
		
		case "July": currentintegermonth=181;break;
		
		case"August": currentintegermonth=212;break;
		
		case"September": currentintegermonth=243;break;
		
		case"October": currentintegermonth=273;break;
		
		case"November": currentintegermonth=304;break;
		
		case"December": currentintegermonth=334;break;
		
		}
		
		switch(m) {
		case "January": integermonth=0; break;
		
		case"Febuary": integermonth=31; break;
		
		case"March": if(y%4==0) {
			integermonth=59;
			bookleapyear=true;
		}
		else {
			integermonth=59;
			bookleapyear=false;
		}
		break;
		
		case"April": integermonth=90; break;
		
		case"May": integermonth=120;break;
		
		case"June": integermonth=151;break;
		
		case "July": integermonth=181;break;
		
		case"August": integermonth=212;break;
		
		case"September": integermonth=243;break;
		
		case"October": integermonth=273;break;
		
		case"November": integermonth=304;break;
		
		case"December": integermonth=334;break;		
		}
		
		if(currentleapyear==false && bookleapyear==true ) {
			if(((year*364)+(currentintegermonth)+(day))-((y*364)+(integermonth)+(d)+1)>14) {
				overdue=true;
			}
			else {
				overdue=false;
			}
		}
		else if(currentleapyear==true && bookleapyear==false) {
			if(((year*364)+(currentintegermonth)+(day)+1)-((y*364)+(integermonth)+(d))>14) {
				overdue=true;
			}
			else {
				overdue=false;
			}
		}
		else {
			if(currentintegermonth==0 && integermonth==334) {
				if(((year*364)+(currentintegermonth)+(day)+1)-((y*364)+(integermonth)+(d))>14) {
					overdue=true;
				}
				else {
					overdue=false;
				}
			}
			else {
			if(((year*364)+(currentintegermonth)+(day))-((y*364)+(integermonth)+(d))>14) {
				overdue=true;
			}
			else {
				overdue=false;
			}
			}
		}
		
		

		return overdue;
	}
	
}
