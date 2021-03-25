package controls;

import java.util.Map;


import dao.MySqlMemberDao;
import webapp.Component;
import webapp.DataBinding;
@Component("/member/delete.do")
public class MemberDeleteController implements Controller, DataBinding{
	MySqlMemberDao memberDao;
	public MemberDeleteController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		String id = (String)model.get("id");
		memberDao.delete(id);
		return "redirect:../Ginger/LoginForm.jsp";
	}

}
