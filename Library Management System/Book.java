
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.Set;

abstract class Book {

    private final String name;
    private final Set<Authors> authors;
    private final LocalDateTime publishTime;
    private final Language language;

    abstract static class Builder<T extends Builder<T>> {

        String name;
        EnumSet<Authors> authors;
        Language language;
        LocalDateTime publishTime;

        public T name(String name) {
            this.name = name;
            return self();
        }

        public T authors(Authors author) {
            authors.add(author);
            return self();
        }

        public T language(Language language) {
            this.language = language;
            return self();
        }

        public T publishTime(LocalDateTime publishTime) {
            this.publishTime = publishTime;
            return self();
        }

        abstract Book build();

        protected abstract T self();
    }

    Book(Builder<?> builder) {
        name = builder.name;
        authors = builder.authors.clone();
        publishTime = builder.publishTime;
        language = builder.language;
    }

    public String getName() {
        return this.name;
    }

    public Set<Authors> getAuthors() {
        return this.authors;
    }

    public Language getLanguage() {
        return this.language;
    }

    public LocalDateTime getPublishTime() {
        return this.publishTime;
    }

}
