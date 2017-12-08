package com.nancy;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy
 * @Description: 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 * @author: guangfeng.zhou
 * @date: 2017/12/7 13:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-*.xml"})
// 模拟 servletContext 进行 MockMvc test
@WebAppConfiguration
public class BaseJunit {

}
