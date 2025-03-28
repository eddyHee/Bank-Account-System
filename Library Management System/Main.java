
import java.time.LocalDateTime;
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
                    new FictionBook.Builder(BookEnums.BookType.FICTION, "fiction book " + i)
                            .authors(BookEnums.Authors.JamesBob)
                            .language(BookEnums.Language.Chinese)
                            .publishTime(LocalDateTime.of(2000, 12, 25, 15, 30))
                            .build()
            );
            booklist.add(
                    new BiographyBook.Builder(BookEnums.BookType.BIOGRAPHY, "Bio book" + i)
                            .authors(BookEnums.Authors.JhonBob)
                            .language(BookEnums.Language.English)
                            .publishTime(LocalDateTime.of(2021, 12, 1, 11, 00))
                            .build()
            );
        }

        System.out.println("The books are: \n" + booklist);

    }
}
