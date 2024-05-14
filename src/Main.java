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
import cz.bonoman.hotel.Manager;
import cz.bonoman.hotel.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        // define class instances
        Manager manager = new Manager();

        String retVal; retVal = "\n### Welcome in Booking system\n\n";

        // define guests
        retVal += "### GUESTS:\n";
        Guest guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13), manager.getNextGuestId());
        manager.guestListAdd(guest1);
        Guest guest2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5), manager.getNextGuestId());
        manager.guestListAdd(guest2);
        retVal += manager.printGuestList() + "\n";

        // define rooms
        retVal += "### ROOMS:\n";
        Room room1 = new Room(1, 1000, true, true, manager.getNextRoomId());
        manager.roomListAdd(room1);
        Room room2 = new Room(1, 1000, true, true, manager.getNextRoomId());
        manager.roomListAdd(room2);
        Room room3 = new Room(3, 2400, false, true, manager.getNextRoomId());
        manager.roomListAdd(room3);
        retVal += manager.printRoomList() + "\n";

        // define bookings
        retVal += "### BOOKINGS:\n";
        manager.bookingListAdd(new Booking(new ArrayList<>(List.of(guest1)) , room1, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), manager.getNextBookingId()));
        manager.bookingListAdd(new Booking(new ArrayList<>(List.of(guest1, guest2)) , room3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), manager.getNextBookingId()));
        retVal += manager.printBookingList() + "\n";

        System.out.println(retVal);
    }
}
