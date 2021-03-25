package controls;

import java.util.Map;





import dao.MySqlMemberDao;
import dto.GingerMember;
import webapp.Component;
import webapp.DataBinding;

@Component("/Ginger/add.do")
public class MemberAddController implements Controller, DataBinding{
	private MySqlMemberDao memberDao;
	
	public MemberAddController setMemberDao(MySqlMemberDao memberDao) {
	    this.memberDao = memberDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"member", dto.GingerMember.class
		};
	}
	
	
	@Override
	public String execute(Map<String, Object>model) throws Exception{
		GingerMember member = (GingerMember)model.get("member");
		memberDao.insert(member);
		return "/Ginger/LoginForm.jsp";
		
	}
}
