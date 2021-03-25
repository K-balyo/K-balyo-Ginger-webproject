package controls;

import java.util.ArrayList;
import java.util.Map;


import javax.servlet.http.HttpSession;

import dao.LikeyDao;
import dao.MySqlMemberDao;
import dao.PickDao;
import dto.GingerLikey;
import dto.GingerMember;
import dto.GingerPick;
import javafx.scene.control.Alert;
import webapp.Component;
import webapp.DataBinding;

@Component("/Ginger/login.do")
public class LogInController implements Controller, DataBinding{
	private MySqlMemberDao memberDao;
	
	
	
	public LogInController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return  new Object[] {
				"loginInfo", dto.GingerMember.class
	  };
	}
	@Override
	public String execute(Map<String, Object>model) throws Exception{
		if(model.get("loginInfo") == null) {
			return "/Ginger/LoginForm.jsp";
		}else {
			GingerMember loginInfo = (GingerMember)model.get("loginInfo");
			GingerMember member = memberDao.exist(
					loginInfo.getId(),
					loginInfo.getPassword());
			if(member != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("member", member);
				return "redirect:../Ginger/index.do";
			}else{
				model.put("noMember", "n");
				return "/Ginger/LoginForm.jsp";
			}
		}		
	}
}
