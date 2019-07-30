package cn.ahaogg.domain;

import java.sql.Timestamp;

public class RealTime {
    private String m_serialnum;
    private float Photovoltaic_input_voltage;
    private float Photovoltaic_input_current;
    private float AC_input_power;
    private float AC_output_phase;
    private float AC_output_frequency;
    private float AC_output_current;
    private float machine_Internal_temperature;
    private String s_code;
    private String f_code;
    private String w_code;
    private int f_status;
    private int w_status;
    private Timestamp time;
    private long rid;
    private int sum;
    private int solar_ac_status;

    public RealTime() {
    }

    public RealTime(String m_serialnum, float photovoltaic_input_voltage, float photovoltaic_input_current, float AC_input_power, float AC_output_phase, float AC_output_frequency, float AC_output_current, float machine_Internal_temperature, String s_code, String f_code, String w_code, int f_status, int w_status, Timestamp time, long rid, int sum, int solar_ac_status) {
        this.m_serialnum = m_serialnum;
        Photovoltaic_input_voltage = photovoltaic_input_voltage;
        Photovoltaic_input_current = photovoltaic_input_current;
        this.AC_input_power = AC_input_power;
        this.AC_output_phase = AC_output_phase;
        this.AC_output_frequency = AC_output_frequency;
        this.AC_output_current = AC_output_current;
        this.machine_Internal_temperature = machine_Internal_temperature;
        this.s_code = s_code;
        this.f_code = f_code;
        this.w_code = w_code;
        this.f_status = f_status;
        this.w_status = w_status;
        this.time = time;
        this.rid = rid;
        this.sum = sum;
        this.solar_ac_status = solar_ac_status;
    }
    public String getM_serialnum() {
        return m_serialnum;
    }

    public void setM_serialnum(String m_serialnum) {
        this.m_serialnum = m_serialnum;
    }

    public float getPhotovoltaic_input_voltage() {
        return Photovoltaic_input_voltage;
    }

    public void setPhotovoltaic_input_voltage(float photovoltaic_input_voltage) {
        Photovoltaic_input_voltage = photovoltaic_input_voltage;
    }

    public float getPhotovoltaic_input_current() {
        return Photovoltaic_input_current;
    }

    public void setPhotovoltaic_input_current(float photovoltaic_input_current) {
        Photovoltaic_input_current = photovoltaic_input_current;
    }

    public float getAC_input_power() {
        return AC_input_power;
    }

    public void setAC_input_power(float AC_input_power) {
        this.AC_input_power = AC_input_power;
    }

    public float getAC_output_phase() {
        return AC_output_phase;
    }

    public void setAC_output_phase(float AC_output_phase) {
        this.AC_output_phase = AC_output_phase;
    }

    public float getAC_output_frequency() {
        return AC_output_frequency;
    }

    public void setAC_output_frequency(float AC_output_frequency) {
        this.AC_output_frequency = AC_output_frequency;
    }

    public float getAC_output_current() {
        return AC_output_current;
    }

    public void setAC_output_current(float AC_output_current) {
        this.AC_output_current = AC_output_current;
    }

    public float getMachine_Internal_temperature() {
        return machine_Internal_temperature;
    }

    public void setMachine_Internal_temperature(float machine_Internal_temperature) {
        this.machine_Internal_temperature = machine_Internal_temperature;
    }

    public String getS_code() {
        return s_code;
    }

    public void setS_code(String s_code) {
        this.s_code = s_code;
    }

    public String getF_code() {
        return f_code;
    }

    public void setF_code(String f_code) {
        this.f_code = f_code;
    }

    public String getW_code() {
        return w_code;
    }

    public void setW_code(String w_code) {
        this.w_code = w_code;
    }

    public int getF_status() {
        return f_status;
    }

    public void setF_status(int f_status) {
        this.f_status = f_status;
    }

    public int getW_status() {
        return w_status;
    }

    public void setW_status(int w_status) {
        this.w_status = w_status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSolar_ac_status() {
        return solar_ac_status;
    }

    public void setSolar_ac_status(int solar_ac_status) {
        this.solar_ac_status = solar_ac_status;
    }

    @Override
    public String toString() {
        return "RealTime{" +
                "m_serialnum='" + m_serialnum + '\'' +
                ", Photovoltaic_input_voltage=" + Photovoltaic_input_voltage +
                ", Photovoltaic_input_current=" + Photovoltaic_input_current +
                ", AC_input_power=" + AC_input_power +
                ", AC_output_phase=" + AC_output_phase +
                ", AC_output_frequency=" + AC_output_frequency +
                ", AC_output_current=" + AC_output_current +
                ", machine_Internal_temperature=" + machine_Internal_temperature +
                ", s_code='" + s_code + '\'' +
                ", f_code='" + f_code + '\'' +
                ", w_code='" + w_code + '\'' +
                ", f_status=" + f_status +
                ", w_status=" + w_status +
                ", time=" + time +
                ", rid=" + rid +
                ", sum=" + sum +
                ", solar_ac_status=" + solar_ac_status +
                '}';
    }
}
