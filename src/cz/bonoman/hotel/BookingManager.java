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

    // ### BOOKING MANAGER
    public void guestListAdd(Guest input){
        this.guestList.add(input);
    }

    public Booking getBooking(int item){return this.bookingList.get(item);}

    public List<Booking> getBookings(){return new ArrayList<>(bookingList);}

    public void clearBookings(){this.bookingList.clear();}

    public int getNumberOfWorkingBookings(){
        int totalWorkingBookings = 0;
        for(Booking booking : this.bookingList){
            if(booking.isWorkingStay() == 1){
                totalWorkingBookings += 1;
            }
        }
        return totalWorkingBookings;
    }

    public ArrayList<Booking> getFirstNHolidayBookings(int n) {
        ArrayList<Booking> firstHolidayBookings = new ArrayList<>();
        int counter = 0;
        for (Booking booking : this.bookingList) {
            if(booking.isWorkingStay() == 2 && counter < n) {
                firstHolidayBookings.add(booking);
                counter++;
            }
        }
        return firstHolidayBookings;
    }

    public double getAverageGuests(){
        double retVal;
        int count = 0;
        for(Booking booking : this.bookingList){
            count += booking.getGuestsList().size();
        }
        retVal = (double)count / this.bookingList.size();
        return retVal;
    }

    public int getBookingCount(){
        return this.bookingList.size();
    }

    public String printGuestList(){
        StringBuilder retVal = new StringBuilder();
        for(Guest guest : this.guestList){
            retVal.append(guest.getName()).append(" ").append(guest.getSurName()).append(", Birthday: ").append("(").append(this.getCzDateFormat(guest.getBirthDay().toString())).append(")").append(", Guest ID: ").append(guest.getId()).append("\n");
        }
        return retVal.toString();
    }

    // ### GUESTS ###
    public int getNextGuestId(){
        int retVal, id;
        retVal = 0;
        for(Guest guest : this.guestList){
            id = guest.getId();
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
            id = room.getId();
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
            if(room.getBalcony()){
                balcony = "Yes";
            }
            String seaView = "No";
            if(room.getSeaView()){
                seaView = "Yes";
            }
            retVal.append("Beds: ").append(room.getBeds());
            retVal.append(", Price: ").append(room.getPrice());
            retVal.append(" CZK/night, Balcony: ").append(balcony);
            retVal.append(", Seaview: ").append(seaView);
            retVal.append(", Room ID: ").append(room.getId()).append("\n");
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
            id = booking.getId();
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
            if(booking.isWorkingStay() == 2){
                typeOfVacation = "Holiday vacation";
            }
            retVal.append("Check-In: ").append(this.getCzDateFormat(booking.getCheckIn().toString()));
            retVal.append(", Check-Out: ").append(this.getCzDateFormat(booking.getCheckOut().toString()));
            retVal.append(", ").append(typeOfVacation);
            retVal.append(", Room ID: ").append(booking.gsRoom().getId());

            StringBuilder guestName = new StringBuilder();
            for(Guest guest : booking.getGuestsList()){
                guestName.append(guest.getName()).append(" ").append(guest.getSurName()).append(", ");
            }

            retVal.append(", Guests: ").append(guestName).append("\n");
            guestName.setLength(0);
        }
        return retVal.toString();
    }

    // getters, setters
    public List<Guest> getGuestList(){return this.guestList;}
    public List<Room> getRoomList(){return this.roomList;}
}
