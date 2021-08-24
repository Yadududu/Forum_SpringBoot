# Forum_SpringBoot
```
使用了Maven自动关联JAR包
在SpringBoot框架上整合了SSM(Spring+SpringMVC+Mybatis),还配置了Filter,Listener和exception
	使用了监听器(Listener)
		做了单点登录
	使用了过滤器(Filter)
		做了首页初始化
	使用SpringMVC与前端交互,前端通过jstl与el表达式获取数据
		使用了SpringMVC的过滤器做了未登录访问跳转到登录页
		自定义了Exception页面
	数据库使用mybatis操作数据库
		其中User,Data,Answer三个表分别配置了一对多,多对一的关系
		刷新首页查询数据库开启了2级缓存

nginx配置:
server {
        listen      80;
        server_name  forum.mylmj.top www.forum.mylmj.top;
        location / {
                proxy_pass http://127.0.0.1:8080/;
				index  index.html index.htm index.jsp;
        }
}
这样配置,访问地址为forum.mylmj.top/springbootforum

server {
        listen      80;
        server_name  forum.mylmj.top www.forum.mylmj.top;

        location / {
                proxy_pass http://127.0.0.1:8080/springbootforum/;
				index  index.html index.htm index.jsp;
        }
		location ~ .*\.(gif|jpg|jpeg|png|bmp|swf)$
        {
            #解决反向代理无法访问图片
            proxy_pass http://127.0.0.1:8080;
            proxy_set_header   Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;
    

            expires      30d;
        }
        location ~ .*\.(js|css)?$
        {
            #解决反向代理无法访问js,css
            proxy_pass http://127.0.0.1:8080;
            proxy_set_header   Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;

            expires      12h;
        }	
		location /springbootforum/
        {
            proxy_pass http://127.0.0.1:8080;
            proxy_set_header   Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;

            expires      12h;
        }
}
这样配置,访问地址为forum.mylmj.top不过,登出和添加日志返回登录页面会出现问题
```