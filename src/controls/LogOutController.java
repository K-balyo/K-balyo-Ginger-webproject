package controls;

import java.util.Map;


import javax.servlet.http.HttpSession;

import webapp.Component;
@Component("/member/logout.do")
public class LogOutController implements Controller {
	@Override
	public String execute(Map<String, Object>model) throws Exception{
//		if(model.get("session") != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.invalidate();
//			}
		return "redirect:../Ginger/LoginForm.jsp";
		}
	}
