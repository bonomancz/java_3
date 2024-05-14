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
        retVal += bookingManager.getAverageGuests() + "\n\n";

        // formated bookings list
        retVal += "### FORMATED BOOKINGS - ALL: (" + bookingManager.getBookingCount() + " bookings)\n";
        retVal += printAllBookingsFormated() + "\n";

        // first N holiday bookings list
        retVal += "### FIRST 8 HOLIDAY BOOKINGS:\n";
        retVal += getFirstNHolidayBookings(8) + "\n";

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
        Booking booking1 = new Booking(new ArrayList<>(List.of(bookingManager.gsGuestList().get(0))) , bookingManager.gsRoomList().get(0), LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), 1, bookingManager.getNextBookingId());
        bookingManager.addBooking(booking1);
        Booking booking2 = new Booking(new ArrayList<>(List.of(bookingManager.gsGuestList().get(0), bookingManager.gsGuestList().get(1))) , bookingManager.gsRoomList().get(2), LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), 2, bookingManager.getNextBookingId());
        bookingManager.addBooking(booking2);
        Booking booking3 = new Booking(new ArrayList<>(List.of(bookingManager.gsGuestList().get(2))) , bookingManager.gsRoomList().get(2), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), 1, bookingManager.getNextBookingId());
        bookingManager.addBooking(booking3);
        Booking booking4 = new Booking(new ArrayList<>(List.of(bookingManager.gsGuestList().get(3))) , bookingManager.gsRoomList().get(1), LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), 2, bookingManager.getNextBookingId());
        bookingManager.addBooking(booking4);

        LocalDate checkIn, checkOut;
        Booking booking99;
        for(int i = 0; i < 10; i++){
            switch(i) {
                case 1: checkIn = LocalDate.of(2023,8,3); checkOut = LocalDate.of(2023,8,4);
                        break;
                case 2: checkIn = LocalDate.of(2023,8,5); checkOut = LocalDate.of(2023,8,6);
                        break;
                case 3: checkIn = LocalDate.of(2023,8,7); checkOut = LocalDate.of(2023,8,8);
                        break;
                case 4: checkIn = LocalDate.of(2023,8,9); checkOut = LocalDate.of(2023,8,10);
                        break;
                case 5: checkIn = LocalDate.of(2023,8,11); checkOut = LocalDate.of(2023,8,12);
                        break;
                case 6: checkIn = LocalDate.of(2023,8,13); checkOut = LocalDate.of(2023,8,14);
                        break;
                case 7: checkIn = LocalDate.of(2023,8,15); checkOut = LocalDate.of(2023,8,16);
                        break;
                case 8: checkIn = LocalDate.of(2023,8,17); checkOut = LocalDate.of(2023,8,18);
                        break;
                case 9: checkIn = LocalDate.of(2023,8,19); checkOut = LocalDate.of(2023,8,20);
                        break;
                default:checkIn = LocalDate.of(2023,8,1); checkOut = LocalDate.of(2023,8,2);
                        break;
            }
            booking99 = new Booking(new ArrayList<>(List.of(bookingManager.gsGuestList().get(4))), bookingManager.gsRoomList().get(1), checkIn, checkOut, 2, bookingManager.getNextBookingId());
            bookingManager.addBooking(booking99);
        }

        Booking booking15 = new Booking(new ArrayList<>(List.of(bookingManager.gsGuestList().get(4))) , bookingManager.gsRoomList().get(2), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), 2, bookingManager.getNextBookingId());
        bookingManager.addBooking(booking15);
    }


    private static String printAllBookingsFormated(){
        StringBuilder retVal = new StringBuilder();

        for(Booking booking : bookingManager.getBookings()){
            String seaView = "No";
            if(booking.gsRoom().gsSeaView()){
                seaView = "Yes";
            }
            String balcony = "No";
            if(booking.gsRoom().gsBalcony()){
                balcony = "Yes";
            }
            String vacation = "Working";
            if(booking.gsTypeOfVacation() == 2){
                vacation = "Holiday";
            }
            retVal.append(bookingManager.getCzDateFormat(booking.gsCheckIn().toString()));
            retVal.append(" - ").append(bookingManager.getCzDateFormat(booking.gsCheckOut().toString()));
            retVal.append(", ").append(booking.gsGuestsList().getFirst().gsName());
            retVal.append(", ").append(booking.getBookingLength());
            retVal.append(" Nights,  ").append(booking.gsGuestsList().getFirst().gsSurName());
            retVal.append(" (Birthday: ").append(bookingManager.getCzDateFormat(booking.gsGuestsList().getFirst().gsBirthDay().toString()));
            retVal.append("), Room: ").append(booking.gsRoom().gsId());
            retVal.append(" [Guests: ").append(booking.getNumberOfGuests());
            retVal.append(", Sea view: ").append(seaView);
            retVal.append(", Balcony: ").append(balcony);
            retVal.append("] with price: ").append(booking.gsRoom().gsPrice());
            retVal.append(" CZK/night");
            retVal.append(", Vacation price: ").append(booking.getPrice());
            retVal.append(" CZK/booking");
            retVal.append(" (Vacation type: ").append(vacation);
            retVal.append(")\n");
        }
        return retVal.toString();
    }

    private static String getFirstNHolidayBookings(int n){
        StringBuilder retVal = new StringBuilder();
        int counter = 0;
        for(Booking booking : bookingManager.getBookings()){
            String vacation = "Working";
            if(booking.gsTypeOfVacation() == 2 && counter < n) {
                vacation = "Holiday";

                String seaView = "No";
                if (booking.gsRoom().gsSeaView()) {
                    seaView = "Yes";
                }
                String balcony = "No";
                if (booking.gsRoom().gsBalcony()) {
                    balcony = "Yes";
                }

                retVal.append(bookingManager.getCzDateFormat(booking.gsCheckIn().toString()));
                retVal.append(" - ").append(bookingManager.getCzDateFormat(booking.gsCheckOut().toString()));
                retVal.append(", ").append(booking.getBookingLength());
                retVal.append(" Nights, ").append(booking.gsGuestsList().getFirst().gsName());
                retVal.append(" ").append(booking.gsGuestsList().getFirst().gsSurName());
                retVal.append(" (Birthday: ").append(bookingManager.getCzDateFormat(booking.gsGuestsList().getFirst().gsBirthDay().toString()));
                retVal.append("), Room: ").append(booking.gsRoom().gsId());
                retVal.append(" [Guests: ").append(booking.getNumberOfGuests());
                retVal.append(", Sea view: ").append(seaView);
                retVal.append(", Balcony: ").append(balcony);
                retVal.append("] with price: ").append(booking.gsRoom().gsPrice());
                retVal.append(" CZK/night");
                retVal.append(", Vacation price: ").append(booking.getPrice());
                retVal.append(" CZK/booking");
                retVal.append(" (Vacation type: ").append(vacation);
                retVal.append(")\n");
                counter++;
            }
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
