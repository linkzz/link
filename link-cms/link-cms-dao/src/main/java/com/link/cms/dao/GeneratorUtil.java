package com.link.cms.dao;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

import javax.sql.DataSource;

/**
 * @ClassName: com.link.cms.dao.GeneratorUtil
 * @Description: ORM工具，生成数据库和实体的映射
 * @author: linkzz
 * @data: 2017-05-11 11:48
*/
public class GeneratorUtil {
    public static void main(String[] args) {
        //base model 所使用的包名
        String baseModelPackageName = "com.link.cms.model.base";
        //base model 保存路径
        String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/java/com/link/cms/model/base";

        //model 所使用的包名（MappingKit默认使用的包名）
        String modelPackageName = "com.link.cms.model";
        //model 文件保存路径（MappingKit 与 DataDictionary 文件默认保存路径）
        String modelOutputDir = baseModelOutputDir + "/..";

        //创建生成器
        Generator generator = new Generator(getDataSource(),baseModelPackageName,baseModelOutputDir,modelPackageName,modelOutputDir);
        //设置数据库方言
        generator.setDialect(new MysqlDialect());
        //设置是否在model中生成dao对象
        generator.setGenerateDaoInModel(true);
        //设置是否生成字典文件
        generator.setGenerateDataDictionary(true);
        // 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为 "User"而非 OscUser
        generator.setRemovedTableNamePrefixes("cms_");
        //生成
        generator.generate();
    }

    public static DataSource getDataSource() {
        Prop p = PropKit.use("config.properties");
        DruidPlugin dp = new DruidPlugin(p.get("jdbc_url"),p.get("jdbc_username"),p.get("jdbc_password"));
        dp.setValidationQuery(p.get("validationQuery"));
        dp.setDriverClass(p.get("driverClassName"));
        dp.start();
        return dp.getDataSource();
    }
}
