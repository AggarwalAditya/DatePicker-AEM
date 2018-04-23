package argil.core.servlets;


import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import javax.jcr.Repository;
import javax.servlet.ServletException;
import java.io.IOException;


@SlingServlet(paths = "/content/my-page",methods="GET")
public class MyServlet extends SlingSafeMethodsServlet {
    @Reference
    private Repository repository;
    @Override  
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {  
        resp.setContentType("application/json");
        
        resp.getWriter().print("response from my servlet");
    }
    }