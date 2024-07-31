package com.cevheri.java.springbootoverrideenv;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app-multiple")
public class AppMultiple {

    private List<Path> paths;

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public static class Path {
        private String method;
        private List<String> roles;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }
    }
}