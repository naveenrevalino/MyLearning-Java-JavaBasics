package Q1_CompositionAggregationAssociation;

import java.util.ArrayList;

/**
 * Association: Is-A relationship.
 * Implies a form of dependency.
 * Both objects have their own lifecycles.

 * Example;
 * Imagine a driver renting out a car, the driver is associated to the car until he uses the car.
 * Once he returns the rental car back to the company, he is no longer associated to that car.
 */
public class Association {

    public static void main(String[] args) {

        //  Build Cars.
        Vehicle bmwCar = new Vehicle( "GAS", 17, null );
        Vehicle toyotaCar = new Vehicle( "HPEV", 21, null );

        // Build a vehicle pool and add the cars
        ArrayList<Vehicle> vehiclePoolList = new ArrayList<>();
        vehiclePoolList.add( bmwCar );
        vehiclePoolList.add( toyotaCar );

        Driver driver = new Driver();

        driver.rentVehicle( bmwCar );
        driver.driveVehicle( 300 );
        driver.returnVehicle();

        // TODO: The driver is related/associated to a particular car only for the duration he rented out the car for.

    }
}
