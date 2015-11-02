package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.CurrencyCalculator;
import objects.MockDAO;
import objects.Product;
import objects.ShoppingCart;

/**
 * Servlet implementation class ProductPage
 */
@WebServlet("/ProductPage")
public class ProductPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductPage() {
		super();
	}

	/**
	 * Forwarder til ProductPage.jsp    
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//TODO Lager og sender produktene til jsp
		
		
		MockDAO d = new MockDAO();
		
		
		// NB! vet ikke om denne metoden er riktig for å hente ned eksisterende currency!!
		CurrencyCalculator curCalc = new CurrencyCalculator();
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null){
			for (int i = 0; i < cookies.length; i++){
				if(cookies[i].getName()=="locale"){
					curCalc.setCurrency(cookies[i].getValue());
				}
			}
		}
		double currencyRate = curCalc.getChosenCurrencyRate();
		request.setAttribute("currencyRate", currencyRate);
		
		List<Product> plist = d.getProductList();
		request.setAttribute("plist", plist);
		
		request.getRequestDispatcher("/WEB-INF/ProductPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		int pNO = Integer.parseInt(request.getParameter("produktId"));
		if(cart!= null){
			if(cart.productInList(pNO)!= -1){
				cart.incrementProduct(pNO);
			} else {
				cart.addNewProduct(pNO);
			}
		} else {
			cart = new ShoppingCart();
			cart.addNewProduct(pNO);
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("ProductPage");
		
	}

}
