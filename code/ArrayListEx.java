package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ArrayListEx {
    public static void main(String[] args) {
//        exOne();
//        exTwo();
        exThree();
    }

    public static void exOne() {
        ArrayList list = new ArrayList(10);
        list.add(5); // list.add(Integer.valueOf(5));와 동일, "오토박싱"
        list.add(4);
        list.add(2);
        list.add(0);
        list.add(1);
        list.add(3);

        ArrayList list2 = new ArrayList(list.subList(1, 4)); // 4, 2, 0
        System.out.println(list + ", " + list2);

        Collections.sort(list);
        Collections.sort(list2);
        System.out.println(list + ", " + list2);

        System.out.println(list.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(3, "A");
        System.out.println(list + ", " + list2);

        list2.set(3, "AA");
        System.out.println(list + ", " + list2);

        for (int i = list2.size() - 1; i >= 0; i--) {
            if (list.contains(list2.get(i))) {
                list2.remove(i);
            }
        }
        System.out.println(list + ", " + list2);
    }

    public static void exTwo() {
        final int LIMIT = 10;
        String source = "0123456789abcdefghijABCDEFGHIJ!@$$%^&*()ZZZ";
        int length = source.length();

        List list = new ArrayList((length / LIMIT) + 10);

        for (int i = 0; i < length; i++) {
            if (i + LIMIT < length) {
                list.add(source.substring(i, i + LIMIT));
                continue;
            }

            list.add(source.substring(i));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }

    public static void exThree() {
        Vector v = new Vector(5);
        v.add("1");
        v.add("2");
        v.add("3");
        System.out.println(v);
        System.out.println(v.size() + ", " + v.capacity()); // 3 5

        v.trimToSize();
        System.out.println(v);
        System.out.println(v.size() + ", " + v.capacity()); // 3 3

        v.ensureCapacity(6);
        System.out.println(v);
        System.out.println(v.size() + ", " + v.capacity()); // 3 6

        v.setSize(7);
        System.out.println(v);
        System.out.println(v.size() + ", " + v.capacity()); // 7 12

        v.clear();
        System.out.println(v);
        System.out.println(v.size() + ", " + v.capacity()); // 0 12
    }
}
