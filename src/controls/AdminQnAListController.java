package controls;

import java.util.Map;


import dao.QnADao;
import webapp.Component;

@Component("/admin/adminqna.do")
public class AdminQnAListController implements Controller{
    private QnADao qnaDao;
	
	public AdminQnAListController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
//        model.put("qlist", qnaDao.selectList());
		return "/admin/adminQnAList.jsp";
	}
	
}
