package com.xdaas.admin.dal.dataobj;

import com.xdaas.admin.dal.dataobj.BaseDO;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author mpg
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysPermissionDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 操作名称
     */
    @TableField("permissionName")
    private String permissionName;

    /**
     * 操作标识
     */
    @TableField("permissionTag")
    private String permissionTag;

    /**
     * 上级
     */
    @TableField("parentId")
    private Integer parentId;


}
