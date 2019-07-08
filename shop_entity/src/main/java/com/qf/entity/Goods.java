package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @version 1.0
 * @user yzb
 * @date 2019-07-05 17:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String gname;
    //商品描述
    private String gdesc;

    private String gimage;

    private BigDecimal gprice;

    private Integer gsave;

    private Integer tid;


}
