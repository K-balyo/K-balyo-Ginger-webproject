package controls;

import java.util.Map;


import dao.QnADao;
import dto.GingerQnA;
import webapp.Component;
import webapp.DataBinding;

@Component("/QnA/qnadetail.do")
public class QnADetailController implements Controller,DataBinding{

	QnADao qnaDao;

	public QnADetailController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"qseq", Integer.class,
				"detail", dto.GingerQnA.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
        int qseq = (Integer)model.get("qseq");
        GingerQnA detail = qnaDao.detail(qseq);
        model.put("qna", detail);
		return "/QnA/QnADetail.jsp";
	}
	

}




