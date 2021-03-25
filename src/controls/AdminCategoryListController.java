package controls;

import java.util.Map;

import dao.ProductDao;
import webapp.Component;
import webapp.DataBinding;

@Component("/admin/adminCategoryList.do")
public class AdminCategoryListController implements Controller{

	ProductDao productDao;
	
	public AdminCategoryListController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}
	
	

	@Override
	public String execute(Map<String, Object> model) throws Exception {
//		String kind = (String)model.get("kind");
//		if(kind == null) {
//			model.put("productList", productDao.alllistitem());
//		}else {
//		model.put("productList", productDao.adminlistitem(kind));
//		}
		
			return "/admin/adminProductList.jsp";
		
	}

}
