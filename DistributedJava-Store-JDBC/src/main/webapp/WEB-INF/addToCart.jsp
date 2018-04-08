<%-- 
    Document   : addToCart
    Created on : Mar 25, 2018, 8:18:48 AM
    Author     : Ryan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.UUID"%>
<%@page import="edu.wctc.dj.week9.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Product validatedProduct = (Product) request.getAttribute("validatedProduct");
    if (validatedProduct != null) {
        UUID uniqueID = (UUID) request.getAttribute("uniqueID");
        String currentQty = (String) request.getAttribute("currentQty");
        System.out.println("New-" + "cart#qty#" +currentQty + "#product#" + uniqueID);
        System.out.print("New-" + validatedProduct.getId());
        session.setAttribute("cart#qty#" +currentQty + "#price#" + validatedProduct.getPrice() + "#" + uniqueID, validatedProduct.getId());
        Double cartTotalAmount = 0.0;
        String cartTotal = (String) session.getAttribute("_cartTotal");
        if (cartTotal == null) {
            cartTotalAmount = Double.valueOf(validatedProduct.getPrice()) * Double.valueOf(currentQty) ;
        } else {
            cartTotalAmount = Double.valueOf(cartTotal) + (Double.valueOf(validatedProduct.getPrice())* Double.valueOf(currentQty));
        }
        session.setAttribute("_cartTotal", cartTotalAmount.toString());
    }
%>
<html>
    <script>
        window.location = "ShoppingCart?cart=view";
        </script>
  <%--  <c:redirect url="/ShoppingCart?cart=view"/> --%>
</html>