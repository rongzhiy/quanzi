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
import com.ruoyi.citylife.domain.CQuestions;
import com.ruoyi.citylife.service.ICQuestionsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 问题Controller
 *
 * @author aze2735
 * @date 2021-04-26
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/citylife/questions" )
public class CQuestionsController extends BaseController {

    private final ICQuestionsService iCQuestionsService;

    /**
     * 查询问题列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:questions:list')")
    @GetMapping("/list")
    public TableDataInfo list(CQuestions cQuestions)
    {
        startPage();
        LambdaQueryWrapper<CQuestions> lqw = new LambdaQueryWrapper<CQuestions>();
        if (StringUtils.isNotBlank(cQuestions.getUid())){
            lqw.eq(CQuestions::getUid ,cQuestions.getUid());
        }
        if (StringUtils.isNotBlank(cQuestions.getTitle())){
            lqw.eq(CQuestions::getTitle ,cQuestions.getTitle());
        }
        if (StringUtils.isNotBlank(cQuestions.getDetail())){
            lqw.eq(CQuestions::getDetail ,cQuestions.getDetail());
        }
        if (StringUtils.isNotBlank(cQuestions.getMajor())){
            lqw.eq(CQuestions::getMajor ,cQuestions.getMajor());
        }
        if (StringUtils.isNotBlank(cQuestions.getLabel())){
            lqw.eq(CQuestions::getLabel ,cQuestions.getLabel());
        }
        if (cQuestions.getCollections() != null){
            lqw.eq(CQuestions::getCollections ,cQuestions.getCollections());
        }
        if (cQuestions.getChecked() != null){
            lqw.eq(CQuestions::getChecked ,cQuestions.getChecked());
        }
        if (cQuestions.getDeleted() != null){
            lqw.eq(CQuestions::getDeleted ,cQuestions.getDeleted());
        }
        List<CQuestions> list = iCQuestionsService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出问题列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:questions:export')" )
    @Log(title = "问题" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public R export(CQuestions cQuestions) {
        LambdaQueryWrapper<CQuestions> lqw = new LambdaQueryWrapper<CQuestions>(cQuestions);
        List<CQuestions> list = iCQuestionsService.list(lqw);
        ExcelUtil<CQuestions> util = new ExcelUtil<CQuestions>(CQuestions. class);
        return util.exportExcel(list, "questions" );
    }

    /**
     * 获取问题详细信息
     */
    @PreAuthorize("@ss.hasPermi('citylife:questions:query')" )
    @GetMapping(value = "/{id}" )
    public R getInfo(@PathVariable("id" ) String id) {
        return R.success(iCQuestionsService.getById(id));
    }

    /**
     * 新增问题
     */
    @PreAuthorize("@ss.hasPermi('citylife:questions:add')" )
    @Log(title = "问题" , businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody CQuestions cQuestions) {
        return toAjax(iCQuestionsService.save(cQuestions) ? 1 : 0);
    }

    /**
     * 修改问题
     */
    @PreAuthorize("@ss.hasPermi('citylife:questions:edit')" )
    @Log(title = "问题" , businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody CQuestions cQuestions) {
        return toAjax(iCQuestionsService.updateById(cQuestions) ? 1 : 0);
    }

    /**
     * 删除问题
     */
    @PreAuthorize("@ss.hasPermi('citylife:questions:remove')" )
    @Log(title = "问题" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public R remove(@PathVariable String[] ids) {
        return toAjax(iCQuestionsService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
