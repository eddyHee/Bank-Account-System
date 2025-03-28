
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Book {

    final String name;
    final Set<BookEnums.Authors> authors;
    final LocalDateTime publishTime;
    final BookEnums.Language language;

    abstract static class Builder<T extends Builder<T>> {

        String name;
        EnumSet<BookEnums.Authors> authors = EnumSet.noneOf(BookEnums.Authors.class);
        BookEnums.Language language;
        LocalDateTime publishTime;

        public T authors(BookEnums.Authors author) {
            authors.add(Objects.requireNonNull(author, "author can not be null"));
            return self();
        }

        public T language(BookEnums.Language language) {
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

    public Set<BookEnums.Authors> getAuthors() {
        return this.authors;
    }

    public BookEnums.Language getLanguage() {
        return this.language;
    }

    public LocalDateTime getPublishTime() {
        return this.publishTime;
    }

}
