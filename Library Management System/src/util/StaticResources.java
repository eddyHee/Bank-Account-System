package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Book;
import model.Member;
import service.Library;

public class StaticResources {

    private StaticResources() {
    }

    public static Library generateLibrary() {
        return new Library("Super fancy library", "Earth");
    }

    public static Book generateBook() {
        return null;
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