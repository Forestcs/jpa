package com.example.demo;

import com.example.demo.dao.UserRepository;
import com.example.demo.pojo.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
    @Autowired(required=false)
    UserRepository userRepository;
    @Autowired
    MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup()
    {
        this.mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    /*
     * @创建日期：2020年3月24日
     * @功能描述：测试dao层的查询操作
     * */
    @Test
    public void DaoFindAll() {
        userRepository.findAll();
    }

    /*
     * @创建日期：2020年3月24日
     * @功能描述：测试dao层的保存和更新操作
     * */
    @Test
    public void DaoSave() {
        User user = new User("张三", "123456", "zhangsan");
        User save = userRepository.save(user);
        System.out.println();
    }

    /*
     * @创建日期：2020年3月24日
     * @功能描述：测试dao层的删除操作
     * */
    @Test
    public void DaoDelete() {
        userRepository.deleteById(1+"");
    }


    /*
     * @throws Exception
     * @创建日期：2020年3月24日
     * @功能描述：测试Controller层的显示
     * */
    @Test
    public void testControllerList() throws Exception {
        String url="/findAll";
        MvcResult mvcResult=this.mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void contextLoads() {
    }

}
