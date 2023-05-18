package com.example.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.Wallet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChiBaoBaoHuaiShuShu
 * @since 2023-05-18
 */
@Mapper
public interface WalletMapper extends BaseMapper<Wallet> {

    /**
     * 消费扣款
     * @param balance
     * @param uid
     * @param wid
     * @return
     */
    int consumption(@Param("wid") Integer wid, @Param("uid") Integer uid, @Param("balance") Double balance);

    /**
     * 退款服务
     * @param balance
     * @param uid
     * @param wid
     * @return
     */
    int refund(@Param("wid") Integer wid, @Param("uid") Integer uid, @Param("balance") Double balance);



}
