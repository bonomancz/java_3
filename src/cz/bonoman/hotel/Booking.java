package cz.bonoman.hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Booking {
    private final int id, typeOfVacation;
    private final LocalDate checkIn, checkOut;
    private final List<Guest> guestsList;
    private final Room room;

    public Booking(List<Guest> guestsList, Room room, LocalDate checkIn, LocalDate checkOut, int typeOfVacation, int id){
        this.guestsList = guestsList;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.typeOfVacation = typeOfVacation;
        this.id = id;
    }

    public int getNumberOfGuests(){
        return this.guestsList.size();
    }

    public int getBookingLength(){
        int retVal;
        retVal = (int)ChronoUnit.DAYS.between(this.checkIn, this.checkOut);
        return retVal;
    }

    public int getPrice(){
        int retVal;
        retVal = this.getBookingLength() * this.gsRoom().gsPrice();
        return retVal;
    }

    // getters, setters
    public List<Guest> gsGuestsList(){return this.guestsList;}
    //public void gsGuestsList(List<Guest> input){this.guestsList = input;}
    public Room gsRoom(){return this.room;}
    //public void gsRoom(Room input){this.room = input;}
    public int gsTypeOfVacation(){return this.typeOfVacation;}
    //public void gsTypeOfVacation(int input){this.gsTypeOfVacation = input;}
    public LocalDate gsCheckIn(){return this.checkIn;}
    //public void gsCheckIn(LocalDate input){this.checkIn = input;}
    public LocalDate gsCheckOut(){return this.checkOut;}
    //public void gsCheckOut(LocalDate input){this.checkOut = input;}
    public int gsId(){return this.id;}
    //public void gsId(int input){this.id = input;}
}
