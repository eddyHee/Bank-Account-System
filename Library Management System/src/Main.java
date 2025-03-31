
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Book;
import model.LibraryItem;
import model.Member;
import service.Library;
import util.StaticResources;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Features: 1. check out/return books, 2. track due dates Classes: Book,
     * Library, Member
     */
    public static void main(String[] args) {
        List<Library> libraries = new ArrayList<>();
        List<Member> members = new ArrayList<>();
        generateResources(members, libraries);

        showInformation(libraries, members);

        while(true) {
            printMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch(choice) {
                case 1:
                    clearScreen();
                    showInformation(libraries, members);
                    break;
                case 2:
                    registerNewMember(members);
                    break;
                case 3:
                    rentBook(libraries, members);
                    break;
                case 4:
                    returnBook(libraries, members);
                    break;
                case 5:
                    addNewBook(libraries);
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void generateResources(List<Member> member, List<Library> libraries) {
        
        member.addAll(StaticResources.generateMembers(5));
        libraries.add(StaticResources.generateLibrary());
        for(int i = 0; i < libraries.size(); i++) {
            Library lib = libraries.get(i);
            lib.addBooks(StaticResources.generateBooks(3, lib));
        }

    }
    
    private static void showInformation(List<Library> libraries, List<Member> members) {
        // Print library information
        System.out.println("\n=== LIBRARIES ===");
        if (libraries.isEmpty()) {
            System.out.println("No libraries available");
        } else {
            for (Library library : libraries) {
                System.out.printf("\nLibrary: %s\n", library.getName());
                System.out.println("Books available:");
                
                // Get books and check if empty
                List<Book> books = library.getBooks();
                if (books.isEmpty()) {
                    System.out.println("  - No books in this library");
                } else {
                    for (Book book : books) {
                        System.out.printf("  - %s by %s (%s)\n", 
                            book.getTitle(), 
                            book.getAuthor(), 
                            book.getPublicationYear());
                    }
                }
            }
        }
    
        // Print member information
        System.out.println("\n=== MEMBERS ===");
        if (members.isEmpty()) {
            System.out.println("No members registered");
        } else {
            System.out.printf("%-20s %-15s %-10s\n", "Name", "Member ID", "Borrowed Books");
            System.out.println("------------------------------------------------");
            for (Member member : members) {
                System.out.printf("%-20s %-15s %-10d\n", 
                    member.getName(), 
                    member.getMemberId(), 
                    member.getBorrowedBooks().size());
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n===== Library System Menu =====");
        System.out.println("1. View all libraries and members");
        System.out.println("2. Register new member");
        System.out.println("3. Rent a book");
        System.out.println("4. Return a book");
        System.out.println("5. Add new book to library");
        System.out.println("6. Exit");
        System.out.println("==============================");
    }

    private static void registerNewMember(List<Member> members) {
        System.out.println("\n--- Register New Member ---");
        String name = getStringInput("Enter member name: ");
        // String email = getStringInput("Enter member email: ");
        
        // Generate member ID
        // String memberId = "MEM-" + (members.size() + 1000);
        Member newMember = new Member(name);
        members.add(newMember);
        
        System.out.println("Successfully registered: " + newMember);
    }

    private static void rentBook(List<Library> libraries, List<Member> members) {
        System.out.println("\n--- Rent a Book ---");
        
        // Show available members
        System.out.println("Available Members:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i+1) + ". " + members.get(i).getName() + " (" + members.get(i).getMemberId() + ")");
        }
        int memberIndex = getIntInput("Select member: ") - 1;
        
        // Show available libraries
        System.out.println("Available Libraries:");
        for (int i = 0; i < libraries.size(); i++) {
            System.out.println((i+1) + ". " + libraries.get(i).getName());
        }
        int libraryIndex = getIntInput("Select library: ") - 1;
        
        // Show available books in selected library
        Library selectedLibrary = libraries.get(libraryIndex);
        List<LibraryItem> availableBooks = selectedLibrary.getAvailableBooks();
        
        if (availableBooks.isEmpty()) {
            System.out.println("No available books in this library.");
            return;
        }
        
        System.out.println("Available Books:");
        for (int i = 0; i < availableBooks.size(); i++) {
            System.out.println((i+1) + ". " + ((Book)availableBooks.get(i)).getTitle());
        }
        int bookIndex = getIntInput("Select book to rent: ") - 1;
        
        // Rent the book
        Member member = members.get(memberIndex);
        Book book = (Book) availableBooks.get(bookIndex);
        
        if (member.borrowBook(book, selectedLibrary)) {
            System.out.println("Successfully rented '" + book.getTitle() + "' to " + member.getName());
        } else {
            System.out.println("Failed to rent book. Member may have reached borrowing limit.");
        }
    }

    private static void returnBook(List<Library> libraries, List<Member> members) {
        System.out.println("\n--- Return a Book ---");
        
        // Implementation would be similar to rentBook but for returning
        // You would:
        // 1. Select member
        // 2. Show their borrowed books
        // 3. Select book to return
        // 4. Call member.returnBook(book)
        System.out.println("\n--- Rent a Book ---");
        
        // Show available members
        System.out.println("Available Members:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i+1) + ". " + members.get(i).getName() + " (" + members.get(i).getMemberId() + ")");
        }
        int memberIndex = getIntInput("Select member: ") - 1;
        
        // Show borrowed books of selected member
        Member selectedMember = members.get(memberIndex);
        List<Book> borrowedBooks = selectedMember.getBorrowedBooks();
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books for this member.");
            return;
        }
        System.out.println("Borrowed Books:");
        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println((i+1) + ". " + borrowedBooks.get(i).getTitle());
        }
        int bookIndex = getIntInput("Select book to return: ") - 1;
        // Return the book
        Book bookToReturn = borrowedBooks.get(bookIndex);
        if (selectedMember.returnBook(bookToReturn)) {
            System.out.println("Successfully returned '" + bookToReturn.getTitle() + "' from " + selectedMember.getName());
        } else {
            System.out.println("Failed to return book.");
        }
    }

    private static void addNewBook(List<Library> libraries) {
        System.out.println("\n--- Add New Book ---");
        
        // Show libraries
        for (int i = 0; i < libraries.size(); i++) {
            System.out.println((i+1) + ". " + libraries.get(i).getName());
        }
        int libraryIndex = getIntInput("Select library to add book to: ") - 1;
        
        // Get book details
        String title = getStringInput("Enter book title: ");
        String author = getStringInput("Enter author: ");
        // String isbn = getStringInput("Enter ISBN: ");
        int year = getIntInput("Enter publication year: ");
        String bookType = getStringInput("Enter book type({0}, {1}): ".formatted(
                enums.BookEnums.BookType.BIOGRAPHY.name(), 
                enums.BookEnums.BookType.FICTION.name()
            ));
        
        // Create and add book
        // Book newBook = new Book(title, author, isbn, year);
        Book newBook = StaticResources.generateBook(bookType, title, author, year, libraries.get(libraryIndex));
        libraries.get(libraryIndex).addBook(newBook);
        
        System.out.println("Successfully added '" + title + "' to library.");
    }

    // Helper methods for input
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
