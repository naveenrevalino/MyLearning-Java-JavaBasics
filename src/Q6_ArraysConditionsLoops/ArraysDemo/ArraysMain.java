package Q6_ArraysConditionsLoops.ArraysDemo;

public class ArraysMain {

    public static void main(String[] args) {

        // Declare Array
        int totalCost = 0;
        String customerSize = "S";
        Clothing[] items = new Clothing[5];


        Clothing clothing0 = new Clothing( "T-Shirt", "S", 5, 2 );
        Clothing clothing1 = new Clothing( "Jeans", "M", 8, 1 );
        Clothing clothing2 = new Clothing( "Saree", "S", 9, 15 );
        Clothing clothing3 = new Clothing( "Skirt", "L", 7, 3 );
        Clothing clothing4 = new Clothing( "Scarf", "S", 2, 1 );

        items[0] = clothing0;
        items[1] = clothing1;
        items[2] = clothing2;
        items[3] = clothing3;
        items[4] = clothing4;

//        for ( Clothing eachCloth : items ) {
//            if ( eachCloth.size.equals(customerSize) ) {
//                System.out.println( "Description : " + eachCloth.description + ", " +
//                        "Size : " + eachCloth.size + ", " +
//                        "Price : " + eachCloth.price + ", " +
//                        "Tax : " + eachCloth.tax + ", " +
//                        "Total : " + (eachCloth.price + eachCloth.tax));
//                totalCost = totalCost + (eachCloth.price + eachCloth.tax);
//            }
//        }
//        System.out.println( "Final total price of all items : " + totalCost );



        for ( Clothing eachCloth : items ) {
            if ( totalCost <= 15 ) {
                System.out.println( "Description : " + eachCloth.description + ", " +
                        "Size : " + eachCloth.size + ", " +
                        "Price : " + eachCloth.price + ", " +
                        "Tax : " + eachCloth.tax + ", " +
                        "Total : " + (eachCloth.price + eachCloth.tax));
                totalCost = totalCost + (eachCloth.price + eachCloth.tax);
            }
        }
        System.out.println( "Final total price of all items : " + totalCost );
        System.out.println("Naveen's sample code !");
        Clothing[] items3 = {clothing0, clothing2};



    }
}
