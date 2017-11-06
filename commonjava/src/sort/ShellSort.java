package sort;

import java.util.HashMap;

/**
 * 希尔(Shell)排序又称为缩小增量排序，它是一种插入排序。它是直接插入排序算法的一种威力加强版。
 * <p>
 * 该方法因DL．Shell于1959年提出而得名。
 * <p>
 * 希尔排序的基本思想是：
 * <p>
 * 把记录按步长 gap 分组，对每组记录采用直接插入排序方法进行排序。
 * 随着步长逐渐减小，所分成的组包含的记录越来越多，当步长的值减小到 1 时，整个数据合成为一组，构成一组有序记录，则完成排序。
 * Created by xkc on 9/18/16.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] data = {13, 27, 49, 55, 4, 49, 38, 65, 97, 26};
        shellSort3(data);
        print(data);


    }

    /**
     * 严格按照定义来写的希尔排序
     *
     * @param data
     */
    public static void shellSort1(int[] data) {
        int n = data.length;
        int i, j, gap;
        for (gap = n / 2; gap > 0; gap /= 2) {//增量
            for (i = 0; i < gap; i++) {//直接插入排序
                for (j = i + gap; j < n; j++) {
                    if (data[j] < data[j - gap]) {
                        int temp = data[j];
                        int k = j - gap;
                        while (k >= 0 && temp < data[k]) {
                            data[k + gap] = data[k];
                            k -= gap;
                        }
                        data[k + gap] = temp;
                    }

                }
            }
        }
    }

    /**
     * 改进版
     *
     * @param data
     */
    public static void shellSort2(int[] data) {
        int n = data.length;
        int j, gap;
        for (gap = n / 2; gap > 0; gap /= 2) {
            for (j = gap; j < n; j++) {//从数组第gap个元素开始
                if (data[j] < data[j - gap]) {//每个元素与自己组内的数据进行直接插入排序
                    int temp = data[j];
                    int k = j - gap;
                    while (k >= 0 && temp < data[k]) {
                        data[k + gap] = data[k];
                        k -= gap;
                    }

                    data[k + gap] = temp;

                }

            }
        }

    }

    /**
     * 升级版
     *
     * @param data
     */
    public static void shellSort3(int[] data) {
        int n = data.length;
        int i, j, gap;
        for (gap = n / 2; gap > 0; gap /= 2) {
            for (i = gap; i < n; i++) {
                for (j = i - gap; j >= 0 && data[j] > data[j + gap]; j -= gap) {
                    swap(data, j, j + gap);
                }
            }
        }

    }

    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    public static void print(int[] data) {
        for (int aData : data) {
            System.out.print(aData + "\t");
        }
        System.out.println();
    }
}
