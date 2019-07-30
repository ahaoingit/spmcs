package cn.ahaogg.utils;

import java.util.Map;
import java.util.Set;
/*
* 用来判断前台用户是否全部输入
* */
public class IsEmpty {

    public static  boolean isEmptyClient(Map<String , String[]> parameterMap){
        boolean flag = true;
        Set<String> strings = parameterMap.keySet();
        for (String string : strings) {
            String[] strarr = parameterMap.get(string);
            for (String s : strarr) {
                if ("".equals(s)){
                    flag = false;
                }
            }
        }
        return  flag;
    }
}
