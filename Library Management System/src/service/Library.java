package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class Library {

    private final String location;
    private final String name;
    private List<Book> book;

    private List<Member> memberList;

    public Library(String name, String localtion) {
        this.location = localtion;
        this.name = name;
        this.book = new ArrayList<Book>();
        this.memberList = new ArrayList<Member>();
    }

    public void addBook(Book book) {
        this.book.add(book);
    }

    public void showBooks() {
        for (Book book : this.book) {
            System.out.println(book);
        }
    }

    public void showBookNumber() {
        System.out.println("this library contains" + this.book.size());
    }

    public boolean isMember(Member member) {
        return this.memberList.contains(member);
    }

    @Override
    public String toString() {
        return this.name + "\n";
    }
}
