package controls;

import java.util.Map;


import dao.PickDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/Ginger/pickList.do")
public class PickListController implements Controller,DataBinding{
	private PickDao pickDao;
	
	public PickListController setPickDao(PickDao pickDao) {
		this.pickDao = pickDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class,
				"pickList", dto.GingerPick.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
        String id = (String)model.get("id");
		model.put("pickList", pickDao.pickList(id));
		return "/Ginger/PickList.jsp";
	}


}
