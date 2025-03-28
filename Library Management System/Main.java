
import java.util.ArrayList;
import java.util.List;

class Main {

    /**
     * Features: 1. check out/return books, 2. track due dates Classes: Book,
     * Library, Member
     */
    public static void main(String[] args) {

        List<Book> booklist = new ArrayList();
        for (int i = 0; i < 3; i++) {
            booklist.add(
                    new FictionBook.Builder("fiction book " + i)
                            .authors(BookEnums.Authors.JamesBob)
                            .language(BookEnums.Language.Chinese)
                            .build()
            );
        }

        System.out.println("The books are: " + booklist);

    }
}
