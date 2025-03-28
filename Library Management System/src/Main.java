
import java.util.ArrayList;
import java.util.List;
import model.Member;
import service.Library;
import util.StaticResources;

class Main {

    /**
     * Features: 1. check out/return books, 2. track due dates Classes: Book,
     * Library, Member
     */
    public static void main(String[] args) {

        List<Library> library = new ArrayList<>();
        List<Member> member = new ArrayList<>();


        library.add(StaticResources.generateLibrary());

        System.out.println("Here are the library:\n\t");
        System.out.println(library);

        member.addAll(StaticResources.generateMembers(5));
        System.out.println("\nHere are the Members:\n\t");
        System.out.println(member);

        // List<Book> booklist = new ArrayList<>();
        // for (int i = 0; i < 3; i++) {
        //     booklist.add(
        //             new FictionBook.Builder(BookEnums.BookType.FICTION, "fiction book " + i)
        //                     .authors(BookEnums.Authors.JamesBob)
        //                     .language(BookEnums.Language.Chinese)
        //                     .publishTime(LocalDateTime.of(2000, 12, 25, 15, 30))
        //                     .build()
        //     );
        //     booklist.add(
        //             new BiographyBook.Builder(BookEnums.BookType.BIOGRAPHY, "Bio book" + i)
        //                     .authors(BookEnums.Authors.JhonBob)
        //                     .language(BookEnums.Language.English)
        //                     .publishTime(LocalDateTime.of(2021, 12, 1, 11, 00))
        //                     .build()
        //     );
        // }

        // System.out.println("The books are: \n" + booklist);

    }
}
