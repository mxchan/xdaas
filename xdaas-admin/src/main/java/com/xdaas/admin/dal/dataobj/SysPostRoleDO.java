package com.xdaas.admin.dal.dataobj;

import com.xdaas.admin.dal.dataobj.BaseDO;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 岗位角色关系表
 * </p>
 *
 * @author mpg
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysPostRoleDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableField("roleId")
    private Integer roleId;

    @TableField("postId")
    private Integer postId;


}
