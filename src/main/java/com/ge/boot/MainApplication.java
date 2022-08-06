package com.ge.boot;

import ch.qos.logback.core.db.DBHelper;
import com.ge.boot.bean.Pet;
import com.ge.boot.bean.User;
import com.ge.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.ge.boot")

public class MainApplication {
    public static void main(String[] args) {
        //1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3、从容器中获取组件
        Pet tommy01 = run.getBean("tommy",Pet.class);
        Pet tommy02 = run.getBean("tommy",Pet.class);
        System.out.println("组件"+(tommy01==tommy02));

        //4、
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);

        //5、获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("==============");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);


    }
}
