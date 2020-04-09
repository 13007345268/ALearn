package com.zking.zzcloud.sysservice.service;


import com.zking.zzcloud.sysservice.model.Cal;

public interface ICalService {
    Double add(Cal cal);

    Double subtract(Cal cal);

    Double multiply(Cal cal);

    Double divide(Cal cal);
}
