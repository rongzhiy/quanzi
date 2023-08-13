package com.ruoyi.citylife.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.ruoyi.common.annotation.Excel;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Tab对象 c_tab
 *
 * @author aze2735
 * @date 2021-04-26
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("c_tab")
public class CTab implements Serializable {

    private static final long serialVersionUID=1L;


    /** Tabid */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /** Tab名字 */
    @Excel(name = "Tab名字")
    private String tabname;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Boolean deleted;

    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}