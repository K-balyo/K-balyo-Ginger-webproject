package controls;

import java.util.Map;

import dao.LikeyDao;
import dao.ProductDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/B-board/boarddislikey.do")
public class BoardDisLikeController implements Controller,DataBinding{
    LikeyDao likeyDao;
    ProductDao productDao;
    
    public BoardDisLikeController setLikeyDao(LikeyDao likeyDao) {
		this.likeyDao = likeyDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class,
				"bseq", String.class,
				"dislikey", dto.GingerBoardLikey.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String)model.get("id");
		String bseq = (String)model.get("bseq");
		int result = likeyDao.boarddodislike(id, bseq);
		if(result == 1) {
			result = likeyDao.boarddislike(bseq);
			if(result == 1) {
			}
		}
		return "redirect:../B-board/boarddetail.do?bseq="+bseq;
	}
}
