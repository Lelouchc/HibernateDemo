import com.demo.service.intf.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yy on 2016/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc-config.xml")
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testGetUsers() {
        userService.getUsers();
    }

    @Test
    public void testGetUser() {
        userService.getUser(1);
    }
}
