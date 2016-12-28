package com.starlight.service;

import com.starlight.entity.Wallet;

/**
 * Created by james.jiang on 2016/12/26.
 */
public interface IWalletService {
	/**
	 * 通过ID查找用户钱包信息
	 * @param uId
	 * @return
	 */
	Wallet findById(int uId);

	/**
	 * 修改金额
	 * @param wallet
	 */
	void updateMoney(Wallet wallet);
}
