package ru.spbu.arts.java.oop.lists;


import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        System.out.println(count(10));
        List<String> test = List.of("abc", "xyz", "ooo");
        printList(test);
        printListWithIndices(test);
        List<String> list3 = List.of("aaa", "bbb", "ccc");
        List<String> list4 = List.of("xxx", "yyy", "zzz");
        List<String> list3plusList4 = concatenateLists(list3, list4);
        System.out.println(list3plusList4);
        List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
        List<String> list5rev = reverseList(list5);
        System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);
        reverseListInPlace(list5);
        System.out.println("list5 = " + list5);
    }

    static List<Integer> count(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i != n; ++i) {
            nums.add(i);
        }
        return nums;
    }

    static void printList(List<String> l) {
        System.out.println("Элементов в списке " + l.size());
        l.forEach(System.out::println); //совет Idea
        //l.forEach(String -> System.out.println(String)) - мой вариант
    }

    static void printListWithIndices(List<String> l) {
        System.out.println("Элементов в списке " + l.size());
        l.forEach(String -> System.out.println((l.indexOf(String) + 1) + ": " + String));
    }

    static List<String> concatenateLists(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>();
        result.addAll(a);
        result.addAll(b);
        return result;
    }

    static List<String> reverseList(List<String> list) {
        List<String> result = new ArrayList<>();
        for (int i = list.size() - 1; i != -1; i = i - 1) {
            result.add(list.get(i));
        }
        return result;
    }

    static void reverseListInPlace(List<String> list) {
        int size = list.size();
        for (int i = size - 1; i != -1; i = i - 1) {
            list.add(list.get(i));
        }
        if (size > 0) {
            list.subList(0, size).clear();
        } // - вариант предложенный IDEA
        //for (int i = 0; i != size; ++i) {
            //list.remove(0);
        //} - мой вариант
    }


}
