package model;

import enums.BookEnums;
import java.util.Objects;

public class BiographyBook extends Book {

    public static class Builder extends Book.Builder<Builder> {

        public Builder(BookEnums.BookType type, String name) {
            super.name = name;
            super.type = Objects.requireNonNull(type, "Book type cannot be null");
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
    }

}
