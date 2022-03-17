package ru.spbu.arts.java.oop.lists;

import java.util.ArrayList;
import java.util.List;

public class ListsFilters {
    public static void main(String[] args) {
        List<Integer> ints = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);
        System.out.println("ints = " + ints);
        System.out.println("ints no even indices = " + filterEvenIndices(ints));
        System.out.println("ints without even = " + filterEven(ints));
        System.out.println(" ============= mutable lists =================== ");
        List<Integer> mutableInts = new ArrayList<>(ints);
        mutableFilterEvenIndices(mutableInts);
        System.out.println("ints no even indices = " + mutableInts);
        mutableInts = new ArrayList<>(ints);
        mutableFilterEven(mutableInts);
        System.out.println("ints without even = " + mutableInts);
    }

    static List<Integer> filterEvenIndices(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        nums.forEach(Integer -> {
            if (nums.indexOf(Integer) % 2 != 0) {
                result.add(Integer);
            }
        });
        return result;
    }

    static List<Integer> filterEven(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        nums.forEach(Integer -> {
            if (Integer % 2 != 0) {
                result.add(Integer);
            }
        });
        return result;
    }

    static void mutableFilterEvenIndices(List<Integer> nums) {
        int size = nums.size();
        for (int i = 1; i < size; i = i + 2) {
            nums.add(nums.get(i));
        }
        if (size > 0) {
            nums.subList(0, size).clear();
        }
    }

    static void mutableFilterEven(List<Integer> nums) {
        int size = nums.size();
        for (int i = 0; i != size; ++i) {
            if (nums.get(i) % 2 != 0) {
                nums.add(nums.get(i));
            }
        }
        if (size > 0) {
            nums.subList(0, size).clear();
        }
    }
}
