/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ntbngoc.data.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import ntbngoc.data.dao.Database;
import ntbngoc.data.model.Category;
import ntbngoc.data.model.Product;

/**
 *
 * @author Admin
 */
public class HomeServlet extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> listCategory = Database.getCategoryDao().findALL();
        request.setAttribute("listCategory", listCategory);
        List<Product> listProduct = Database.getProductDao().findAll();
        request.setAttribute("listProduct", listProduct);
        String id_category = request.getParameter("id_category");
        request.setAttribute("id_category",id_category);
        addProductToCart(request);
        request.setAttribute("title", "Home Page");
        request.getRequestDispatcher("./views/home.jsp").include(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    void addProductToCart(HttpServletRequest request){
        int id_product;
        try{
            id_product=Integer.parseInt(request.getParameter("id_product"));
        }catch(Exception e){
            id_product = 0;
        }
        List<Product> cart = (List<Product>)request.getSession().getAttribute("cart");
        if(cart==null)cart= new ArrayList<>();
        if(id_product > 0){
            Product product = Database.getProductDao().findProduct(id_product);
            boolean isProductInCart=false;
            for (Product pro: cart){
                if(pro.getId()==id_product){
                    pro.setQuantity(pro.getQuantity()+1);
                    isProductInCart = true;
                }
            if(!isProductInCart)cart.add(product);
        }
        request.getSession().setAttribute("cart", cart);
        }
    }
    
}
