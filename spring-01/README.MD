## MEETING SPRING
### 概述：
Spring 轻量级的、是模块化的，允许您只使用您需要的那些部分
Spring 被设计为非侵入式的，这意味着您的域逻辑代码通常不依赖于框架本身。
在您的集成层（例如数据访问层）中，将存在对数据访问技术和 Spring 库的一些依赖关系。但是，应该很容易将这些依赖项与您的代码库的其余部分隔离开来。

> 参考文档 :
> 
> spring官方文档： https://docs.spring.io/spring-framework/docs/3.2.14.RELEASE/spring-framework-reference/html/index.html
> 
> Spring 框架概述

1.2.1 核心容器
核心容器由核心、bean、上下文和表达式语言模块组成。

Core 和 Beans模块提供了框架的基本部分，包括 IoC 和依赖注入特性。这 BeanFactory是工厂模式的复杂实现。它消除了对编程单例的需求，并允许您将依赖项的配置和规范与实际程序逻辑分离。

Context 模块建立在Core 和 Beans模块提供的坚实基础之上 ：它是一种以类似于 JNDI 注册表的框架样式方式访问对象的方法。Context 模块从 Beans 模块继承了它的特性，并增加了对国际化（例如使用资源包）、事件传播、资源加载以及通过例如 servlet 容器透明地创建上下文的支持。Context 模块还支持 Java EE 功能，例如 EJB、JMX 和基本远程处理。接口是 Context 模块的 ApplicationContext焦点。

表达式语言模块提供了一种强大的表达式语言，用于在运行时查询和操作对象图。它是 JSP 2.1 规范中指定的统一表达式语言（统一 EL）的扩展。该语言支持设置和获取属性值、属性分配、方法调用、访问数组的上下文、集合和索引器、逻辑和算术运算符、命名变量以及从 Spring 的 IoC 容器中按名称检索对象。它还支持列表投影和选择以及常见的列表聚合。

1.2.2 数据访问/集成
数据访问/集成层由 JDBC、ORM、OXM、JMS 和事务模块组成。

JDBC模块提供了一个 JDBC 抽象层，它消除了对数据库供应商特定错误代码进行繁琐的 JDBC 编码和解析的需要。

ORM模块为流行的对象关系映射 API 提供集成层，包括JPA、JDO、Hibernate和iBatis。使用 ORM 包，您可以将所有这些 O/R 映射框架与 Spring 提供的所有其他特性结合使用，例如前面提到的简单的声明性事务管理特性。

OXM模块提供了一个抽象层，支持 JAXB、Castor、XMLBeans、JiBX 和 XStream 的对象/XML 映射实现。

Java 消息服务 ( JMS ) 模块包含用于生成和使用消息的功能。

Transaction模块支持对实现特殊接口的类和所有 POJO（普通的旧 Java 对象）进行编程和声明式事务管理。

1.2.3 网页
Web层由Web、Web-Servlet、Web-Struts 和 Web-Portlet 模块组成。

Spring 的Web模块提供了基本的面向 Web 的集成功能，例如多部分文件上传功能以及使用 servlet 侦听器和面向 Web 的应用程序上下文初始化 IoC 容器。它还包含 Spring 远程支持的与 web 相关的部分。

Web-Servlet模块包含 Spring 用于 Web 应用程序的模型-视图-控制器 ( MVC ) 实现。Spring 的 MVC 框架在域模型代码和 Web 表单之间提供了清晰的分离，并与 Spring 框架的所有其他功能集成。

Web-Struts模块包含用于在 Spring 应用程序中集成经典 Struts Web 层的支持类。请注意，从 Spring 3.0 开始，此支持现已弃用。考虑将您的应用程序迁移到 Struts 2.0 及其 Spring 集成或 Spring MVC 解决方案。

Web-Portlet模块提供了在portlet 环境中使用的MVC 实现，并反映了Web-Servlet 模块的功能。

1.2.4 AOP 和仪表
Spring 的AOP模块提供了一个符合AOP Alliance的面向方面的编程实现，允许您定义例如方法拦截器和切入点，以干净地解耦实现应该分离的功能的代码。使用源级元数据功能，您还可以将行为信息以类似于 .NET 属性的方式合并到您的代码中。

单独的Aspects模块提供与 AspectJ 的集成。

Instrumentation模块提供类检测支持和类加载器实现以在某些应用程序服务器中使用。

1.2.5 测试
Test模块支持使用 JUnit 或 TestNG 测试 Spring 组件。它提供一致的 Spring ApplicationContexts 加载和这些上下文的缓存。它还提供了可用于单独测试代码的模拟对象。