package Q1_CompositionAggregationAssociation;

import java.util.ArrayList;

/**
 * Aggregation: Has-A relationship.
 * Implies Parent-Child relationship.
 * The lifecycle of each of the involved objects are independent.

 * Example;
 * A VEHICLE Object may or may not belong to a CARPOOL Object.
 */
public class Aggregation {

    public static void main(String[] args) {

        //  BMW CAR: Car built using bmw parts list ( a null list ).
        Vehicle bmwCar = new Vehicle( "GAS", 17, null );

        //  TOYOTA CAR: Car built using toyota parts list ( a null list ).
        Vehicle toyotaCar = new Vehicle( "HPEV", 21, null );

        // Build a vehicle pool >> Aggregation
        ArrayList<Vehicle> vehiclePoolList = new ArrayList<>();

        vehiclePoolList.add( bmwCar );
        vehiclePoolList.add( toyotaCar );

        // TODO: If the Object ( vehiclePoolList ) is garbage collected the Objects ( "bmw" and "toyota" ) might not
        //  be garbage collected as they could be part of another vehicle pool object.


    }
}
