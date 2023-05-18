package com.example.controller;


import com.example.entity.Resuit;
import com.example.mapper.RecordMapper;
import com.example.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ChiBaoBaoHuaiShuShu
 * @since 2023-05-18
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    IRecordService recordService;

    //查询用户钱包金额蝙蝠明显的接口
    @GetMapping("/selectWalletRecord/{wid}/{uid}")
    public Resuit selectWalletRecord(@PathVariable("wid")Integer wid, @PathVariable("uid")Integer uid) {

        return new Resuit(true,recordService.selectWalletRecord(wid, uid));
    }

}
