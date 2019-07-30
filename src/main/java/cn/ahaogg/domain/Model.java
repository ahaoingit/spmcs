package cn.ahaogg.domain;

public class Model {
    private String m_model;
    private String max_input_voltage;
    private String min_input_voltage;
    private String full_solar_recommend_input_voltage;
    private String mixed_solar_recommend_input_voltage;
    private String recommend_voltage;
    private String rated_power;
    private String max_output_frequency;
    private String rated_output_voltage;
    private String output_phase;
    private String max_output_current;
    private String max_input_power;
    private String mppt_track;
    private String soft_version;
    private String hard_version;

    public Model() {
    }

    public Model(String m_model, String max_input_voltage, String min_input_voltage, String full_solar_recommend_input_voltage, String mixed_solar_recommend_input_voltage, String recommend_voltage, String rated_power, String max_output_frequency, String rated_output_voltage, String output_phase, String max_output_current, String max_input_power, String mppt_track, String soft_version, String hard_version) {
        this.m_model = m_model;
        this.max_input_voltage = max_input_voltage;
        this.min_input_voltage = min_input_voltage;
        this.full_solar_recommend_input_voltage = full_solar_recommend_input_voltage;
        this.mixed_solar_recommend_input_voltage = mixed_solar_recommend_input_voltage;
        this.recommend_voltage = recommend_voltage;
        this.rated_power = rated_power;
        this.max_output_frequency = max_output_frequency;
        this.rated_output_voltage = rated_output_voltage;
        this.output_phase = output_phase;
        this.max_output_current = max_output_current;
        this.max_input_power = max_input_power;
        this.mppt_track = mppt_track;
        this.soft_version = soft_version;
        this.hard_version = hard_version;
    }

    public String getM_model() {
        return m_model;
    }

    public void setM_model(String m_model) {
        this.m_model = m_model;
    }

    public String getMax_input_voltage() {
        return max_input_voltage;
    }

    public void setMax_input_voltage(String max_input_voltage) {
        this.max_input_voltage = max_input_voltage;
    }

    public String getMin_input_voltage() {
        return min_input_voltage;
    }

    public void setMin_input_voltage(String min_input_voltage) {
        this.min_input_voltage = min_input_voltage;
    }

    public String getFull_solar_recommend_input_voltage() {
        return full_solar_recommend_input_voltage;
    }

    public void setFull_solar_recommend_input_voltage(String full_solar_recommend_input_voltage) {
        this.full_solar_recommend_input_voltage = full_solar_recommend_input_voltage;
    }

    public String getMixed_solar_recommend_input_voltage() {
        return mixed_solar_recommend_input_voltage;
    }

    public void setMixed_solar_recommend_input_voltage(String mixed_solar_recommend_input_voltage) {
        this.mixed_solar_recommend_input_voltage = mixed_solar_recommend_input_voltage;
    }

    public String getRecommend_voltage() {
        return recommend_voltage;
    }

    public void setRecommend_voltage(String recommend_voltage) {
        this.recommend_voltage = recommend_voltage;
    }

    public String getRated_power() {
        return rated_power;
    }

    public void setRated_power(String rated_power) {
        this.rated_power = rated_power;
    }

    public String getMax_output_frequency() {
        return max_output_frequency;
    }

    public void setMax_output_frequency(String max_output_frequency) {
        this.max_output_frequency = max_output_frequency;
    }

    public String getRated_output_voltage() {
        return rated_output_voltage;
    }

    public void setRated_output_voltage(String rated_output_voltage) {
        this.rated_output_voltage = rated_output_voltage;
    }

    public String getOutput_phase() {
        return output_phase;
    }

    public void setOutput_phase(String output_phase) {
        this.output_phase = output_phase;
    }

    public String getMax_output_current() {
        return max_output_current;
    }

    public void setMax_output_current(String max_output_current) {
        this.max_output_current = max_output_current;
    }

    public String getMax_input_power() {
        return max_input_power;
    }

    public void setMax_input_power(String max_input_power) {
        this.max_input_power = max_input_power;
    }

    public String getMppt_track() {
        return mppt_track;
    }

    public void setMppt_track(String mppt_track) {
        this.mppt_track = mppt_track;
    }

    public String getSoft_version() {
        return soft_version;
    }

    public void setSoft_version(String soft_version) {
        this.soft_version = soft_version;
    }

    public String getHard_version() {
        return hard_version;
    }

    public void setHard_version(String hard_version) {
        this.hard_version = hard_version;
    }

    @Override
    public String toString() {
        return "Model{" +
                "m_model='" + m_model + '\'' +
                ", max_input_voltage='" + max_input_voltage + '\'' +
                ", min_input_voltage='" + min_input_voltage + '\'' +
                ", full_solar_recommend_input_voltage='" + full_solar_recommend_input_voltage + '\'' +
                ", mixed_solar_recommend_input_voltage='" + mixed_solar_recommend_input_voltage + '\'' +
                ", recommend_voltage='" + recommend_voltage + '\'' +
                ", rated_power='" + rated_power + '\'' +
                ", max_output_frequency='" + max_output_frequency + '\'' +
                ", rated_output_voltage='" + rated_output_voltage + '\'' +
                ", output_phase='" + output_phase + '\'' +
                ", max_output_current='" + max_output_current + '\'' +
                ", max_input_power='" + max_input_power + '\'' +
                ", mppt_track='" + mppt_track + '\'' +
                ", soft_version='" + soft_version + '\'' +
                ", hard_version='" + hard_version + '\'' +
                '}';
    }
}
