import com.demo.entity.Category;
import com.demo.entity.User;
import com.demo.model.UserModel;
import com.demo.service.impl.CategoryServiceImpl;
import com.demo.service.impl.LogServiceImpl;
import com.demo.service.impl.UserServiceImpl;
import com.demo.service.intf.CategoryService;
import com.demo.service.intf.LogService;
import com.demo.service.intf.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by yy on 2016/3/9.
 */
public class HibernateTest {
    public static void main(String[] args) {
        Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);
    }

    @Test
    public void testLogin() {
        try {
            ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
            UserService userService = a.getBean(UserServiceImpl.class);
//            userService.checkLogin(new UserLogin().setAccount("yy").setPassword("1"));
            Optional<User> userOptional = userService.getUser(2);
            if (userOptional.isPresent())
                System.out.println(userOptional.get());
            else
                System.out.println("用户不存在");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testRegister() {
        try {
            ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
            UserService userService = a.getBean(UserServiceImpl.class);
            userService.addUser(new UserModel().setAccount("yy").setPassword("123"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testUserList() {
        try {
            ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
            UserService userService = a.getBean(UserServiceImpl.class);
            userService.getUsers().forEach(System.out::println);
            System.out.println(userService.getUser(1).get());
//            UserJpa userJpa = a.getBean(UserJpaImpl.class);
//            userJpa.getUsers().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCheckUser() {
        try {
            ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
            UserService userService = a.getBean(UserServiceImpl.class);
            System.out.println(userService.countUser());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testUpdUser() {
        try {
            ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
            UserService userService = a.getBean(UserServiceImpl.class);
            userService.updUserWithVersion(new UserModel().setId(1).setUsername("yyyyy").setSex("male"));
//            userService.updUser(new UserModel().setId(1).setAccount("yy").setSex("男").setBirthday("2016/03/14").setPhone("13456789009").setEmail("ttt@qq.com").setVersion(0));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddCategory() {
        try {
            ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
            CategoryService categoryService = a.getBean(CategoryServiceImpl.class);
            categoryService.addCategory(new Category().setName("test1"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testUpdCategory() {
        try {
            ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
            CategoryService categoryService = a.getBean(CategoryServiceImpl.class);
            categoryService.updCategory(new Category().setName("test1").setBlogcount(2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDelCategory() {
        try {
            ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
            CategoryService categoryService = a.getBean(CategoryServiceImpl.class);
            categoryService.delCategory(new Category().setName("test1"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testLogList() {
        try {
            ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
            LogService logService = a.getBean(LogServiceImpl.class);
            logService.getLogs().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
