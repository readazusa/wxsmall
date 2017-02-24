package club.lovety.wx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * Created by 念梓  on 2016/11/21.
 * Email:sunmch@163.com
 * author: 念梓
 */
@Configuration
@EnableTransactionManagement
public class DataSourceSessionFactoryConfig {

    @Resource
    private DbConfig dbConfig;

    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dbConfig.getDriver());
        druidDataSource.setUrl(dbConfig.getUrl());
        druidDataSource.setUsername(dbConfig.getUsername());
        druidDataSource.setPassword(dbConfig.getPassword());
//        druidDataSource.
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean loadSqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDruidDataSource());
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/sql-map-config-mysql.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager loadPlatformTransactionManager() {
        return new DataSourceTransactionManager(getDruidDataSource());
    }

}
