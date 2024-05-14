package cz.bonoman.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BookingManager {
    private final List<Guest> guestList = new ArrayList<>();
    private final List<Room> roomList = new ArrayList<>();
    private final List<Booking> bookingList = new ArrayList<>();

    public BookingManager(){}

    // ### GUESTS ###

    // ### BOOKING MANAGER
    public void guestListAdd(Guest input){
        this.guestList.add(input);
    }

    public Booking getBooking(int item){return this.bookingList.get(item);}

    public List<Booking> getBookings(){return this.bookingList;}

    public void clearBookings(){this.bookingList.clear();}

    public int getNumberOfWorkingBookings(){
        int retVal = 0;
        for(Booking booking : this.bookingList){
            if(booking.gsTypeOfVacation() == 1){
                retVal += 1;
            }
        }
        return retVal;
    }

    public double getAverageGuests(){
        double retVal;
        int count = 0;
        for(Booking booking : this.bookingList){
            count += booking.gsGuestsList().size();
        }
        retVal = Math.round((double)count / this.bookingList.size() * 100.0) / 100.0;
        return retVal;
    }


    public String printGuestList(){
        StringBuilder retVal = new StringBuilder();
        for(Guest guest : this.guestList){
            retVal.append(guest.gsName()).append(" ").append(guest.gsSurName()).append(", Birthday: ").append("(").append(this.getCzDateFormat(guest.gsBirthDay().toString())).append(")").append(", Guest ID: ").append(guest.gsId()).append("\n");
        }
        return retVal.toString();
    }

    public int getNextGuestId(){
        int retVal, id;
        retVal = 0;
        for(Guest guest : this.guestList){
            id = guest.gsId();
            if(id > retVal){
                retVal = id;
            }
        }
        retVal += 1;
        return retVal;
    }

    public String getCzDateFormat(String input){
        String retVal;
        LocalDate date = LocalDate.parse(input);
        Locale locale = new Locale.Builder().setLanguage("cs").setRegion("CZ").build();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy", locale);
        retVal = date.format(formatter);
        return retVal;
    }

    // ### ROOMS ###
    public void roomListAdd(Room input){
        this.roomList.add(input);
    }

    public int getNextRoomId(){
        int retVal, id;
        retVal = 0;
        for(Room room : this.roomList){
            id = room.gsId();
            if(id > retVal){
                retVal = id;
            }
        }
        retVal += 1;
        return retVal;
    }

    public String printRoomList(){
        StringBuilder retVal = new StringBuilder();
        for(Room room : this.roomList){
            String balcony = "No";
            if(room.gsBalcony()){
                balcony = "Yes";
            }
            String seaView = "No";
            if(room.gsSeaView()){
                seaView = "Yes";
            }
            retVal.append("Beds: ").append(room.gsBeds());
            retVal.append(", Price: ").append(room.gsPrice());
            retVal.append(" CZK/night, Balcony: ").append(balcony);
            retVal.append(", Seaview: ").append(seaView);
            retVal.append(", Room ID: ").append(room.gsId()).append("\n");
        }
        return retVal.toString();
    }

    // ### BOOKING ###
    public void addBooking(Booking input){
        this.bookingList.add(input);
    }

    public int getNextBookingId(){
        int retVal, id;
        retVal = 0;
        for(Booking booking : this.bookingList){
            id = booking.gsId();
            if(id > retVal){
                retVal = id;
            }
        }
        retVal += 1;
        return retVal;
    }

    public String printBookingList(){
        StringBuilder retVal = new StringBuilder();
        for(Booking booking : this.bookingList){
            String typeOfVacation = "Working vacation";
            if(booking.gsTypeOfVacation() == 2){
                typeOfVacation = "Holiday vacation";
            }
            retVal.append("Check-In: ").append(this.getCzDateFormat(booking.gsCheckIn().toString()));
            retVal.append(", Check-Out: ").append(this.getCzDateFormat(booking.gsCheckOut().toString()));
            retVal.append(", ").append(typeOfVacation);
            retVal.append(", Room ID: ").append(booking.gsRoom().gsId());

            StringBuilder guestName = new StringBuilder();
            for(Guest guest : booking.gsGuestsList()){
                guestName.append(guest.gsName()).append(" ").append(guest.gsSurName()).append(", ");
            }

            retVal.append(", Guests: ").append(guestName).append("\n");
            guestName.setLength(0);
        }
        return retVal.toString();
    }

    // getters, setters
    public List<Guest> gsGuestList(){return this.guestList;}
    public List<Room> gsRoomList(){return this.roomList;}
}
