package controls;

import java.util.Map;

import dao.MySqlMemberDao;
import dto.GingerMember;
import webapp.Component;
import webapp.DataBinding;

@Component("/member/mlist.do")
public class MemberMListcontroller implements Controller,DataBinding{
	 MySqlMemberDao memberDao;
     
		public MemberMListcontroller setMemberDao(MySqlMemberDao memberDao) {
			this.memberDao = memberDao;
			return this;
		}
		public Object[] getDataBinders() {
			return new Object[] {
					"member", dto.GingerMember.class
			};
		}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		GingerMember member = (GingerMember)model.get("member");
			GingerMember detailInfo = memberDao.selectOne(member.getId());
			model.put("member", detailInfo);
			return "/member/MemberInfo.jsp";
	
	}
	}
