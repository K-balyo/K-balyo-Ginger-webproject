package controls;

import java.util.Map;

import dao.ProductDao;
import webapp.Component;
import webapp.DataBinding;
@Component("/Ginger/search.do")
public class AddressController implements Controller,DataBinding{

	private ProductDao productDao;
	
	public AddressController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"add", String.class,
				"productsearch", dto.GingerProduct.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String add = (String)model.get("add");
		model.put("productsearch", productDao.listAD(add));
		return "/Ginger/SearchList.jsp";
	}

}
