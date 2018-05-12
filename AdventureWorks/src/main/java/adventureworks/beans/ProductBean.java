package adventureworks.beans;

import adventureworks.model.Product;
import adventureworks.service.ProductService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("productBean")
@Scope("session")
public class ProductBean implements Serializable {

	@Autowired
	private ProductService productService;

	private String search;
	private Product product;
	private List<Product> productList;

	public ProductBean() {
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product name) {
		this.product = name;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public String searchProducts() {
		productList = productService.findProducts(search);
		return "productList";
	}

	public void productDetail(AjaxBehaviorEvent event) {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
				.redirect("productDetail.xhtml?id=" + product.getId());
		} catch (IOException ex) {
			FacesMessage msg = new FacesMessage("IOException", product.getId());
        		FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public String allProducts() throws Exception {
		productList = productService.getAllProducts();
		return "productList";
	}
}
