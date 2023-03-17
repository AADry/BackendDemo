import com.example.backendDemo.BackendDemoApplication;
import com.example.backendDemo.model.User;
import com.example.backendDemo.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.event.annotation.AfterTestMethod;
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
    @BeforeEach
    public void setUp() {
        for (int i = 0; i < 21; i++) {
            User user = new User("login", "password");
            userService.saveUser(user);
        }

    }
    @Test
    public void printUsersTest(){
        userService.printUsers();
        System.out.println();
    }
    @Test
    public void countUsersTest(){
        System.out.print("Количество пользователей = " + userService.countUsers());
        System.out.println();
    }

    @AfterEach
    public void cleanUp(){
        userService.deleteAll();
    }
}
