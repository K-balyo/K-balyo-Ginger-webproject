package controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dto.GingerAdmin;
import webapp.Component;
import webapp.DataBinding;

@Component("/admin/Adminlogin.do")
public class AdminLoginController implements Controller,DataBinding{

	AdminDao adminDao;
	
	public AdminLoginController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"loginInfo", dto.GingerAdmin.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		if(model.get("loginInfo") == null) {
			return "/admin/adminLoginForm.jsp";
		}else {
			GingerAdmin loginInfo = (GingerAdmin)model.get("loginInfo");
			GingerAdmin admin = adminDao.exist(
					loginInfo.getId(),
					loginInfo.getPassword());
			if(admin != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("admin", admin);
				return "redirect:../admin/adminindex.do";
			}else{
				model.put("noMember", "n");
				return "/admin/adminLoginForm.jsp";
			}
		}		
	}

}
