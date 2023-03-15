import com.example.backendDemo.BackendDemoApplication;
import com.example.backendDemo.model.User;
import com.example.backendDemo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = BackendDemoApplication.class)
public class AppTest {


    @Autowired
    DataSource dataSource;
    @Autowired
    UserServiceImpl userService;

    @Test
    public void connectionTest() throws SQLException {
        assertThat(dataSource.getConnection()).isNotNull();
        dataSource.getConnection().close();
    }
    @Test
    @Transactional
    @Rollback(value = true)
    public void insertTest(){
        User user = new User(1, "login", "password");
        userService.saveUser(user);
    }
    @Test
    public void userExistsTest(){
        User user = new User(1, "login", "password");
        User user2 = new User(1, "falseLogin", "password");

        assertEquals(true, user.getLogin().length() < 10 && user.getLogin().length() > 1);
        assertFalse(user.getLogin().contains("123") || user.getPassword().contains("~"));
        userService.saveUser(user);
        assertTrue(userService.isExists(user));
        assertFalse(userService.isExists(user2));
    }
}
