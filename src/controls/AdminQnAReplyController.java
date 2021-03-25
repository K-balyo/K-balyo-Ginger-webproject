package controls;

import java.util.Map;

import dao.QnADao;
import dto.GingerQnA;
import webapp.Component;
import webapp.DataBinding;

@Component("/admin/adminQnAreply.do")
public class AdminQnAReplyController implements Controller,DataBinding{

	QnADao qnaDao;
	
	public AdminQnAReplyController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"qseq", Integer.class,
				"qnareply", dto.GingerQnA.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		GingerQnA qnareply = (GingerQnA)model.get("qnareply");
		if(qnareply.getSubject() == null) {
			int qseq = (Integer)model.get("qseq");
			GingerQnA reply = qnaDao.doreply(qseq);
			model.put("qnareply", reply);
			return  "/admin/adminQnAreply.jsp";
		}else {
			qnaDao.reply(qnareply);
			return "redirect:../admin/adminqna.do";
		}
	}

}
