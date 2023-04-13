package com.zhongyuan;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.zhongyuan.core.ProjectConstant;
import java.sql.Types;
import java.util.Collections;
import java.util.HashMap;

public class Generator {
    public static void main(String[] args) {
        final String projectPath = System.getProperty("user.dir");
        final String outPutDir = projectPath + "/src/main/java";
        final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&amp&allowMultiQueries=true";
        final String USER_NAME = "root";
        final String PASSWORD = "root";
        final String AUTHOR_NAME = "敢敢";

        final String TABLE_NAME = "user"; // 需要生成的表名，逗号分割

        FastAutoGenerator.create(URL, USER_NAME, PASSWORD)
            .globalConfig(builder -> {
                builder.author(AUTHOR_NAME) // 设置作者
                    .enableSwagger() // 开启 swagger 模式
                    .outputDir(outPutDir)// 指定输出目录
                    .disableOpenDir()
                ;
            })

            .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                if (typeCode == Types.SMALLINT) {
                    // 自定义类型转换
                    return DbColumnType.INTEGER;
                }
                return typeRegistry.getColumnType(metaInfo);

            }))
            .packageConfig(builder -> {
                builder.parent(ProjectConstant.BASE_PACKAGE) // 设置父包名
                    .moduleName(StrUtil.EMPTY) // 设置父包模块名
                    .pathInfo(new HashMap<OutputFile, String>(){{
                        put(OutputFile.xml, ProjectConstant.BASE_PATH + "/mapper");
                        put(OutputFile.entity, ProjectConstant.BASE_PATH + "/bean");
                        put(OutputFile.controller, ProjectConstant.BASE_PATH + "/controller");
                        put(OutputFile.service, ProjectConstant.BASE_PATH + "/service");
                        put(OutputFile.serviceImpl, ProjectConstant.BASE_PATH + "/service/impl");
                        put(OutputFile.mapper, ProjectConstant.BASE_PATH + "/mapper");
                    }})
                ;
            })
            .strategyConfig(builder -> {
                builder.addInclude(TABLE_NAME.split(",")) // 设置需要生成的表名
                    .addTablePrefix("t_", "c_") // 设置过滤表前缀
                    .serviceBuilder().formatServiceFileName("%sService") // 去掉I前缀
                    .entityBuilder().enableFileOverride() // 允许 entity 覆盖
                    .enableLombok() // lombok
                ;
            })
            .templateConfig(builder -> {
//                builder.controller(null);
//                builder.service(null);
//                builder.serviceImpl(null);
                builder.xml(null);
            })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
    }
}
