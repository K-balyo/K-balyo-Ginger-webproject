package controls;

import java.util.Map;

import dao.BoardDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/B-board/MyBoardList.do")
public class MyBoardListController implements Controller,DataBinding{

	BoardDao boardDao;
	
	public MyBoardListController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"page",String.class,
				"form",String.class,
				"searchn",String.class,
				"id",String.class,
			"board", dto.GingerBoard.class	
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String)model.get("id");
		String page = (String)model.get("page");
		String form = (String)model.get("form");
		String add = (String)model.get("searchn");
		System.out.println("여긴가?++++"+add);
		int cnt = boardDao.myselectCnt(id,form,add);
		int count = (int) Math.ceil((double) cnt / (double) 10);
		model.put("board", boardDao.mylist(id,page,form,add));
		model.put("countlist", count);
		model.put("formvalue", form);
		return "/B-board/MyBoardList.jsp";
	}

}
