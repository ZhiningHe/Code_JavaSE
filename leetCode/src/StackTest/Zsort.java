package StackTest;


//LEETCODEISHIRING
//输出为：
//L   C   I   R
//E T O E S I I G
//E   D   H   N

/*思路：比如n是4
那么字符串的行数是：0 1 2 3 2 1 | 0 1 2 3 2 1 | ……
也就是numRows+numRows-2 为一循环
而列的顺序和字符串本来的顺序就一致，按顺序存起来就好了，最后按行相加，得到结果
重点是对下标index的处理，小于行数那就不用处理，大于行数就和循环数取模。最重点的就是处理后的index可能会是大于行数的，
所以又得处理，index= (index<numRows)?(index):(tmp-index);
纸上画一画就能找到规律

 */

public class Zsort {
    public static String convert(String s, int numRows) {
        if(s.length()==1||numRows==1) return s;
        //创建长度为numRows的数组，存放字符串
        StringBuilder[] str = new StringBuilder[numRows];
        int tmp = 2*numRows-2;
        for(int i=0; i<s.length(); i++){
            //先计算下标
            int index = (i>=numRows)?(i%tmp):i;
            index= (index<numRows)?(index):(tmp-index);
            //已经有值，往后添加
            if (str[index]!=null){
                str[index].append(s.charAt(i));
                //没有值，创建StringBuilder
            }else{
                str[index] = new StringBuilder(Character.toString(s.charAt(i)));
            }
        }
        StringBuilder result = str[0];
        for(int j=1; j<numRows; j++){
            if(str[j]!=null){
                result.append(str[j]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",4));

    }

}
