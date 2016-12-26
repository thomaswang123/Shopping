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

	public Wallet findById(int uId) {
		return iWalletDao.findById(uId);
	}

	public void updateMoney(Wallet wallet) {
		iWalletDao.updateMoney(wallet);
	}
}
