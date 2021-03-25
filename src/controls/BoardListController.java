package controls;

import java.util.Map;

import dao.BoardDao;

import webapp.Component;
import webapp.DataBinding;

@Component("/B-board/BoardList.do")
public class BoardListController implements Controller,DataBinding{

	BoardDao boardDao;
	
	public BoardListController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"page",String.class,
				"form",String.class,
				"id",String.class,
				"searchn",String.class,
			    "board", dto.GingerBoard.class	
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String page = (String)model.get("page");
		String form = (String)model.get("form");
		String add = (String)model.get("searchn");
		int cnt = boardDao.selectCnt(form,add);
		int count = (int) Math.ceil((double) cnt / (double) 10);
		model.put("board", boardDao.list(page,form,add));
		model.put("countlist", count);
		model.put("formvalue", form);
		return "/B-board/BoardList.jsp";
	}

}
