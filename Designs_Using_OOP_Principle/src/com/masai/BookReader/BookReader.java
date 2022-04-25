package com.masai.BookReader;

import java.util.List;

public class BookReader {

}

enum Subject {PHYSICS, CHEMISTRY, MATHS}
enum UserStatus {READING, NOT_READING}
enum BookStatus {READING, NOT_READING}
enum DatabaseStatus{AVAILABLE, NOT_AVAILABLE}
enum MembershipStatus {YES, NO}


class Book{
    private String name;
    private String authorName;
    private Subject subject;
    private int bookId;
    private BookStatus bookStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
class User{
    private String name;
    private int userId;
    private UserStatus userStatus;
    MembershipStatus membershipStatus = MembershipStatus.NO;
    private int membershipPeriodInYears = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public MembershipStatus getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(MembershipStatus membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public int getMembershipPeriodInYears() {
        return membershipPeriodInYears;
    }

    public void setMembershipPeriodInYears(int membershipPeriodInYears) {
        this.membershipPeriodInYears = membershipPeriodInYears;
    }

}
class Database{
    private static List<User> users;
    private static List<Book> books;
    private DatabaseStatus databaseStatus;


    public int searchBook(String name){ //provide author name or bookName

        for(Book b : books){
            if(b.getName() ==name || b.getAuthorName()==name){
                return b.getBookId();// returning id of book;
            }
        }

        return -1; // no such book exist
    }

    public String readBook(int bookId,User user){
        if(databaseStatus==DatabaseStatus.NOT_AVAILABLE)
            return "SomeOne is already reading using database";
        Book b1 = null;
        for(Book b : books){
            if(b.getBookId() ==bookId){
                b1 = b;
            }
        }
        b1.setBookStatus(BookStatus.READING);
        user.setUserStatus(UserStatus.READING);

        databaseStatus = DatabaseStatus.NOT_AVAILABLE;
        return "Started reading...";
    }

    public void createMembership(int userId){
        User u1 = null;
        for(User u : users){
            if(u.getUserId() == userId){
                u.membershipStatus = MembershipStatus.YES;
                u.setMembershipPeriodInYears(u.getMembershipPeriodInYears()+1);
            }
        }
    }

    public void  extendMembership(int userId){
        User u1 = null;
        for(User u : users){
            if(u.getUserId() == userId){
                u.setMembershipPeriodInYears(u.getMembershipPeriodInYears()+1);
            }
        }
    }

}