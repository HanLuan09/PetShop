package sevice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionService {
	public void sesionURLService(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
    	String previousUrl = (String) session.getAttribute("previousUrl");
    	if (previousUrl != null && !previousUrl.isEmpty()) {
    	    // Xóa URL trước đó khỏi session
    	    session.removeAttribute("previousUrl");
    	} 
    	String previousNewUrl="";
    	String query = request.getQueryString();
    	if(query == null || query.equals("")) {
    		previousNewUrl = request.getRequestURI();
    	}
    	else {
    		previousNewUrl = request.getRequestURI() + "?" + query;
    	}
    	
    	session.setAttribute("previousUrl", previousNewUrl);
	}
}
