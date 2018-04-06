package argil.core.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NextFiveDates 
{
	
	private Calendar calendar;
	
	public NextFiveDates(Calendar calendar)
	{
		this.calendar=calendar;
	}
	
	public String printNextFiveDates()
	{
		StringBuilder str=new StringBuilder();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setCalendar(calendar);
		for(int i=0;i<5;i++)
		{
			calendar.add(Calendar.DATE, 7);
			simpleDateFormat.setCalendar(calendar);
			str.append(simpleDateFormat.format(calendar.getTime())+System.lineSeparator());
		}
		
		return str.toString();
	}
}
