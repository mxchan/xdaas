package com.xdaas.admin.dal.dataobj;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @Author mathc
 * @since 2020/10/19
 */
@Data
@TableName("sys_user")
public class SysUserDO {

    private Integer id;
    private String username;
    private String password;
    private String salt;
}
