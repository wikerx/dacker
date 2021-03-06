SpringBoot的讲解就不在多说了，主要说一下多数据源切换的效果(读写分离)
这里的数据源切换指的是主节点执行修改，插入，删除等耗时操作，
从节点执行查询操作。
这里的master指的是主节点，一般来说数据库的主库，主库用来记录所有的数据
从库，依赖主库实时更新，用于执行查询操作，统计制图的操作。
所有默认在使用的时候都是使用的主库（mapper注解：@DataSource）
如果有使用其他的数据节点(数据源)，直接在对应的mapper的方法上面使用@DataSource("节点名称")  即可完成数据源的切换
两种配置通过使用mapper的两种写法都表示出来了。

测试地址1：http://localhost/dacker/test

测试地址2：http://localhost/dacker/testDefault

MySQL版本：8.0.15 + 如有需要请修改版本jar



还有一种主从切换指的是：主节点（数据库）出现异常，连接失败，立刻执行从库的连接从库数据库，
将所有的数据录入到从库，从库再将数据实时录入到主库（带主库恢复使用）


### 项目启动条件
>1.MySQL一主二从（可以再同一个库中划分）
>
>2.reids集群，至少3个节点-无密码访问
>
>3.RabbitMQ安装配置完善


### 新增附加内容：
> redis集群的集群注解的使用   -   搭建步骤自己百度，网上一大堆。
>
> RabbitMQ的配置及使用  -  搭建和配置网上一大堆，自己百度。
>
> Dubbo的简单使用，服务集成，
>
>
>
>
>
>


### 限流接口的使用
>请加上注解： @AnRateLimiter(timeout = 1, timeunit = TimeUnit.SECONDS)
>
>timeout:时间 默认1
>
>permitsPerSecond：单位时间内的最大请求数据-1
>
>timeunit:时间单位 默认秒
>
### 鉴权接口的使用
>使用场景一般为需要安全验证的数据接口
>
>请加上注解： @AuthRequired
>
>鉴权的详细处理方式可自己定义，位置为 com/scott/ds/limit/AuthorityInterceptor.java
>