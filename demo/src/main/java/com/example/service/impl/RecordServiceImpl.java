package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.entity.Record;
import com.example.mapper.RecordMapper;
import com.example.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public List<Record> selectWalletRecord(Integer wid, Integer uid) {
        LambdaQueryWrapper<Record> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Record::getWid, wid).eq(Record::getUid, uid);

        return recordMapper.selectList(lqw);
    }

}
