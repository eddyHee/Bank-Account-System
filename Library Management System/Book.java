
import java.time.LocalDateTime;
import java.util.List;

class Book {

    private final String name;
    private final List<String> authors;
    private final LocalDateTime publishTime;
    private final Language language;

    public static class Builder {

        private String name;
        private List<String> authors;
        private Language language;
        private LocalDateTime publishTime;

        public Builder() {
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder publishTime(LocalDateTime time) {
            this.publishTime = time;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder authros(List<String> authors) {
            this.authors = authors;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    private Book(Builder builder) {
        this.name = builder.name;
        this.authors = builder.authors;
        this.publishTime = builder.publishTime;
        this.language = builder.language;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public Language getLanguage() {
        return this.language;
    }

    public LocalDateTime getPublishTime() {
        return this.publishTime;
    }

}
