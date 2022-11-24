package icu.javacg.comtroller;

import icu.javacg.pojo.User;
import icu.javacg.service.UserService;
import net.sf.jsqlparser.util.validation.metadata.NamedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;


@Controller
@RequestMapping("/user")
public class UserControl {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String loginIn(){
        return "/html/user/login/login";
    }

    @RequestMapping("/")
    public String index(){
        return "/html/user/index/index";
    }

    @PostMapping("/register")
    public String register(String username, String password, String password2,String email, Model model){
        Boolean register = false;
        if (password.equals(password2)){
            register = userService.register(username, password, email);
            System.out.println(register);
        }else {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            model.addAttribute("password2", password2);
            model.addAttribute("email", email);
            model.addAttribute("zcsb", "两次密码不一致，请重试");
        }
        if (!register) {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            model.addAttribute("password2", password2);
            model.addAttribute("email", email);
            model.addAttribute("zcsb", "注册失败，请重试");
        }
        return "/html/user/login/login";
    }
    @PostMapping("/login")
    public String login(String username, String password, Model model, HttpSession session){
        List<User> login = userService.login(username, password);
        if (login.size() > 0){
            session.setAttribute("user", login.get(0));
            model.addAttribute("user", session);
            return "forward:/user/";
        }else {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            model.addAttribute("sb", "账号或密码错误");
            return "/html/user/login/login";
        }
    }

    @GetMapping("/update")
    public String update(){
        return "/html/user/login/update";
    }

    @PostMapping ("/updateUser")
    public String updateUser(Integer uid, String username, String password, String email, Model model, HttpSession session){
        Boolean update = userService.update(uid, username, password, email);
        if (update){
            List<User> login = userService.login(username, password);
            session.setAttribute("user", login.get(0));
            model.addAttribute("user", session);
            model.addAttribute("update","修改成功");
            return "/html/user/login/update";
        }else {
            model.addAttribute("update", "修改失败");
            return "/html/user/index/index";
        }
    }
}
