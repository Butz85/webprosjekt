package objects;

/**
 * @author Magnus Brimsholm
 *
 */

public class CurrencyCalculator {
	private final double NOKRATE = 9.41;
	private final double GBPRATE = 0.72;
	private final double USRATE = 1.10;
	private final double EURRATE = 1.0;

	private String currency;

	/**
	 * Standard constructor
	 * Sets the currency string-value at default: EUR
	 */
	public CurrencyCalculator() {
		currency = "EURRATE";
	}
	
	
	/**
	 * @param cur
	 * Constructor
	 * Sets the currency string-value to a currency value 
	 * given at object initialization.
	 */
	public CurrencyCalculator(String cur) {
		currency = cur;
	}
	
	/**
	 * @return currency
	 * returns currency string-value.
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * @param currency
	 * Takes a string input value and changes 
	 * the current currency value to correct value of the given language.
	 */
	public void setCurrency(String language) {
		if (currency.equals("en_US")) {
			currency = "USD";
		} else if (currency.equals("no_NO")) {
			currency = "NOK";
		} else if (currency.equals("en_EN")){
			currency = "GBP";
		} 	
	}

	/**
	 * @param sum
	 * @return value
	 * 
	 * Calculates a given value against the currency defined in the object.
	 */
	public double calculateValueInGivenCurrency(double sum){
		double value = 0.0;
		if (currency.equals("USD")) {
			value = (sum * USRATE);
		} else if (currency.equals("NOK")) {
			value = (sum * NOKRATE);
		} else if (currency.equals("GBP")){
			value = (sum * GBPRATE);
			} 	
		return value;
	}
	
	
	/**
	 * @return currencyRate
	 * Returns the currency rate value of the given currency in the object.
	 */
	public double getChosenCurrencyRate(){
		double currencyRate = EURRATE;
		if (currency.equals("USD")) {
			currencyRate = USRATE;
		} else if (currency.equals("NOK")) {
			currencyRate = NOKRATE;
		} else if (currency.equals("GBP")){
			currencyRate = GBPRATE;
			}
		return currencyRate;
	}
}
