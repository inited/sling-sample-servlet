package cz.inited.sample;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@SlingServlet(label = "Sample servlet", paths = { "/sample/servlet" }, methods = { "GET", "POST" })
public class SampleServlet extends SlingAllMethodsServlet {
    
    private static final long serialVersionUID = 646516856976036177L;
    
    private static final Logger log = LoggerFactory.getLogger(SampleServlet.class);
    
    public SampleServlet() {
    }
    
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        
        SampleClass sampleObject = new SampleClass();
        sampleObject.setTitle("myTitle");
        sampleObject.setDescription("myDescription");
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), sampleObject);
    }
    
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Activate
    protected void activate(ComponentContext context) {
        log.info("Sample Servlet activated");
    }
    
    @Deactivate
    protected void deactivate(ComponentContext componentcontext) {
    }
}
