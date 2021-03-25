package controls;

import java.io.IOException;




import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dto.GingerMember;
import webapp.ApplicationContext;
import webapp.ContextLoaderListener;
import webapp.DataBinding;
import webapp.ServletRequestDataBinder;

@SuppressWarnings("serial")
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String servletPath = request.getServletPath();
		try {
//			ServletContext sc = this.getServletContext();
			ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("session", request.getSession());
			
//			System.out.print(servletPath);
//			Controller controller = (Controller)sc.getAttribute(servletPath);
			Controller controller = (Controller)ctx.getBean(servletPath);
//			if("/auth/add.do".equals(servletPath)){
//			if(request.getParameter("email") != null) {
//				model.put("member", new Member().setEmail(request.getParameter("email"))
//						.setPassword(request.getParameter("pw"))
//						.setName(request.getParameter("name")));
//			}
//			}else if("/member/update.do".equals(servletPath)) {
//				if(request.getParameter("email") != null) {
//					model.put("member", new Member()
//							.setNo(Integer.parseInt(request.getParameter("no")))
//							.setEmail(request.getParameter("email"))
//							.setPassword(request.getParameter("pw"))
//							.setName(request.getParameter("name")));
//				}else {
//					model.put("no", new Integer(request.getParameter("no")));
//				}
//			}else if("/member/delete.do".equals(servletPath)) {
//				model.put("no", new Integer(request.getParameter("no")));
//			}else if("/auth/login.do".equals(servletPath)) {
//				if(request.getParameter("email") != null) {
//					model.put("loginInfo", new Member().setEmail(request.getParameter("email"))
//							.setPassword(request.getParameter("password")));
//				}
//			}
			if(controller instanceof DataBinding) {
				prepareRequestData(request, model, (DataBinding)controller);
			}
			String viewUrl = controller.execute(model);
			for( String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}
			if(viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void prepareRequestData
	(HttpServletRequest request,
			HashMap<String, Object>model,
			DataBinding dataBinding)throws Exception{
		Object[] dataBinders = dataBinding.getDataBinders();
		String dataName = null;
		Class<?> dataType = null;
		Object dataObj = null;
		for( int i = 0; i < dataBinders.length; i += 2) {
			dataName = (String)dataBinders[i];
			dataType = (Class<?>)dataBinders[i + 1];
			dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);
			model.put(dataName, dataObj);
		}
	}
}
	