package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChiBaoBaoHuaiShuShu
 * @since 2023-05-18
 */
@Data
public class Wallet implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 钱包id
     */
    @TableId(value = "wid", type = IdType.AUTO)
    private Integer wid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 余额
     */
    private Double balance;

    /**
     * 编码
     */
    private String encoding;

    //标识乐观锁版本号字段
    @Version
    private Integer version;

    public Wallet() {
    }

    public Wallet(Integer wid, Integer uid, Double balance, String encoding) {
        this.wid = wid;
        this.uid = uid;
        this.balance = balance;
        this.encoding = encoding;
    }
}
