package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Record;
import com.example.entity.Wallet;
import com.example.mapper.RecordMapper;
import com.example.mapper.WalletMapper;
import com.example.service.IWalletService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChiBaoBaoHuaiShuShu
 * @since 2023-05-18
 */
@Service
@Transactional
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet> implements IWalletService {

    @Autowired
    private WalletMapper walletMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private WalletServiceImpl walletService;

    /**
     * 获取余额
     * @param uid
     * @return
     */
    @Override
    public Double selectWalletMoney(Integer uid) {
        LambdaQueryWrapper<Wallet> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Wallet::getUid, uid);
        return walletMapper.selectOne(lqw).getBalance();
    }

    /**
     * 消费扣款
     * @param wid
     * @param uid
     * @param money
     * @return
     */
    @Override
    public boolean consumption(Integer wid, Integer uid, Double money) {
        if (walletService.selectWalletMoney(uid) >= money) {
            Record record = new Record(wid, uid, money, '1', null);

            return walletMapper.consumption(wid, uid, money) > 0 && recordMapper.insert(record) > 0;
        }else{
            return false;
        }
    }

    /**
     * 退款业务
     * @param wid
     * @param uid
     * @param money
     * @return
     */
    @Override
    public boolean refund(Integer wid, Integer uid, Double money) {
        Record record = new Record(wid, uid, money, '2',null);

        return walletMapper.refund(wid, uid, money) > 0 && recordMapper.insert(record) > 0;
    }



}
