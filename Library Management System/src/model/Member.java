package model;

import java.util.ArrayList;
import java.util.List;
import service.Library;

public class Member {

    private final String name;
    private Library belongToLibrary;
    private List<Book> borrowList = new ArrayList<Book>();

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, Library lib) {
        this(name);
        this.belongToLibrary = lib;
    }

    public void borrowBook(Book book) {
        this.borrowList.add(book);
    }

    public boolean returnBook(Book book) {
        return this.borrowList.remove(book);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
