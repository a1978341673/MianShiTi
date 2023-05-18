package com.example.service;

import com.example.entity.Wallet;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChiBaoBaoHuaiShuShu
 * @since 2023-05-18
 */
public interface IWalletService extends IService<Wallet> {

    /**
     * 获取余额
     * @param uid
     * @return
     */
    public Double selectWalletMoney(Integer uid);

    /**
     * 消费扣款
     * @param wid
     * @param uid
     * @param money
     * @return
     */
    public boolean consumption(Integer wid,Integer uid,Double money);

    /**
     * 退款业务
     * @param wid
     * @param uid
     * @param money
     * @return
     */
    boolean refund(Integer wid, Integer uid, Double money);


}
