import com.starlight.dao.*;
import com.starlight.entity.*;
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
                new ClassPathXmlApplicationContext("spring/springmvc.xml");
        /*	new FileSystemXmlApplicationContext("resources/spring/spring-mvc.xml");*/
        System.out.println(act);
        System.out.println(UserServiceImp);
	    IUserDao userdao = act.getBean(IUserDao.class);
        System.out.println(userdao);
        System.out.println("进来了");
        List<User> list = userdao.findAll();
        for (User lists : list) {
            System.out.println(lists.getId() + "," + lists.getPassword() + "," + lists.getAccount());
           /* System.out.println(lists.getuId() + "," + lists.getuName() + "," + lists.getuPwd());*/
        }
        User user = new User();
        user.setAccount("123456");
        user.setPassword("123456");
        int usertemp = userdao.login(user);
        System.out.println(usertemp);
        
        PassWordProtection pp = new PassWordProtection();
        pp.setId(2001);
        pp.setAnswer("啊哈哈");
            int pwptemp = Appliction.getAct().getBean(IChangePasswordDao.class).alterPWP(pp);
            System.out.println(pwptemp);
        String[] string = Appliction.getAct().getBean(IChangePasswordDao.class).findAnswerById(1001);
        for (int temp = 0; temp < string.length; temp++
                ) {
            System.out.println(string[temp]);}
            System.out.println(11%10);
        Paging paging = new Paging();
        paging.setPrice(300);
        paging.setRise(1);
        paging.setStop(10);
        int adminclasses = act.getBean(IAdminDao.class).findClassesById(1001);
        System.out.println(adminclasses);

     /*   Admin admin = new Admin();
        admin.setId(1001);
        admin.setClasses(2);
        System.out.println(act.getBean(IAdminDao.class).alterAdmin(admin));*/


      /*  System.out.println(act.getBean(IRepertoryDao.class).findIdNumber(1142));*/

        System.out.println(act.getBean(IGoodsDao.class).findByPrice(paging));
        Goods goods = new Goods();
     /*   User user = new User();
        user.setU_name("123456");
        user.setU_pwd("123456");
        if (userdao.login(user) != 0) {
            System.out.println("存在");
        }
        String string = "" ;
        int temp = 1;
        List<PasswordProtecTion> lists =
                Appliction.getAct().getBean(Change_PasswordDao.class).findQuestionById(1001);

        for (PasswordProtecTion lt:lists
                ) {
            string += "" + lt.getPp_question() ;
            if(temp<3) {
                string += ",";
            }
            temp ++;
        }
        System.out.println(string);*/

    }
}
