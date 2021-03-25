package controls;

import java.util.Map;

import dao.BoardDao;
import dao.LikeyDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/B-board/boardlikey.do")
public class BoardLikeyController implements Controller,DataBinding{
    LikeyDao likeyDao;
    BoardDao boardDao;
    
    public BoardLikeyController setLikeyDao(LikeyDao likeyDao) {
		this.likeyDao = likeyDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class,
				"bseq", String.class,
				"boardlikey", dto.GingerBoardLikey.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String)model.get("id");
		String bseq = (String)model.get("bseq");
		int result = likeyDao.boarddolike(id, bseq);
		if(result == 1) {
			result = likeyDao.boardlike(bseq);
			if(result == 1) {
				model.put("boardlike", "y");
			}
		}
		return "redirect:../B-board/boarddetail.do?bseq="+bseq;
	  }
	}
