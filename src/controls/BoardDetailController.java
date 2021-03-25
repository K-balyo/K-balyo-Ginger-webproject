package controls;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.LikeyDao;
import dto.GingerBoard;
import dto.GingerBoardLikey;
import dto.GingerMember;
import webapp.Component;
import webapp.DataBinding;

@Component("/B-board/boarddetail.do")
public class BoardDetailController implements Controller,DataBinding{

	private BoardDao boardDao;
	private LikeyDao likeyDao;

	public BoardDetailController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	public BoardDetailController setLikeyDao(LikeyDao likeyDao) {
		this.likeyDao = likeyDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"bseq", Integer.class,
				"bbseq", String.class,
				"detail", dto.GingerBoard.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
        int bseq = (Integer)model.get("bseq");

        int result = likeyDao.boardlook(bseq);
        GingerBoard boarddetail = boardDao.detail(bseq);
        model.put("board", boarddetail);
        
        HttpSession session = (HttpSession)model.get("session");
		GingerMember member = (GingerMember)session.getAttribute("member");
		
		ArrayList<GingerBoardLikey> boardlikeList = 
				likeyDao.boardlikeList(member.getId());
		session.setAttribute("boardlikeList", boardlikeList);

		return "/B-board/BoardDetail.jsp";
	}
	

}






