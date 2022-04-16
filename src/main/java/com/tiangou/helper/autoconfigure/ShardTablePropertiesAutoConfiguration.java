package com.tiangou.helper.autoconfigure;

import com.tiangou.helper.ShardTableProperties;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ShardTablePropertiesAutoConfiguration {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConfigurationProperties(
            prefix = "shard-table"
    )
    public ShardTableProperties shardTableProperties() {
        return new ShardTableProperties();
    }

}
