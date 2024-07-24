package Q4_Abstract;

public class Naveen {

    private String address = "Canada";

    public void printMyName(){
        final String name="Naveen Ravi";
        System.out.println("My name is : " + name);
    }

    public void printMyInfo(){
        final String gender="Male";
        final int age = 50;
        System.out.println("My gender is : " + gender);
        System.out.println("My age is : " + age);
        // System.out.println("My address is : " + address);
    }

    // GET Method
    public String getAddress(){
        return address;
    }

    // SET Method
    public void setAddress( String newAddress ){
        address = newAddress;
    }
}
