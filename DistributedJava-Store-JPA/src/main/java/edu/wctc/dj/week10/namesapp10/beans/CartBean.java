/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week10.namesapp10.beans;

import edu.wctc.dj.week10.namesapp10.model.Name;
import edu.wctc.dj.week10.namesapp10.model.ShoppingCart;
import edu.wctc.dj.week10.namesapp10.services.ShoppingCartService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ryan
 */
@Component("cartBean")
@Scope("session")
public class CartBean implements Serializable {
    
    private final String sessionId;
    private final ShoppingCart cart;
    private final ShoppingCartService cartService = new ShoppingCartService();

    public int getItemsInCart() {
        return cart.getItemsInCart();
    }

    public void addToCart(Name name) {
        cart.add(name);
        cartService.update(sessionId, cart);
        
    }

    /**
     * Creates a new instance of CartBean
     */
    public CartBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        sessionId = facesContext.getExternalContext().getSessionId(true);
        cart = cartService.getContents(sessionId);
}

}
    
