package cn.imufeng.mufengblog;

import cn.imufeng.mufengblog.core.controller.BaseController;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collections;

/**
 * @author MuFeng
 * @since 2023-4-27 18:45:04
 */
public class MuFengCodeGenerate {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/second_hand_transaction", "root", "root")
                .globalConfig(builder -> builder.author("MuFeng")
                        .outputDir(System.getProperty("user.dir") + "\\src\\main\\java")
                        .commentDate("yyyy-MM-dd HH:mm:ss")
                        .enableSpringdoc()
                        .build())
                .packageConfig(builder -> builder.parent("cn.imufeng")
                        .moduleName("test")
                        .entity("entity")
                        .service("service")
                        .serviceImpl("service.impl")
                        .controller("controller")
                        .xml("mapper")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "\\src\\main\\resources\\mapper")))
                .strategyConfig(builder -> builder
                        /* 全局配置 */
                        //.addTablePrefix("mf_")

                        /* 实体配置 */
                        .entityBuilder()
                        .enableLombok()
                        .enableFileOverride()

                        /* 持久层配置 */
                        .mapperBuilder()
                        .enableFileOverride()
                        .enableBaseResultMap()
                        .superClass(BaseMapper.class)
                        .formatMapperFileName("%sMapper")
                        .mapperAnnotation(Mapper.class)
                        .formatXmlFileName("%sMapper")

                        /* 业务层配置 */
                        .serviceBuilder()
                        .enableFileOverride()
                        .formatServiceFileName("I%sService")
                        .formatServiceImplFileName("%sServiceImpl")

                        /* 接口层配置 */
                        .controllerBuilder()
                        .enableFileOverride()
                        .superClass(BaseController.class)
                        .enableRestStyle()
                        .build())
                .templateConfig(builder ->
                        builder
                                .entity("templates/entity.java")
                                .controller("templates/controller.java")
                                .service("templates/service.java")
                                .serviceImpl("templates/serviceImpl.java")
                                .mapper("templates/mapper.java")
                                .xml("templates/mapper.xml")
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}
