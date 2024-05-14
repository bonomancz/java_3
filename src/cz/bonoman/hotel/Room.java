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
    public int gsBeds(){return this.beds;}
    //public void gsBeds(int input){this.beds = input;}
    public int gsPrice(){return this.price;}
    //public void gsPrice(int input){this.price = input;}
    public boolean gsBalcony(){return this.balcony;}
    //public void gsBalcony(boolean input){this.balcony = input;}
    public boolean gsSeaView(){return this.seaView;}
    //public void gsSeaView(boolean input){this.seaView = input;}
    public int gsId(){return this.id;}
    //public void gsId(int input){this.id = input;}
}
