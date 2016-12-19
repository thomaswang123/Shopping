import com.starlight.dao.UserDao;
import com.starlight.entity.UserEt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
public class Test {
@org.junit.Test
public void test() {
	ApplicationContext act =
				new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
		/*	new FileSystemXmlApplicationContext("resources/spring/spring-mvc.xml");*/
	System.out.println(act);
	UserDao userdao = act.getBean(UserDao.class);
	System.out.println("进来了");
	List<UserEt> list = userdao.findAll();
	for (UserEt lists : list) {
		System.out.println(lists.getU_id() + "," + lists.getU_name() + "," + lists.getU_pawd());
	}
}
}
