package com.example.service;

import com.example.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChiBaoBaoHuaiShuShu
 * @since 2023-05-18
 */
public interface IRecordService extends IService<Record> {

    /**
     * 查询用户钱包金额变动明细
     * @param wid
     * @param uid
     * @return
     */
    List<Record> selectWalletRecord(Integer wid, Integer uid);

}
