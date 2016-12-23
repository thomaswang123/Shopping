import com.starlight.dao.IChangePasswordDao;
import com.starlight.dao.IUserDao;
import com.starlight.dao.IUserinfoDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.*;
import com.starlight.serviceimp.UserServiceImp;
import com.starlight.util.Appliction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.Arrays;
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
        System.out.println(userdao.login(user));
        
      /*  PassWordProtection pp = new PassWordProtection();
        pp.setId(2001);
        pp.setAnswer("啊哈哈");
            int pwptemp = Appliction.getAct().getBean(IChangePasswordDao.class).alterPWP(pp);
            System.out.println(pwptemp);*/
    
        Wallet wallet = new Wallet();
        wallet.setId(1001);
        wallet.setPassword(123456);
        int walletemp = Appliction.getAct().getBean(IWalletDao.class).alertPayPwdById(wallet);
        System.out.println(walletemp);
        String[] string = Appliction.getAct().getBean(IChangePasswordDao.class).findAnswerById(1001);
        for (int i = 0; i <string.length ; i++) {
            System.out.println(string[i]);
        }
        System.out.println("哈哈".equals("哈哈"));
        Paging paging = new Paging();
        paging.setRise(0);
        paging.setStop(4);
        List<UserInfo> list1s = act.getBean(IUserinfoDao.class).byPagingfindAll(paging);
        for (UserInfo ls:list1s
             ) {
            System.out.println(ls.getNickname()+","+ls.getPhone()+","+ls.getSex()+ls.getAge()+ls.getUser().getAccount());
        }

        user.setAccount("654321");
        user.setPassword("123456");
            System.out.println("存在"+userdao.login(user));
            System.out.println(22%20);
      /*  String string = "" ;
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
