package com.example.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Author ChiBaoBaoHuaiShuShu
 * @Date 2023/4/19 13:25
 * @PackageName:com.atguigu
 * @Description: 代码生成器
 * @Version 1.0
 */
public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mianshi? characterEncoding=utf-8&userSSL=false", "root", "a1978341673")
                .globalConfig(builder -> {
                    builder.author("ChiBaoBaoHuaiShuShu") // 设置作者
                             //.enableSwagger()// 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://GongZuo//IDEA//XianMu//MianShiTi//demo//src//main//java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名
                            //.moduleName("demo") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://GongZuo//IDEA//XianMu//MianShiTi//demo//src//main//resources//mapper"));// 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("record")
                            .addInclude("wallet");
                            //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker 引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
