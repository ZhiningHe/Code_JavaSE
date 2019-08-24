package StringTest;

import java.util.HashMap;

public class checkString {
    public static boolean wordPattern(String pattern, String str) {
        if(pattern == null || str==null) return false;
        String[] string = str.split(" ");
        if(pattern.length() != string.length) return false;
        HashMap<Character,String> map = new HashMap<>();

        for(int i=0; i<pattern.length(); i++){
            char tmp = pattern.charAt(i);
            //key已经在
            if(map.containsKey(tmp)){
                //不对应就失败
                if(!map.get(tmp).equals(string[i])) return false;
            }
            //key不存在
            else{
                //两个key的值一样
                if (map.containsValue(string[i])) return false;
                else
                //添加k-v值
                map.put(tmp,string[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkString.wordPattern("abba","dog dog dog dog"));
    }
}
