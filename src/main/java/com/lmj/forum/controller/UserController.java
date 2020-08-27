package com.lmj.forum.controller;

import com.lmj.forum.exception.CustomException;
import com.lmj.forum.model.User;
import com.lmj.forum.service.UserService;
import com.lmj.forum.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

@Controller
@SessionAttributes(names = { "user" })
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registerUser")
    public ModelAndView registerUser(User user, String checkPassword) {
        ModelAndView model = new ModelAndView();

        if (user.getUsername() == "" || user.getPassword() == "" || user.getPhonenum() == "" || checkPassword == "") {
            System.out.println("注册失败");
            model.addObject("error", "请填写好信息,不能留空!");
            model.setViewName("register");
            return model;
        }
        if (!user.getPassword().equals(checkPassword)) {
            System.out.println("注册失败");
            model.addObject("error", "两次填写的密码不一致!");
            model.setViewName("register");
            return model;
        }
        String pattern = "^[1]([3-9])[0-9]{9}$";
        String content = user.getPhonenum();
        boolean isMatch = Pattern.matches(pattern, content);
        if (!isMatch) {
            System.out.println("注册失败");
            model.addObject("error", "手机格式错误!");
            model.setViewName("register");
            return model;
        }

        boolean temp = userService.InsertUser(user);
        if (temp) {
            System.out.println("注册成功");
            model.setViewName("login");
            return model;
        } else {
            System.out.println("注册失败");
            model.addObject("error", "用户名已存在!");
            model.setViewName("register");
            return model;
        }
    }

    @PostMapping("/responseJson")
    public @ResponseBody String responseJson(String username, String password, String checkPassword, String phonenum) {
//		System.out.println(username + "," + password + "," + checkPassword + "," + phonenum);
        String message = "";
        if (username != null) {
            boolean isEmpty = username == "";
            if (isEmpty) {
                message = "{\"isSuccess\":" + !isEmpty + "}";
                return message;
            }
            boolean isExist = userService.FindUserByUsername(username);
            message = "{\"isSuccess\":" + !isExist + "}";
        }
        if (password != null & checkPassword == null) {
            boolean isEmpty = password == "";
            message = "{\"isSuccess\":" + !isEmpty + "}";
        }
        if (checkPassword != null) {
            boolean isEqual = checkPassword.equals(password);
            message = "{\"isSuccess\":" + isEqual + "}";
        }
        if (phonenum != null) {
            boolean isEmpty = phonenum == "";
            if (isEmpty) {
                message = "{\"isSuccess\":" + !isEmpty + "}";
            }
            String pattern = "^[1]([3-9])[0-9]{9}$";
            String content = phonenum;
            boolean isMatch = Pattern.matches(pattern, content);
            message = "{\"isSuccess\":" + isMatch + "}";
        }
        return message;
    }

    @PostMapping("/findPassword")
    public ModelAndView findPassword(User user, String checkPassword) {
        ModelAndView model = new ModelAndView();

        if (user.getUsername() == "" || user.getPassword() == "" || user.getPhonenum() == "" || checkPassword == "") {
            System.out.println("修改失败");
            model.addObject("error", "请填写好信息,不能留空!");
            model.setViewName("findPassword");
            return model;
        }
        if (!user.getPassword().equals(checkPassword)) {
            System.out.println("修改失败");
            model.addObject("error", "两次填写的密码不一致!");
            model.setViewName("findPassword");
            return model;
        }

        boolean temp = userService.UpdateUserPassword(user);
        if (temp) {
            System.out.println("修改成功");
            model.setViewName("login");
            return model;
        } else {
            System.out.println("修改失败");
            model.addObject("error", "填写信息有误,修改失败!");
            model.setViewName("findPassword");
            return model;
        }
    }

    @RequestMapping("/loginUser")
    public String loginUser(User user, Model model) {

        user = userService.FindUserByUsernameAndPassword(user);
        if (user == null) {
            System.out.println("登陆失败");
            model.addAttribute("error", "用户名或者密码错误!");
            return "login";
        } else {
            System.out.println("登陆成功");
            model.addAttribute("user",user);
            return "redirect:index";
        }
    }

    @RequestMapping("/logoutUser")
    public String logoutUser(ModelMap model, SessionStatus sessionStatus) {
        User user = (User) model.get("user");
        if (SessionManager.SessionMap.containsKey(user.getUsername())) {
            SessionManager.SessionMap.remove(user.getUsername());
        }
        sessionStatus.setComplete();
        return "redirect:/index";
    }

    @RequestMapping("/fail")
    public void fail() throws CustomException {
        System.out.println("fail()");
        try {
            int a=10/0;
        }catch(Exception e) {
            e.printStackTrace();
//            throw new Exception("系统出错了！");
            throw new CustomException("系统出错了！");
        }
    }

}
