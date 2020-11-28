STDM Laboratory work No.2
Topic: Structural Design Patterns
Prepared by : Turcan Catalin , FAF-181
Evaluated by : Drumea Vasile 
Main tasks :      

1. By extending our project,to implement at least 3 structural design patterns;

2. Keep the files grouped (into packages/directories);

3. Document the work in a separate markdown file;

##                                                                           Theory :
Example of structural DP.

**1)Adapter**

**2)Bridge**

**3)Composite**

**4)Decorator**

**5)Facade**

**6)Flyweight**

**7)Proxy**

 ##                                                                       Implementation :
In this project I continued work from the previous laboratory with the Transport domain. I implemented 3 Structural Design Patterns(Facade , Proxy and Adapter) that allows to extend functionalities of the system .

## 1. Adapter 
In software engineering, the adapter pattern is a software design pattern that allows the interface of an existing class to be used as another interface. It is often used to make existing classes work with others without modifying their source code. 
```
public interface IMass {
	double getMass();
}

public class BridgeMaxMass implements IMass {
	@Override
    public double getMass() {
        return 3000;
         }
}

public interface IMassAdapter {
	double getMass();
}

public class MassAdapterImplementation implements IMassAdapter {
	private IMass mass;

    public MassAdapterImplementation(IMass mass) {
        this.mass = mass;
    }

    @Override
    public double getMass() {
        double lb = mass.getMass();
        return convertMPHtoKMPH(lb);
    }

    private double convertMPHtoKMPH(double kg){
        return kg*2.20;
    }
}
```

## 2.Facade
The facade pattern is a software-design pattern commonly used in object-oriented programming. Analogous to a facade in architecture, a facade is an object that serves as a front-facing interface masking more complex underlying or structural code. I use it to add customatization options to a car when bought.
```
public class addOption {
	   private IcustomInterior leatherInterior;
	   private IcustomInterior soundSystem;

	   public addOption() {
		   leatherInterior = new leatherInterior();
		   soundSystem = new soundSystem();
	   }
	   
	   public void tuneCar(){
		      leatherInterior.addOptions();
			   soundSystem.addOptions();
		   }		
}

public class soundSystem implements IcustomInterior {
	   @Override
	   public void addOptions() {
	      System.out.println("Premium sound system added");
	   }
	}
```


## 3. Proxy 
A proxy, in its most general form, is a class functioning as an interface to something else. The proxy could interface to anything: a network connection, a large object in memory, a file, or some other resource that is expensive or impossible to duplicate. I use it to book maintenance orders for cars using a class through another class
```
public class bookM implements Scheduler{
	@Override
    public void book() {
	}
}

public interface Scheduler {
	void book();
}

public class bookMproxy implements Scheduler {
	private boolean isScheduled;
    private bookM bookM;

    public bookMproxy() {
        this.isScheduled = false;
        this.bookM = new bookM();
    }

    public boolean isScheduled(){
        return isScheduled;
    }
    public void setScheduled(boolean scheduled){
        isScheduled = scheduled;
    }

    private void scheduleByPhone(){
        System.out.println("Scheduled for service succesfully");
        this.isScheduled = true;
    }

    @Override
    public void book() {
        scheduleByPhone();
        if(this.isScheduled){
            this.bookM.book();
        }

    }
}
```

##                                                                           Results and Conclusion:
```
Premium interior added.
Premium sound system added
Scheduled for service succesfully
The maximal mass for bridges in US is:6600.000000000001kg
The maximal mass for roads in US is:19800.0kg
```

**In conclusion** , these design patterns helped maintain a cleaner code and making it less redunant when not needed.



