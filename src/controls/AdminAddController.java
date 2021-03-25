package controls;

import java.util.Map;

import dao.AdminDao;
import dto.GingerAdmin;
import webapp.Component;
import webapp.DataBinding;

@Component("/admin/addadmin.do")
public class AdminAddController implements Controller,DataBinding{
	AdminDao adminDao;

	public AdminAddController setAdminDao(AdminDao adminDao) {
	    this.adminDao = adminDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"admin", dto.GingerAdmin.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		GingerAdmin admin = (GingerAdmin)model.get("admin");
		adminDao.insert(admin);
		return "/admin/adminLoginForm.jsp";
	}
	
	

}
