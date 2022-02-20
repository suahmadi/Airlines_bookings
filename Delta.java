import java.util.ArrayList;

public class Delta implements Airline {

    private String name;
    private String desc;
    private int capcity;
    private ArrayList<Passenger> passengers;



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
