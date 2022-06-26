package binary;

public class binaryTest {

    public static int binary(int[] arr, int val) {
        int resultIndex = 0;
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == val) {
                if (mid + 1 > arr.length) {
                    resultIndex = mid;
                    break;
                }
                while (arr[mid + 1] == val) {
                    mid++;
                }
                resultIndex = mid + 1;
                break;
            } else if (arr[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return resultIndex;
    }

    public static void main(String[] args) {
        int[] arr = {12, 23, 44, 46, 47, 55, 55, 55, 556, 600, 666, 790};
        final int i = binary2(arr, 55);
        final int j = binary(arr, 600);
        System.out.println(i);
        System.out.println(j);
    }


    public static int binary2(int[] arr, int val) {
        int resultIndex = 0;
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == val) {
                if (mid - 1 <= 0) {
                    resultIndex = mid;
                    break;
                }
                while (arr[mid - 1] == val) {
                    mid--;
                }
                resultIndex = mid;
                break;
            } else if (arr[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return resultIndex;
    }
}
