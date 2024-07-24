package Q1_CompositionAggregationAssociation;

public class Driver {

    private Vehicle availableVehicle;

    public void rentVehicle( Vehicle vehicle ) {
        this.availableVehicle = vehicle;
        System.out.println(" The driver has a vehicle to drive.");
    }

    public void driveVehicle( double miles ) {

        if ( this.availableVehicle != null ) {
            System.out.println(" The driver can drive this car up-to " + "[ " +miles+ " ] miles.");
        }
    }

    public void returnVehicle() {

        this.availableVehicle = null;
            System.out.println(" The driver has returned the vehicle.");
        }
    }
