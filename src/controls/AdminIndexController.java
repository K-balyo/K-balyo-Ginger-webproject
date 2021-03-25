package controls;

import java.util.Map;

import dao.AdminDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/admin/adminindex.do")
public class AdminIndexController implements Controller,DataBinding{
	AdminDao adminDao;
	
	public AdminIndexController setAdminDao(AdminDao adminDao) {
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
		return "/admin/adminIndex.jsp";
	}

}
