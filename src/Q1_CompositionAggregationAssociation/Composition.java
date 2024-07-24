package Q1_CompositionAggregationAssociation;

import java.util.ArrayList;

/**
 * Composition: Special type of Has-A relationship
 * Implies Parent-Child relationship. ( meaning, child-object cannot exist independent of parent-object )

 * Example;
 * Imagine we have a VEHICLE object ( parent-object ), and it is composed of PARTS object ( child-object ).
 * Once the VEHICLE object is destroyed, the child object PARTS is also destroyed. That is, if one object is
 * garbage collected the other will be garbage collected too.
 */
public class Composition {

    public static void main(String[] args) {

        // BMW PARTS
        ArrayList<Part> bmwPartsList = new ArrayList<>();
        Part bmwEngine = new Part();
        Part bmwBody = new Part();
        bmwPartsList.add( bmwEngine );
        bmwPartsList.add( bmwBody );

        //  BMW CAR: Car built using bmw parts list
        Vehicle newBMWCar = new Vehicle( "GAS", 17, bmwPartsList );

        // TODO: If the Object ( newBMWCar ) is garbage collected then Object ( bmwPartsList ) will become orphan.
        //  Hence it will be garbage collected too.
    }
}
