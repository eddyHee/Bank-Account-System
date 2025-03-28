
class GenericMethodDemo {

    static <T extends Comparable<T>, V extends T> boolean arraysEqual(T[] x, V[] y) {
        if (x.length != y.length) {
            return false;
        }

        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i])) {
                return false;
            }
        }

        return true;
    }
}
