package com.yh.config;

import com.yh.multiDataSource.DataSourceEnum;
import com.yh.multiDataSource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * mybatis配置
 * Created by HR on 2018/5/3.
 */

@Configuration
//@EnableTransactionManagement
public class MybatisConfig {

    @Primary
    @Bean
    @Qualifier("base")
    @ConfigurationProperties(prefix = "datasource.master")
    public DataSource baseDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("book")
    @ConfigurationProperties(prefix = "datasource.slaver")
    public DataSource evalDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("local")
    @ConfigurationProperties(prefix = "datasource.local")
    public DataSource localDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("dynamicDatasource")
    public DynamicDataSource dynamicDataSource(@Qualifier("base") DataSource baseDataSource,
                                               @Qualifier("book") DataSource bookDataSource,
                                               @Qualifier("local") DataSource localDataSource){

        Map<Object, Object> targetDataSources = new HashMap();
        targetDataSources.put(DataSourceEnum.edu_zq, baseDataSource);
        targetDataSources.put(DataSourceEnum.Dblibrarynew, bookDataSource);
        targetDataSources.put(DataSourceEnum.local, localDataSource);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(baseDataSource);

        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDatasource") DynamicDataSource dynamicDataSource,
                                               @Value("mybatis.type-aliases-package") String typeAliasesPackage,
                                               @Value("${mybatis.mapperLocations}") String mapperLocations) throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        factoryBean.setDataSource(dynamicDataSource);

//        factoryBean.setTypeAliasesPackage(typeAliasesPackage);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        factoryBean.setConfiguration(configuration);

//        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
//
//        //添加插件
//        bean.setPlugins(new Interceptor[]{pageHelper});
//
//        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        try {
//            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//            return bean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }


        return factoryBean.getObject();
    }

    /**
     * 自定义事务
     * @return
     */

    @Bean
    @Qualifier("baseTransaction")
    public DataSourceTransactionManager baseTransaction(@Qualifier("dynamicDataSource") DataSource dynamicDataSource){
        return new DataSourceTransactionManager(dynamicDataSource);
    }

}
