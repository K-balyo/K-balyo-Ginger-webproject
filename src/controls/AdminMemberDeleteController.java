package controls;

import java.util.Map;

import dao.AdminDao;
import dao.MySqlMemberDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/admin/admindelete.do")
public class AdminMemberDeleteController implements Controller,DataBinding{
	AdminDao adminDao;
	public AdminMemberDeleteController setAdminDao(AdminDao adminDao) {
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
		adminDao.delete(id);
		return "redirect:../admin/list.do";
	}

}
