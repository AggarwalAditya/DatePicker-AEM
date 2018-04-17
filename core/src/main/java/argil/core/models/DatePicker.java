package argil.core.models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.installer.api.OsgiInstaller;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.osgi.service.component.annotations.Modified;

import argil.core.services.KeyServiceImpl;
import argil.core.services.MyService;

@Model(adaptables = { Resource.class})
public class DatePicker 
{
	private Date date;
	private Calendar calendar;
	
	@Inject @Optional 
	private String userDate;
	
	@Inject 
	@Named("jcr:created")	
	private String createdDate;

	@OSGiService
	private KeyServiceImpl myService;
	
	
	public String func()
	{
		String temp = myService.getAge()+myService.getGender()+myService.getInterests();
		return temp;
	}
	
	
	public void setUserDate(String userDate) 
	{
		this.userDate = userDate;
	}
	
	public String getUserDate() 
	{
		return createdDate;
	}
	
	@PostConstruct
	public void nishant()
	{
		System.out.println(myService.getAge());
	}
	
	public String getDayFromDate() throws ParseException
	{
		date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH).parse(userDate);
		calendar = new GregorianCalendar();
		calendar.setTime(date);
		String[] days= {" ","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};	
		return days[calendar.get(Calendar.DAY_OF_WEEK)];	
	}
	
	public String getMessage() throws ParseException
	{
		StringBuilder str=new StringBuilder();
		str.append("The date you selected is "+getUserDate());
		str.append("\n This corresponds to "+getDayFromDate());
		str.append("The next five dates will be: ");
		NextFiveDates nextFiveDates=new NextFiveDates(calendar);
		str.append(nextFiveDates.printNextFiveDates());
		
		return str.toString();
	}
	
	
}
