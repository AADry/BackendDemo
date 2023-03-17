import com.example.backendDemo.BackendDemoApplication;
import com.example.backendDemo.model.User;
import com.example.backendDemo.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
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


    @Before
    @Transactional
    public void setUp() {
        for (int i = 0; i < 21; i++) {
            userService.saveUser(new User("uLogin","uPassword"));
        }

    }
    @Disabled
    public void cleanUp(){
        for (int i = 0; i < 21; i++) {
            userService.deleteUser(new User("uLogin","uPassword"));
        }
    }
    @Test
    public void printAllUsers(){
        userService.printUsers();
    }
    @Test
    public  void countUsersTest(){
        System.out.println("Количество пользователей = " + userService.countUsers());
    }
}
