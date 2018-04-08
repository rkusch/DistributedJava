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
<%@page import="edu.wctc.dj.week9.model.Product"%>
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
<div id="message">
<jsp:include page="/WEB-INF/body_top.html" />



<div>
    <h4> Your Cart<br><br><br><%
        if (cartIsEmpty) {
        %> is Empty<%}%> </h4>
        <%
            if (!cartIsEmpty) {
                for (Map.Entry<String, Product> entry : productsInCart.entrySet()) {
                    String key = entry.getKey();
                    String[] keySplit = key.split("#");
                    int qty = Integer.parseInt(keySplit[2]);
                    Product product = entry.getValue();
                    totalCostOfCartItems = totalCostOfCartItems + (Double.valueOf(product.getPrice()) * qty);
//  System.out.println(key + " => " + product.getId());

        %>
    <div style="float:left; padding: 20px 20px 20px 20px;">
        <a href='?product=<%=product.getId()%>'>
            <img src='<%=product.getImageUrl()%>' height='300' width='240'>
        </a>
        <h4><%=product.getName()%> </h4>
        <p>$<%=product.getPrice()%></p>
        <p>
        <form action="ShoppingCart?cart=change" method="POST" style="color:black;" class="ajaxForm">
            <span style="color:white">Qty:</span>
            <input type="text" name="qty" size="2" size="2" maxlength="4" value="<%=qty%>">
            <input type="hidden" name="uuid" value="<%=keySplit[4]%>">
            <input type="submit" value="Change">
        </form>
            <br>
        <form action="ShoppingCart?cart=remove" method="POST" style="color:black;" class="ajaxForm">
            <input type="hidden" name="uuid" value="<%=keySplit[4]%>">
            <input type="submit" value="Remove">
        </form>
        <!--        </p>-->
    </div>
    <%}%>

</div>
<div id="cartTotals" style="display:block">
    <center><div>   
                <p>Total: <% NumberFormat formatter = NumberFormat.getCurrencyInstance();
            out.println(formatter.format(totalCostOfCartItems));%></p>

        </div></center>

</div>
<a href="ShoppingCart?cart=removeAll">Remove All Items</a>




<%}%>

<script>
    (document).ready(function () {

    }

</script>



<jsp:include page="/WEB-INF/body_bottom.html" />
</div>
<jsp:include page="/WEB-INF/footer.html" />



