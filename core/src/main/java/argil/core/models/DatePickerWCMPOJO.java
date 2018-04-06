package argil.core.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.jcr.Node;

import org.apache.sling.api.resource.Resource;
import com.adobe.cq.sightly.WCMUsePojo;

public class DatePickerWCMPOJO extends WCMUsePojo 
{
	
	private String userDate;
	
	@Override
	public void activate() throws Exception 
	{
		
        Resource resource = getResource();
        Node node = resource.adaptTo(Node.class);
        Calendar calendar = node.getProperty("userDate").getValue().getDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setCalendar(calendar);
        userDate = simpleDateFormat.format(calendar.getTime());
	}
	
	public String getDate()
	{
		return userDate;
	}
	
}
