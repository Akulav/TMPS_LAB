# TMPS_LAB1

Topic: Cars
Author: Turcan Catalin


#Theory


I used three patterns: Singleton, Builder, Abstract Factory. 

Singleton: Restricts the creation of a class to a single instance, and provides access to that single instance. I used it to create a Car Shop. Only 1 car shop is allowed to exist so that we can correctly count at any time the number of sold cars and/or revenue.

Abstract Factory: Lets you select a specific factory implementation from a family of possible factories. I use it to get prices for the cars, so that the revenue of the shop can be calculated. 

Builder: Used to create a complex object using simple objects. It gradually constructs a car from smaller parts. I use it to build a car from 3 other parts (body, engine, wheels).


#Implementation


Singleton single instance: 
```
public static CarShop getInstance() {
        if (instance == null) {
            instance = new CarShop();
		}
        return instance;
    }
```

Abstract factory price list for three types of cars

```
interface Lada {
    long getLadaPrice();
}
interface Ferrari {
    long getFerrariPrice();
}
interface Porshe {
    long getPorshePrice();
}
interface InteAbsFactory {
    Lada getLada();
    Ferrari getFerrari();
    Porshe getPorshe();
}
class LadaImpl implements Lada { // First
    public long getLadaPrice() {
        return (int)1000;
    }
}
class FerrariImpl implements Ferrari {
    public long getFerrariPrice() {
        return (int)3000;
    }
}
class PorsheImpl implements Porshe {
    public long getPorshePrice() {
        return (int)2000;
    }
}
class CarPriceAbsFactory implements InteAbsFactory {
    public Lada getLada() {
        return new LadaImpl();
    }
    public Ferrari getFerrari() {
        return new FerrariImpl();
    }
    public Porshe getPorshe() {
        return new PorsheImpl();
    }
}
```

Builder car building process

```
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
```


#Results

```
    	Build build = new Build();
	//Build 4 cars
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

        
        //The sold cars are 4, because only 4 were produced. Cant sell more than the avaiable stock
        System.out.println("Sold cars: " + carShop.soldCars);
        
        //Get total revenue as of sold cars and price
        System.out.println("Total revenue: " + carShop.revenue);
```
	
OUTPUT: 
	

```
Building the base of the car.
Installing wheels.
Installing engine.
The car was successfully built.


Building the base of the car.
Installing wheels.
Installing engine.
The car was successfully built.


Building the base of the car.
Installing wheels.
Installing engine.
The car was successfully built.


Building the base of the car.
Installing wheels.
Installing engine.
The car was successfully built.


Sold cars: 4
Total revenue: 6000
```
