package com.ruoyi.citylife.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.NullLiteral;
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
import com.ruoyi.citylife.domain.CAnswers;
import com.ruoyi.citylife.service.ICAnswersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 回答Controller
 *
 * @author aze2735
 * @date 2021-04-26
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/citylife/answers" )
public class CAnswersController extends BaseController {

    private final ICAnswersService iCAnswersService;

    /**
     * 查询回答列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:answers:list')")
    @GetMapping("/list")
    public TableDataInfo list(CAnswers cAnswers)
    {
        startPage();
        LambdaQueryWrapper<CAnswers> lqw = new LambdaQueryWrapper<CAnswers>();
        if (StringUtils.isNotBlank(cAnswers.getUid())){
            lqw.eq(CAnswers::getUid ,cAnswers.getUid());
        }
        if (StringUtils.isNotBlank(cAnswers.getQid())){
            lqw.eq(CAnswers::getQid ,cAnswers.getQid());
        }
        if (StringUtils.isNotBlank(cAnswers.getDetail())){
            lqw.eq(CAnswers::getDetail ,cAnswers.getDetail());
        }
        if (cAnswers.getViews() != null){
            lqw.eq(CAnswers::getViews ,cAnswers.getViews());
        }
        if (cAnswers.getComments() != null){
            lqw.eq(CAnswers::getComments ,cAnswers.getComments());
        }
        if (cAnswers.getLikes() != null){
            lqw.eq(CAnswers::getLikes ,cAnswers.getLikes());
        }
        if (cAnswers.getUnlikes() != null){
            lqw.eq(CAnswers::getUnlikes ,cAnswers.getUnlikes());
        }
        if (StringUtils.isNotBlank(cAnswers.getLabel())){
            lqw.eq(CAnswers::getLabel ,cAnswers.getLabel());
        }
        if (cAnswers.getChecked()!= null){
            lqw.eq(CAnswers::getChecked ,cAnswers.getChecked());
        }
        if (cAnswers.getDeleted()!= null){
            lqw.eq(CAnswers::getDeleted ,cAnswers.getDeleted());
        }
        List<CAnswers> list = iCAnswersService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出回答列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:answers:export')" )
    @Log(title = "回答" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public R export(CAnswers cAnswers) {
        LambdaQueryWrapper<CAnswers> lqw = new LambdaQueryWrapper<CAnswers>(cAnswers);
        List<CAnswers> list = iCAnswersService.list(lqw);
        ExcelUtil<CAnswers> util = new ExcelUtil<CAnswers>(CAnswers. class);
        return util.exportExcel(list, "answers" );
    }

    /**
     * 获取回答详细信息
     */
    @PreAuthorize("@ss.hasPermi('citylife:answers:query')" )
    @GetMapping(value = "/{id}" )
    public R getInfo(@PathVariable("id" ) String id) {
        return R.success(iCAnswersService.getById(id));
    }

    /**
     * 新增回答
     */
    @PreAuthorize("@ss.hasPermi('citylife:answers:add')" )
    @Log(title = "回答" , businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody CAnswers cAnswers) {
        return toAjax(iCAnswersService.save(cAnswers) ? 1 : 0);
    }

    /**
     * 修改回答
     */
    @PreAuthorize("@ss.hasPermi('citylife:answers:edit')" )
    @Log(title = "回答" , businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody CAnswers cAnswers) {
        return toAjax(iCAnswersService.updateById(cAnswers) ? 1 : 0);
    }

    /**
     * 删除回答
     */
    @PreAuthorize("@ss.hasPermi('citylife:answers:remove')" )
    @Log(title = "回答" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public R remove(@PathVariable String[] ids) {
        return toAjax(iCAnswersService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
