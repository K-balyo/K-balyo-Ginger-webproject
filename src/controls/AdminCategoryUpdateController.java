package controls;

import java.util.Map;

import dao.ProductDao;
import dto.GingerProduct;
import webapp.Component;
import webapp.DataBinding;

@Component("/admin/adminproductupdate.do")
public class AdminCategoryUpdateController implements Controller,DataBinding{

	ProductDao productDao;
	public AdminCategoryUpdateController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"pseq",Integer.class,
				"product", dto.GingerProduct.class
				
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		GingerProduct product = (GingerProduct)model.get("product");
		if(product.getName() == null) {
			GingerProduct productInfo = productDao.selectOne(product.getPseq());
			model.put("product", productInfo);
			return "/admin/adminProductUpdate.jsp";
		}else {
			productDao.update(product);
			return "redirect:../admin/adminindex.do";
		}
	}

}
