/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week4.controller;

import edu.wctc.dj.week4.model.Product;
import edu.wctc.dj.week4.model.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ryan
 */
public class ShoppingCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShoppingCart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingCart at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductService products = new ProductService();

        RequestDispatcher dispatcher = null;
        String id = request.getParameter("id");
        String product = request.getParameter("product");
        String cart = request.getParameter("cart");
        String qty = request.getParameter("qty");
        String addToCart = request.getParameter("addToCart");
        String search = request.getParameter("search");

        if ("all".equals(product)) {
            List<Product> allProducts = products.getAllProducts();
            request.setAttribute("allProducts", allProducts);
            dispatcher = request.getRequestDispatcher("/WEB-INF/products.jsp");
            //go to products.jsp
        } else if (product != null && !("all".equals(product))) {
            Product currentProduct = products.validateProduct(product);
            request.setAttribute("currentProduct", currentProduct);
            dispatcher = request.getRequestDispatcher("/WEB-INF/productDetails.jsp");
            //go to productDetails.jsp
        } else if ("view".equals(cart)) {
//            request.setAttribute("addedToCart", "noItems");
            TreeMap<String, Product> productsInCart = new TreeMap<>();
            Enumeration keys = request.getSession().getAttributeNames();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                if (key.startsWith("cart")) {
                    String[] keySplit = key.split("#");
                    String productID = (String) request.getSession().getValue(key);
                    Product validatedProduct = products.validateProduct(productID);
                    Double qtyConverted = null;
                    if (validatedProduct != null) {
                        try {
                             qtyConverted = Double.valueOf(keySplit[2]);
                        } catch (NumberFormatException nfe) {
                            //dont add product
                        }
                        if (qtyConverted != null) {
                            productsInCart.put(key, validatedProduct);
                        }
                        
                    }

                }
//        out.println(key + ": " + session.getValue(key) + "<br>");
            }
            request.setAttribute("productsInCart", productsInCart);
            dispatcher = request.getRequestDispatcher("/WEB-INF/cart.jsp");

        } else if (id != null && "add".equals(cart) && qty != null) {
            Product validatedProduct = products.validateProduct(id);
            if (validatedProduct != null) {
                UUID uniqueID = UUID.randomUUID();
                request.setAttribute("validatedProduct", validatedProduct);
                request.setAttribute("currentQty", qty);
                request.setAttribute("uniqueID", uniqueID);
            }

            dispatcher = request.getRequestDispatcher("/WEB-INF/addToCart.jsp");
        } else if (search != null) {
            dispatcher = request.getRequestDispatcher("/WEB-INF/pageDetail.jsp");
            //go to nameDetail.jsp
        } else if ("removeAll".equals(cart)) {
            request.setAttribute("removeAll", "true");
            dispatcher = request.getRequestDispatcher("/WEB-INF/modifyCart.jsp");
            //go to home.jsp
        } else {
            dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
            //go to home.jsp
        }
        dispatcher.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductService products = new ProductService();
        RequestDispatcher dispatcher = null;
        String id = request.getParameter("id");
        String uuid = request.getParameter("uuid");
        String cart = request.getParameter("cart");
        String qty = request.getParameter("qty");
        if (id != null && "add".equals(cart) && qty != null) {
            Product validatedProduct = products.validateProduct(id);
            Integer convertedQty = null;
            try {
                convertedQty = Integer.valueOf(qty);
            } catch (NumberFormatException nfe) {
                //dont add product
            }
            if (validatedProduct != null && convertedQty !=null) {
                UUID uniqueID = UUID.randomUUID();
                request.setAttribute("validatedProduct", validatedProduct);
                request.setAttribute("currentQty", qty);
                request.setAttribute("uniqueID", uniqueID);
            }
            dispatcher = request.getRequestDispatcher("/WEB-INF/addToCart.jsp");
        } else if ("change".equals(cart) && uuid != null && qty != null) {
            request.setAttribute("uuid",uuid);
            request.setAttribute("qty", qty);
            request.setAttribute("cart", cart);
            dispatcher = request.getRequestDispatcher("/WEB-INF/modifyCart.jsp");

        } else if ("remove".equals(cart) && uuid != null) {
            request.setAttribute("uuid",uuid);
            request.setAttribute("cart", cart);
            dispatcher = request.getRequestDispatcher("/WEB-INF/modifyCart.jsp");
            
        }
        else {
            dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
            //go to home.jsp
        }
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
