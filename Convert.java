
import java.util.Optional;

public class Convert {

    // prevent initialize
    private Convert() {
    }

    public static Optional<Integer> convertStringToInt(String str) {
        try {
            return Optional.of(Integer.valueOf(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
