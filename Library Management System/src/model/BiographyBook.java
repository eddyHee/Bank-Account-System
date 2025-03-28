package model;

import enums.BookEnums;
import java.util.Objects;
import service.Library;

public class BiographyBook extends Book implements LibraryItem{

    private Library belowToLibrary;
    private boolean isAvailable;
    public static class Builder extends Book.Builder<Builder> {

        Library library;
        public Builder(BookEnums.BookType type, String name, Library lib) {
            super.name = name;
            super.type = Objects.requireNonNull(type, "Book type cannot be null");
            this.library = lib;
        }

        @Override
        public Book build() {
            return new BiographyBook(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }

    private BiographyBook(Builder builder) {
        super(builder);
        this.belowToLibrary = builder.library;
        this.isAvailable = true;
    }


    @Override
    public boolean isAvailable() {
        return this.isAvailable;
    }
}
