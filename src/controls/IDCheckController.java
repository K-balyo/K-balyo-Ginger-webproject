package controls;


import java.util.Map;



import dao.MySqlMemberDao;
import dto.GingerMember;
import webapp.Component;
import webapp.DataBinding;

@Component("/Ginger/idCheck.do")
public class IDCheckController implements Controller,DataBinding{
	MySqlMemberDao memberDao;
	public IDCheckController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String)model.get("id");
		GingerMember member = memberDao.idCheck(id);		
		model.put("member", member);
//		return "redirect:../member/CK.jsp"; 
		return "/member/CK.jsp";
	}

}
