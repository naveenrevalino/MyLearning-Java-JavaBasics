package Q4_Abstract;

public class Main {

    public static void main(String[] args) {

        // Instance of Naveen
        Naveen naveen = new Naveen();

        naveen.printMyName();
        naveen.printMyInfo();
        naveen.setAddress("USA");
        System.out.println( naveen.getAddress() );

    }
}