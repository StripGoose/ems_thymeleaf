package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*登录方法*/
    @PostMapping("/login")
    public String login(String username,String password,HttpSession session){
        User user = userService.login(username, password);
        if (user!=null){
            session.setAttribute("user",user);
            return "redirect:/emp/findAll";
        }
        else
            return "redirect:/index";
    }

    /*注册方法*/
    @PostMapping("/register")
    public String register(User user,String code,HttpSession session){
        String sessionCode = (String) session.getAttribute("code");
        if (sessionCode.equals(code)){
            userService.register(user);
            /*跳转到登录界面*/
            return "redirect:/index";
        }else {
            return "redirect:/toRegister";
        }
    }

    /**
     * 生成验证码
     * @param session
     * @param response
     */
    @GetMapping("/code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        /* 生成验证码 */
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        session.setAttribute("code",securityCode);
        /* 响应图片 */
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image,"png",os);
    }
}
