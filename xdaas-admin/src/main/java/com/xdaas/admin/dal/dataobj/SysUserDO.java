package com.xdaas.admin.dal.dataobj;

import lombok.Data;

/**
 * @Author mathc
 * @since 2020/10/19
 */
@Data
public class SysUserDO {

    private Integer id;
    private String username;
    private String password;
    private String salt;
}
