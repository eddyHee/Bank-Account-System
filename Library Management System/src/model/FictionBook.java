package model;

import enums.BookEnums;
import java.util.Objects;

public class FictionBook extends Book {

    public static class Builder extends Book.Builder<Builder> {

        public Builder(BookEnums.BookType type, String name) {
            super.name = name;
            super.type = Objects.requireNonNull(BookEnums.BookType.FICTION, "Book type cannot be null");
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
    }

}
