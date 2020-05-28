// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
// Extend HttpServlet class
public class DisplayHeader extends HttpServlet {
	
 	private String docType;
	private String title;
	
 //--------------------------------------- initialization ------------------
	public void init() throws ServletException{
		
        title = "HTTP Header Request Information";
        docType = "<!DOCTYPE>\n";		
	}
	
 
   // Method to handle GET method request.
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");
 
      PrintWriter out = response.getWriter();

      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n"+
         "<body bgcolor = \"#F9DDA4\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n" +
         "<table width = \"70%\" border = \"1\" align = \"center\">\n" +
         "<tr bgcolor = \"#DFAF2B\">\n" +
         "<th>Header Name</th><th>Header Value(s)</th>\n"+
         "</tr>\n"
      );
 
      Enumeration headerNames = request.getHeaderNames();
    
      while(headerNames.hasMoreElements()) {
         String paramName = (String)headerNames.nextElement();
         out.print("<tr><td>" + paramName + "</td>\n");
         String paramValue = request.getHeader(paramName);
         out.println("<td> " + paramValue + "</td></tr>\n");
      }
      out.println("</table>\n</body></html>");
   }
   
   // Method to handle POST method request.
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      doGet(request, response);
   }
   
   //------------------------------- destroy() ---------------------------------
    public void destroy() {
    	super.destroy();
    }
}