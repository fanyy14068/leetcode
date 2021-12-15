package com.fanyy.base.sort;

import java.util.*;

/**
 * @author fanyuanyuan
 * @data 12/13/21
 */

public class SortDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{1,6,3,8,33,27,66,9,7,88};
//        bubbleDemo(nums);
//        insertSort(nums);
//        shellSort(nums);
//        heapSort(nums);
//        nums = mergeSort(nums, 0, nums.length - 1);
//        quickSort(nums, 1, nums.length-1);

        nums = bucketSort(nums);
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 冒泡排序：O(N**2), 稳定
     */
    public static void bubbleDemo(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            for(int j=0;j<nums.length-1;j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }



    /**
     * 选择排序：每次选择出最小的值放在左边
     * 复杂度O(N*N), 不稳定，在交换的时候可能会改变原有的次序，比如：(7) 2 5 9 3 4 [7] 1
     */
    public static void selectSort(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            int cur = i;
            for(int j=i+1;j<nums.length;j++) {
                if (nums[j] < nums[cur]) {
                    cur = j;
                }
            }
            if (cur != i) {
                int tmp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = tmp;
            }
        }
    }


    /**
     * 插入排序，认定前i个元素，对于第i个元素，按顺序插入
     * @param nums
     */
    public static void insertSort(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            int tmp = nums[i];
            int j = i;
            while(j > 0 && nums[j-1] > tmp) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = tmp;
        }
    }

    /**
     * 快速排序, 给定一个元素（通常是第０个，不断交换，使得交换之后，它左边的元素都小于它，右边的元素都大于它), 再递归即可
     * 每一轮的循环为：从右往左，找比cur小的值，交换，然后从左往右，找比cur大的值进行交换
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int low = left;
        int high = right;
        int cur = nums[left];
        while(low < high) {
            while (nums[high] >= cur && high > low) {
                high--;
            }
            nums[low] = nums[high];

            while(nums[low] <= cur && low < high) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = cur;
        quickSort(nums, left, low -1);
        quickSort(nums, high+1, right);
    }

    /**
     * 希尔排序
     * 思想：维护一个gap变量，(i, i+gap, i+gap*2) 先排序；然后缩小gap=gap/2, 相当于使得插入排序更快（尽可能使得插入时前面的序列有序)
     */
    public static void shellSort(int[] nums) {
        int n = nums.length;
        int gap = n / 2;
        int j;
        while(gap >= 1) {
            for(int i=gap;i<nums.length;i++) {
                int tmp = nums[i];
                for(j=i;j>=gap && nums[j-gap] > tmp;j-=gap) {
                    nums[j] = nums[j-gap];
                }
                nums[j] = tmp;
            }
            gap = gap / 2;
        }
    }


    /**
     * 归并排序　（将两个有序子序列合并即可)
     */
    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h)
            return new int[] { nums[l] };

        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid);
        int[] rightArr = mergeSort(nums, mid + 1, h);
        int[] newNum = new int[leftArr.length + rightArr.length];

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];
        return newNum;
    }

    /**
     * 堆排序: 构建最大堆（从最后一个非叶子节点开始调整），对于最大堆，依次把堆顶的元素和堆尾的元素进行交换
     */
    public static void heapSort(int[] nums) {
        int n = nums.length;
        for(int i=n/2-1;i>=0;i--) {
            adjustHeap(nums, i, n);
        }
        for(int i=nums.length-1;i>0;i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            adjustHeap(nums, 0, i);
        }

    }

    public static void adjustHeap(int[] arr, int parentIndex, int len) {
        // 向下调整
        int childIndex = parentIndex * 2 + 1;
        int tmp = arr[parentIndex];
        while(childIndex < len) {
            if (childIndex + 1 < len && arr[childIndex + 1] > arr[childIndex]) {
                childIndex += 1; // 到右节点
            }
            if (tmp >= arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        arr[parentIndex] = tmp;

    }

    /**
     * 桶排序：按照区间划分桶，桶内部可以使用其他排序方法
     * 桶排序的复杂度，时间：O(m+n), 稳定
     */
    public static int[] bucketSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for(int i=0;i<n;i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        double d = max - min;

        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(n);
        for(int i=0;i<n;i++) {
            bucketList.add(new LinkedList<Integer>());
        }

        for(int i=0;i<n;i++) {
            int id = (int) ((nums[i] - min) / d * (n-1));
            bucketList.get(id).add(nums[i]);
        }

        // 每个桶内部排序
        for(int i=0;i<n;i++) {
            Collections.sort(bucketList.get(i));
        }

        int[] arr = new int[n];
        int index = 0;
        for(LinkedList<Integer> list: bucketList) {
            for(Integer ele: list) {
                arr[index] = ele;
                index++;
            }
        }
        return arr;



    }
}
