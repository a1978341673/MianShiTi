package com.example.controller;


import com.example.entity.Resuit;
import com.example.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ChiBaoBaoHuaiShuShu
 * @since 2023-05-18
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private IWalletService walletService;

    //查询用户钱包余额
    @GetMapping("/selectWalletMoney/{uid}")
    public Resuit selectWalletMoney(@PathVariable("uid")Integer uid) {
        Double balance = walletService.selectWalletMoney(uid);
        return new Resuit(true, balance);
    }

    //消费接口
    @PutMapping("consumption/{wid}/{uid}/{money}")
    public Resuit consumption(@PathVariable("wid")Integer wid,@PathVariable("uid")Integer uid,@PathVariable("money")Double money){
        boolean flag = walletService.consumption(wid, uid, money);
        return new Resuit(flag,flag ? "消费扣款成功^_^" : "余额不足，消费扣款失败-_-!");
    }

    //退款接口
    @PutMapping("refund/{wid}/{uid}/{money}")
    public Resuit refund(@PathVariable("wid")Integer wid,@PathVariable("uid")Integer uid,@PathVariable("money")Double money){
        boolean flag = walletService.refund(wid, uid, money);
        return new Resuit(flag,flag ? "退款操作成功^_^" : "退款操作失败-_-!");
    }



}
