package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version 1.0
 * @user yzb
 * @date 2019-07-05 18:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "goodstype")
public class GoodsType implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String gtname;

    private Integer gtpid;

    private Integer status;
    @TableField(exist = false)
    private String gtPname;
}
