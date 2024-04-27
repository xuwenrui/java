package com.frank.generate;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.frank.base.BaseEntity;
import com.google.gson.Gson;
import lombok.Setter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.Collections;

/**
 * @description: 类功能描述
 * @author: wuzhenzhao
 * @time 2020/7/15 14:45
 * @since 1.0
 **/
// mojo注解就是maven插件的注解
// 后面配置的是生命周期，我这里配置了PACKAGE，即默认是打包时候执行本插件（这个可以在pom文件指定）
@Mojo(name = "generator", defaultPhase = LifecyclePhase.PACKAGE)
public class CodeGeneratorMojo extends AbstractMojo {
    // 配置的是本maven插件的配置，在pom使用configration标签进行配置 property就是名字，
    // 在配置里面的标签名字。在调用该插件的时候会看到
    /**
     * 库名
     */
    @Setter
    @Parameter(property = "database")
    private String database;

    /**
     * 模块包
     * 例如:com.fn.auth
     */
    @Setter
    @Parameter(property = "modulePackage")
    private String modulePackage;

    @Parameter(defaultValue = "${project.build.directory}", property = "outputDir", required = true)
    private File outputDirectory;

    @Override
    public void execute() {
        if (outputDirectory != null) {
            System.out.println(outputDirectory.getParent());
        }
        String url = "jdbc:mysql://localhost:3306/hotpot?useSSL=false&serverTimezone=UTC";
        FastAutoGenerator.create(url, "root", "123456")
                .globalConfig(builder -> {
                    builder.author("system") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()
                            .outputDir(outputDirectory.getParent() + "/src/main/java/");
//                            .outputDir("D:\\frank-mybatis-plus-generator\\src\\main\\java\\");// 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
//                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
//                    if (typeCode == Types.SMALLINT) {
//                        // 自定义类型转换
//                        return DbColumnType.INTEGER;
//                    }
                    return typeRegistry.getColumnType(metaInfo);
                }))
                .packageConfig(builder -> {
                    builder.parent(modulePackage)
                            .moduleName("dao") // 设置父包模块名
                            .entity("entity")
                            .mapper("mapper")
                            .service("storage")
                            .serviceImpl("storage.impl")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, outputDirectory.getParent() + "/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> builder.addInclude() // 设置需要生成的表名
                        .entityBuilder()
                        .superClass(BaseEntity.class)
                        .disableSerialVersionUID()
                        .enableFileOverride()
                        .enableLombok()
                        // 忽略字段
                        .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
//                        .enableTableFieldAnnotation()   //字段别名注解
                        .formatFileName("%sEntity")) // 设置文件后缀
                .strategyConfig(builder -> builder.serviceBuilder()
                        .formatServiceFileName("%sDao")
                        .formatServiceImplFileName("%sDaoImpl")
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER); //不生成前端控制器, 其实还有另一种方案, 各位看了源码就知道了, 在AbstractTemplateEngine.outputController()方法中
                })
                .execute();
        System.out.println("generate successfully");
    }
}
