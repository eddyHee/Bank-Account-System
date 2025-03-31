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

    public boolean borrowBook(Book book, Library lib) {
        if (book == null) {
            return false;
        }
        if (lib == null) {
            return false;
        }
        if (lib.getBooks().contains(book) == false) {
            return false;
        }
        if (book.isAvailable() == false) {
            return false;
        }
        if (this.borrowList.contains(book)) {
            return false;
        }
        try {
            this.borrowList.add(book);
            book.setAvailable(false);
            return true;
        } catch(Exception e) {
            return false;
        }
        
    }

    public boolean returnBook(Book book) {
        try {
            if (book == null) {
                return false;
            }
            book.setAvailable(true);
            return this.borrowList.contains(book);
        } catch(Exception e) {
            return false;
        }
        
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
