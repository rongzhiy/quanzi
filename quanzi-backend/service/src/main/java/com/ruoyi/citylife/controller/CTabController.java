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
import com.ruoyi.citylife.domain.CTab;
import com.ruoyi.citylife.service.ICTabService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * TabController
 *
 * @author aze2735
 * @date 2021-04-26
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/citylife/tab" )
public class CTabController extends BaseController {

    private final ICTabService iCTabService;

    /**
     * 查询Tab列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:tab:list')")
    @GetMapping("/list")
    public TableDataInfo list(CTab cTab)
    {
        startPage();
        LambdaQueryWrapper<CTab> lqw = new LambdaQueryWrapper<CTab>();
        if (StringUtils.isNotBlank(cTab.getTabname())){
            lqw.like(CTab::getTabname ,cTab.getTabname());
        }
        if (cTab.getDeleted()!=null){
            lqw.eq(CTab::getDeleted ,cTab.getDeleted());
        }
        List<CTab> list = iCTabService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出Tab列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:tab:export')" )
    @Log(title = "Tab" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public R export(CTab cTab) {
        LambdaQueryWrapper<CTab> lqw = new LambdaQueryWrapper<CTab>(cTab);
        List<CTab> list = iCTabService.list(lqw);
        ExcelUtil<CTab> util = new ExcelUtil<CTab>(CTab. class);
        return util.exportExcel(list, "tab" );
    }

    /**
     * 获取Tab详细信息
     */
    @PreAuthorize("@ss.hasPermi('citylife:tab:query')" )
    @GetMapping(value = "/{id}" )
    public R getInfo(@PathVariable("id" ) String id) {
        return R.success(iCTabService.getById(id));
    }

    /**
     * 新增Tab
     */
    @PreAuthorize("@ss.hasPermi('citylife:tab:add')" )
    @Log(title = "Tab" , businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody CTab cTab) {
        return toAjax(iCTabService.save(cTab) ? 1 : 0);
    }

    /**
     * 修改Tab
     */
    @PreAuthorize("@ss.hasPermi('citylife:tab:edit')" )
    @Log(title = "Tab" , businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody CTab cTab) {
        return toAjax(iCTabService.updateById(cTab) ? 1 : 0);
    }

    /**
     * 删除Tab
     */
    @PreAuthorize("@ss.hasPermi('citylife:tab:remove')" )
    @Log(title = "Tab" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public R remove(@PathVariable String[] ids) {
        return toAjax(iCTabService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
