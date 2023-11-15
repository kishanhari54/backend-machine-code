package com.harshet.hotelManagement.Services;

import com.harshet.hotelManagement.DTO.requestBooking;
import com.harshet.hotelManagement.DTO.responseBooking;
import com.harshet.hotelManagement.Enum.BookingStatus;
import com.harshet.hotelManagement.Models.*;
import com.harshet.hotelManagement.Repository.HotelsRepo;
import com.harshet.hotelManagement.Repository.HotelsRoomRepo;
import com.harshet.hotelManagement.Repository.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {

    UsersRepo userRepo;
    HotelsRoomRepo roomRepo;
    HotelsRepo hotelRepo;

    com.harshet.hotelManagement.Repository.RoomBookings roomBookingRepo;
    public BookingService(UsersRepo userrepo, HotelsRoomRepo hotelsRoomRepo, HotelsRepo hotelsRepo, com.harshet.hotelManagement.Repository.RoomBookings roomBookingsRepo){
        userRepo = userrepo;
        roomRepo = hotelsRoomRepo;
        hotelRepo = hotelsRepo;
        roomBookingRepo = roomBookingsRepo;
    }

    public responseBooking createBooking(requestBooking bookingInfo){

        RoomBookings roomBookings = new RoomBookings();

        // Assign User
        Optional<Users> user = userRepo.findById(UUID.fromString(bookingInfo.getUserId()));
        if(user.isEmpty()){
            // throw error user not found
        }
        roomBookings.setUser(user.get());

        //Assign Hotel
        Optional<Hotels> hotels = hotelRepo.findById(UUID.fromString(bookingInfo.getHotelId()));
        if(hotels.isEmpty()){
            //throw Error
        }
            roomBookings.setHotel_booking(hotels.get());



        //Assign Available Rooms;
            /// Filter for Available Rooms.
         Optional<List<HotelRoom>>  room =  roomRepo.findAllByHotel_Id( UUID.fromString(bookingInfo.getHotelId()));
         if(room.isEmpty()){
             // Throw No Room Available for the given dates
         }
            List<RoomBookingDetails> bookingDetails = new ArrayList<>();

                room.get().stream().forEach( roomInfo -> {

                    RoomBookingDetails book = new RoomBookingDetails();
                    book.setBookingStartDate(bookingInfo.getStartDate() );
                    book.setBookingEndDate(bookingInfo.getEndDate());
                    book.setRoomBooked(roomInfo);
                    book.setStatus(BookingStatus.BOOKED);
                    book.setBookingId(roomBookings);
                    bookingDetails.add(book);
                });

        roomBookings.setBookingStartDate(bookingInfo.getStartDate() );
        roomBookings.setBookingEndDate(bookingInfo.getEndDate());
         roomBookings.setBookingDetails(bookingDetails);
         // Update Booking Details
        return responseBooking.from(roomBookingRepo.save(roomBookings));



    }

    public responseBooking getBookingInfo(String bookingId){
          Optional<RoomBookings>  booking =  roomBookingRepo.findById(UUID.fromString(bookingId)) ;
          if(booking.isEmpty()) return null;
          return responseBooking.from(booking.get());
    }

}
