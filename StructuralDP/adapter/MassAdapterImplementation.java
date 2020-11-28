package adapter;

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