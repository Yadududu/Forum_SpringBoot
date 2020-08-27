package com.lmj.forum;

import com.lmj.forum.model.Data;
import com.lmj.forum.service.DataService;
import com.lmj.forum.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ForumApplicationTests {

    @Autowired
    DataService dataService;

    @Test
    void contextLoads() {
        List<Data> datas = dataService.FindAllData();
        datas.forEach(data -> System.out.println(data));
    }

    @Test
    void Test1() {
        List<Data> datas = dataService.FindAllData();
        datas.forEach(data -> System.out.println(data));
    }
}
