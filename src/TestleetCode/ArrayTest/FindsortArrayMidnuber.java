package TestleetCode.ArrayTest;
//寻找两个数组的中位数
public class FindsortArrayMidnuber {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            //因为是按照nums1为基准，节省时间必须要nums1的长度最小
            return findMedianSortedArrays(nums2, nums1);
        }
        int len = nums1.length + nums2.length;
        int left1 = nums1.length % 2 == 0 ? nums1.length / 2 : (nums1.length + 1) / 2;
        int left2 = 0;
        //用Left表示切点左边的位置
        while (left1 < nums1.length - 1) {
            left2 = len / 2 - left1;
            if (nums1[left1] > nums2[left2 + 1]) {
                left1--;
            }
            if (nums1[left1 + 1] < nums2[left2]) {
                left1++;
            }
        }
        if (len % 2 == 0) {
            double result = nums1[left1] > nums2[left2] ? nums2[left2] : nums1[left1];
            return result;
        } else {
            return (double) (nums1[left1] + nums2[left2]) / 2;
        }
    }
}

