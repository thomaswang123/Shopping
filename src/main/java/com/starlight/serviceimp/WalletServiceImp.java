package com.starlight.serviceimp;

import com.starlight.dao.IWalletDao;
import com.starlight.entity.Wallet;
import com.starlight.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by james.jiang on 2016/12/26.
 */
@Service
public class WalletServiceImp implements IWalletService {
	@Autowired
	private IWalletDao iWalletDao;

	//通过ID查找用户钱包信息
	@Transactional
	public Wallet findById(int userId) {
		return iWalletDao.findById(userId);
	}

	//修改金额
	@Transactional
	public void updateMoney(Wallet wallet) {
		  iWalletDao.updateMoney(wallet);
	}

}
