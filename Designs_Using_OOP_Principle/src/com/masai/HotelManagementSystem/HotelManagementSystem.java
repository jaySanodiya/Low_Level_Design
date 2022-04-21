package com.masai.HotelManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HotelManagementSystem {


}

enum RoomType {DELUXE , STANDARD , FAMILY_SUITS}
enum RoomStatus {AVAILABLE , NOT_AVAILABLE, RESERVED}
enum PaymentStatus {PAID, UNPAID}
enum PaymentMode {CREDIT_CARD , CHECK , CASH}
enum Amenities {SWIMMING_POOL , SPA , FREE_WIFI , MINI_BAR }
enum RoomCleaningStatus {CLEAN , NOT_CLEAN}


class Address {
    String houseNo;
    String street;
    String area;
    String landmark;
    String city;
    String state;
    String pincode;
}

abstract class People{
    String name;
    String mobNo;
    Address address;
}

abstract class Employee extends People{
    int empId;
    String salary;
}

class Room{
    int roomNo;
    double RentPerDay;
    RoomType roomType;
    RoomStatus status;
    Date checkInDate;
    Date checkOutDate;
    RoomCleaningStatus roomCleaningStatus;
    int customerNo;

    public void emptyRoom(){
        this.checkInDate = null;
        this.checkOutDate = null;
        this.customerNo = 0;
    }

}

class Customer extends People{
    int customerNo;
    Date checkInDate;
    Date checkOutDate;
    PaymentStatus paymentStatus;
    PaymentMode paymentMode;
    int roomNo;

    public void addAmenities(Amenities amenities){
        // amenities provided
    }
    public void roomService(){
        // room service is available
    }
    public void orderFood(String listOfMeals){
        // food is provided
    }

}

class Hotel{
    String name;
    Address address;
    String rating;
    static double  moneyEarned ;
    static List<Room> rooms = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();

}

class Receptionist extends Employee{

    public Customer whoBookedThisRoom(int roomno){
        List<Customer> customers = Hotel.customers;
        for(Customer cust : customers){
            if(cust.roomNo == roomno){
                return cust;
            }
        }
        return null;
    }

    public Room roomOfThisCustomer(Customer customer){
        List<Room> rooms = Hotel.rooms;
        for(Room room : rooms){
            if(room.customerNo==customer.customerNo){
                return room;
            }
        }
        return null;
    }

    public int searchForRoom(RoomType roomType){
        List<Room> rooms = Hotel.rooms;
        for(Room room : rooms){
            if(room.roomType == roomType && room.status== RoomStatus.AVAILABLE){
                return room.roomNo;
            }
        }

        return -1; // it means room is not available
    }

    public String bookRoom(int roomno , Customer customer , RoomType roomType){

        // room rent
        double rent;
        if(roomType==RoomType.DELUXE)
            rent = 50000.00;
        else if(roomType==RoomType.STANDARD)
            rent = 10000.00;
        else
            rent = 5000.00;

        // booking searched room
        List<Room> rooms = Hotel.rooms;
        for(Room room : rooms){
            if(room.roomNo == roomno ){
                room.status = RoomStatus.NOT_AVAILABLE;
                room.customerNo = customer.customerNo;
                room.checkInDate = customer.checkInDate;
                room.checkOutDate = customer.checkOutDate;
                room.RentPerDay = rent;
            }
        }

        return "Booking confirmed";
    }

    public String cancelBooking(int roomno ){
        List<Room> rooms = Hotel.rooms;
        for(Room room : rooms){
            if(room.roomNo == roomno){
                room.emptyRoom();
            }
        }
        // if current date - checkIn date is more than 24 hour then 100% money is refunded
        return "Booking is canceled";
    }



    public double getBill(int customerId){
        List<Customer> customers = Hotel.customers;
        int roomNo = 0;
        for(Customer cust : customers){
            if(cust.customerNo==customerId){
                roomNo = cust.roomNo;
            }
        }

        double bill = 0.00;
        List<Room> rooms = Hotel.rooms;
        for(Room room : rooms){
            if(room.roomNo == roomNo){
                bill = room.RentPerDay; // multiply by number of days
            }
        }
        return bill;
    }

    public PaymentStatus payBill(PaymentMode mode , double money){
        Hotel.moneyEarned += money;
        return  PaymentStatus.PAID;
    }

    public void checkOut(int roomNo){
        List<Room> rooms = Hotel.rooms;
        for(Room room : rooms){
            if(room.roomNo == roomNo){
                room.emptyRoom();
                room.roomCleaningStatus = RoomCleaningStatus.NOT_CLEAN;
            }
        }
    }

    public void sendNotification(int costId){
        List<Customer> customers = Hotel.customers;

        String mobNumber = null;
        for(Customer cust : customers){
            if(cust.customerNo==costId){
                mobNumber = cust.mobNo;
            }
        }
        // send notification
    }

}

class HouseKeeping extends Employee{
    public void cleanRoom(int roomNo){
        List<Room> rooms = Hotel.rooms;
        for(Room room : rooms){
            if(room.roomNo == roomNo){
                room.roomCleaningStatus = RoomCleaningStatus.CLEAN;
            }
        }
    }
}
