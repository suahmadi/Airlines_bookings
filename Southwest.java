import java.util.ArrayList;

public class Southwest implements Airline {
    String name;
    String desc;
    int capcity;
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
        this.capcity = capicty;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
}
