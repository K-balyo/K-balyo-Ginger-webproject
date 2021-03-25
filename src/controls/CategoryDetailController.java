package controls;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.LikeyDao;
import dao.PickDao;
import dao.ProductDao;
import dto.GingerLikey;
import dto.GingerMember;
import dto.GingerPick;
import dto.GingerProduct;
import webapp.Component;
import webapp.DataBinding;

@Component("/member/productdetail.do")
public class CategoryDetailController implements Controller,DataBinding{
	private ProductDao productDao;
	private LikeyDao likeyDao;
	private PickDao pickDao;
	
	public CategoryDetailController setPickDao(PickDao pickDao) {
		this.pickDao = pickDao;
		return this;
	}
	public CategoryDetailController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}
	
	public CategoryDetailController setLikeyDao(LikeyDao likeyDao) {
		this.likeyDao = likeyDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"pseq",Integer.class,
				"detail", dto.GingerProduct.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int pseq = (Integer)model.get("pseq");
		GingerProduct detail = productDao.detail(pseq);
		model.put("product", detail);
		
		HttpSession session = (HttpSession)model.get("session");
		GingerMember member = (GingerMember)session.getAttribute("member");
		
		ArrayList<GingerLikey> likeList = likeyDao.likeList(
				member.getId());
		session.setAttribute("likeList", likeList);
		
		ArrayList<GingerPick> pickList = pickDao.pickList(
				member.getId());
		session.setAttribute("pickList", pickList);
		
		return "/Ginger/ProductDetail.jsp";
	}

}
