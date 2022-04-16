package com.tiangou.helper.autoconfigure;


import com.tiangou.helper.ShardTableInterceptor;
import com.tiangou.helper.ShardTableProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@AutoConfigureAfter(name = "com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration")
@ConditionalOnBean(SqlSessionFactory.class)
public class ShardTableHelperAutoConfiguration {

    public ShardTableHelperAutoConfiguration (List<SqlSessionFactory> sqlSessionFactories, ShardTableProperties properties) {
        this.properties = properties;
        addInterceptor(sqlSessionFactories);
    }

    private final ShardTableProperties properties;

    public void addInterceptor(List<SqlSessionFactory> sqlSessionFactories) {
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactories) {
            sqlSessionFactory.getConfiguration().addInterceptor(new ShardTableInterceptor(properties));
        }
    }

}


