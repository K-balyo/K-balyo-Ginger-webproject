package controls;

import java.util.Map;


import dao.LikeyDao;
import dao.ProductDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/Ginger/likey.do")
public class LikeyController implements Controller,DataBinding{
    LikeyDao likeyDao;
    ProductDao productDao;
    
    public LikeyController setLikeyDao(LikeyDao likeyDao) {
		this.likeyDao = likeyDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class,
				"pseq", String.class,
				"likey", dto.GingerLikey.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String)model.get("id");
		String pseq = (String)model.get("pseq");
		int result = likeyDao.dolike(id, pseq);
		if(result == 1) {
			result = likeyDao.like(pseq);
			if(result == 1) {
				model.put("like", "y");
			}
		}
		return "redirect:../member/productdetail.do?pseq="+pseq;
	  }
	}
