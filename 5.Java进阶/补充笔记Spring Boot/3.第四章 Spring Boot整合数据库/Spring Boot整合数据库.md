## Spring Boot整合数据库

-----

### 使用MySQL数据库

##### 数据库配置

###### application.properties

```properties
# mysql
# 数据库驱动
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
# 数据库地址
spring.datasource.url=jdbc:mysql://101.200.42.195:3306/easydb?useUnicode=true&characterEncoding=utf8&useSSL=false
# 数据库用户名
spring.datasource.username=root
# 数据库密码
spring.datasource.password=root

```

##### 依赖

```xml
 		<!-- mysql需要添加的依赖 -->
		<dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
```



### 使用SQL Server数据库

##### 数据库配置

###### application.properties

```properties
# SQL Server
# 数据库地址
spring.datasource.url=jdbc:sqlserver://192.168.16.218:1433;databaseName=dev_btrpawn
# 数据库用户名
spring.datasource.username=sa
# 数据库密码
spring.datasource.password=sa
# 数据库驱动
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServer
```

##### 依赖

```xml
		<!-- SQL Service需要添加的依赖 -->
		<dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <scope>runtime</scope>
        </dependency>
```



### 使用Orcale数据库

##### 配置

###### application.properties

```properties
# Oracle
# 数据库驱动
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
# 数据库地址
spring.datasource.url=jdbc:oracle:thin:@172.17.112.249:1521:orcl
# 数据库用户名
spring.datasource.username=sde
# 数据库密码
spring.datasource.password=sde
```

##### 依赖

```xml
		<!-- Orcale数据库需要添加的依赖 -->
        <dependency>
            <groupId>com.oracle.ojdbc</groupId>
            <artifactId>ojdbc8</artifactId>
            <scope>runtime</scope>
        </dependency>
```



### 使用MongoDB数据库

##### 配置

```properties
# MongoDB
# 无密码
#spring.data.mongodb.uri=mongodb://localhost:27017/test
# 有密码
spring.data.mongodb.uri=mongodb://root(username):root(password)@localhost(ip地址):27017(端口号)/test(collections/数据库)
```

##### 依赖

```xml
		<!-- MongoDB数据库依赖 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>	
```



### 使用Neo4j数据库

##### 配置

```properties
# Neo4j数据库
spring.data.neo4j.uri=http://localhost:7474
spring.data.neo4j.username=root
spring.data.neo4j.password=root
```

##### 依赖

```xml
		<!-- neo4j数据库依赖 -->
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-neo4j</artifactId>
        </dependency>
```



### 使用redis数据库

##### 配置

```properties
# Redis数据库配置
# Redis数据库索引，默认为0
spring.redis.database=0
# Redis服务器地址
spring.redis.host=localhost
# Redis服务器连接端口
spring.redis.port=6379
# Redis服务器连接密码
spring.redis.password=
# 连接池最大连接数，使用负值则表示没有任何限制
spring.redis.pool.max-active=8
# 连接池最大阻塞等待时间，使用负值则表示没有任何限制
spring.redis.pool.max-wait=-1
# 连接池中得最大空闲连接
spring.redis.pool.max-idle=8
# 连接池中得最小空闲连接
spring.redis.pool.min-idle=0
# 连接超时时间(毫秒)
spring.redis.timeout=0
```

##### 依赖

```xml
		<!-- redis数据库依赖 -->        
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
```



### 使用Mybatis数据库

##### 配置

```properties
# MyBatis配置
# 检查Mybatis配置文件是否存在
mybatis.check-config-location=true
# 配置文件位置：一般用于配置别名等信息
mybatis.config-location=classpath://mybatis/mybatis-config.xml
# mapper xml文件地址
mybatis.mapper-locations=classpath*:/mapper/*.xml
# 日志级别
logging.level.com.springboot.dao.UserMapper=debug
```

##### 依赖

```xml
		<!-- Mybatis依赖 -->
		<dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.0</version>
        </dependency>
```



### 使用Memcached数据库

> 略



### 数据库插件

##### Mybatis-Generator

> 略

##### PageHelper插件

> 略

##### Mybatis-Plus插件

> 略



### 配置多数据源

> 略



### 使用Druid数据库连接池

> 配置类设置：略
>
> > 还需要添加三个配置类

##### 配置

```properties
# 使用Druid时需要配置这一属性
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
# 连接池的配置信息
spring.datasource.druid.initial-size=5
spring.datasource.druid.min-idle=5
spring.datasource.druid.max-active=20
# 配置获取连接等待超时时间
spring.datasource.druid.max-evictable-idle-time-millis=60000
# 配置连接池中最小连接生成时间(毫秒)
spring.datasource.druid.min-evictable-idle-time-millis=300000
spring.datasource.druid.validation-query=SELECT 1 FROM DUAL
spring.datasource.druid.test-while-idle=true
spring.datasource.druid.test-on-borrow=false
spring.datasource.druid.test-on-return=false
# 打开PSCache，并且指定每个连接上PSCache的大小
spring.datasource.druid.pool-prepared-statements=true
spring.datasource.druid.max-pool-prepared-statement-per-connection-size=20
# 配置监控拦截的filters，去掉后监控界面sql无法统计，wall用于防火墙
spring.datasource.druid.filters=stat,wall,log4j
```

##### 依赖

```xml
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.16</version>
        </dependency>
```