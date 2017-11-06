package sort;

/**
 * 堆排序：完全二叉树的结构
 * 以大顶堆为例，使用数组存储
 * 大根堆排序算法的基本操作：
 * <p>
 * ① 初始化操作：将R[1..n]构造为初始堆；
 * <p>
 * ② 每一趟排序的基本操作：将当前无序区的堆顶记录R[1]和该区间的最后一个记录交换，然后将新的无序区调整为堆(亦称重建堆)。
 * <p>
 * 注意：
 * <p>
 * ①只需做n-1趟排序，选出较大的n-1个关键字即可以使得文件递增有序。
 * <p>
 * ②用小根堆排序与利用大根堆类似，只不过其排序结果是递减有序的。
 * 堆排序和直接选择排序相反：在任何时刻堆排序中无序区总是在有序区之前，且有序区是在原向量的尾部由后往前逐步扩大至整个向量为止。
 * Created by xkc on 9/14/16.
 */
public class HeapSortTest {
    public static void main(String[] args){
        int[] data = {10,15,56,25,30,70};
        print(data);
        heapSort(data);
        System.out.println("排序后的数组是：");
        print(data);
    }

    /**
     * 堆排序
     *
     * @param data
     */
    public static void heapSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            createMaxHeap(data, data.length - 1 - i);
            swap(data, 0, data.length - 1 - i);
            print(data);
        }
    }

    public static void createMaxHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //保存当前正在判断的节点
            int k = i;
            //若当前节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                //biggerIndex总是记录较大节点的值，先赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                //如果当前节点有右子节点
                if (biggerIndex < lastIndex) {
                    //如果右子节点的值比左子节点值大，则biggerIndex记录右子节点
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        biggerIndex++;
                    }

                }

                if (data[k] < data[biggerIndex]) {
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }


    /**
     * 交换两个数组元素
     * 不占用任何额外空间
     *
     * @param data
     * @param i
     * @param j
     */
    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }

        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    public static void print(int[] data){
        for (int i = 0; i < data.length; i ++){
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
