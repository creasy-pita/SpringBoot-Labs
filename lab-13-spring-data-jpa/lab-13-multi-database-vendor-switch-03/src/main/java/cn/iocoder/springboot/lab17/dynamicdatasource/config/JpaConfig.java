package cn.iocoder.springboot.lab17.dynamicdatasource.config;

import cn.iocoder.springboot.lab17.dynamicdatasource.constant.DBConstants;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = DBConstants.ENTITY_MANAGER_FACTORY_USERS,
        transactionManagerRef = DBConstants.TX_MANAGER_USERS,
        basePackages = {"cn.iocoder.springboot.lab17.dynamicdatasource.repository"}) // 设置 Repository 接口所在包
public class JpaConfig {


    @Resource
    private JpaProperties jpaProperties;

    @Resource
    private DataSourceProperties dataSourceProperties;

    /*
     * 需要自己构造，虽然不构造则JPA会自动建立，但是发现会报循环引用的异常
     * 这里目前只配置了一个，给所有数据源通用，
     * 如果各数据源配置需要不同，则分别配置多个JpaVendorAdapter
     */
    @Bean
    @Primary
    public JpaVendorAdapter primaryJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(jpaProperties.isShowSql());
        hibernateJpaVendorAdapter.setGenerateDdl(jpaProperties.isGenerateDdl());
        hibernateJpaVendorAdapter.setDatabase(jpaProperties.getDatabase());
        return hibernateJpaVendorAdapter;
    }
    /**
     * 创建 users 数据源
     */
    @Bean(name = "usersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.users")
    public DataSource dataSource() {
        //或者使用 AtomikosDataSourceBean
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        return dataSource;

    }

    /**
     * 创建 LocalContainerEntityManagerFactoryBean
     */
    @Bean(name = DBConstants.ENTITY_MANAGER_FACTORY_USERS)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        /*★★★★★这里set数据源千万要注意:如果没有使用JTA事务，单纯只是多数据源，那么这里要setDataSource，而不是setJtaDataSource
         * 否则会报错，我这里因为用的是Atomikos JTA事务，所以setJtaDataSource。
         */
        entityManager.setJtaDataSource(this.dataSource());
        entityManager.setJpaVendorAdapter(primaryJpaVendorAdapter());
        entityManager.setPackagesToScan("cn.iocoder.springboot.lab17.dynamicdatasource.dataobject");
//        entityManager.setPackagesToScan("com.ctrip.framework.apollo.common.entity");
//        entityManager.setPersistenceUnitName("usersPersistenceUnit");
        entityManager.setPersistenceUnitName("usersPersistenceUnit02");
        entityManager.setJpaPropertyMap(jpaProperties.getProperties());

//        return builder
//                .dataSource(this.dataSource()) // 数据源
//                .properties(hibernateVendorProperties) // 获取并注入 Hibernate Vendor 相关配置
//                .packages("cn.iocoder.springboot.lab17.dynamicdatasource.dataobject") // 数据库实体 entity 所在包
////                .persistenceUnit("usersPersistenceUnit") // 设置持久单元的名字，需要唯一
//                .persistenceUnit("usersPersistenceUnit02") // 设置持久单元的名字，需要唯一
//                .build();

        return entityManager;
    }

    /**
     * 创建 PlatformTransactionManager
     */
    @Bean(name = DBConstants.TX_MANAGER_USERS)
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
}
