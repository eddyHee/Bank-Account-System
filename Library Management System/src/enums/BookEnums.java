package enums;

public class BookEnums {

    public enum Authors {
        JamesBob("James Bob"),
        JhonBob("Jhon Bob");

        private final String authorName;

        private Authors(String name) {
            this.authorName = name;
        }

        public String getName() {
            return authorName;
        }

    }

    public enum BookType {
        FICTION,
        NON_FICTION,
        MYSTERY,
        SCIENCE_FICTION,
        FANTASY,
        BIOGRAPHY,
        SELF_HELP
    }

    public enum Language {
        English,
        Chinese,
        Japanese;
    }

}
