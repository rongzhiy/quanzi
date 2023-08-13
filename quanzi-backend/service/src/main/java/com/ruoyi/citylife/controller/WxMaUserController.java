package com.ruoyi.citylife.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.citylife.config.WxMaConfiguration;
import com.ruoyi.citylife.domain.CUser;
import com.ruoyi.citylife.service.ICUserService;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.WxLoginService;
import com.ruoyi.framework.web.service.WxUser;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 微信小程序用户接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@RestController
@RequestMapping("/wx/user/{appid}")
@Slf4j
public class WxMaUserController {

    @Autowired
    private WxLoginService wxLoginService;
    @Autowired
    private ICUserService icUserService;

    /**
     * 登陆接口
     */

    @GetMapping("/login")
    public R login(@PathVariable String appid, String code, String token) {

        System.out.println("拿到初始token ="+token);
        WxUser wxUser = null;
        if (StringUtils.isNotEmpty(token)) {
            wxUser = wxLoginService.getWxUser(token);
            System.out.println("wxUser = " + wxUser);
        }
        //如果token为空或者wxUser为空，返回错误信息
        if (StringUtils.isEmpty(token) || StringUtils.isNull(wxUser)) {
            if (StringUtils.isBlank(code)) {
                return R.error("empty jscode");
            }
            //根据appid得到微信服务
            final WxMaService wxService = WxMaConfiguration.getMaService(appid);

            try {
                WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
                log.info("得到Sessionkey",session.getSessionKey());
                log.info("得到openid",session.getOpenid());
                wxUser = new WxUser();
                wxUser.setOpenid(session.getOpenid());
                //根据openid查询数据库得到cuser，然后判断cuser是否为空
                QueryWrapper<CUser> wrapper = new QueryWrapper<>();
                wrapper.eq("openid", session.getOpenid());
                CUser cUser = icUserService.getOne(wrapper);
                System.out.println("cUser = " + cUser);
                //数据库里有cuser
                if (StringUtils.isNotNull(cUser)) {
                    if (StringUtils.isNotEmpty(cUser.getNickname())) {//cuer的nickname不为空
                        wxUser.setNickname(cUser.getNickname());
                        System.out.println("cUser.getNickname() = " + cUser.getNickname());
                        //根据wxuser创建新的token
                        String newToken = wxLoginService.createToken(wxUser);
                        HashMap<String, Object> map = new HashMap<>();
                        //把新token，cuser传给前端
                        map.put("token", newToken);
                        cUser.setNull();//id和openid是敏感数据，需要置为空
                        map.put("user", cUser);
                        return R.success("登录成功", map);

                    } else {  //nickname为空有openid ==》非首次,未授权
                        String newToken = wxLoginService.createToken(wxUser);
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("token", newToken);
                        map.put("user", null);
                        return R.error("非首次,未授权", map);
                    }
                } else {
                    //数据库里没有cuser
                    //首次尝试登陆
                    String newToken = wxLoginService.createToken(wxUser);
                    CUser user = new CUser();
                    user.setOpenid(session.getOpenid());
                    icUserService.save(user);
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("token", newToken);
                    map.put("user", null);
                    return R.error("未登录,请登录", map);
                }

            } catch (WxErrorException e) {
                log.error(e.getMessage());
                return R.error(e.toString());
            }

        } else {
            //token ,wxUser 都不是空
            String nickname = wxUser.getNickname();
            if (StringUtils.isNotBlank(nickname)) {  //nickname不为空

                QueryWrapper<CUser> wrapper = new QueryWrapper<>();
                wrapper.eq("openid", wxUser.getOpenid());
                CUser cUser = icUserService.getOne(wrapper);
                //更新缓存
                wxLoginService.setWxUser(wxUser);
                HashMap<String, Object> map = new HashMap<>();
                map.put("token", token);
                cUser.setNull();
                map.put("user", cUser);
                return R.success("登录成功", map);
            } else {                                  //nickname为空
                wxLoginService.setWxUser(wxUser);
                HashMap<String, Object> map = new HashMap<>();
                map.put("token", token);
                map.put("user", null);
                return R.error("非首次,未授权",map);
            }
        }
    }

    //授权操作
    @PostMapping("/postAuth")
    public R postAuth(@RequestBody CUser cUser, HttpServletRequest request) {
        String token = wxLoginService.getToken(request);
        System.out.println("授权中的token = " + token);
        WxUser wxUser = wxLoginService.getWxUser(token);
        System.out.println("授权中的wxUser = " + wxUser);

        System.out.println(" 微信用户 " +cUser);
        wxUser.setNickname(cUser.getNickname());
        wxLoginService.setWxUser(wxUser);

        cUser.setOpenid(wxUser.getOpenid());
        QueryWrapper<CUser> wrapper = new QueryWrapper<>();
        wrapper.eq("openid", wxUser.getOpenid());
        icUserService.update(cUser, wrapper);
        return R.success("授权成功");
    }


//    /**
//     * <pre>
//     * 获取用户信息接口
//     * </pre>
//     */
//    @GetMapping("/info")
//    public String info(@PathVariable String appid, String sessionKey,
//                       String signature, String rawData, String encryptedData, String iv) {
//        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
//
//        // 用户信息校验
//        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
//            return "user check failed";
//        }
//
//        // 解密用户信息
//        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
//
//        return JsonUtils.toJson(userInfo);
//    }
//
//    /**
//     * <pre>
//     * 获取用户绑定手机号信息
//     * </pre>
//     */
//    @GetMapping("/phone")
//    public String phone(@PathVariable String appid, String sessionKey, String signature,
//                        String rawData, String encryptedData, String iv) {
//        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
//
//        // 用户信息校验
//        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
//            return "user check failed";
//        }
//
//        // 解密
//        WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);
//
//        return JsonUtils.toJson(phoneNoInfo);
//    }

}
