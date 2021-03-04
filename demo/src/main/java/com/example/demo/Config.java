package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("demo")
public class Config implements InitializingBean{

    private String environment;

    private List<String> hosts = new ArrayList<>();

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    @Override
    public String toString() {
	return "Config [environment=" + environment + ", hosts=" + hosts + "]";
    }

    @Override
    public void afterPropertiesSet() {

        final List<String> messages = new ArrayList<>(4);
        if (environment.isBlank()) {
            messages.add("Non-null and not blank value expected for property environment");
        }

        if (CollectionUtils.isEmpty(hosts)) {
            messages.add("Non-null and not blank value expected for property hosts");
        }

        if (!messages.isEmpty()) {
            //add logger
            throw new IllegalArgumentException("Config properties is not properly configured. Please see logs for details.");
        }
    }
}
