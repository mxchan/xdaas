package com.xdaas.admin.dal.dataobj;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author mathc
 * @since 2020/10/22
 */
public class BaseDO implements Serializable {

    private static final long serialVersionUID = 738983925091097080L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Date created;
    private Date modified;
    @TableLogic
    private Integer flag;
}
