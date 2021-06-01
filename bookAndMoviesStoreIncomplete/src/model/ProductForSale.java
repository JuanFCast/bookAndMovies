package model;

public class ProductForSale extends Product implements Saleable{
	
	//Attributes
	private double discount;

	//Constructor
	public ProductForSale(String code, String name, int units, double price, ProductType type){
		super(code, name, units, price, type);
		discount = 0;
	}



	//Methods
	@Override
	public double calculateTax (double totalPrice, double percenteage) {
		double percentagePrice, finalPrice;

		percentagePrice = totalPrice * percenteage;

		finalPrice = totalPrice + percentagePrice;

		return finalPrice;
	}


	@Override
	public double getSalePrice(int units){
		double subTotal;

		subTotal = (units*price) - discount;

		return subTotal;

	}


	@Override
	public String getInformation(){
		return "===================\n"+
			   "=== Information ===\n"+
			   "===================\n\n"+
			   "Code: " + getCode() + "\n"+
			   "Product name: " + getName() + "\n" +
			   "Units: " + getUnits() + "\n" + 
			   "Price: " + getPrice() + "\n" + 
			   "Product Type: " + getType() + "\n"+;

	}


	@Override
	public void setDiscount(double discount){

		this.discount = discount;

	}


	@Override
	public boolean isSafeSale(int units){

		boolean available = false;


		if (units >= 0){

			available = true;
		}


		return available;
	}


	@Override
	public double applyExtraDiscount(double subtotal,double percenteageDiscount){
		double finalPrice = 0;

		finalPrice = subtotal - (percenteageDiscount*subtotal);

		return finalPrice;
	}




}