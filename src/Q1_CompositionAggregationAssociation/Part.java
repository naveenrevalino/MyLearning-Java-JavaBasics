package Q1_CompositionAggregationAssociation;

public class Part {

    // Class Variable
    public boolean isFunctional = true;

    public void fix() {
        if ( !isFunctional ) {
            isFunctional = true;
        }
    }
}
