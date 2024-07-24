package Q4_Abstract;

public abstract class AbstractPerson {

    // Class Variables
    private String Name;
    private final String Gender;

    // Class Constructor
    public AbstractPerson(String nm, String Gen) {
        this.Name = nm;
        this.Gender = Gen;
    }

    // Abstract Method
    public abstract void work();

    public void Exam() {
        // TODO : Complex computation
        System.out.println("Exam Started : ");
    }

    public void Office() {
        // TODO : Complex computation
        System.out.println("Office Started : ");
    }

    // toString Method
    @Override
    public String toString() {
        return "Name=" + this.Name + "::Gender=" + this.Gender;
    }

    // Setter Method
    public void steName(String newName) {
        this.Name = newName;
    }

}
