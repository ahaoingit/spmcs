package cn.ahaogg.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConvertUtils {
    //时间转化为时间戳去查询
    public static Long timeConvert(String year,String mouth,String day){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strTime = year+"-"+mouth+"-"+day;
        long time = 0L;
        try {
            Date date =  format.parse(strTime);
            time = date.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

}
