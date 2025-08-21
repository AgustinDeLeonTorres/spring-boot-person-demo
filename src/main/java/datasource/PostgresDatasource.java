package datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresDatasource {

    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSourcePoolMetadata hikariDataSourcePoolMetadata () {
        return DataSourceBuilder
                .create()
                .type(HikariDataSourcePoolMetadata.class)
                .build();
    }
}
