package com.xdaas.admin.dal.dataobj;

import com.xdaas.admin.dal.dataobj.BaseDO;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author mpg
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDeptDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableField("deptCode")
    private String deptCode;

    @TableField("deptName")
    private String deptName;

    /**
     * 上级Id
     */
    @TableField("parentId")
    private Integer parentId;


}
