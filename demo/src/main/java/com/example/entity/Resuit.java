package com.example.entity;

import lombok.Data;

/**
 * @Author HuaiShuShu
 * @Date 2023/5/11 13:22
 * @PackageName:com.huaishushu.entity
 * @Description: 前后端数据传输统一的类
 * @Version 1.0
 */
@Data
public class Resuit {

    private Boolean flag;
    private Object data;
    private String msg;

    public Resuit(){}

    public Resuit(Boolean flag){
        this.flag = flag;
    }

    public Resuit(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }

    public Resuit(Boolean flag, String msg){
        this.flag = flag;
        this.msg = msg;
    }

    public Resuit(String msg){
        this.flag = false;
        this.msg = msg;
    }
}
