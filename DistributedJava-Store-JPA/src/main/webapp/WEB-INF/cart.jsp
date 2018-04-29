<%-- 
    Document   : products
    Created on : Feb 6, 2018, 6:40:49 PM
    Author     : ryan
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.UUID"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="edu.wctc.dj.week9.entities.Product"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% TreeMap<String, Product> productsInCart = (TreeMap<String, Product>) request.getAttribute("productsInCart");%>
<% double totalCostOfCartItems = 0.0; %>


<% boolean cartIsEmpty = true;
    if (productsInCart != null) {
        cartIsEmpty = false;
    }
%>

<jsp:include page="/WEB-INF/header.jsp" />
<div id="message"></div>
<jsp:include page="/WEB-INF/body_top.html" />



<div>
    <h4> Your Cart<br><br><br><%
        if (cartIsEmpty) {
        %> is Empty<%}%> </h4>
        <div id="cartItems">
        <%
            if (!cartIsEmpty) {
                int counter = 0;
                for (Map.Entry<String, Product> entry : productsInCart.entrySet()) {
                    String key = entry.getKey();
                    String[] keySplit = key.split("#");
                    String currentUUID = keySplit[5];
                    int qty = Integer.parseInt(keySplit[2]);
                    Product product = entry.getValue();
                    totalCostOfCartItems = totalCostOfCartItems + (Double.valueOf(product.getPrice()) * qty);
//  System.out.println(key + " => " + product.getId());

        %>
    <div id="<%=currentUUID%>" style="float:left; padding: 20px 20px 20px 20px;">
        <a href='?product=<%=product.getId()%>'>
            <img src='<%=product.getImageurl()%>' height='300' width='240'>
        </a>
        <h4><%=product.getName()%> </h4>
        <p>$<%=product.getPrice()%></p>
        <p>
        <form action="ShoppingCart?cart=change" method="POST" style="color:black;" class="cartAjaxForm">
            <span style="color:white">Qty:</span>
            <input type="text" name="qty" size="2" size="2" maxlength="4" value="<%=qty%>">
            <input type="hidden" name="uuid" value="<%=keySplit[5]%>">
            <input type="submit" value="Change">
        </form>
            <br>
        <form action="ShoppingCart?cart=remove" method="POST" style="color:black;" class="cartAjaxForm">
            <input type="hidden" name="uuid" value="<%=keySplit[5]%>">
            <input type="submit" value="Remove">
        </form>
        <!--        </p>-->
    </div>
    <%}%>
        </div>
</div>
<div id="cartTotals" style="display:block">
    
    
            <form action="ShoppingCart?cart=removeAll" method="POST" style="color:black;" class="cartAjaxForm"> <input type="submit" value="Remove All Items"></form>
</div>
           




<%}%>



<jsp:include page="/WEB-INF/body_bottom.html" />

<jsp:include page="/WEB-INF/footer.html" />



