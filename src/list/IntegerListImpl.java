package list;

import java.util.Arrays;

public class IntegerListImpl<G> implements MyList<Integer> {
    private Integer[] arr;
    private Integer size;
    private static final int CAPACITY = 10;

    public IntegerListImpl() {
        this.arr = new Integer[CAPACITY];
        this.size = 0;
    }

    public IntegerListImpl(int capacity) {
        this.arr = new Integer[capacity];
        this.size = 0;
    }

    private void Examination(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " - несуществующий индекс");
        }
    }
    private void grow() {
        if (arr[arr.length - 1] != null) {
            arr = Arrays.copyOf(arr, arr.length * 3 / 2);
        }
    }
    @Override
    public Integer add(Integer item) {
        grow();
        arr[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        Examination(index);
        grow();
        Integer[] newArr = Arrays.copyOf(arr, size);
        System.arraycopy(newArr, 0, arr, 0, index);
        arr[index] = item;
        System.arraycopy(newArr, index, arr, index + 1, newArr.length - index);
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        Examination(index);
        arr[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        if (!contains(item)) {
            throw new IllegalArgumentException("Нет такой строки");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(item)) {
                System.arraycopy(arr, i + 1, arr, i, arr.length - i - 1);
                size--;
            }
        }
        return item;
    }

    @Override
    public Integer remove(int index) {
        Examination(index);
        System.arraycopy(arr,index+1,arr,index,arr.length-index-1);
        return null;
    }

    @Override
    public boolean contains(Integer item) {
        return binaryContains(item);
    }
    private boolean binaryContains(int item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != null && arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        Examination(index);
        return arr[index];
    }


    @Override
    public boolean equals(MyList<Integer> otherList) {
        if (otherList == null) {
            throw new NullPointerException() ;
        }
        if (this.size() != otherList.size())
            return false;

        for (int i = 0; i < size(); i++) {
            if (!this.get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size=0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[size];
        System.arraycopy(arr, 0, result, 0, size);
        return result;
    }

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    private  void sortSelection(int[] arr) {
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
}