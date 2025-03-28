
class Main {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        Integer[] nums2 = {1, 2, 3, 4, 5};
        Integer[] nums3 = {1, 2, 7, 4, 5};
        Integer[] nums4 = {1, 2, 7, 4, 5, 6};

        if (GenericMethodDemo.arraysEqual(nums, nums)) {
            System.out.println("nums equals nums");
        }

        if (GenericMethodDemo.arraysEqual(nums, nums2)) {
            System.out.println("nums equals nums2");
        }

        Double[] dvals = {1.1, 2.2, 3.3, 4.4};
        // if(GenericMethodDemo.arraysEqual(nums, dvals)) {
        //     System.out.println("nums equals dvals");
        // }

    }
}
