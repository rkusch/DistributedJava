<%-- 
    Document   : products
    Created on : Feb 6, 2018, 6:40:49 PM
    Author     : ryan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="edu.wctc.dj.week9.entities.Product"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/header.jsp" />
<div id="message">
<jsp:include page="/WEB-INF/body_top.html" />


<div>
    <div class='p-one simpleCart_shelfItem'>
        <form action="ShoppingCart?cart=add" method="POST" class="ajaxForm">
        <a href='?product=<c:out value="${currentProduct.id}"/>'>
            <img src='<c:out value="${currentProduct.imageurl}"/>' height='600' width='480'>
        </a>
        <h4> <c:out value="${currentProduct.name}"/> </h4>
        <p> $<c:out value="${currentProduct.price}"/>
        <p>Qty:<input type="text" value="1" style="color:black;" size="2" maxlength="4" name="qty"></p>
        <input type="hidden" name="id" value="<c:out value="${currentProduct.id}"/>">
        <input type="submit" style="color:black" value="Add To Cart">
        <p> <c:out value="${currentProduct.description}"/> </p>
        </form>
    </div>
</div>
      


<jsp:include page="/WEB-INF/body_bottom.html" />
  </div>
<jsp:include page="/WEB-INF/footer.html" />



