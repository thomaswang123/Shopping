import com.starlight.dao.UserDao;
import com.starlight.entity.User;
import com.starlight.serviceimp.UserServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
public class Test {

    @Resource
    private UserServiceImp UserServiceImp;

    public com.starlight.serviceimp.UserServiceImp getUserServiceImp() {
        return UserServiceImp;
    }

    public void setUserServiceImp(com.starlight.serviceimp.UserServiceImp userServiceImp) {
        UserServiceImp = userServiceImp;
    }

    @org.junit.Test
    public void test() {
        ApplicationContext act =
                new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
        /*	new FileSystemXmlApplicationContext("resources/spring/spring-mvc.xml");*/
        System.out.println(act);
        System.out.println(UserServiceImp);
	    UserDao userdao = act.getBean(UserDao.class);
        System.out.println(userdao);
        System.out.println("进来了");
        List<User> list = userdao.findAll();
        for (User lists : list) {
            System.out.println(lists.getU_id() + "," + lists.getU_name() + "," + lists.getU_pwd());
        }
        User user = new User();
        user.setU_name("123456");
        user.setU_pwd("123456");
        if (userdao.login(user) != 0) {
            System.out.println("存在");
        }


    }
}
