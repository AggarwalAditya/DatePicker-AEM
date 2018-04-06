/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package argil.core.models;

import java.util.Calendar;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables = { Resource.class})
public class TestSample {

	@Self
	private Resource resource;
	
	
//	public String getMessage() {
//        return "nishant gupta test sample" ;
//    }
	
	private String getMonth(String month)
	{
		if(month.equals("Jan"))
		{
			return "01";
		}
		
		if(month.equals("Feb"))
		{
			return "02";
		}
		
		if(month.equals("Mar"))
		{
			return "03";
		}
		
		if(month.equals("Apr"))
		{
			return "04";
		}
		
		if(month.equals("May"))
		{
			return "05";
		}
		if(month.equals("Jun"))
		{
			return "06";
		}
		if(month.equals("Jul"))
		{
			return "07";
		}
		if(month.equals("Aug"))
		{
			return "08";
		}
		if(month.equals("Sep"))
		{
			return "09";
		}
		if(month.equals("Oct"))
		{
			return "10";
		}
		if(month.equals("Nov"))
		{
			return "11";
		}
		return "12";
	}
	
	  public String getDate() 
	  {
	     ValueMap map =resource.getValueMap();
	     String[] vals=map.get("jcr:created", Calendar.class).getTime().toString().split("\\s+");
	     StringBuilder str=new StringBuilder();
	     str.append(vals[2]);
	     String month=getMonth(vals[1]);
	     str.append(month);
	     str.append(vals[5]);
	     return str.toString();
	    }
}
