package com.starlight.serviceimp;


import com.starlight.dao.IChangePasswordDao;
import com.starlight.dao.IUserDao;
import com.starlight.entity.Paging;
import com.starlight.entity.PassWordProtection;
import com.starlight.entity.User;
import com.starlight.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 * 用户业务实现类
 */
@Service
public class UserServiceImp implements IUserService {

    /**用户账号sql接口*/
    @Resource
    private IUserDao iUserDao;

    /**用户密保sql接口*/
    @Resource
    private IChangePasswordDao iChangePasswordDao;

    /**
     * 用户登陆
     * @param user  用户账号密码
     * @return  查找数据返回数量
     */
    @Transactional
    public int login(User user) {
        return iUserDao.login(user);
    }

    /**
     * 根据用户账号来查询id，用于判断账号是否存在
     * @param username 用户账号
     * @return  返回0或者非0数
     */
    @Transactional
    public int bynameGainId(String username) {
        return iUserDao.findIdByAccounUnmber(username);
    }

    /**
     * 用户注册
     * @param user  用户
     * @return  如果插入成功返回非0数，插入失败则反之
     */
    @Transactional
    public int register(User user) {
        iUserDao.register(user);
        return iUserDao.findIdByUser(user.getAccount());
    }

    /**
     * 添加密保
     * @param passWordProtection    密保对象
     */
    @Transactional
    public void addPWP(PassWordProtection passWordProtection){
        iChangePasswordDao.addPWP(passWordProtection);
    }

    /**
     * 通过账号查找是否存在该用户
     * @param account   账号
     * @return  用户集合
     */
    @Transactional
    public List<User> findAccount(String account){
        return iUserDao.findAccount(account);
    }

    /**
     * 通过ID查找用户账号
      * @param userId   用户
     * @return  用户
     */
    @Transactional
    public User findAccountById(int userId) {
        return iUserDao.findAccountById(userId);
    }

    /**
     * 根据账号条件来模糊查询的总数量
     * @param paging   分页对象
     * @return  分页数
     */
    @Transactional
    public int findByLikeNameNumber(Paging paging) {
        return iUserDao.findByLikeNameNumber(paging);
    }
}
