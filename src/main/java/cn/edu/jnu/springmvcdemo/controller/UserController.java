package cn.edu.jnu.springmvcdemo.controller;

import cn.edu.jnu.springmvcdemo.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author kongchuiyun
 */
@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        if ("root@qq.com".equals(user.getUserName()) && "123".equals(user.getPassWord())) {
            session.setAttribute("loginUser", user);
            return "redirect:/dashboard.html";
        }
        model.addAttribute("loginFailedMsg", "账号密码错误！");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";
    }
}
