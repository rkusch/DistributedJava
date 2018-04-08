<%-- 
    Document   : removeFromCart
    Created on : Mar 25, 2018, 10:43:49 AM
    Author     : Ryan
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.UUID"%>
<%@page import="edu.wctc.dj.week9.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String uuid = (String) request.getAttribute("uuid");
    String qty = (String) request.getAttribute("qty");
    String cart = (String) request.getAttribute("cart");
    String removeAll = (String) request.getAttribute("removeAll");
%>
<!DOCTYPE html>
<%-- Product validatedProduct = (Product) request.getAttribute("validatedProduct");
    if (validatedProduct != null) {
        UUID uniqueID = (UUID) request.getAttribute("uniqueID");
        String currentQty = (String) request.getAttribute("currentQty");
        System.out.println("Product #" +validatedProduct.getId() );
        session.setAttribute("cart#qty_" +currentQty + "#product#" + uniqueID, validatedProduct.getId());
        Double cartTotalAmount = 0.0;
        String cartTotal = (String) session.getAttribute("_cartTotal");
        if (cartTotal == null) {
            cartTotalAmount = validatedProduct.getPrice();
        } else {
            cartTotalAmount = Double.valueOf(cartTotal) + validatedProduct.getPrice();
        }
        session.setAttribute("_cartTotal", cartTotalAmount.toString());
    }
--%>
<%-- session.invalidate();--%>
<% Enumeration keys = session.getAttributeNames();
    while (keys.hasMoreElements()) {
        String key = (String) keys.nextElement();
        if ("true".equals(removeAll)) {
            if (key.startsWith("cart") || key.startsWith("_cart"))
            //remove all keys starting with "cart" or _cart
            session.removeAttribute(key);
        } else if (removeAll == null && key.startsWith("cart")) {
            String[] keySplit = key.split("#");
            String currentUUID = keySplit[4];
            Integer qtyConverted = null;
            Boolean updateTotal = false;
            System.out.println(keySplit[4]);
            if (uuid.equals(currentUUID)) {
                try {
                    qtyConverted = Integer.valueOf(qty);
                } catch (NumberFormatException nfe) {
                    //dont add product
                }

                if ("change".equals(cart) && !keySplit[2].equals(qty) && qtyConverted != null) {
                    String id = (String) session.getValue(key);
//                              session.setAttribute("cart#qty#" +currentQty + "#price#" + validatedProduct.getPrice() + "#" + uniqueID, validatedProduct.getId());
                    String newKey = keySplit[0] + "#" + keySplit[1] + "#" + qty + "#" + keySplit[3] + "#" + keySplit[4] + "#" + keySplit[5];
                    System.out.println("Updated-" + newKey);
                    System.out.print("Updated-" + id);
                    session.setAttribute(newKey, id);
                    session.removeAttribute(key);
                    updateTotal = true;

                } else if ("remove".equals(cart)) {
                    qtyConverted = 0;
                    session.removeAttribute(key);
                    updateTotal = true;
                }

            }

            if (updateTotal) {
                Double cartTotalAmount = 0.0;
                String cartTotal = (String) session.getAttribute("_cartTotal");
//                System.out.println("UPDATETOTAL");
//                System.out.println("REMOVE-" + Double.valueOf(keySplit[4]) + " " + Integer.valueOf(keySplit[2]) + "   " + (Double.valueOf(keySplit[4]) * Integer.valueOf(keySplit[2])));
//                System.out.println("ADD-" + (Double.valueOf(keySplit[4]) * qtyConverted));
                cartTotalAmount = Double.valueOf(cartTotal) - (Double.valueOf(keySplit[4]) * Integer.valueOf(keySplit[2])) + (Double.valueOf(keySplit[4]) * qtyConverted);
                session.removeAttribute("_cartTotal");
                if (cartTotalAmount >0.0) {
                    session.setAttribute("_cartTotal", cartTotalAmount.toString());
                }
            }

        }

        

    }
%>

<html>
        <script>
        window.location = "ShoppingCart?cart=view";
        </script>
   <%-- <c:redirect url="/ShoppingCart?cart=view"/> --%>
</html>
