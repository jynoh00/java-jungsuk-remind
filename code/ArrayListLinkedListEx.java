package ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListEx {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(2_000_000);
        LinkedList<Integer> ll = new LinkedList<>();

        System.out.println("-- 순차적 추가 --");
        System.out.println("ArrayList: " + add1(al));
        System.out.println("LinkedList: " + add1(ll));

        System.out.println();

        System.out.println("-- 중간 삽입 --");
        System.out.println("ArrayList: " + add2(al));
        System.out.println("LinkedList: " + add2(ll));

        System.out.println();

//        System.out.println("-- 순차적 삭제 --");
//        System.out.println("ArrayList: " + remove1(al));
//        System.out.println("LinkedList: " + remove1(ll));
//
//        System.out.println();

        System.out.println("-- 중간 삭제 --");
        System.out.println("ArrayList: " + remove2(al));
        System.out.println("LinkedList: " + remove2(ll));
    }

    private static long add1(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long add2(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            list.add(500, 1);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long remove1(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = list.size() - 1; i >= 0; i--) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long remove2(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
