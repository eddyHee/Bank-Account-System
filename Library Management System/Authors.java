
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
