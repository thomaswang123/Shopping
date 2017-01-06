package com.starlight.serviceimp;

import com.starlight.dao.IWalletDao;
import com.starlight.entity.Wallet;
import com.starlight.service.IWalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * Created by thomas.wang on 2016/12/20.
 * 钱包业务实现类
 */
@Service
public class WalletServiceImp implements IWalletService {

	/**用户钱包sql接口*/
	@Resource
	private IWalletDao iWalletDao;

	/**
	 * 通过ID查找用户钱包信息
	 * @param userId	用户id
	 * @return	钱包信息
	 */
	@Transactional
	public Wallet findById(int userId) {
		return iWalletDao.findById(userId);
	}

	/**
	 * 修改金额
	 * @param wallet	钱包对象
	 */
	@Transactional
	public void updateMoney(Wallet wallet) {
		  iWalletDao.updateMoney(wallet);
	}

	/**
	 * 注册用户钱包
	 * @param wallet   用户钱包
	 */
	@Transactional
	public void registerWallet(Wallet wallet) {
		iWalletDao.register(wallet);
	}

}
