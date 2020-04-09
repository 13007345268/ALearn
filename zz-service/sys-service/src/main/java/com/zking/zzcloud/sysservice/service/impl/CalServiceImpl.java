package com.zking.zzcloud.sysservice.service.impl;

import com.zking.zzcloud.sysservice.model.Cal;
import com.zking.zzcloud.sysservice.service.ICalService;
import org.springframework.stereotype.Service;

@Service
public class CalServiceImpl implements ICalService {

    public Double add(Cal cal) {
        return cal.getNum1() + cal.getNum2();
    }

    public Double subtract(Cal cal) {
        return cal.getNum1() - cal.getNum2();
    }

    public Double multiply(Cal cal) {
        return cal.getNum1() * cal.getNum2();
    }

    public Double divide(Cal cal) {
        return cal.getNum1() / cal.getNum2();
    }
}
