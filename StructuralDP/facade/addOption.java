package facade;

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