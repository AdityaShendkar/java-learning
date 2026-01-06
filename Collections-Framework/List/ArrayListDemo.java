
import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(110);
        list.add(120);
//        System.out.println(list);

        list.add(2,115);
        System.out.println(list);

        List<Integer> newList = new ArrayList<>();
        newList.add(500);
        newList.add(5000);

        list.addAll(newList);
        System.out.println(list);

        System.out.println(list.get(4));

    }
}
