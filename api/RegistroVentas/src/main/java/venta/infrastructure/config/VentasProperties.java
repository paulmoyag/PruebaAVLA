package venta.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ventas")
public class VentasProperties {
    private DataSourceProps ventasDataSource;

    public static class DataSourceProps{
        private String name;
        private String driverClassName;
        private String jdbcUrl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }

        public String getJdbcUrl() {
            return jdbcUrl;
        }

        public void setJdbcUrl(String jdbcUrl) {
            this.jdbcUrl = jdbcUrl;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        private String username;
        private String password;
    }

    public DataSourceProps getVentasDataSource() {
        return ventasDataSource;
    }

    public void setVentasDataSource(DataSourceProps ventasDataSource) {
        this.ventasDataSource = ventasDataSource;
    }
}
