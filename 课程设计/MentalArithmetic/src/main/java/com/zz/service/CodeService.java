package com.zz.service;

import com.zz.pojo.Code;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface CodeService {
    Code saveCode(Code code);
    String selectCode(String email);
}
