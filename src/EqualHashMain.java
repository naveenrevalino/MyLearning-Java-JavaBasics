import java.util.Objects;

class Laptop{
    int price;
    String model;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return price == laptop.price && Objects.equals(model, laptop.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, model);
    }
}

public class EqualHashMain {

    public static void main(String[] args) {

        Laptop laptop1 = new Laptop();
        laptop1.price = 1000;
        laptop1.model = "Mac";

        Laptop laptop2 = new Laptop();
        laptop2.price = 1000;
        laptop2.model = "Mac";

        System.out.println( "Memory Location: " + laptop1 + " Hash Code: " + laptop1.hashCode());
        System.out.println( "Memory Location: " + laptop2 + " Hash Code: " + laptop2.hashCode());

        System.out.println( laptop1.equals(laptop2) );
    }

}
