import java.math.BigInteger;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by xkc on 9/3/16.
 */
public class Main {
    static String str = new String("good");
    static char[] ch = {'a', 'b', 'c'};
    Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
//        StringBuilder a = new StringBuilder("A");
//        StringBuilder b = new StringBuilder("B");
//        get(a,b);
//        System.out.println(a+" "+b);

//        new Derived();
//
//        Set<Set<Integer>> subSets = new HashSet<>();


//        test();
//        System.out.print("main");

//        Main.change(Main.str,Main.ch);
//        System.out.print(Main.str+"and");
//        System.out.print(Main.ch);

//        System.out.println(foo(3, 5));

//        int[] a = new int[]{4,9, 2, 8,1, 3,2};
//        qsort(a,0,6);
//        for (int x : a){
//            System.out.println(x);
//        }

//        ArrayList<String> list = new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("hel");
//        list.add("hello");
//        list.add("wor");
//        list.add("helo");
//        list.add("world");
//        delDuplication(list);
//        for (String s : list){
//            System.out.println(s);
//        }
//
//        HashSet<Integer> set = new HashSet<>();
//        set.add(1);

//      System.out.print(fun(100));



    }

    private static int fun(int n){
        int[] a = new int[n];
        int count  = 0;
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < n; i ++){
            a[i] = a[i-1] + a[i-2];
            if (a[i] % 7 == 0){
                count ++;
            }
        }
        return count;
    }

    private static void  delDuplication(ArrayList<String> list){
       for (int i = 0; i < list.size(); i ++){
           for (int j = i + 1; j < list.size(); j ++){
               if (list.get(j).equals(list.get(i))){
                   list.remove(j);
               }
           }
       }
    }

    private static void qsort(int[] a, int left, int right) {
        if (left < right) {
            int key = a[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high && a[high] >= key) {
                    high--;
                }

                a[low] = a[high];

                while (low < high && a[low] <= key) {
                    low++;
                }

                a[high] = a[low];
            }

            a[low] = key;
            qsort(a,left,low-1);
            qsort(a,low + 1, right);
        }
    }


    public static int foo(int x, int y) {
        if (x <= 0 || y <= 0) {
            return 1;
        }
        return 3 * foo(x - 1, y / 2);
    }

    public static void change(String str, char[] ch) {
        str = "test OK";
        ch[0] = 'g';
    }


    public static void test() {
        try {
            int i = 5 / 0;
            System.out.println("try");
            return;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }


    public static void get(StringBuilder a, StringBuilder b) {
        a.append(b);
        b = a;
    }


    static class Base {
        private String name = "Base";

        public Base() {
            tell();
            print();
        }

        public void tell() {
            System.out.println("tell my name:" + name);
        }

        public void print() {
            System.out.println("print my name:" + name);
        }
    }

    static class Derived extends Base {
        private String name = "Derived";

        public Derived() {
            tell();
            print();
        }

        public void tell() {
            System.out.println("tell name:" + name);
        }

        public void print() {
            System.out.println("print  name:" + name);
        }

    }



}
