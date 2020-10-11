

public class Main { // Test
    public static void main(String[] args){
    	
    	//Start the factory and build 5 cars.
    	Build build = new Build();
    	build.buildCar();
    	build.buildCar();
    	build.buildCar();
    	build.buildCar();
    	
    	//Instantiate the car Shop
        CarShop carShop = CarShop.getInstance();

        
        //Attempt to sell 6 cars
        carShop.sellCar("Ferrari");
        carShop.sellCar("Lada");
        carShop.sellCar("Lada");
        carShop.sellCar("Lada");
        carShop.sellCar("Lada");
        carShop.sellCar("Porshe");

        
        //The sold cars are 5, because only 5 were produced.
        System.out.println("Sold cars: " + carShop.soldCars);
        
        //Get total revenue as of sold cars and price
        System.out.println("Total revenue: " + carShop.revenue);
        
      

        
    }
}