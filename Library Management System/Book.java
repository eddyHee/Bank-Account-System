
import java.util.List;

class Book {

    private final String name;
    private final List<String> authors;
    private final String type;

    public static class Builder {

        private String name;
        private List<String> authors;
        private String type;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder authros(List<String> authors) {
            this.authors = authors;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    private Book(Builder builder) {
        this.name = builder.name;
        this.authors = builder.authors;
        this.type = builder.type;
    }

    public String getName() {
        return this.name;
    }

    public List<String> etAuthors() {
        return this.authors;
    }

    public String getType() {
        return this.type;
    }

}
