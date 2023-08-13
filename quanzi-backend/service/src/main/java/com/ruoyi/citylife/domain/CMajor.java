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
 * 专业分类对象 c_major
 * 
 * @author aze2735
 * @date 2021-04-26
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("c_major")
public class CMajor implements Serializable {

private static final long serialVersionUID=1L;


    /** 专业id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /** 专业名 */
    @Excel(name = "专业名")
    private String name;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imgurl;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Boolean deleted;

    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 修改时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
