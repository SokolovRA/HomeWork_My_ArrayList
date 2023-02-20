import list.IntegerListImpl;
import list.StringListImpl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


public class Main {
    public static int[] generateRandom() {
        Random random = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1) + 100_000;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = generateRandom();
        int[] bubble = Arrays.copyOf(arr1,100000);
        int[] selection = Arrays.copyOf(bubble,100000);
        int[] insertion = Arrays.copyOf(selection,100000);
        long start = System.currentTimeMillis();
//        sortBubble(bubble);         // 1976
//        sortSelection(selection);   // 1717
//        sortInsertion(insertion);   // 1905
//        System.out.println(System.currentTimeMillis() - start);
        IntegerListImpl integerList = new IntegerListImpl<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(19);
        integerList.add(19);
        integerList.add(19);
        integerList.add(19);
        integerList.add(19);
        integerList.add(19);
        System.out.println(integerList.contains(18));




//        StringListImpl stringList = new StringListImpl(5);
//        stringList.add("1");
//        stringList.add("2");
//        stringList.add("3");
//        stringList.add("4");
//        stringList.add("5");
//        stringList.add("6");
//        stringList.add("7");

//        stringList.add(2,"5");
//        stringList.set(1,"7");
//        stringList.remove("8");
//        stringList.remove(2);
//        stringList.indexOf("2");
//        System.out.println(stringList.contains("2"));
//        System.out.println(stringList.indexOf("1"));
//        System.out.println(stringList.lastIndexOf("3"));
//        System.out.println(stringList.get(2));
//        stringList.clear();
//        stringList.toArray();
//        System.out.println(stringList.contains("9"));

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(2);
//        System.out.println(stringList.equals(list));
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}