package com.devil.basic.structure.search;

/**
 * 二分查找法
 *
 * @author Devil
 * @date Created in 2021/7/12 16:47
 */
public class BinarySearchTest {

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // left,right都很大时有可能越界，所以采用这种方式 不用 (right + left)/2
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 没找到
        return -1;
    }

}
