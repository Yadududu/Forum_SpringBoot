package com.lmj.forum.controller;

import com.lmj.forum.model.Answer;
import com.lmj.forum.model.Data;
import com.lmj.forum.model.User;
import com.lmj.forum.service.AnswerService;
import com.lmj.forum.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;
    @Autowired
    private AnswerService answerService;

    @PostMapping("/addData")
    public String addData(Data data, HttpSession session){

        data.setAnsnum(0);
        User user = (User) session.getAttribute("user");
        data.setU_id(user.getId());
        data.setUser(user);

        Date date=new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        data.setDtime(time);

        data = dataService.InsertData(data);
        String dId = data.getId();
        if(dId=="") {
            System.out.println("发布失败");
            return "add";
        }else {
            System.out.println("发布成功");
            return "redirect:detailPara?dId="+dId;
        }
    }

    @RequestMapping("/addAnswer")
    public String addAnswer(Answer answer, String dId, HttpSession session){
        User user = (User) session.getAttribute("user");
        answer.setU_id(user.getId());
        answer.setD_id(dId);

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        answer.setAtime(time);

        answerService.InsertAnswer(answer);
        //回答数+1
        dataService.UpdateDataAnsnum(answer.getD_id(),1);

        return "redirect:detailPara?dId="+answer.getD_id();
    }

    @RequestMapping("/detailPara")
    public ModelAndView detail(String dId){
        ModelAndView model = new ModelAndView();
        //返回帖子内容
        Data data = dataService.FindDataById(dId);
        model.addObject("data", data);
        //返回回答内容
        List<Answer> answers=answerService.FindAllAnswer(dId);
        model.addObject("answers",answers);
        model.setViewName("detail");

        return model;
    }

    @RequestMapping("/deleData")
    public String deleData(String delId) {
        dataService.DeleteDataById(delId);
        return "redirect:../index";
    }

    @RequestMapping("/deleAnswer")
    public String deleAnswer(String delId,String dId) {
        answerService.DeleteAnswerById(delId);
        //回答数-1
        dataService.UpdateDataAnsnum(dId,-1);

        return "redirect:detailPara?dId="+dId;
    }
}
