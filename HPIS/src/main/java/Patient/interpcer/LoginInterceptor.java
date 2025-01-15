package Patient.interpcer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import Patient.pojo.Patient;

public class LoginInterceptor extends HandlerInterceptorAdapter{
 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		if(url.indexOf("/login.do")>0){
			return true;
		}
		
		HttpSession session = request.getSession();
		Patient account = (Patient) session.getAttribute("account");
		if(account!=null){
			return true;
		}
		
		request.setAttribute("msg", "您还未登录，请登录");
		request.getRequestDispatcher("/WEB-INF/jsp/loginPage.jsp").forward(request, response);
		return false;
	}
	
}

