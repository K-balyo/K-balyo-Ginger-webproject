package controls;

import java.util.Map;


import dao.ProductDao;
import webapp.Component;

@Component("/Ginger/index.do")
public class IndexController implements Controller{
	private ProductDao productDao;
	
	public IndexController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("productlist", productDao.listBestProduct());
		model.put("productlist2", productDao.listNewProduct());
		return "/Ginger/Index.jsp";
	}

}
