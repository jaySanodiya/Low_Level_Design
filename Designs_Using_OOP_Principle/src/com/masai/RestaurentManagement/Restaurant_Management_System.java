package com.masai.RestaurentManagement;


import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Restaurant_Management_System {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.name = "Darbaar";
        Address add = new Address();
        add.city = "Indore";
        add.State = "M.P";
        restaurant.address = add;
        Branch branch1 = new Branch();
        branch1.name = "Darbaar01";
        Address branchAdd = new Address();
        branchAdd.State = "M.P";
        branchAdd.city = "Palasia, Indore";
        branch1.branchAddress = branchAdd;
        Manager manager = new Manager();
        manager.name = "Raju";
        manager.address = branchAdd;
        manager.department = "FoodAndService";
        manager.empId = "V01";
        manager.phoneNo = "9981547854";
        branch1.addEmployee(manager);

        restaurant.addBranch(new Branch());


    }
}

/*
* Handle Ambiguity...
*
*It contains branches
* Each branch has its seating arrangements
* It has menu
* menu has menuItem
* Branch has Employee
*
*
* ///////////////// Actors ///////////
* Waiter, Customer, Manager, Chef, System
*
* ////////////////   Use cases ///////////////////
* Manager: add remove new restaurant branches, add/remove table from a branch, add/remove staff
* search tables
* place/update order, make/cancel reservation, pay bill, check in , update order.
*
*
* */

enum ReservationStatus {CONFIRMED , CANCEL , PENDING , REQUESTED}
enum TableStatus {AVAILABLE , RESERVED , OCCUPIED}
enum OrderStatus {PLACED , SERVED ,COMPLETE}
enum ItemType {VEG , NONVEG , VEGAN}
enum PaymentStatus {PAID , UNPAID}
enum PaymentMethod {CASH, DC, CC, UPI}

class Address{
    String city;
    String State;
}

abstract class person{
    String name;
    String phoneNo;
    Address address;
}

abstract class Employee extends person{
    String empId;
    String department;
}
class Chef extends Employee{
    int chefId;
    OrderStatus orderStatus;
    List<Order> orderList;
    public void cookFood(Order order){
        orderList.add(order);
        //will be ready in some time
        new Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("Executed...");
                //giveFoodToWaiter
                //1000*5=5000 mlsec. i.e. 5 seconds. u can change accordngly
            }
        },1000*5,1000*5);

    }


}
class Manager extends Employee{
    public void scheduleWorkTimeOfEmployees(){
        //
    }
    public void SalaryDistribution(){
        //
    }
}
class MenuItems{
    String name;
    double price;
    String size;
    String description;
    ItemType itemType;
    String itemNumber;
    String picture;

    public void updatePrice(double price){
        this.price = price;
    }
}
class MenuSection{
    String title;
    List<MenuItems> menuItems;

    public void addMenuItems(MenuItems items){
        menuItems.add(items);
    }
}
class Menu{
    String title;
    List<MenuSection> menuSections;

    public void addSection(MenuSection section){
        menuSections.add(section);

    }
}

class  Order{
    OrderStatus orderStatus;
    PaymentStatus paymentStatus;
    PaymentMethod paymentMethod;
    Menu menu;
    Chef chef;
    double bill;
    int tableNumber;
}
class Waiter extends Employee{
    String salary;
    List<Order> orderList;

    public void getOrder(Order order){

        orderList.add(order);
        order.orderStatus = OrderStatus.PLACED;
    }

    public void serveOrder(Order order){
        order.orderStatus = OrderStatus.SERVED;
    }

    public void getBills(Order order){
        order.orderStatus = OrderStatus.COMPLETE;
    }
}

class Tables{
    TableStatus tableStatus;
    int tableNumber;
    int tableCapacity;

    public boolean isAvailable(int tableNumber){
        return tableStatus == TableStatus.AVAILABLE;
    }

    public String reserveTable(int tableNumber){
        if(tableStatus == TableStatus.AVAILABLE){
            tableStatus = TableStatus.RESERVED;
            return "Table is reserved for you";
        }
        return "Table is not available";
    }

    public String emptyTable(int tableNumber){
        tableStatus = TableStatus.AVAILABLE;
        return "Table is empty now";
    }
}

class Branch{
    String name;
    Address branchAddress;
    List<Tables> tablesList;
    List<Employee> employeeList = new ArrayList<>();

    public void addTable(Tables tables){
        tablesList.add(tables);
    }

    public void removeTable(Tables tables){
        tablesList.remove(tables);
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee){
        employeeList.remove(employee);
    }
}

class Restaurant{
    String name;
    String Rating;
    public Address address;
    List<Branch> branchList = new ArrayList<>();

    public String addBranch(Branch branch){
        branchList.add(branch);
        return "Branch Added Successfully";
    }

    public String removeBranch(Branch branch){
        branchList.remove(branch);
        return "Branch is removed successfully";
    }

    public String shutAllBranch(){
        branchList.clear();
        return "Restaurant is shut down";
    }

}
class Customer{

}
class Reservation{
    ReservationStatus reservationStatus;
    Tables[] tables;
    Time reservedTime;
    Time checkInTime;
    int reservationId;
    Customer customer;
    PaymentStatus paymentStatus;
    int peopleCount;

    public void bookReservation(){
        reservationStatus = ReservationStatus.REQUESTED;
    }
    public void pendingReservation(){
        reservationStatus = ReservationStatus.PENDING;
    }
    public void confirmReservation(){
        reservationStatus = ReservationStatus.CONFIRMED;
        if(peopleCount==2||peopleCount==4||peopleCount==6||peopleCount==8)
            tables = new Tables[1];
        else
            tables = new Tables[(int)Math.floor(peopleCount/8) +1];
    }
    public void cancelReservation(){
        reservationStatus = ReservationStatus.CANCEL;
        tables = null;
    }
    public void updatePeopleCount(int peopleCount){
        this.peopleCount = peopleCount;
        confirmReservation();
    }
    public void updateCheckInTime(){
        
    }
}
