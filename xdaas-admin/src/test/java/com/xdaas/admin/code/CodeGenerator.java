package com.xdaas.admin.code;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mathc
 * Created on 2020/10/21
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://xdaas.cn:3306/xdaas-admin?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("flowers2020");
        mpg.setDataSource(dsc);
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //这个勿乱改，dal项目的路径，后面也会用到
        final String projectPath = Thread.currentThread().getClass().getResource("/").getPath().replace("/target/classes/", "");
        gc.setOutputDir(projectPath + "/src/main/java/");
        //生成的类 文件头上的作者
        gc.setAuthor("mpg");
        //重要，如果是true，生成的类会 extends BaseDO<Model>
        //如果是 false 生成的类会 extends BaseDO
        gc.setActiveRecord(false);
        gc.setOpen(false);
        gc.setEnableCache(false);
        mpg.setGlobalConfig(gc);
        // 包配置
        final PackageConfig pc = new PackageConfig();
        pc.setModuleName("");//顶层包名
        pc.setParent("com.xdaas.admin.dal");
        pc.setEntity("dataobj");//实体包名
        pc.setMapper("mapper");
        pc.setService("repo");
        pc.setServiceImpl("repo.impl");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 输出Mapper.xml
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                String mapperName = tableInfo.getEntityName() + "Mapper.xml";
                if (mapperName.contains("DO")) {
                    mapperName = mapperName.replaceAll("DO", "");
                }
                return projectPath + "/src/main/resources/mybatis/" + mapperName;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //父类
        strategy.setSuperEntityClass("com.xdaas.admin.dal.dataobj.BaseDO");
        strategy.setEntityLombokModel(true);
        String[] tables = {"sys_user"};//要生成的表，官网说支持正则，但这个版本好像不支持
        strategy.setInclude(tables);
        strategy.setSuperEntityColumns("id", "created", "modified", "flag");//父类的属性
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        ConfigBuilder configBuilder = new ConfigBuilder(pc, dsc, strategy, templateConfig, gc);
        for (TableInfo tableInfo : configBuilder.getTableInfoList()) {
            tableInfo.setControllerName(null);
            tableInfo.setXmlName(null);
            tableInfo.setMapperName(tableInfo.getEntityName() + "Mapper");
            tableInfo.setServiceName(tableInfo.getEntityName() + "Repository");
            tableInfo.setServiceImplName(tableInfo.getEntityName() + "RepositoryImpl");
            tableInfo.setEntityName(strategy, tableInfo.getEntityName() + "DO");
        }
        mpg.setConfig(configBuilder);
        mpg.execute();
    }
}
