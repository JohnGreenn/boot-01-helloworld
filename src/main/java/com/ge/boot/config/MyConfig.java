package com.ge.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.ge.boot.bean.Pet;
import com.ge.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、
 *      Lite(proxyBeanMethods = false)
 *      组件依赖：如果没有用到依赖，就用false比较轻量速度快
 * 4、@Import({User.class,DBHelper.class})
 *      给容器中自动创建出这俩个类型的组件、默认组件的名字就是全类名
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false) //告诉springboot这是一个配置类 == 配置文件
public class MyConfig {

    @Bean //给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型。返回值，就是组件在容器中的实例
    public User user01() {
        return new User("caleb",44);
    }

    @Bean("tommy")
    public Pet tommyPet() {
        return new Pet("tommy");
    }
}
