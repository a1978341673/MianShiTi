package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChiBaoBaoHuaiShuShu
 * @since 2023-05-18
 */
@Data
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易记录id
     */
    @TableId(value = "rid", type = IdType.AUTO)
    private Integer rid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 钱包id
     */
    private Integer wid;

    /**
     * 交易金额
     */
    private Double money;

    /**
     * 交易类型(1为消费，2为退款)
     */
    private Character type;

    /**
     * 交易时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    //标识乐观锁版本号字段
    @Version
    private Integer version;

    public Record() {
    }

    public Record(Integer uid, Integer wid, Double money, Character type, Date time) {
        this.uid = uid;
        this.wid = wid;
        this.money = money;
        this.type = type;
        this.time = time;
    }
}
