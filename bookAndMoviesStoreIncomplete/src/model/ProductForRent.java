package model;
import java.time.LocalDate;

public class ProductForRent extends Product implements Rentable{
	
	//Attributes
	private LocalDate devolutionDate;
	
	//Relationships
	private State state;
	
	//Constructor
	public ProductForRent(String code, String name, double price, ProductType type){
		super(code, name, price, type);
		devolutionDate = LocalDate.of(2021, 05, 28);
		state = State.AVAILABLE;
	}
	
	@0verride from Rentable
	public String rentProduct(int amountDays){
		int aux, day = 28, month = 05, year = 2021;
		
		state = State.RENTED;
		aux = day + amountDays;
	
		for(int i = 0; i <= 12; i++){
			if(month == 01){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
					year++;
				}
			} else if(month == 02){
				if(aux > 28){
					day = aux - 28;
					month++;
					aux = day;
				}
			} else if(month == 03){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			} else if(month == 04){
				if(aux > 30){
					day = aux - 30;
					month++;
					aux = day;
				}
			} else if(month == 05){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			} else if(month == 06){
				if(aux > 30){
					day = aux - 30;
					month++;
					aux = day;
				}
			} else if(month == 07){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			} else if(month == 08){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			} else if(month == 09){
				if(aux > 30){
					day = aux - 30;
					month++;
					aux = day;
				}
			} else if(month == 10){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			} else if(month == 11){
				if(aux > 30){
					day = aux - 30;
					month++;
					aux = day;
				}
			} else if(month == 12){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			}
		}
		
		devolutionDate = LocalDate.of(year, month, day);
		
		return "El producto ha sido alquilado exitosamente\nSu fecha de devolucion limite es " + devolutionDate;
	} 
	
	@0verride from Rentable
	public boolean getRentPrice(int amountDays){
		return amountDays * price; 
	}
	
	@0verride from Product
	public String getInformation(){
		return "===================\n"+
			   "=== Information ===\n"+
			   "===================\n\n"+
			   "Product Type: " + getType() + "\n"+
			   "Code: " + getCode() + "\n"+
			   "Product name: " + getName() + "\n"+
			   "State: " + state + "\n"+
			   "Return deadline: " + devolutionDate + "\n"+
	}
	
	@0verride from Rentable
	public boolean isSafeRent(){
		if(state == State.AVAILABLE){
			return true;
		} else {return false;}
	}
}