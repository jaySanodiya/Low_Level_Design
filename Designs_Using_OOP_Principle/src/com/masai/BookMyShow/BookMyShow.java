package com.masai.BookMyShow;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookMyShow {
    public static void main(String[] args) {


    }
}

enum SeatAvailability {YES, NO}
enum SeatQuality {LOW , NORMAL , PREMIUM , VIP}
enum MovieLanguage {HINDI , ENGLISH}


class Address {
    private String area;
    private String city;
    private String state;
    private String pincode;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}

class Casts{
    private String actorName;
    private String actressName;
    private String director;

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActressName() {
        return actressName;
    }

    public void setActressName(String actressName) {
        this.actressName = actressName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}

class Movies{
    private String name;
    private String rating;
    private MovieLanguage movieLanguage;


    private List<Casts> castList = new ArrayList<>();
    public void addCasts(Casts casts){
        castList.add(casts);
    }

    public MovieLanguage getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(MovieLanguage movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<Casts> getCastList() {
        return castList;
    }

}

class Theatre{
    private String name;
    private Address address;
    List<Seat> seats = new ArrayList<>();
    List<Movies> moviesList = new ArrayList<>();

    public void addSeats(Seat seat){
        seats.add(seat);
    }
    public void addMovies(Movies movies){
        moviesList.add(movies);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Movies> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<Movies> moviesList) {
        this.moviesList = moviesList;
    }
}

class Seat{
    SeatAvailability seatAvailability;
    SeatQuality seatQuality;
    String price;
    String seatNo;

}

class BookShow{
    Movies movie;
    String noOfSeats;
    SeatQuality seatQuality;
    Time time;
    Date date;
    int tickedId;
    public int bookTicket(){

        // ticket is booked
        return tickedId;
    }
    public void cancelTicket(int tickedId){
        // cancel booking
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public String getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(String noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public SeatQuality getSeatQuality() {
        return seatQuality;
    }

    public void setSeatQuality(SeatQuality seatQuality) {
        this.seatQuality = seatQuality;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTickedId() {
        return tickedId;
    }

    public void setTickedId(int tickedId) {
        this.tickedId = tickedId;
    }
}

class User{
    String name;
    String mobileNo;
}