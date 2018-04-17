package argil.core.services;

import java.util.Arrays;
import java.util.Map;

import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyOption;
import org.apache.felix.scr.annotations.PropertyUnbounded;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;


@Component(immediate = true, metatype = true)
@Service(value = MyService.class)
public class KeyServiceImpl implements MyService 
{

	private String name,gender;
	private String age;
	private String[] interests;
	
	
	
	@Property(label="Name of the Author",value = "author") 
    private static final String AUTHOR_NAME = "author.name";
	
    @Property(label="Age of the Author",intValue = 15)
    private static final String AUTHOR_AGE = "author.age";
    
    @Property(name = "Gender",
    	    options = {
    	        @PropertyOption(name = "1", value = "Male"),
    	        @PropertyOption(name = "2", value = "Female")
    	    }
    	)
    private static final String AUTHOR_GENDER = "author.gender";
    
    @Property(value= {}, unbounded = PropertyUnbounded.ARRAY, label = "Interests", cardinality = 50, description = "User Interests")
    private static final String AUTHOR_INTERESTS = "author.interests";
	
	
	@Override
	public String getAge()
	{
		return age;
	}
	
	@Override
	public String getGender() 
	{
		return gender;
	}
	
	@Override
	public String[] getInterests() 
	{
		return interests;
	}
	
	@Override
	public String getName() 
	{
		return name;
	}
	
	@Override
	public void sortInterests(String[] interests) 
	{
		Arrays.sort(interests);	
	}
	
	
	@Activate
	protected void activate(@SuppressWarnings("rawtypes") final Map context) {
	    this.name = PropertiesUtil.toString(context.get(AUTHOR_NAME), "");
	    this.gender = PropertiesUtil.toString(context.get(AUTHOR_GENDER),"");
	    this.interests = PropertiesUtil.toStringArray(context.get(AUTHOR_INTERESTS));
	    this.age = PropertiesUtil.toString(context.get(AUTHOR_AGE),"");
	 
	}
	
	@Modified
	protected void modified(ComponentContext context){
	    this.name = PropertiesUtil.toString(
	        context.getProperties().get(AUTHOR_NAME),"");
	    this.gender = PropertiesUtil.toString(
	        context.getProperties().get(AUTHOR_GENDER),"");
	     this.interests = PropertiesUtil.toStringArray(
	              context.getProperties().get(AUTHOR_INTERESTS));
	    this.age = PropertiesUtil.toString(
	            context.getProperties().get(AUTHOR_AGE),"");
	}
	
}
