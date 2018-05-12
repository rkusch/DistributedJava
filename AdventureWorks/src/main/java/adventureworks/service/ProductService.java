package adventureworks.service;

import adventureworks.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import adventureworks.data.dao.IProductDAO;

@Service
@Transactional
public class ProductService {

	@Autowired
	private IProductDAO productDao;

	public Product getProduct(String id) {
		return productDao.getOne(id);
	}

	public List<Product> getAllProducts() throws Exception {
		return productDao.findAll();
	}

	public List<Product> findProducts(String search) {
		ExampleMatcher matcher = ExampleMatcher.matching()
			.withMatcher("name", startsWith().ignoreCase());
		Product product = new Product();
		product.setName(search);
		return productDao.findAll(Example.of(product, matcher));
	}
	
}
