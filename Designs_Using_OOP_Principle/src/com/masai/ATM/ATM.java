package com.masai.ATM;

public class ATM {
    String name;
    Address address;
    Status status;
}

enum Status {OPEN, CLOSE}
enum Language {ENGLISH , HINDI}

class Address {
    String street;
    String area;
    String landmark;
    String city;
    String state;
    String pincode;
}

class Screen{
    String welcomeMessage;

    public void selectLanguage(){
       // hindi or english
    }
    public void options(){
        // change pin, withdraw cash, deposit cash, etc
    }
    public void changePin(){
        // enter old pin twice, then enter new pin
    }
    public void withdrawCash(){
        // enter card then check balance and few more things
    }
    public void depositCash(){
        // enter cash
    }
    public void depositCheck(){
        // enter check
    }
}

class KeyPad{
    public String enter(){
        return "enter";
    }
    public String back(){
        return "back";
    }
    public String cancel(){
        return "cancel";
    }
    public String number(){
        return "pinCode";
    }
}

class CardReader{
    public void enterCard(){
        // check for validation
    }

}

class CashDispenser{
    public void dispenseCash(int amount){
        // if machine contained that amount then it will come out
    }
}

class Printer{
    public void receipt(){
        // print money deducted with time stamp and many more information
    }
}

class DepositSlot{
    public void deposit(int amount){
        // money is deposited to the given account
    }
}

class Help{
    public void communicateWithBank(){
        // connect with bank
    }
}