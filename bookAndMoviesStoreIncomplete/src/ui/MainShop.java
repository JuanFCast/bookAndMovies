package ui;

import java.util.Scanner;

import model.Shop;
import model.ProductType;

/**
 * 
 * @author angievig
 * 
 */
public class MainShop {
	private Shop shop;
	private static Scanner sc = new Scanner(System.in);
	
	public MainShop() {
		shop= new Shop("AP1's book store");
	}

	public static void main(String[] args) {
		
		MainShop mainObject= new MainShop();
		int option = 0;
		do {
			option=mainObject.showMenuAndReadInput();
			mainObject.dispatchOption(option);
		}while(option!=0);
		
	}

	public void dispatchOption(int option) {
		switch(option) {
		case -1: 
			createScenario();
			break;
		case 0: 
			System.out.println("\n*** Leaving the app, bye bye ***");
			break;
		case 1:
			addProductCatalog();
			break;
		case 2:
			System.out.println(shop.showCatalog());
			break;
		case 3:
			processProduct();
			break;
				
		}
		
		
	}

	public void rentProduct(String code) {
		System.out.println("\n*** Welcome to the rent's screen***\n");
		
		System.out.println("How many days you wanna rent the product?");
		int days= sc.nextInt();
		sc.nextLine();
		
		String answer =shop.rentProduct(code, days);
		System.out.println(answer);
		
		
		
	}
	
	public void saleProduct(String code) {
		System.out.println("\n*** Welcome to the sale's screen***\n");
		
		System.out.println("Digit the amount of units you wanna buy");
		int units2Buy= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digit the percenteage of discount(if applies)\n"
				+ "the discount is a number between 0 and 1");
		double discount= sc.nextDouble();
		sc.nextLine();
		
		String answer = shop.saleProduct(code, units2Buy, discount);
		
		System.out.println(answer);
		
		
	}

	public void processProduct() {
		System.out.println("\n*** Digit the code of the product you wanna process ***\n");
		String code = sc.nextLine();
		
		int operation= shop.getOperation(code);
		
		switch(operation) {
		case Shop.SALE:
			System.out.println("You picked a saleable product!!");
			saleProduct(code);
			break;
		case Shop.RENT:
			System.out.println("You picked a rentable product!!");
			rentProduct(code);
			break;
			default :
				System.out.println("Sorry, there's no product with that code");
				
		}
		

	}

	public  void createScenario() {
		TestScenario scenario = new TestScenario();
		scenario.createScenario1(shop);
		
	}

	public int showMenuAndReadInput() {
		System.out.println("*** Welcome to the "+ shop.getName() +  " ***\n");
		System.out.println("Please, select one option:\n"+
							"(-1) For running the scenario \n"+
							"(1) For adding a product to the catalog \n"+
							"(2) For displaying the catalog's contents \n"+
							"(3) For rent/sale a product  \n"+
							"(0) For leaving the app");
		
		int number= sc.nextInt();
		sc.nextLine();
		
		return number;
		
		
	}
	
	public void addProductCatalog() {

		System.out.println("======================\nFormat for new product\n======================");
		System.out.println("Please choose if the producer is for Sale or Rent \n(1) Sale \n(2) Rent");
		int option = sc.nextInt();
		sc.nextLine();

		if (option==1){

			System.out.println("Enter the Code of the product please: ");
			String code= sc.nextLine();
			System.out.println("Enter the Name of the product please: ");
			String name= sc.nextLine();
			System.out.println("Enter the Units of the product please: ");
			int units= sc.nextInt();
			System.out.println("Enter the Price of the product please: ");
			double price= sc.nextDouble();
			System.out.println("Please select the type of the product: \n(1) BOOK \n(2) MAGAZINE \n(3) DVD_MOVIE \n(4) DOWNLOAD_MOVIE ");
			int type = sc.nextInt();

			if (type==1){
				System.out.println(shop.addProduct(code,name,units,price,ProductType.BOOK));

			}else if(type==2){
				System.out.println(shop.addProduct(code,name,units,price,ProductType.MAGAZINE));

			}else if (type==3){
				System.out.println(shop.addProduct(code,name,units,price,ProductType.DVD_MOVIE));

			}else if (type==4){
				System.out.println(shop.addProduct(code,name,units,price,ProductType.DOWNLOAD_MOVIE));

			}else 
			System.out.println("Try again\n");


		}else if (option==2){
			System.out.println("Enter the Code of the product please: ");
			String code= sc.nextLine();
			System.out.println("Enter the Name of the product please: ");
			String name= sc.nextLine();
			System.out.println("Enter the Price of the product please: ");
			double price= sc.nextDouble();
			System.out.println("Please select the type of the product: \n(1) BOOK \n(2) MAGAZINE \n(3) DVD_MOVIE \n(4) DOWNLOAD_MOVIE ");
			int type = sc.nextInt();

			if (type==1){
				System.out.println(shop.addProduct(code,name,price,ProductType.BOOK));

			}else if(type==2){
				System.out.println(shop.addProduct(code,name,price,ProductType.MAGAZINE));

			}else if (type==3){
				System.out.println(shop.addProduct(code,name,price,ProductType.DVD_MOVIE));

			}else if (type==4){
				System.out.println(shop.addProduct(code,name,price,ProductType.DOWNLOAD_MOVIE));

			}else 
			System.out.println("Try again\n");

		} else 
		System.out.println("Try again\n");
		
	}
	
	

}
