package com.xdaas.admin.dal.dataobj;

import com.xdaas.admin.dal.dataobj.BaseDO;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限关系表
 * </p>
 *
 * @author mpg
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRolePermissionDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableField("roleId")
    private Integer roleId;

    @TableField("permissionId")
    private Integer permissionId;


}
