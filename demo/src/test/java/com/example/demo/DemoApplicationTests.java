package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.entity.Wallet;
import com.example.mapper.WalletMapper;
import com.example.service.IWalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    IWalletService walletService;

    @Autowired
    WalletMapper walletMapper;

    @Test
    void contextLoads() {
        LambdaQueryWrapper<Wallet> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Wallet::getUid, 1);
         System.out.println(walletMapper.selectOne(lqw));
    }

}
