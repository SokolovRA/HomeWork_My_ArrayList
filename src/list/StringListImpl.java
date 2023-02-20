package list;
import java.util.Arrays;
public class StringListImpl implements MyList<String> {

    private String[] arr;
    private int size;


    public StringListImpl(int size) {
        if (size > 0) {
            this.arr = new String[size];
        } else if (size == 0) {
            this.arr = new String[10];
        } else {
            throw new IllegalArgumentException("Illegal" +size);
        }
    }
    private  void Examination(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " - несуществующий индекс");
        }
    }
    @Override
    public String add(String item) {
        grow();
        arr[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        Examination(index);
        grow();
        String[] newArr = Arrays.copyOf(arr, size);
        System.arraycopy(newArr, 0, arr, 0, index);
        arr[index] = item;
        System.arraycopy(newArr, index, arr, index + 1, newArr.length - index);
        size++;
        return item;
    }
    private void grow() {
        if (arr[arr.length - 1] != null) {
            arr = Arrays.copyOf(arr, arr.length * 3 / 2);
        }
    }

    @Override
    public String set(int index, String item) {
        Examination(index);
        arr[index] = item;
        return item;
    }


    @Override
    public String remove(String item) {
        if(!contains(item)){
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
    public String remove(int index) {
        Examination(index);
        System.arraycopy(arr,index+1,arr,index,arr.length-index-1);
        return null;
    }

    @Override
    public boolean contains(String item) {
        for (String string : arr) {
            if (string != null && string.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != null && arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String get(int index) {
        Examination(index);
        return arr[index];
    }

    @Override
    public boolean equals(MyList otherList) {
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
    public String[] toArray() {
        String[] result = new String[size];
        System.arraycopy(arr, 0, result, 0, size);
        return result;
    }

    @Override
    public String toString() {
        return "StringListImpl : " +
                " arr= " + Arrays.toString(arr) +
                " size= " + size+ ";";
    }
}