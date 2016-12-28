package com.starlight.serviceimp;

import com.starlight.dao.IWalletDao;
import com.starlight.entity.Wallet;
import com.starlight.service.IWalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by james.jiang on 2016/12/26.
 */
@Service
@Transactional
public class WalletServiceImp implements IWalletService {
	@Resource
	IWalletDao iWalletDao;

	//通过ID查找用户钱包信息
	public Wallet findById(int uId) {
		return iWalletDao.findById(uId);
	}

	//修改金额
	public void updateMoney(Wallet wallet) {
		  iWalletDao.updateMoney(wallet);
	}

}
