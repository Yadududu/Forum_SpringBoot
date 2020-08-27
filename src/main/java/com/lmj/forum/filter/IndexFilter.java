package com.lmj.forum.filter;

import com.lmj.forum.model.Data;
import com.lmj.forum.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

@Component
public class IndexFilter implements Filter {

    @Autowired
    private DataService dataService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行过滤器");
        List<Data> datas = dataService.FindAllData();
        request.setAttribute("initDatas", datas);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
