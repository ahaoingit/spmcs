package cn.ahaogg.nettyservice;

public class BitUtils {
    public static String judgeBit(long num) {
        int bit = 0;
        if (0 == num) {
            return "Normal";
        } else {
            while ((num = num >> 1) != 0) {
                ++bit;
            }
        }
        return "BIT" + bit;
    }

}
