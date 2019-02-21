package com.frozen.frozenoa.controller.route;

import com.frozen.frozenoa.po.SysMenu;
import com.frozen.frozenoa.po.SysUser;
import com.frozen.frozenoa.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.frozen.frozenoa.shiro.utils.ShiroUtils.getSysUser;

/**
 * @Auther: Frozen
 * @Date: 2019/1/30 17:09
 * @Description:
 */
@Controller
public class IndexRoute {
    @Autowired
    SysMenuService sysMenuService;

    /**
     * 主页
     * @param mmap
     * @returnm
     */
    @RequestMapping("/index")
    public String index(ModelMap mmap){
        // 取身份信息
        SysUser user = getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = sysMenuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        //mmap.put("copyrightYear", Global.getCopyrightYear());
        return "index.html";
    }


}
