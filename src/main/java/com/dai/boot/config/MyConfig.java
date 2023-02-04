package com.dai.boot.config;

import com.dai.boot.bean.Car;
import com.dai.boot.bean.Pet;
import com.dai.boot.bean.User;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1.配置类里使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.MyConfig本身也是一个组件
 * 3.@Configuration(proxyBeanMethods = true)默认为true,容器中的MyConfig组件为代理对象，每次调用里面的bean
 *  方法时都会检查容器中是否存在,保持组件单实例。
 * 4.Full(@Configuration(proxyBeanMethods = true))
 *   Lite(@Configuration(proxyBeanMethods = false))
 * 5.@Import({User.class, Pet.class})
 *   给容器中自动创建出这两个类型的组件（调用无参构造），默认组件的名字是全类名
 * 6.@Conditional
 *      @ConditionalOnBean(name = "tom") 当容器中有tom组件时才会注册下面的bean(也可加在方法上)
 *       @@ConditionalOnMissingBean(name = "tom") 当容器中没有tom组件时才会注册下面的bean(也可加在方法上)
 * 7.@ImportResource("classpath:beans.xml") 导入配置文件中的配置到容器中
 * 8.@EnableConfigurationProperties(Car.class)
 *   1.开启Car配置绑定功能
 *   2.把Car这个组件自动注册到容器中
 *   Car为第三方组件时，第三方组件属性与SpringBoot核心配置类配置绑定。
 */
@Import({User.class, Pet.class})
@Configuration(proxyBeanMethods = true) // 告诉springboot这是个配置类 == 配置文件
@ConditionalOnBean(name = "tom")
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)
public class MyConfig {
    @Bean // 给容器添加组件，以方法名为组件id,返回类型为组件类型，返回的值就是组件在容器中的实例。
    public User user() {
        return new User("asd", 18);
    }

    @Bean("ttom")
    public Pet tom() {
        return new Pet("ttom");
    }
}
