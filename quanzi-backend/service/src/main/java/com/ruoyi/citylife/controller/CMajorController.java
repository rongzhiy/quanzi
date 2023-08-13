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
import com.ruoyi.citylife.domain.CMajor;
import com.ruoyi.citylife.service.ICMajorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专业分类Controller
 *
 * @author aze2735
 * @date 2021-04-26
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/citylife/major" )
public class CMajorController extends BaseController {

    private final ICMajorService iCMajorService;

    /**
     * 查询专业分类列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:major:list')")
    @GetMapping("/list")
    public TableDataInfo list(CMajor cMajor)
    {
        startPage();
        LambdaQueryWrapper<CMajor> lqw = new LambdaQueryWrapper<CMajor>();
        if (StringUtils.isNotBlank(cMajor.getName())){
            lqw.like(CMajor::getName ,cMajor.getName());
        }
        if (StringUtils.isNotBlank(cMajor.getImgurl())){
            lqw.eq(CMajor::getImgurl ,cMajor.getImgurl());
        }
        if (cMajor.getDeleted()!=null){
            lqw.eq(CMajor::getDeleted ,cMajor.getDeleted());
        }
        List<CMajor> list = iCMajorService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出专业分类列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:major:export')" )
    @Log(title = "专业分类" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public R export(CMajor cMajor) {
        LambdaQueryWrapper<CMajor> lqw = new LambdaQueryWrapper<CMajor>(cMajor);
        List<CMajor> list = iCMajorService.list(lqw);
        ExcelUtil<CMajor> util = new ExcelUtil<CMajor>(CMajor. class);
        return util.exportExcel(list, "major" );
    }

    /**
     * 获取专业分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('citylife:major:query')" )
    @GetMapping(value = "/{id}" )
    public R getInfo(@PathVariable("id" ) String id) {
        return R.success(iCMajorService.getById(id));
    }

    /**
     * 新增专业分类
     */
    @PreAuthorize("@ss.hasPermi('citylife:major:add')" )
    @Log(title = "专业分类" , businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody CMajor cMajor) {
        return toAjax(iCMajorService.save(cMajor) ? 1 : 0);
    }

    /**
     * 修改专业分类
     */
    @PreAuthorize("@ss.hasPermi('citylife:major:edit')" )
    @Log(title = "专业分类" , businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody CMajor cMajor) {
        return toAjax(iCMajorService.updateById(cMajor) ? 1 : 0);
    }

    /**
     * 删除专业分类
     */
    @PreAuthorize("@ss.hasPermi('citylife:major:remove')" )
    @Log(title = "专业分类" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public R remove(@PathVariable String[] ids) {
        return toAjax(iCMajorService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
