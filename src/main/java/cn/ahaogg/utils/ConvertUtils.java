package cn.ahaogg.utils;

public class ConvertUtils {
    //故障转换，输出给前台
    public static String errorConvertString(String code) {
        String convertion = null;
        switch (code) {
            case "BIT0":convertion = "OVER_LOAD";break;
            case "BIT1":convertion = "OVER_VOLTAGE";break;
            case "BIT2":convertion = "IGBT_ERROR";break;
            case "BIT3":convertion = "AC_OUTPUT_OVER_CURRENT";break;
            case "BIT4":convertion = "OVER_TEMPERATURE";break;
            case "BIT5":convertion = "DRIVER_IC_VOLTAGE";break;
            case "BIT6":convertion = "PHASE_LOST";break;
            case "BIT7":convertion = "MFT_DRIVE";break;
            case "BIT8":convertion = "BOOSTER";break;
            case "BIT9":convertion = "PV_LOW_VOLTAGE";break;
        }
        return convertion;
    }
    //警告转换，输出给前台
    public static String warningConvertString(String code) {
        String convertion = null;
        switch (code) {
            case "BIT0":convertion = "AC_LOW_VOLTAGE";break;
            case "BIT1":convertion = "SYSTEM_TIME";break;
            case "BIT2":convertion = "EEPROM_WAR";break;
            case "BIT3":convertion = "OUTPUT_PHASE_UNBALANCE";break;
            case "BIT4":convertion = "OUTPUT_CURRENT_SENSOR";break;
            case "BIT5":convertion = "AC_PHASE_LOST";break;
        }
        return convertion;
    }
    //开关状态转换，输出给前台
    public static String switchConvertString(String code) {
        String convertion = null;
        switch (code) {
            case "BIT0":convertion = "SWITCH BUTTON";break;
            case "BIT1":convertion = "REMOTE SHUTDOWN";break;
            case "BIT2":convertion = "SYSTEM WORK TIME";break;
            case "BIT3":convertion = "SOLAR INPUT LOW POWER";break;
            case "BIT4":convertion = "MIXED STATE   SWITCH SHUTDOWN";break;
            case "BIT5":convertion = "WATER TOWER FULL";break;
            case "BIT6":convertion = "WATER WELL EMPTY";break;
            case "BIT7":convertion = "SOFTWARE DRY PUMP SHUTDOWN";break;
            case "BIT8":convertion = "ERROR";break;
        }
        return convertion;
    }
}
