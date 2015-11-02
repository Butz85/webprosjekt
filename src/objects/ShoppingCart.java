package objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Magnus Brimsholm
 *
 *         ShoppingCart contains a list of products, a list of the quantity of
 *         each product in it, a list of the total value of each product by the
 *         given quantity, a total sum of all items in the cart, and a given
 *         currency-rate.
 */
public class ShoppingCart {
	private List<Product> productList;
	private List<Integer> quantity;
	private List<Double> totalPerProdInCurr;
	private double total = 0;

	private MockDAO dao;
	private CurrencyCalculator curCalc = new CurrencyCalculator();

	/**
	 * Standard constructor
	 * Initiate all data-lists and gives variables default-values.
	 */
	public ShoppingCart() {
		dao = new MockDAO();
		productList = new ArrayList<Product>();
		quantity = new ArrayList<Integer>();
		totalPerProdInCurr = new ArrayList<Double>();
		total = 0.0;
		curCalc.setCurrency("EUR");
	}

	/**
	 * @param list
	 * @param numbers
	 * @param cur
	 * 
	 * Constructor 
	 * Initiate all data-lists and variables by the given
	 * parametres. Recalculates the correct values for total and
	 * totalPerProduct.
	 */
	public ShoppingCart(List<Product> list, List<Integer> numbers, String cur) {
		dao = new MockDAO();
		productList = list;
		quantity = numbers;
		totalPerProdInCurr = new ArrayList<Double>();
		total = 0.0;
		curCalc.setCurrency(cur);
		calculateTotalPerProdInCurr();
		calculateTotal();
	}

	/**
	 * @return productList 
	 * Returns the productlist in the cart.
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList
	 * Sets the productList of the cart to list given as input.
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	/**
	 * @return total 
	 * Returns the total value off all products in the cart
	 * in the given currency.
	 */
	public double getTotal() {
		return curCalc.calculateValueInGivenCurrency(total);
	}
	
	/**
	 * @param total
	 * Sets the total value of the products in the cart to the given input.
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return totalPerProduct 
	 * Returns the list of total value per product in the cart.
	 */
	public List<Double> getTotalPerProdInCurr() {
		return totalPerProdInCurr;
	}
	
	/**
	 * @param totalPerProduct
	 * Sets the totalPerProduct list to the given input list.
	 */
	public void setTotalPerProdInCurr(List<Double> totalPerProduct) {
		this.totalPerProdInCurr = totalPerProduct;
	}
	
	/**
	 * @return quantity 
	 * Returns the list of quantities product in the cart.
	 */
	public List<Integer> getQuantity() {
		return quantity;
	}
	
	/**
	 * @param quantity
	 * Sets the quantity list to the given input list.
	 */
	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}
	
	
	/**
	 * @param currency
	 * Changes the given currency to the currency defined by the input parameters.
	 */
	public void setCurrency(String currency) {
		curCalc.setCurrency(currency);
		calculateTotalPerProdInCurr();
	}

	/**
	 * Calculate total value of all products in the cart
	 */
	public void calculateTotal() {
		int lengde = productList.size();
		for (int i = 0; i < lengde; i++) {
			total += totalPerProdInCurr.get(i);
		}
	}

	/**
	 * Calculate total value of each product in the cart and sets them in a list
	 */
	public void calculateTotalPerProdInCurr() {
		List<Double> totPerProd = new ArrayList<Double>();
		int lengde = productList.size();
		for (int i = 0; i < lengde; i++) {
			double valueInCurr = curCalc.calculateValueInGivenCurrency((productList.get(i).getPriceInEuro()* quantity.get(i)));
			totPerProd.add(valueInCurr);
		}
		totalPerProdInCurr = totPerProd;
	}

	/**
	 * @param pNO
	 * Adds a new product into the carts productList, and add a new
	 * value in the quantity and totalPerProduct lists.
	 */
	public void addNewProduct(int pNO) {
		Product product = dao.getProductList().get(pNO);
		productList.add(product);
		quantity.add(1);
		totalPerProdInCurr.add(curCalc.calculateValueInGivenCurrency(product.getPriceInEuro()));
		calculateTotal();
	}

	/**
	 * @param pNo
	 * increments and existing product in the cart by one.
	 */
	public void incrementProduct(int pNo) {
		int index = productInList(pNo);
		int antall = quantity.get(index);
		quantity.set(index, antall++);
		calculateTotal();
	}

	/**
	 * @param number
	 * removes a given product from productList and the equivalent
	 * values in quantity and totalPerproduct lists
	 */
	public void removeProduct(int number) {
		int lengde = productList.size();
		for (int i = 0; i < lengde; i++) {
			if (productList.get(i).getpNo() == number) {
				productList.remove(i);
				quantity.remove(i);
				totalPerProdInCurr.remove(i);
			}
		}
		calculateTotal();
	}

	/**
	 * @param pNo
	 * @param newNumb
	 * Changes the quantity of an existing product in the list.
	 */
	public void changeQuantity(int pNo, int newNumb) {
		if (productInList(pNo) > -1) {
			int lengde = productList.size();
			for (int i = 0; i < lengde; i++) {
				if (productList.get(i).getpNo() == pNo) {
					if (quantity.get(i) > 1) {
						quantity.set(i, newNumb);
					} else {
						removeProduct(pNo);
					}
				}
			}
			calculateTotalPerProdInCurr();
			calculateTotal();
		}
	}

	/**
	 * @param pNo
	 * @return index
	 * 
	 * Returns the index value of a product if it exist in the list,
	 * otherwise -1.
	 */
	public int productInList(int pNo) {
		int lengde = productList.size();
		int index = -1;
		for (int i = 0; i < lengde; i++) {
			if (productList.get(i).getpNo() == pNo) {
				index = i;
			}
		}
		return index;
	}
	
}
