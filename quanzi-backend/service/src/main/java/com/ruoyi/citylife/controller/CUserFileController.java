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
import com.ruoyi.citylife.domain.CUserFile;
import com.ruoyi.citylife.service.ICUserFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文件上传Controller
 *
 * @author aze2735
 * @date 2021-04-26
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/citylife/userFile" )
public class CUserFileController extends BaseController {

    private final ICUserFileService iCUserFileService;

    /**
     * 查询文件上传列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:userFile:list')")
    @GetMapping("/list")
    public TableDataInfo list(CUserFile cUserFile)
    {
        startPage();
        LambdaQueryWrapper<CUserFile> lqw = new LambdaQueryWrapper<CUserFile>();
        if (StringUtils.isNotBlank(cUserFile.getUid())){
            lqw.eq(CUserFile::getUid ,cUserFile.getUid());
        }
        if (StringUtils.isNotBlank(cUserFile.getImgurl())){
            lqw.eq(CUserFile::getImgurl ,cUserFile.getImgurl());
        }
        if (StringUtils.isNotBlank(cUserFile.getVideourl())){
            lqw.eq(CUserFile::getVideourl ,cUserFile.getVideourl());
        }
        if (cUserFile.getDeleted()!=null){
            lqw.eq(CUserFile::getDeleted ,cUserFile.getDeleted());
        }
        List<CUserFile> list = iCUserFileService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出文件上传列表
     */
    @PreAuthorize("@ss.hasPermi('citylife:userFile:export')" )
    @Log(title = "文件上传" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public R export(CUserFile cUserFile) {
        LambdaQueryWrapper<CUserFile> lqw = new LambdaQueryWrapper<CUserFile>(cUserFile);
        List<CUserFile> list = iCUserFileService.list(lqw);
        ExcelUtil<CUserFile> util = new ExcelUtil<CUserFile>(CUserFile. class);
        return util.exportExcel(list, "userFile" );
    }

    /**
     * 获取文件上传详细信息
     */
    @PreAuthorize("@ss.hasPermi('citylife:userFile:query')" )
    @GetMapping(value = "/{id}" )
    public R getInfo(@PathVariable("id" ) String id) {
        return R.success(iCUserFileService.getById(id));
    }

    /**
     * 新增文件上传
     */
    @PreAuthorize("@ss.hasPermi('citylife:userFile:add')" )
    @Log(title = "文件上传" , businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody CUserFile cUserFile) {
        return toAjax(iCUserFileService.save(cUserFile) ? 1 : 0);
    }

    /**
     * 修改文件上传
     */
    @PreAuthorize("@ss.hasPermi('citylife:userFile:edit')" )
    @Log(title = "文件上传" , businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody CUserFile cUserFile) {
        return toAjax(iCUserFileService.updateById(cUserFile) ? 1 : 0);
    }

    /**
     * 删除文件上传
     */
    @PreAuthorize("@ss.hasPermi('citylife:userFile:remove')" )
    @Log(title = "文件上传" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public R remove(@PathVariable String[] ids) {
        return toAjax(iCUserFileService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
