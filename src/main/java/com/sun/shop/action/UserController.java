package com.sun.shop.action;

import com.sun.shop.entity.User;
import com.sun.shop.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ddyunf on 2018/7/17.
 * @author ddyunf
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/showInfo/{userId}")
    public String showUserInfo(Model modelMap, @PathVariable int userId) {
        LOGGER.info("查看用户：" + userId);
        User userInfo = userService.getById(userId);
        modelMap.addAttribute("userInfo", userInfo);
        modelMap.addAttribute("nnnn", "开心您");
        return "/user/showInfo";
    }

    @RequestMapping("/showAll")
    public @ResponseBody List<User> showUserInfos() {
        LOGGER.info("json返回全部用户的信息");
        List<User> userInfos = userService.findAll();
        return userInfos;
    }
}
