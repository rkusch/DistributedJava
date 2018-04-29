package edu.wctc.dj.week9.beans;


import edu.wctc.dj.week9.model.Product;
import edu.wctc.dj.week9.services.ProductService;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ryan
 */
@Component("productBean")
@Scope("session")
public class ProductBean implements Serializable {
    @Autowired
    private ProductService productService;
    private Product product;
    private List<Product> productList;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
   public String allProducts() throws Exception {
       productList = productService.getAllProducts();
       return "productList";
   }
   
   public void productDetail(AjaxBehaviorEvent event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/WEB-INF/productDetails.xh?id=" + product.getId());
        } catch (IOException ex) {
            FacesMessage msg = new FacesMessage("IOException", product.getId());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
   
   public ProductBean() {
       
   }
    

}