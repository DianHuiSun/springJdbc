package sun;

/**
 * Created by ddyunf on 2018/7/16.
 */

import com.alibaba.fastjson.JSON;
import com.sun.shop.entity.User;
import com.sun.shop.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by ddyunf on 2018/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUserService {
    private static final Logger LOGGER = Logger.getLogger(TestUserService.class);
    @Autowired
    private UserService userService;


    @Test
    public void testGetById() {
        //测试查询对应的用户
        User userInfo = userService.getById(9);
        LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,
                "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void testFindAll() {
        //测试查询全部用户
        List<User> userInfos = userService.findAll();
        for (User userInfo : userInfos) {
            LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,
                    "yyyy-MM-dd HH:mm:ss"));
        }
    }

    @Test
    public void testSave() {
        //测试保存用户数据
        User userInfo = new User();
        userInfo.setName("sundianhui");
        userInfo.setAge(99);
        userInfo.setRegisterTime(new Date());
        int result = userService.save(userInfo);
        LOGGER.info("result = " + result);
    }
}
