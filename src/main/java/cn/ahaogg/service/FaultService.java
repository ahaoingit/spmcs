package cn.ahaogg.service;

import cn.ahaogg.domain.Fault;

public interface FaultService {
    Fault findFault(String f_code);
}
