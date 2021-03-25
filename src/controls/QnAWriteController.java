package controls;

import java.util.Map;

import dao.QnADao;
import dto.GingerQnA;
import webapp.Component;
import webapp.DataBinding;
@Component("/QnA/qnaadd.do")
public class QnAWriteController implements Controller,DataBinding{

	private QnADao qnaDao;
	
	public QnAWriteController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
        
		return new Object[] {
				"id", String.class,
				"qna", dto.GingerQnA.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String)model.get("id");
		GingerQnA qna = (GingerQnA)model.get("qna");
		qnaDao.insert(qna);
		return "redirect:../QnA/mql.do?id="+id;
	}
	

}
