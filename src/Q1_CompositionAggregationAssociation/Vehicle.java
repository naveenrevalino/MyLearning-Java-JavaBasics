package Q1_CompositionAggregationAssociation;

import java.util.ArrayList;

public class Vehicle {

    // Class Variables
    public String fuelType;
    public double fuelCapacity;
    public ArrayList<Part> parts;

    // Class Constructor
    public Vehicle(String fuelType, double fuelCapacity, ArrayList<Part> parts ) {
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.parts = parts;
    }

    public void goToDestination () {
        System.out.println("Go To Destination method executed");
    }
}
