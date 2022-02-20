import java.util.ArrayList;

public class Alaska implements Airline {

    String name;
    String desc;
    int capicty;
    ArrayList<Passenger> passengers;


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;

    }

    @Override
    public void setCap(int capicty) {
        this.capicty = capicty;

    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
}
