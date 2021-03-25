package controls;

import java.util.Map;

import dao.LikeyDao;
import dao.ProductDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/Ginger/dislikey.do")
public class DisLikeController implements Controller,DataBinding{
    LikeyDao likeyDao;
    ProductDao productDao;
    
    public DisLikeController setLikeyDao(LikeyDao likeyDao) {
		this.likeyDao = likeyDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class,
				"pseq", String.class,
				"dislikey", dto.GingerLikey.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String)model.get("id");
		String pseq = (String)model.get("pseq");
		int result = likeyDao.dodislike(id, pseq);
		System.out.println(result);
		if(result == 1) {
			result = likeyDao.dislike(pseq);
			if(result == 1) {
			}
		}
		return "redirect:../member/productdetail.do?pseq="+pseq;
	}
}
