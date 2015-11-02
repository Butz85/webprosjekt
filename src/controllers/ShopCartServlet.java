package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.MockDAO;
import objects.Product;
import objects.ShoppingCart;

/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShopCartServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();
			
		
		ShoppingCart sc =(ShoppingCart)session.getAttribute("cart");
		
		//sjekker om det finnes et shoppingCart objekt i session.
		if(sc == null){ //hvis ikke opprett ny
			 sc = new ShoppingCart();
			
		}else {
			session.setAttribute("sc", sc);
			List<Product> plist = sc.getProductList();
		}
		
		request.getRequestDispatcher("WEB-INF/ShoppingCart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

		response.sendRedirect("ShopCartServlet");
	}

}
