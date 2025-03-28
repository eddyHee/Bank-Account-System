
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Book {

    final String name;
    final Set<BookEnums.Authors> authors;
    final LocalDateTime publishTime;
    final BookEnums.Language language;
    final BookEnums.BookType type;

    abstract static class Builder<T extends Builder<T>> {

        String name;
        EnumSet<BookEnums.Authors> authors = EnumSet.noneOf(BookEnums.Authors.class);
        BookEnums.Language language;
        LocalDateTime publishTime;
        BookEnums.BookType type;

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
        type = builder.type;
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

    public BookEnums.BookType getBookType() {
        return this.type;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Book Name: {0}.\n\tAuthors: {1}.\n\tPublish time: {2}.\n\tLanguage: {3}.\n", this.name, this.authors, this.publishTime, this.language);
    }
}
