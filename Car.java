class Car {
    public void buildBase() {
        print("Building the base of the car.");
    }
    public void buildWheels() {
        print("Installing wheels.");
    }
    public void buildEngine(Engine engine) {
        print("Installing engine.");
        print("The car was successfully built.");
        print("\n");
    }
    private void print(String msg){
        System.out.println(msg);
    }
}
interface Engine {
    String getEngineType();
}
class EngineOne implements Engine {
    public String getEngineType() {
        return "First engine";
    }
}
class EngineTwo implements Engine {
    public String getEngineType() {
        return "Second engine";
    }
}
abstract class Builder {
    protected Car car;
    public abstract Car buildCar();
}
class OneBuilderImpl extends Builder {
    public OneBuilderImpl(){
        car = new Car();
    }
    public Car buildCar() {
        car.buildBase();
        car.buildWheels();
        Engine engine = new EngineOne();
        car.buildEngine(engine);
        return car;
    }
}

class Build {
    private Builder builder;
    
    public Build(){
    	
    	CarShop carShop = CarShop.getInstance();
    	CarShop.avaiable_cars++;
    	
        
        builder = new OneBuilderImpl();
        
       
    }
    public Car buildCar(){
    	CarShop carShop = CarShop.getInstance();
    	CarShop.avaiable_cars++;
        return builder.buildCar();
        
    }
}