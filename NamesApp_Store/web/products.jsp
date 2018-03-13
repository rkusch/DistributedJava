<%-- 
    Document   : products
    Created on : Feb 6, 2018, 6:40:49 PM
    Author     : ryan
--%>

<%@page import="edu.wctc.dj.week3.model.StaticPage"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.List"%>
<%@page import="edu.wctc.dj.week3.model.Name"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% List<StaticPage> pageList = (List<StaticPage>) request.getAttribute("pageList");%>
<%=pageList.get(0).getContent()%>

<section class="content content-2">
    <div class="container">
      <!--start-product-->
      <div class="product">
        <div class="container">
          <div class="product-main">
            <div class="col-md-9 p-left">
            <div class="product-one">
            <div class="col-md-4 product-left single-left">
              <div class="p-one simpleCart_shelfItem">
                <a href="productsDetails.html">
                    <img src="images/shoes-1.png" alt="" />
                    <div class="mask mask1">
                      <span>Quick View</span>
                    </div>
                  </a>
                <h4>Aenean placerat</h4>
                <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
              </div>
            </div>
            <div class="col-md-4 product-left single-left">
              <div class="p-one simpleCart_shelfItem">
                <a href="productsDetails.html">
                    <img src="images/shoes-2.png" alt="" />
                    <div class="mask mask1">
                      <span>Quick View</span>
                    </div>
                  </a>
                <h4>Aenean placerat</h4>
                <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
              </div>
            </div>
            <div class="col-md-4 product-left single-left">
              <div class="p-one simpleCart_shelfItem">
                <a href="productsDetails.html">
                    <img src="images/shoes-3.png" alt="" />
                    <div class="mask mask1">
                      <span>Quick View</span>
                    </div>
                  </a>
                <h4>Aenean placerat</h4>
                <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
              </div>
            </div>
            <div class="clearfix"> </div>
          </div>
          <div class="product-one">
            <div class="col-md-4 product-left single-left">
              <div class="p-one simpleCart_shelfItem">
                <a href="productsDetails.html">
                    <img src="images/shoes-5.png" alt="" />
                    <div class="mask mask1">
                      <span>Quick View</span>
                    </div>
                  </a>
                <h4>Aenean placerat</h4>
                <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
              </div>
            </div>
            <div class="col-md-4 product-left single-left">
              <div class="p-one simpleCart_shelfItem">
                <a href="productsDetails.html">
                    <img src="images/shoes-6.png" alt="" />
                    <div class="mask mask1">
                      <span>Quick View</span>
                    </div>
                  </a>
                <h4>Aenean placerat</h4>
                <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
              </div>
            </div>
            <div class="col-md-4 product-left single-left">
              <div class="p-one simpleCart_shelfItem">
                <a href="productsDetails.html">
                    <img src="images/shoes-7.png" alt="" />
                    <div class="mask mask1">
                      <span>Quick View</span>
                    </div>
                  </a>
                <h4>Aenean placerat</h4>
                <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
              </div>
            </div>
          <div class="clearfix"> </div>
          </div>
          <div class="product-one">
            <div class="col-md-4 product-left single-left">
              <div class="p-one simpleCart_shelfItem">
                <a href="productsDetails.html">
                    <img src="images/shoes-15.png" alt="" />
                    <div class="mask mask1">
                      <span>Quick View</span>
                    </div>
                  </a>
                <h4>Aenean placerat</h4>
                <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>

              </div>
            </div>
            <div class="col-md-4 product-left single-left">
              <div class="p-one simpleCart_shelfItem">
                <a href="productsDetails.html">
                    <img src="images/shoes-10.png" alt="" />
                    <div class="mask mask1">
                      <span>Quick View</span>
                    </div>
                  </a>
                <h4>Aenean placerat</h4>
                <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>

              </div>
            </div>
            <div class="col-md-4 product-left single-left">
              <div class="p-one simpleCart_shelfItem">
                <a href="productsDetails.html">
                    <img src="images/shoes-11.png" alt="" />
                    <div class="mask mask1">
                      <span>Quick View</span>
                    </div>
                  </a>
                <h4>Aenean placerat</h4>
                <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
              </div>
            </div>
            <div class="clearfix"> </div>
          </div>
          </div>
          <div class="col-md-3 p-right single-right">
            <h3>Categories</h3>
              <ul class="product-categories">
                <li><a href="#">Blucher Shoe</a> <span class="count">(14)</span></li>
                <li><a href="#">Clog Shoe</a> <span class="count">(2)</span></li>
                <li><a href="#">Snow Boot Shoe</a> <span class="count">(2)</span></li>
                <li><a href="#">Galesh Shoe</a> <span class="count">(11)</span></li>
                <li><a href="#">pataugas Shoe</a> <span class="count">(3)</span></li>
                <li><a href="#">Jazz Shoe</a> <span class="count">(3)</span></li>
              </ul>
              <h3>Colors</h3>
              <ul class="product-categories">
                <li><a href="#">Green</a> <span class="count">(14)</span></li>
                <li><a href="#">Blue</a> <span class="count">(2)</span></li>
                <li><a href="#">Red</a> <span class="count">(2)</span></li>
                <li><a href="#">Gray</a> <span class="count">(8)</span></li>
                <li><a href="#">Green</a> <span class="count">(11)</span></li>
                <li><a href="#">Yellow</a> <span class="count">(2)</span></li>
              </ul>
              <h3>Sizes</h3>
              <ul class="product-categories">
                <li><a href="#">5.5</a> <span class="count">(14)</span></li>
                <li><a href="#">6</a> <span class="count">(2)</span></li>
                <li><a href="#">6.5</a> <span class="count">(2)</span></li>
                <li><a href="#">7</a> <span class="count">(8)</span></li>
                <li><a href="#">7.5</a> <span class="count">(11)</span></li>
              </ul>
              <h3>Price</h3>
              <ul class="product-categories p1">
                <li><a href="#">600$-700$</a> <span class="count">(14)</span></li>
                <li><a href="#">700$-800$</a> <span class="count">(2)</span></li>
                <li><a href="#">800$-900$</a> <span class="count">(2)</span></li>
                <li><a href="#">900$-1000$</a> <span class="count">(8)</span></li>
                <li><a href="#">1000$-1100$</a> <span class="count">(11)</span></li>
              </ul>
          </div>
          <div class="clearfix"> </div>
        </div>
      </div>
      </div>
      <!--end-product-->
      <!--start-footer-->
      <div class="footer">
        <div class="container">
          <div class="footer-top">
            <div class="col-md-3 footer-left">
              <h3>ABOUT US</h3>
              <ul>
                <li><a href="#">Who We Are</a></li>
                <li><a href="contact.html">Contact Us</a></li>
                <li><a href="#">Our Sites</a></li>
                <li><a href="#">In The News</a></li>
                <li><a href="#">Team</a></li>
                <li><a href="#">Carrers</a></li>
              </ul>
            </div>
            <div class="col-md-3 footer-left">
              <h3>YOUR ACCOUNT</h3>
              <ul>
                <li><a href="account.html">Your Account</a></li>
                <li><a href="#">Personal Information</a></li>
                <li><a href="contact.html">Addresses</a></li>
                <li><a href="#">Discount</a></li>
                <li><a href="#">Track your order</a></li>
              </ul>
            </div>
            <div class="col-md-3 footer-left">
              <h3>CUSTOMER SERVICES</h3>
              <ul>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">Shipping</a></li>
                <li><a href="#">Cancellation</a></li>
                <li><a href="#">Returns</a></li>
                <li><a href="#">Bulk Orders</a></li>
                <li><a href="#">Buying Guides</a></li>
              </ul>
            </div>
            <div class="col-md-3 footer-left">
              <h3>CATEGORIES</h3>
              <ul>
                <li><a href="#">Sports Shoes</a></li>
                <li><a href="#">Casual Shoes</a></li>
                <li><a href="#">Formal Shoes</a></li>
                <li><a href="#">Party Shoes</a></li>
                <li><a href="#">Ethnic</a></li>
              </ul>
            </div>
            <div class="clearfix"> </div>
          </div>
        </div>
      </div>




<%=pageList.get(1).getContent()%>



<%--
 <%
                for (StaticPage aPage : pageList) {
                    %>
                    <tr>
                        <td> <%= aPage.getId() %> </td>
                        <td> 
                         <a href="?id=<%= aPage.getId() %> "> <%= aPage.getId() %> </a></td>
                    </tr>
                    <%
                }

                %>
--%>