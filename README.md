### amor服务器文件配置
    1、服务器在 腾讯云  公网ip：49.234.76.112     root  dxt@1218
    2、服务器上mysql数据库： root 密码：1218
    3、服务器默认上传路径  resources:static-locations: file:/home/upload/
    4、静态资源路径  file:/home/static/ 
    5、自己做的网页  file:/home/templates/ 
### 模块介绍
    1、核心工具模块core  通用方法和通用类可以定里面
    2、用户模块amor-customer    端口待定 目前单模块 80
    预设计模块：
    如果要做分布式  基于Cloud；
    系统模块amor-system   负责后台管理系统  登陆以及配置 端口待定
    注册中心amor-eureka   服务注册和发现  端口待定 
    其他服务模块待创建
### 开发规范
    一、包命名规范
            1、功能包命名：com.amor.xxx 如用户：com.amor.customer
            2、controller 包命名:com.amor.customer.controller
            3、service 包命名:com.amor.customer.service
            4、service实现类 包命名:com.amor.customer.service.impl
            5、mapper 包命名:com.amor.customer.mapper
            6、bean 包命名:com.amor.customer.bean
    二、类继承（基于mybati-plus  可以看下demo 很方便 不影响mybatis正常编码操作）
        1、controller继承父类BaseController(base类目前未编写)
        2、sevice接口继承IService<T>
        3、sevice实现类继承ServiceImpl<M extends BaseMapper<T>, T>
        4、mapper继承BaseMapper<T> 
        5、状态码自己定义  可写 yml中配置 或者直接返回code、msg和data
          如 result{"code":0000,"msg"："成功"}
        6、model中dto作为方法内部调用类xxxDto,Entity数据库实体类xxxEntity，VO前端接收参数或自己定义param文件夹
    三、返回消息
        1、统一返回一个封装对象BaseResult对象(待定)
        2、返回都是json格式 如：{code: 402, message: "账号/密码错误", data: null}
    四、读写分离
        1、读写分离采用apo思想实现、故service实现类需满足命名规范、否则无法实现读写分离
        2、读方法需以select、list、get、load、find开头。如：selectUser()、finaUser()
    五、swagger API接口管理（准备搭建）
        1、所有controller需要添加文档注释
    六、统一日志
        暂未开发
    七、中间件
       1、redis 以及rabbitmq  都可以搭建 根据优化再使用
       2、redis直接作为缓存用  基于Redisson 框架封装处理（服务器待安装）
       3、mq以后作为状态同步或审核 再添加 （服务器待安装）
### 注意：
    1、maven管理 pom统一父类 作为依赖管理  各模块专有依赖 在自身pom文件中注入
    2、编写 备注要详细，方法上尽量写上思路，参数属性根据swagger注解 备注清楚，不清楚的去了解下swagger注解方法
    3、mapstruct的作用  对象转换 可以了解下 或者objectmapper 的对象转换
    4、log.info日志抛出  不要用 + 关联参数   用{}
    