package controls;

import java.util.Map;

import dao.BoardDao;
import dto.GingerBoard;
import webapp.Component;
import webapp.DataBinding;
@Component("/B-Board/boardwrite.do")
public class BoardWriteController implements Controller,DataBinding{

	private BoardDao boardDao;
	
	public BoardWriteController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
        
		return new Object[] {
				"id", String.class,
				"board", dto.GingerBoard.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String)model.get("id");
		GingerBoard board = (GingerBoard)model.get("board");
		boardDao.insert(board);
		return "redirect:../B-board/BoardList.do";
	}
	

}
