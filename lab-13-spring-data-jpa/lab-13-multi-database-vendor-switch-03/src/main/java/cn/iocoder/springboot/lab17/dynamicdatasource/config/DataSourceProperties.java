package cn.iocoder.springboot.lab17.dynamicdatasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lujq on 11/3/2021.
 */
@Component
@ConfigurationProperties("spring.datasource")
public class DataSourceProperties {
    private String driverClassName;

    private String url;

    private String username;

    private String password;

    private int maxPoolSize;

    private int minPoolSize;

    private String uniqueResourceName;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public String getUniqueResourceName() {
        return uniqueResourceName;
    }

    public void setUniqueResourceName(String uniqueResourceName) {
        this.uniqueResourceName = uniqueResourceName;
    }

    @Override
    public String toString() {
        return "PrimaryDataSourceProperties [driverClassName=" + driverClassName
                + ", url=" + url + ", username=" + username + ", password="
                + password + ", maxPoolSize=" + maxPoolSize + ", minPoolSize="
                + minPoolSize + ", uniqueResourceName=" + uniqueResourceName
                + "]";
    }
}
