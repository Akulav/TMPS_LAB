import adapter.BridgeMaxMass;
import adapter.IMass;
import adapter.IMassAdapter;
import adapter.MassAdapterImplementation;
import adapter.RoadMaxMass;
import facade.addOption;
import proxy.Scheduler;
import proxy.bookMproxy;

public class Main {
    public static void main(String[] args){
    
    	//Start the factory and build 1 car.
        Instantiate.getBuilder();
        addOption add_option = new addOption();
    	Instantiate.build.buildCar();

    	
    	//Instantiate the car Shop
        CarShop carShop = CarShop.getInstance();

        
        //Attempt to sell 6 cars
        add_option.tuneCar();
        carShop.sellCar("Ferrari");
        //carShop.sellCar("Lada");
        //carShop.sellCar("Lada");
        /*
        carShop.sellCar("Lada");
        carShop.sellCar("Lada");
        carShop.sellCar("Porshe");

        
        //The sold cars are 5, because only 5 were produced.
        System.out.println("Sold cars: " + carShop.soldCars);
        
        //Get total revenue as of sold cars and price
        System.out.println("Total revenue: " + carShop.revenue);
        */
        
        //Proxy
        Scheduler repair = new bookMproxy();
        repair.book();
        
        //Adapter
        IMass massB = new BridgeMaxMass();
        IMassAdapter MassAdapter = new MassAdapterImplementation(massB);
        System.out.println("The maximal mass for bridges in US is:"+MassAdapter.getMass()+"kg");
        IMass massR = new RoadMaxMass();
        IMassAdapter roadMassAdapter = new MassAdapterImplementation(massR);
        System.out.println("The maximal mass for roads in US is:"+roadMassAdapter.getMass()+"kg");
        
    }
}