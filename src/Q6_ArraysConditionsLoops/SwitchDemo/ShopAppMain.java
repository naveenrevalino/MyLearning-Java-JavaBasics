package Q6_ArraysConditionsLoops.SwitchDemo;

public class ShopAppMain {

    public static void main(String[] args) {

        int measurement = 7;

        Customer customer1 = new Customer();

        switch( measurement ) {

            case 1 : case 2 : case 3:
                customer1.size = "S";
                break;
            case 4 : case 5 : case 6:
                customer1.size = "M";
                break;
            case 7 : case 8 : case 9:
                customer1.size = "L";
                break;
            default:
                customer1.size = "UN";

        }


        System.out.println("Customer size : " + customer1.size );
    }
}
