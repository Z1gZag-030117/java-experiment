package com.zz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 朱喆
 * @version 1.0
 */
@Data
public class User {
    private String account;
    private String name;
    private String password;
    private String gander;
    private String mailbox;
}
