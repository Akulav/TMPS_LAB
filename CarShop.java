class CarShop {
    private static CarShop instance = null;
    private CarShop() {}
    public static int soldCars = 0;
    public static int avaiable_cars = -1;
    public static int revenue = 0;
    public static CarShop getInstance() {
        if (instance == null) {
            instance = new CarShop();
		}
        return instance;
    }
    public void sellCar(String S) {
    	if (avaiable_cars > 0) {
    	//Get pricelist
        InteAbsFactory ifactory = null;
        ifactory = new CarPriceAbsFactory();
        Lada lada = ifactory.getLada();
        Porshe porshe = ifactory.getPorshe();
        Ferrari ferrari = ifactory.getFerrari();
        
        ifactory = new CarPriceAbsFactory();
        soldCars++;
        avaiable_cars--;
        
        if (S.equals("Lada")) {
        	revenue = (int) (revenue + lada.getLadaPrice());
        }
        
        else if (S.equals("Porshe")) {
        	revenue = (int) (revenue + porshe.getPorshePrice());
        }
        
        else if (S.equals("Ferrari")) {
        	revenue = (int) (revenue + ferrari.getFerrariPrice());
        }
        
    	}
    }
}




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

