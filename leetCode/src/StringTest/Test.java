package StringTest;

import java.util.*;

/**
 * 寻找最长的数字串
 */
class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();

        int start = 0,max_start = 0,max =0,len =0;
        for(int i=0 ;i<arr.length; i++){
            //如果是数字
            if(isNum(arr[i])){
                //如果前一个是字母，就初始化长度，记录初始位置
                if(!isNum(arr[i-1])){
                    len=1; start=i;
                }
                //如果i+1是字母，那就+1后比较max，保存最大长度和初始位置
                else if(!isNum(arr[i+1])||i+1==arr.length){
                    if(max<len+1){
                        max = len+1; max_start = start;
                    }
                }
                //如果前后都是数字，那就长度加1
                else len++;
            }
        }
        for(int j=max_start; j<start+max; j++){
            System.out.print(arr[j]);
        }
    }

    public static boolean isNum(char c){
        return c <='9' && c>='0';
    }
}
