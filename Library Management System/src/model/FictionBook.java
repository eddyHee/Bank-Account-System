package model;

import enums.BookEnums;
import java.util.Objects;
import service.Library;

public class FictionBook extends Book {

    private Library belowToLibrary;
    private boolean isAvailable;
    public static class Builder extends Book.Builder<Builder> {
        Library library;

        public Builder(BookEnums.BookType type, String name, Library lib) {
            super.name = name;
            super.type = Objects.requireNonNull(BookEnums.BookType.FICTION, "Book type cannot be null");
            this.library = lib;
        }

        @Override
        public FictionBook build() {
            return new FictionBook(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private FictionBook(Builder builder) {
        super(builder);
        this.belowToLibrary = builder.library;
        this.isAvailable = true;
    }


    @Override
    public boolean isAvailable() {
        return this.isAvailable;
    }


    @Override
    void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
