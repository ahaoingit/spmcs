package cn.ahaogg.web;

import cn.ahaogg.domain.RealTime;

public class RealtimeInfo {
    String m_model;
    RealTime realTime;

    public RealtimeInfo() {
    }

    public RealtimeInfo(String m_model, RealTime realTime) {
        this.m_model = m_model;
        this.realTime = realTime;
    }

    public String getM_model() {
        return m_model;
    }

    public void setM_model(String m_model) {
        this.m_model = m_model;
    }

    public RealTime getRealTime() {
        return realTime;
    }

    public void setRealTime(RealTime realTime) {
        this.realTime = realTime;
    }

    @Override
    public String toString() {
        return "RealtimeInfo{" +
                "m_model='" + m_model + '\'' +
                ", realTime=" + realTime +
                '}';
    }
}
