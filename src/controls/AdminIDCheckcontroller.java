package controls;

import java.util.Map;

import dao.AdminDao;
import dto.GingerAdmin;
import webapp.Component;
import webapp.DataBinding;

@Component("/admin/adminidCheck.do")
public class AdminIDCheckcontroller implements Controller,DataBinding{
	AdminDao adminDao;
	public AdminIDCheckcontroller setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
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
		GingerAdmin admin = adminDao.idCheck(id);
		model.put("admin", admin);
		return "/admin/adminCk.jsp";
	}

}
