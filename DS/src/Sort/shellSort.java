package Sort;

public class shellSort {
    public static void shell(int[] data){
        if(data.length <1){
            return;
        }
        int step = data.length/2;
        //跳出的条件
        while (step>=1) {
            //小数组中要插入的元素

            //相当于直插排序
            for(int i =step; i<data.length; i++){
                int value = data[i];
                //j是直插中已排序的元素
                int j=i-step;
                for(; j>=0; j-=step) {
                    if (value < data[j]) {
                        //如果待插入元素小于已有元素则把j移动到j+step
                        //相当于把直插排序中的1换成step即可
                        data[j + step] = data[j];
                    } else {
                        break;
                    }
                }
                    //将value插入到data[j]
                    data[j+step] = value;
                }
                step = step/ 2;
            }
        }
    }

