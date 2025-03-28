
public class FictionBook extends Book {

    private final BookType type;

    public static class Builder extends Book.Builder<Builder> {

        private final BookType type;

        public Builder() {
            this.type = BookType.FICTION;
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

    public BookType getBookType() {
        return this.type;
    }

}
