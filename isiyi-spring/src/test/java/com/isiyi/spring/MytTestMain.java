package com.isiyi.spring;

import com.isiyi.spring.pojo.MyTestBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: MytTestMain
 * @author: 向鹏飞
 * @since: 2021/7/10
 */
public class MytTestMain {


    @Test
    public void testMyTestBean(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean myTest = (MyTestBean) beanFactory.getBean("myTest");
        System.out.println(myTest.getTestStr());
    }
}
