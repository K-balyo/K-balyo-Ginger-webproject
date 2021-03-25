package controls;

import java.util.Map;


import dao.AdminDao;
import webapp.Component;

@Component("/admin/list.do")
public class AdminMemberListController implements Controller{
	private AdminDao adminDao;
	
	public AdminMemberListController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object>model) throws Exception{
//		model.put("members", adminDao.selectList());
//		model.put("members", adminDao.selectPage("members", 0, 2));
		return "/admin/adminMemberList.jsp";
	}

}
