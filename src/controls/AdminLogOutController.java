package controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import webapp.Component;

@Component("/admin/adminlogout.do")
public class AdminLogOutController implements Controller{

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		session.invalidate();
        return "redirect:../admin/adminLoginForm.jsp";
	}

}







