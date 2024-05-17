package cz.bonoman.hotel;

public class Room {
    private final int beds, price, id;
    private final boolean balcony, seaView;

    public Room(int beds, int price, boolean balcony, boolean seaView, int id){
        this.beds = beds;
        this.price = price;
        this.balcony = balcony;
        this.seaView = seaView;
        this.id = id;
    }

    // getters, setters
    public int getBeds(){return this.beds;}
    public int getPrice(){return this.price;}
    public boolean getBalcony(){return this.balcony;}
    public boolean getSeaView(){return this.seaView;}
    public int getId(){return this.id;}
}
