
class StaticResources {

    private StaticResources() {
    }

    public static Library generateLibrary() {
        return new Library("Super fancy library", "Earth");
    }

    public static Book generateBook() {
        return null;
    }
}
