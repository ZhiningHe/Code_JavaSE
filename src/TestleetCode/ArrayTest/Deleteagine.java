package TestleetCode.ArrayTest;
//删除重复元素 返回新长度
public class Deleteagine {

        public static int removeDuplicates(int[] nums) {
            if(nums.length == 0||nums.length == 1){
                return nums.length;
            }
            int i=0,k=0;
            while (i<nums.length-1){
                if(nums[i] == -1) break; //到末尾跳出
                int j = i+1;
                if(nums[j] == nums[i]){
                    while (j<nums.length) {
                        nums[j-1] = nums[j];//往前推一位
                        j++;
                    }
                    nums[nums.length-1-k] = -1;
                    k++;
                }
                if(nums[i+1] != nums[i]) i++;
            }
            return i;
        }

        public static void main(String[] args) {
            int len = Deleteagine.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
            System.out.println(len);
        }
    }
