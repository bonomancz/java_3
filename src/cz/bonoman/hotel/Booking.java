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
        return (int)ChronoUnit.DAYS.between(this.checkIn, this.checkOut);
    }

    public int getPrice(){
        return this.getBookingLength() * this.gsRoom().getPrice();
    }

    // getters, setters
    public List<Guest> getGuestsList(){return this.guestsList;}
    public Room gsRoom(){return this.room;}
    public int isWorkingStay(){return this.typeOfVacation;}
    public LocalDate getCheckIn(){return this.checkIn;}
    public LocalDate getCheckOut(){return this.checkOut;}
    public int getId(){return this.id;}
}
