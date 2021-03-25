package controls;

import java.util.Map;

import dao.PickDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/Ginger/deletepick.do")
public class DeletePickController implements Controller,DataBinding{
	 private PickDao pickDao;
		
		public DeletePickController setPickDao(PickDao pickDao) {
			this.pickDao = pickDao;
			return this;
		}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
		    "id",String.class,
		    "pseq", Integer.class,
			"pick", dto.GingerPick.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int pseq = (Integer)model.get("pseq");
        String id = (String)model.get("id");
        pickDao.deletepickup(pseq, id);
    	return "redirect:../Ginger/pickList.do?id="+id;
	}

}
