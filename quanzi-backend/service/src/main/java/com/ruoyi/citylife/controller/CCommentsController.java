package com.ruoyi.citylife.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.citylife.domain.CComments;
import com.ruoyi.citylife.service.ICCommentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论Controller
 *
 * @author aze2735
 * @date 2021-04-26
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/citylife/comments" )
public class CCommentsController extends BaseController {

    private final ICCommentsService iCCommentsService;

    /**
     * 查询评论列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:comments:list')")
    @GetMapping("/list")
    public TableDataInfo list(CComments cComments)
    {
        startPage();
        LambdaQueryWrapper<CComments> lqw = new LambdaQueryWrapper<CComments>();
        if (StringUtils.isNotBlank(cComments.getUid())){
            lqw.eq(CComments::getUid ,cComments.getUid());
        }
        if (StringUtils.isNotBlank(cComments.getAnswerid())){
            lqw.eq(CComments::getAnswerid ,cComments.getAnswerid());
        }
        if (StringUtils.isNotBlank(cComments.getDetail())){
            lqw.eq(CComments::getDetail ,cComments.getDetail());
        }
        if (cComments.getLikes() != null){
            lqw.eq(CComments::getLikes ,cComments.getLikes());
        }
        if (cComments.getUnlikes() != null){
            lqw.eq(CComments::getUnlikes ,cComments.getUnlikes());
        }
        if (cComments.getChecked() != null){
            lqw.eq(CComments::getChecked ,cComments.getChecked());
        }
        if (cComments.getDeleted() != null){
            lqw.eq(CComments::getDeleted ,cComments.getDeleted());
        }
        List<CComments> list = iCCommentsService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:comments:export')" )
    @Log(title = "评论" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public R export(CComments cComments) {
        LambdaQueryWrapper<CComments> lqw = new LambdaQueryWrapper<CComments>(cComments);
        List<CComments> list = iCCommentsService.list(lqw);
        ExcelUtil<CComments> util = new ExcelUtil<CComments>(CComments. class);
        return util.exportExcel(list, "comments" );
    }

    /**
     * 获取评论详细信息
     */
    @PreAuthorize("@ss.hasPermi('citylife:comments:query')" )
    @GetMapping(value = "/{id}" )
    public R getInfo(@PathVariable("id" ) String id) {
        return R.success(iCCommentsService.getById(id));
    }

    /**
     * 新增评论
     */
    @PreAuthorize("@ss.hasPermi('citylife:comments:add')" )
    @Log(title = "评论" , businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody CComments cComments) {
        return toAjax(iCCommentsService.save(cComments) ? 1 : 0);
    }

    /**
     * 修改评论
     */
    @PreAuthorize("@ss.hasPermi('citylife:comments:edit')" )
    @Log(title = "评论" , businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody CComments cComments) {
        return toAjax(iCCommentsService.updateById(cComments) ? 1 : 0);
    }

    /**
     * 删除评论
     */
    @PreAuthorize("@ss.hasPermi('citylife:comments:remove')" )
    @Log(title = "评论" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public R remove(@PathVariable String[] ids) {
        return toAjax(iCCommentsService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
