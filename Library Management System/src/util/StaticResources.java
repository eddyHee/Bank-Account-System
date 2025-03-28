package util;

import enums.BookEnums;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.BiographyBook;
import model.Book;
import model.FictionBook;
import model.Member;
import service.Library;

public class StaticResources {

    private StaticResources() {
    }

    public static Library generateLibrary() {
        return new Library("Super fancy library", "Earth");
    }

    public static List<Book> generateBooks(int size, Library lib) {
        List<Book> bookList = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            bookList.add(
                new FictionBook.Builder(
                        BookEnums.BookType.FICTION, 
                        BookTitleGenerator.generateTitle(), 
                        lib
                    )
                    .authors(BookEnums.Authors.JamesBob)
                    .language(BookEnums.Language.English)
                    .build()
            );
        }

        return bookList;
    }

    public static Book generateBook(String bookType, String title, String author, int year, Library lib) {
        Book book;

        switch(enums.BookEnums.BookType.valueOf(bookType)){
            case BIOGRAPHY:
                book = new BiographyBook.Builder(
                    BookEnums.BookType.BIOGRAPHY, 
                    title, 
                    lib
                )
                .authors(BookEnums.Authors.valueOf(author))
                .language(BookEnums.Language.English)
                .build();
                break;
            case FICTION:
                book = new FictionBook.Builder(
                    BookEnums.BookType.FICTION, 
                    title, 
                    lib
                )
                .authors(BookEnums.Authors.valueOf(author))
                .language(BookEnums.Language.English)
                .build();
                break;
            default:
                book = new BiographyBook.Builder(
                    BookEnums.BookType.BIOGRAPHY, 
                    title, 
                    lib
                )
                .authors(BookEnums.Authors.valueOf(author))
                .language(BookEnums.Language.English)
                .build();
                break;
        }


        return book;
    }

    public static List<Member> generateMembers(int size) {
        List<Member> memList  = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            memList.add(generateMember());
        }
        return memList;
    }

    public static Member generateMember(){
        return new Member(RandomNameGenerator.generateRandomName());
    }

    public static String generateId() {
        return IdGenerator.generateRandomId(4);
    }
}

class RandomNameGenerator {
    private static final String[] FIRST_NAMES = {"James", "Mary", "John", "Patricia", "Robert", "Jennifer"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia"};

    public static String generateRandomName() {
        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }
}
class BookTitleGenerator {
    private static final String[] ADJECTIVES = {"Dark", "Mysterious", "Secret", "Lost", "Hidden", "Forgotten"};
    private static final String[] NOUNS = {"Kingdom", "Forest", "Promise", "Legacy", "Theory", "Code"};
    private static final String[] PREPOSITIONS = {"of", "in", "and the", "with the", "without a"};

    public static String generateTitle() {
        Random random = new Random();
        return ADJECTIVES[random.nextInt(ADJECTIVES.length)] + " " +
               NOUNS[random.nextInt(NOUNS.length)] + " " +
               PREPOSITIONS[random.nextInt(PREPOSITIONS.length)] + " " +
               NOUNS[random.nextInt(NOUNS.length)];
    }
}

class IdGenerator {
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random random = new Random();

    public static String generateRandomId(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));
        }
        return sb.toString();
    }
}