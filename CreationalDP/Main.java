package CreationalDP;

import java.util.Scanner;

import BehavioralDP.strategy.Context;
import BehavioralDP.strategy.NormalOil;
import BehavioralDP.strategy.PremiumOil;
import CreationalDP.*;
import StructuralDP.adapter.BridgeMaxMass;
import StructuralDP.adapter.IMass;
import StructuralDP.adapter.IMassAdapter;
import StructuralDP.adapter.MassAdapterImplementation;
import StructuralDP.adapter.RoadMaxMass;
import StructuralDP.facade.addOption;
import StructuralDP.proxy.Scheduler;
import StructuralDP.proxy.bookMproxy;

public class Main {
    public static void main(String[] args) {

        // Just instantiate everything
        Instantiate.getBuilder();
        addOption add_option = new addOption();
        Instantiate.build.buildCar();
        Scheduler repair = new bookMproxy();
        IMass massB = new BridgeMaxMass();
        CarShop carShop = CarShop.getInstance();
        Scanner sc = new Scanner(System.in);
        IMassAdapter MassAdapter = new MassAdapterImplementation(massB);

        while (true) {
            System.out.println("Press '1' to buy a car");
            System.out.println("Press '2' to tune your car");
            System.out.println("Press '3' to make an appointment");
            System.out.println("Press '4' to check for max mass EU/US");
            System.out.println("Press '5' to change oil");
            System.out.println("Press '6' to exit");

            int option = sc.nextInt();

            if (option == 1) {
                System.out.println("Select what car you want to buy:");
                System.out.println("Press 1 for Porshe");
                System.out.println("Press 2 for Lada");
                System.out.println("Press 3 for Ferrari");
                System.out.println("Press 4 to go back");

                // Cars are ordered and are first built, then sold...

                int second_option = sc.nextInt();
                if (second_option == 1) {
                    Instantiate.build.buildCar();
                    carShop.sellCar("Porshe");
                } else if (second_option == 2) {
                    Instantiate.build.buildCar();
                    carShop.sellCar("Lada");
                } else if (second_option == 3) {
                    Instantiate.build.buildCar();
                    carShop.sellCar("Ferrari");
                } else if (second_option == 4) {
                    // nothing
                }

                System.out.println("Total pay: " + carShop.revenue);
                System.out.println("Total sold cars: " + carShop.soldCars);
            }

            else if (option == 2) {
                add_option.tuneCar();

            }

            else if (option == 3) {
                repair.book();
            }

            else if (option == 4) {
                System.out.println("Press 1 for EU");
                System.out.println("Press 2 for US");

                int add = sc.nextInt();

                if (add == 1) {
                    System.out.println("The maximal mass for bridges in EU is:" + MassAdapter.getMass() + "kg");
                }

                else if (add == 2) {
                    IMass massR = new RoadMaxMass();
                    IMassAdapter roadMassAdapter = new MassAdapterImplementation(massR);
                    System.out.println("The maximal mass for roads in US is:" + roadMassAdapter.getMass() + "lb");
                }
            }

            else if (option == 5) {

                System.out.println("Press 1 for normal oil");
                System.out.println("Press 2 for premium oil");

                int choice = sc.nextInt();

                if (choice == 1) {

                    Context cx = new Context(new NormalOil());
                    System.out.println(cx.executeStrategy());
                }

                else if (choice == 2) {

                    Context cx = new Context(new PremiumOil());
                    System.out.println(cx.executeStrategy());
                }

            }

            else if (option == 6) {
                break;

            }
        }
    }
}
