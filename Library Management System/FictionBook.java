
import java.util.Objects;

public class FictionBook extends Book {

    private final BookEnums.BookType type;

    public static class Builder extends Book.Builder<Builder> {

        private final BookEnums.BookType type;

        public Builder(String name) {
            super.name = name;
            this.type = Objects.requireNonNull(BookEnums.BookType.FICTION, "Book type cannot be null");
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
        type = builder.type;
    }

    public BookEnums.BookType getBookType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "This is a fiction book with \n\tName: {"
                + this.name + "}\n\tauthors: {" + this.authors + "}\n\ttype: {" + this.type + "}\n";
    }
}
