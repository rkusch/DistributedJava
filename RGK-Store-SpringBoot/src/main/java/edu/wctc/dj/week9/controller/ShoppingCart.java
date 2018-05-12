/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week9.controller;

import edu.wctc.dj.week9.entities.Product;
import edu.wctc.dj.week9.services.ProductFacade;
import edu.wctc.dj.week9.services.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;
import javax.ejb.EJB;
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

  ProductService productService = new ProductService();

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

        ProductService productService = new ProductService();

        RequestDispatcher dispatcher = null;
        String id = request.getParameter("id");
        String product = request.getParameter("product");
        String cart = request.getParameter("cart");
        String qty = request.getParameter("qty");
        String addToCart = request.getParameter("addToCart");
        String search = request.getParameter("search");

        if ("view".equals(cart)) {
//            request.setAttribute("addedToCart", "noItems");
            TreeMap<String, Product> productsInCart = new TreeMap<>();
            Enumeration keys = request.getSession().getAttributeNames();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                if (key.startsWith("cart")) {
                    String[] keySplit = key.split("#");
                    String productID = (String) request.getSession().getValue(key);
                    Product validatedProduct = productService.getID(productID);
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
            Product validatedProduct = productService.getID(id);
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
        String id = (String) request.getParameter("id");
        String uuid = request.getParameter("uuid");
        String cart = request.getParameter("cart");
        String qty = request.getParameter("qty");
        if (id != null && "add".equals(cart) && qty != null) {
            Product validatedProduct = productService.getID(id);
            Integer convertedQty = null;
            try {
                convertedQty = Integer.valueOf(qty);
            } catch (NumberFormatException nfe) {
                //dont add product
            }
            if (validatedProduct != null && convertedQty != null) {
                UUID uniqueID = UUID.randomUUID();
                request.setAttribute("validatedProduct", validatedProduct);
                request.setAttribute("currentQty", qty);
                request.setAttribute("uniqueID", uniqueID);
            }
            dispatcher = request.getRequestDispatcher("/WEB-INF/addToCart.jsp");
        } else if ("change".equals(cart) && uuid != null && qty != null) {
            Enumeration keys = request.getSession().getAttributeNames();
            Integer qtyConverted = null;
            Double cartTotal = 0.0;
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                if (key.startsWith("cart")) {
                    String[] keySplit = key.split("#");
                    String currentUUID = keySplit[5];
                    if (uuid.equals(currentUUID)) {
                        try {
                            qtyConverted = Integer.valueOf(qty);
                        } catch (NumberFormatException nfe) {
                            //dont change product
                        }
                        Object currentID = request.getSession().getValue(key);
                        Product validatedProduct = null;
                        validatedProduct = productService.getID(String.valueOf(currentID));
                        if (qtyConverted != null && validatedProduct != null) {
                            String newKey = keySplit[0] + "#" + keySplit[1] + "#" + qty + "#" + keySplit[3] + "#" + keySplit[4] + "#" + keySplit[5];
                            System.out.println("a" + validatedProduct.getPrice());
                            request.getSession().removeAttribute(key);
                            request.getSession().setAttribute(newKey, validatedProduct.getId());

                            System.out.println("Cart modified");
                        } else {
                            System.out.println("Could not alter cart");
                        }
                    }
                }
            }
            cartTotal = calculateCartTotal(request);
            request.getSession().setAttribute("_cartTotal", cartTotal.toString());
            request.setAttribute("cartTotalAmount", cartTotal.toString());

            dispatcher = request.getRequestDispatcher("/WEB-INF/modifyCart.jsp");

        } else if ("remove".equals(cart) && uuid != null) {
            Enumeration keys = request.getSession().getAttributeNames();
            Integer qtyConverted = null;
            String removeDiv = null;
            Double cartTotal = 0.0;
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                if (key.startsWith("cart")) {
                    String[] keySplit = key.split("#");
                    String currentUUID = keySplit[5];
                    if (uuid.equals(currentUUID)) {
                        removeDiv = currentUUID;
                        request.getSession().removeAttribute(key);
                    }
                }
            }

            cartTotal = calculateCartTotal(request);
            request.setAttribute("removeDiv", removeDiv);
            request.getSession().setAttribute("_cartTotal", cartTotal.toString());
            request.setAttribute("cartTotalAmount", cartTotal.toString());
            dispatcher = request.getRequestDispatcher("/WEB-INF/modifyCart.jsp");

        } else if ("removeAll".equals(cart)) {
            
            Enumeration keys = request.getSession().getAttributeNames();
           
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                if (key.startsWith("cart") || key.startsWith("_cart")) {
                  request.getSession().removeAttribute(key);
                    
                }
            }
            request.setAttribute("removeAll", "true");
            request.setAttribute("cartTotalAmount", "0");
            dispatcher = request.getRequestDispatcher("/WEB-INF/modifyCart.jsp");
            //go to home.jsp
        } else {
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

    private Double calculateCartTotal(HttpServletRequest request) {
        Double cartTotal = 0.0;
        Enumeration keys = request.getSession().getAttributeNames();
        Double cartTotalAmount = 0.0;
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();

            if (key.startsWith("cart")) {
                String[] keySplit = key.split("#");
                String qty = keySplit[2];
                String currentProductID = (String) request.getSession().getValue(key);
                Product validatedProduct = null;
                validatedProduct = productService.getID(currentProductID);
                cartTotalAmount = cartTotalAmount + (Double.valueOf(validatedProduct.getPrice()) * Integer.valueOf(qty));
            }
        }

        return cartTotalAmount;
    }

}
