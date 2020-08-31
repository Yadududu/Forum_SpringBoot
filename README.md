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
```