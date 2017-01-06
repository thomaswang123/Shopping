package com.starlight.service;

import com.starlight.entity.Wallet;

/**
 * Created by james.jiang on 2016/12/26.
 * 用户钱包业务
 */
public interface IWalletService {

	/**
	 * 钱包注册
	 * @param wallet
	 */
	void registerWallet(Wallet wallet);
	/**
	 * 通过ID查找用户钱包信息
	 * @param userId	用户id
	 * @return	钱包信息
	 */
	Wallet findById(int userId);

	/**
	 * 修改金额
	 * @param wallet	钱包对象
	 */
	void updateMoney(Wallet wallet);
}
