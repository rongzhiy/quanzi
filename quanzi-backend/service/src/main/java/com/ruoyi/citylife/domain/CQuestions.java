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
 * 问题对象 c_questions
 * 
 * @author aze2735
 * @date 2021-04-26
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("c_questions")
public class CQuestions implements Serializable {

private static final long serialVersionUID=1L;


    /** 问题id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /** 发布人id */
    @Excel(name = "发布人id")
    private String uid;

    /** 问题标题 */
    @Excel(name = "问题标题")
    private String title;

    /** 问题详情 */
    @Excel(name = "问题详情")
    private String detail;

    /** 所属专业 */
    @Excel(name = "所属专业")
    private String major;

    /** 问题标签 */
    @Excel(name = "问题标签")
    private String label;

    /** 收藏数 */
    @Excel(name = "收藏数")
    private Integer collections;

    /** 审核与否 */
    @Excel(name = "审核与否")
    private Boolean checked;

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
