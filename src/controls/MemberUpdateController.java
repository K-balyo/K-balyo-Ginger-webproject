package controls;

import java.util.Map;





import dao.MySqlMemberDao;
import dto.GingerMember;
import webapp.Component;
import webapp.DataBinding;

@Component("/member/update.do")
public class MemberUpdateController implements Controller, DataBinding{
     MySqlMemberDao memberDao;
     
	public MemberUpdateController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	// 새로 추가한것 20.11.11
	public Object[] getDataBinders() {
		return new Object[] {
				"member", dto.GingerMember.class,
				"sss", String.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		GingerMember member = (GingerMember)model.get("member");
		String sss = (String)model.get("sss");
		if(sss != null) {
			GingerMember detailInfo = memberDao.selectOne(member.getId());
			model.put("member", detailInfo);
			return "/member/MemberUpdate.jsp";
		}else {
			memberDao.update(member);
			return "redirect:../Ginger/index.do";
		}
	}
}
