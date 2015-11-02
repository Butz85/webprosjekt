package objects;

/**
 * *****Product (pno, pName, priceInEuro, imageFile) 
 * Brukes til å opprette produkt
 * 
 * @author Magnus Brimsholm
 */
public class Product {
	private int pNo;
	private String pName;
	private double priceInEuro;
	private String imageFile;
	
	
	/**
	 * Standard constructor. 
	 * Sets all the product values to 0 or empty string upon creation.
	 */
	public Product() {
		pNo = 0;
		pName = "";
		priceInEuro = 0.0;
		imageFile = "";
	}
	
	/**
	 * Constructor:
	 * @param numb
	 * @param name
	 * @param price
	 * @param fileName
	 * takes all these inputs to create a new product object with the specified values.
	 */
	public Product(int numb, String name, double price, String fileName) {
		pNo = numb;
		pName = name;
		priceInEuro = price;
		imageFile = fileName;
	}

	/**
	 * @return pNo
	 * returns product number as int-value
	 */
	public int getpNo() {
		return pNo;
	}
	
	/**
	 * @param pNo
	 * takes int pNo as input to change the value of the products number.
	 */
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	/**
	 * @return pName
	 * returns product name as string-value
	 */
	public String getPName() {
		return pName;
	}
	
	/**
	 * @param pName
	 * takes String pName as input to change the value of the products name.
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	
	/**
	 * @return priceInEuro
	 * returns price value in EURO (default) as double-value
	 */
	public double getPriceInEuro() {
		return priceInEuro;
	}
	
	/**
	 * @param priceInEuro
	 * takes priceInEuro as input to change the value of priceInEuro.
	 */

	public void setPriceInEuro(double priceInEuro) {
		this.priceInEuro = priceInEuro;
	}
	
	/**
	 * @return imageFile
	 * returns image file name as a String-value.
	 */
	public String getImageFile() {
		return imageFile;
	}
	
	/**
	 * @param imageFile
	 * takes imageFilea as input to change the file name of the given picture.
	 */
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

}
