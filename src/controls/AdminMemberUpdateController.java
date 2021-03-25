package controls;

import java.util.Map;


import dao.AdminDao;
import dto.GingerMember;
import webapp.Component;
import webapp.DataBinding;

@Component("/admin/adminupdate.do")
public class AdminMemberUpdateController implements Controller,DataBinding {

	AdminDao adminDao;
	
	public AdminMemberUpdateController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"ID", String.class,
				"member", dto.GingerMember.class,
				
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		GingerMember member = (GingerMember)model.get("member");
		if(member.getEmail() == null) {
			GingerMember detailInfo = adminDao.selectOne(member.getId());
			model.put("member", detailInfo);
			return "/admin/adminMemberUpdate.jsp";
		}else {
			adminDao.update(member);
			return "redirect:../admin/list.do";
			
		}
	}

}
