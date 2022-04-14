package oldTasks;

import java.util.Arrays;

public class Binary_search {
    public static int binarySearch(int[] a, int value) {
        //ищем значение от индекса l до индекса r
        // -----------------------
        //      l      m      r
        //      --------
        int l = 0;
        int r = a.length - 1;
        if (a.length != 0) {
            if (a[l] == value) {
                return l;
            }
            if (a[r] == value) {
                return r;
            }
            while (l != r - 1) {
                int m = (l + r) / 2;
                if (a[m] > value) {
                    r = m;
                } else {
                    l = m;
                }
                if (a[m] == value) {
                    return m;
                }
                if (l == r) {
                    if (a[l] == value) {
                        return l;
                    } else {
                        break;
                    }
                }
            }
            //середина диапазона
            //проверить a[m] и понять, где искать дальше, слева или справа от m
        }
        return -1;
    }

    public static void test(int[] a, int value, int correctAnswer) {
        // Looking for 'value' in 'a'
        int actualAnswer = binarySearch(a, value);
        if (actualAnswer == correctAnswer)
            System.out.println("ok");
        else
            System.out.println(
                    "Got " + actualAnswer + " instead of " + correctAnswer
            );
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 10, 20, 100};
        System.out.println(Arrays.toString(a));
        test(a, 5, 2);
        test(a, 1, 0);
        test(a, 100, 5);
        test(a, 42, -1);
        test(a, 120, -1);
        test(a, 0, -1);

        int[] b = {1, 4, 6, 65, 100};
        System.out.println(Arrays.toString(b));
        test(b, 0, -1);
        test(b, 1, 0);
        test(b, 2, -1);
        test(b, 4, 1);
        test(b, 5, -1);
        test(b, 6, 2);
        test(b, 10, -1);
        test(b, 65, 3);
        test(b, 70, -1);
        test(b, 100, 4);
        test(b, 200, -1);

        int[] c = {1, 4, 6, 65, 100, 110};
        System.out.println(Arrays.toString(c));
        test(c, 0, -1);
        test(c, 1, 0);
        test(c, 2, -1);
        test(c, 4, 1);
        test(c, 5, -1);
        test(c, 6, 2);
        test(c, 10, -1);
        test(c, 65, 3);
        test(c, 70, -1);
        test(c, 100, 4);
        test(c, 105, -1);
        test(c, 110, 5);
        test(c, 200, -1);

        System.out.println("{42}");
        test(new int[]{}, 42, -1);
        test(new int[]{42}, 0, -1);
        test(new int[]{42}, 42, 0);
        test(new int[]{42}, 100, -1);

        System.out.println("{10, 20}");
        test(new int[]{10, 20}, 0, -1);
        test(new int[]{10, 20}, 10, 0);
        test(new int[]{10, 20}, 15, -1);
        test(new int[]{10, 20}, 20, 1);
        test(new int[]{10, 20}, 25, -1);
    }
}
//-------------
//private static int binarySearch(int[] x, int n) {
//for (int i = 0; i != x.length - 1; ++i) {
//for (int j = i; j != x.length; ++j) {
// if (x[i] >= x[j]) {
// int k = x[i];
// x[i] = x[j];
// x[j] = k;
//   }
//  }
// }
// System.out.println(Arrays.toString(x));
// int i = x.length / 2;
// int beginning = x[0];
//  int ending = x[x.length - 1];
// while (x[i] != n) {
//  if (i == 0) {
//  break;
// }
// if (i == x.length - 1) {
// break;
// }
//if (x[i] > n) {
//  ending = i;
//  i = (i - beginning) / 2;
//  } else {
//    beginning = i;
//   i = (ending + i) / 2;
//  }
// }
//  return i + 1;
// }