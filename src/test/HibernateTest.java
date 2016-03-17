import com.demo.entity.Category;
import com.demo.service.impl.CategoryServiceImpl;
import com.demo.service.impl.LogServiceImpl;
import com.demo.service.impl.UserServiceImpl;
import com.demo.service.intf.CategoryService;
import com.demo.service.intf.LogService;
import com.demo.service.intf.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yy on 2016/3/9.
 */
public class HibernateTest {
    public static void main(String[] args) {
        ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
    }

    @Test
    public void testLogin() {
        try {
            ApplicationContext a = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc-config.xml"});
            UserService userService = a.getBean(UserServiceImpl.class);
//            userService.checkLogin("yyy", "123");
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
//            userService.updUser(new User().setId(2).setAccount("yy").setSex("男").setBirthday("2016/03/14").setPhone("13456789009").setEmail("ttt@qq.com"));
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
    public void testLogList(){
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
