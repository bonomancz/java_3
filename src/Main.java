/*
################################################################################################
# HOTEL BOOKING APPLICATION
# It defines guest, rooms and booking reservations lists.
# It fills it with data and handles reservation terms.
#
# Author: Jan Novotny, <12.5.2024>
# mail: bonoman@volny.cz
################################################################################################
 */

import cz.bonoman.hotel.Booking;
import cz.bonoman.hotel.Guest;
import cz.bonoman.hotel.BookingManager;
import cz.bonoman.hotel.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    // define class instances
    private static final BookingManager bookingManager = new BookingManager();

    public static void main(String[] args){

        String retVal; retVal = "\n### Welcome in Booking system\n\n";

        // define guests
        retVal += "### GUESTS:\n";
        Guest guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13), bookingManager.getNextGuestId());
        bookingManager.guestListAdd(guest1);
        Guest guest2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5), bookingManager.getNextGuestId());
        bookingManager.guestListAdd(guest2);
        Guest guest3 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15), bookingManager.getNextGuestId());
        bookingManager.guestListAdd(guest3);
        Guest guest4 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3), bookingManager.getNextGuestId());
        bookingManager.guestListAdd(guest4);
        Guest guest5 = new Guest("Karolína", "Tmavá", LocalDate.of(1968, 8, 21), bookingManager.getNextGuestId());
        bookingManager.guestListAdd(guest5);
        retVal += bookingManager.printGuestList() + "\n";

        // define rooms
        retVal += "### ROOMS:\n";
        Room room1 = new Room(1, 1000, true, true, bookingManager.getNextRoomId());
        bookingManager.roomListAdd(room1);
        Room room2 = new Room(1, 1000, true, true, bookingManager.getNextRoomId());
        bookingManager.roomListAdd(room2);
        Room room3 = new Room(3, 2400, false, true, bookingManager.getNextRoomId());
        bookingManager.roomListAdd(room3);
        retVal += bookingManager.printRoomList() + "\n";

        // define bookings
        fillBookings();

        retVal += "### BOOKINGS: (" + bookingManager.getBookingCount() + " bookings)\n";
        retVal += bookingManager.printBookingList() + "\n";

        // working bookings
        retVal += "### WORKING BOOKINGS:\n";
        retVal += bookingManager.getNumberOfWorkingBookings() + "\n\n";

        // average guests
        retVal += "### AVERAGE GUESTS:\n";
        retVal += Math.round(bookingManager.getAverageGuests() * 100.0) / 100.0 + "\n\n";

        // formated bookings list
        retVal += "### FORMATED BOOKINGS - ALL: (" + bookingManager.getBookingCount() + " bookings)\n";
        retVal += printBookingsFormated(bookingManager.getBookings()) + "\n";

        // first N holiday bookings list
        retVal += "### FIRST 8 HOLIDAY BOOKINGS:\n";
        retVal += printBookingsFormated(bookingManager.getFirstNHolidayBookings(8)) + "\n";

        // guest statisticks
        retVal += "### GUEST STATISTICS:\n";
        retVal += printGuestStatistics() + "\n";

        // booking length
        retVal += "### BOOKING LENGTH:\n";
        retVal += "Appended in booking listings above....\n\n";

        // get price
        retVal += "### GET PRICE:\n";
        retVal += "Appended in booking listings above....\n";

        System.out.println(retVal);
    }


    private static void fillBookings(){
        Booking booking1 = new Booking(new ArrayList<>(List.of(bookingManager.getGuestList().get(0))) , bookingManager.getRoomList().get(0), LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), 1, bookingManager.getNextBookingId());
        bookingManager.addBooking(booking1);
        Booking booking2 = new Booking(new ArrayList<>(List.of(bookingManager.getGuestList().get(0), bookingManager.getGuestList().get(1))) , bookingManager.getRoomList().get(2), LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), 2, bookingManager.getNextBookingId());
        bookingManager.addBooking(booking2);
        Booking booking3 = new Booking(new ArrayList<>(List.of(bookingManager.getGuestList().get(2))) , bookingManager.getRoomList().get(2), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), 1, bookingManager.getNextBookingId());
        bookingManager.addBooking(booking3);
        Booking booking4 = new Booking(new ArrayList<>(List.of(bookingManager.getGuestList().get(3))) , bookingManager.getRoomList().get(1), LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), 2, bookingManager.getNextBookingId());
        bookingManager.addBooking(booking4);

        LocalDate checkIn, checkOut;
        Booking bookingX;
        for(int i = 1; i < 21; i+=2){
            checkIn = LocalDate.of(2023,8, i); checkOut = LocalDate.of(2023,8, i+1);
            bookingX = new Booking(new ArrayList<>(List.of(bookingManager.getGuestList().get(4))), bookingManager.getRoomList().get(1), checkIn, checkOut, 2, bookingManager.getNextBookingId());
            bookingManager.addBooking(bookingX);
        }

        Booking booking15 = new Booking(new ArrayList<>(List.of(bookingManager.getGuestList().get(4))) , bookingManager.getRoomList().get(2), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), 2, bookingManager.getNextBookingId());
        bookingManager.addBooking(booking15);
    }


    private static String printBookingsFormated(List<Booking> inputList){
        StringBuilder retVal = new StringBuilder();

        for(Booking booking : inputList){
            String seaView = "ne";
            if(booking.gsRoom().getSeaView()){
                seaView = "ano";
            }
            String balcony = "ne";
            if(booking.gsRoom().getBalcony()){
                balcony = "ano";
            }
            retVal.append(bookingManager.getCzDateFormat(booking.getCheckIn().toString()));
            retVal.append(" až ").append(bookingManager.getCzDateFormat(booking.getCheckOut().toString()));
            retVal.append(": ").append(booking.getGuestsList().getFirst().getName());
            retVal.append(" ").append(booking.getGuestsList().getFirst().getSurName());
            retVal.append(" (").append(bookingManager.getCzDateFormat(booking.getGuestsList().getFirst().getBirthDay().toString()));
            retVal.append(")[").append(booking.getNumberOfGuests());
            retVal.append(", ").append(seaView);
            retVal.append("] za ").append(booking.gsRoom().getPrice());
            retVal.append(" Kč");
            retVal.append("\n");
        }
        return retVal.toString();
    }

    private static String printGuestStatistics(){
        StringBuilder retVal = new StringBuilder();
        int oneManBooking = 0, twoPeopleBooking = 0, morePeopleBooking = 0;
        for(Booking booking : bookingManager.getBookings()){
            if(booking.getNumberOfGuests() == 1){
                oneManBooking += 1;
            }else if(booking.getNumberOfGuests() == 2){
                twoPeopleBooking += 1;
            }else if(booking.getNumberOfGuests() > 2){
                morePeopleBooking += 1;
            }
        }
        retVal.append("One man booking: ").append(oneManBooking).append("\n");
        retVal.append("Two people booking: ").append(twoPeopleBooking).append("\n");
        retVal.append("More people booking: ").append(morePeopleBooking).append("\n");
        return retVal.toString();
    }
}
