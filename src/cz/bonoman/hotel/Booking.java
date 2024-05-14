package cz.bonoman.hotel;

import java.time.LocalDate;
import java.util.List;

public class Booking {
    private final int id;
    private final LocalDate checkIn, checkOut;
    private final List<Guest> guestsList;
    private final Room room;

    public Booking(List<Guest> guestsList, Room room, LocalDate checkIn, LocalDate checkOut, int id){
        this.guestsList = guestsList;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.id = id;
    }

    // getters, setters
    public List<Guest> gsGuestsList(){return this.guestsList;}
    //public void gsGuestsList(List<Guest> input){this.guestsList = input;}
    public Room gsRoom(){return this.room;}
    //public void gsRoom(Room input){this.room = input;}
    public LocalDate gsCheckIn(){return this.checkIn;}
    //public void gsCheckIn(LocalDate input){this.checkIn = input;}
    public LocalDate gsCheckOut(){return this.checkOut;}
    //public void gsCheckOut(LocalDate input){this.checkOut = input;}
    public int gsId(){return this.id;}
    //public void gsId(int input){this.id = input;}
}
