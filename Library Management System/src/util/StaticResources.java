package util;

import model.Book;
import service.Library;

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
