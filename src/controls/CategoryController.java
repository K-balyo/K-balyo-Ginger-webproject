package controls;

import java.util.Map;


import dao.ProductDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/Ginger/category.do")
public class CategoryController implements Controller, DataBinding{
	private ProductDao productDao;
	
	public CategoryController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"kind", String.class,
				"productList", dto.GingerProduct.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String kind = (String)model.get("kind");
		model.put("productList", productDao.listitem(kind));
		return "/Ginger/CategoryList.jsp";
		
	}

	

}
