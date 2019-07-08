package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version 1.0
 * @user yzb
 * @date 2019-07-03 11:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePowerTable implements Serializable {
    private Integer rid;
    private Integer pid;
}
