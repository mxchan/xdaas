package com.xdaas.admin.dal.dataobj;

import com.xdaas.admin.dal.dataobj.BaseDO;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author mpg
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String email;

    private String mobile;

    /**
     * 盐
     */
    private String salt;

    /**
     * 部门Id
     */
    @TableField("deptId")
    private Integer deptId;

    /**
     * 职位Id
     */
    @TableField("postId")
    private Integer postId;

    /**
     * 部门层级编码路径
     */
    @TableField("deptPath")
    private String deptPath;


}
