package com.example.spring_movie_app.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 *  DataSourceをapplication.ymlの設定値を元に構成する
 */

@Configuration
@EnableConfigurationProperties(DataSourceConfigurationProperties.class)
public class DataSourceConfiguration {
    private final DataSourceConfigurationProperties properties;

    public DataSourceConfiguration(DataSourceConfigurationProperties properties) {
        this.properties = properties;
    }

    /**
     * データベース接続とコネクションプールの設定
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        //JDBCドライバ指定
        dataSource.setDriverClassName(this.properties.getDriverClassName());

        //接続情報
        dataSource.setUrl(this.properties.getUrl());
        dataSource.setUsername(this.properties.getUsername());
        dataSource.setPassword(this.properties.getPassword());

        //コネクション数設定
        dataSource.setInitialSize(this.properties.getInitialSize());
        dataSource.setMaxIdle(this.properties.getMaxIdle());
        dataSource.setMinIdle(this.properties.getMinIdle());

        return dataSource;
    }
}
