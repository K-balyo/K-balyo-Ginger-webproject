package controls;

import java.util.Map;

import dao.QnADao;
import dto.GingerQnA;
import webapp.Component;
import webapp.DataBinding;

@Component("/QnA/mql.do")
public class MyQnAListController implements Controller,DataBinding{

	QnADao qnaDao;
	
	public MyQnAListController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id",String.class,
			"qna", dto.GingerQnA.class	
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String)model.get("id");
		model.put("mql", qnaDao.mylist(id));
		return "/QnA/MyQnAList.jsp";
	}

}
