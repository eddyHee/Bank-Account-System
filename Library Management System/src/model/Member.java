package model;

import java.util.ArrayList;
import java.util.List;
import service.Library;
import util.StaticResources;

public class Member {

    private final String name;
    private Library belongToLibrary;
    private List<Book> borrowList = new ArrayList<Book>();
    private final String id;

    public Member(String name) {
        this.name = name;
        this.id = StaticResources.generateId();
    }

    public Member(String name, Library lib) {
        this(name);
        this.belongToLibrary = lib;
    }

    public boolean borrowBook(Book book) {
        try {
            this.borrowList.add(book);
            return true;
        } catch(Exception e) {
            return false;
        }
        
    }

    public boolean returnBook(Book book) {
        return this.borrowList.remove(book);
    }

    public String getName() {
        return this.name;
    }

    public List<Book> getBorrowedBooks() {
        return this.borrowList;
    }

    public String getMemberId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
