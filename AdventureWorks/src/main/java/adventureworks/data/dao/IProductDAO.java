package adventureworks.data.dao;

import adventureworks.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDAO extends JpaRepository<Product, String>
{
	
}
