package DivideAndConquer;import java.util.*;public class SelectionSortAss {    public static int findKthLargest(int[] nums, int k) {        if (k > 0 && k <= nums.length) {            return quickSelect(nums, 0, nums.length - 1, nums.length - k);        }        return -1; // Invalid input    }    private static int quickSelect(int[] nums, int left, int right, int k) {        if (left == right) {            return nums[left];        }        int pivotIndex = partition(nums, left, right);        if (k == pivotIndex) {            return nums[k];        } else if (k < pivotIndex) {            return quickSelect(nums, left, pivotIndex - 1, k);        } else {            return quickSelect(nums, pivotIndex + 1, right, k);        }    }    private static int partition(int[] nums, int left, int right) {        int randomPivotIndex = left + new Random().nextInt(right - left + 1);        swap(nums, randomPivotIndex, right);        int pivot = nums[right];        int i = left - 1;        for (int j = left; j < right; j++) {            if (nums[j] <= pivot) {                i++;                swap(nums, i, j);            }        }        swap(nums, i + 1, right);        return i + 1;    }    private static void swap(int[] nums, int i, int j) {        int temp = nums[i];        nums[i] = nums[j];        nums[j] = temp;    }    public static void main(String[] args) {        int[] arr1 = {1, 3, 2, 4, 5, 6, 7};        int k1 = 3;        System.out.println("Output 1: " + findKthLargest(arr1, k1)); // Output 1: 5        int[] arr2 = {4, 3, 3, 2, 1};        int k2 = 4;        System.out.println("Output 2: " + findKthLargest(arr2, k2)); // Output 2: 2    }}