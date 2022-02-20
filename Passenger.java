
public class Passenger {


    String name;
    String lastname;
    int age;


    public Passenger (String name, String lastname, int age) {
        this.age = age;
        this.lastname = lastname;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}
