import list.StringListImpl;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl(5);
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
//        stringList.add("6");
//        stringList.add("7");
//        stringList.add("8");
//        stringList.add("9");
//        stringList.add("10");
//        stringList.add("11");


        stringList.add(2,"5");
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
        System.out.println(stringList);
//
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(2);
//        System.out.println(stringList.equals(list));
    }
}