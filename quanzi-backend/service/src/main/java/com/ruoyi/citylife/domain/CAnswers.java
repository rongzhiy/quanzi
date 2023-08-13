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
 * 回答对象 c_answers
 * 
 * @author aze2735
 * @date 2021-04-26
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("c_answers")
public class CAnswers implements Serializable {

private static final long serialVersionUID=1L;


    /** 回答id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /** 用户id */
    @Excel(name = "用户id")
    private String uid;

    /** 问题id */
    @Excel(name = "问题id")
    private String qid;

    /** 回答详情 */
    @Excel(name = "回答详情")
    private String detail;

    /** 浏览人数 */
    @Excel(name = "浏览人数")
    private Integer views;

    /** 评论数 */
    @Excel(name = "评论数")
    private Integer comments;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Integer likes;

    /** 点踩数 */
    @Excel(name = "点踩数")
    private Integer unlikes;

    /** 回答标签 */
    @Excel(name = "回答标签")
    private String label;

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

    /** 更新时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
