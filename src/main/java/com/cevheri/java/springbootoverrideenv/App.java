package com.cevheri.java.springbootoverrideenv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class App {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        Environment env = app.run(args).getEnvironment();
        init(env);
    }

    private static void init(Environment env) {
        log.info("App Started!");
        log.warn("Reading properties from environment variables");

        log.info("------------------------------------");
        log.warn("App Properties");
        log.info("app-properties.name: {}", env.getProperty("app-properties.name"));
        log.info("app-properties.version: {}", env.getProperty("app-properties.version"));
        log.info("app-properties.description: {}", env.getProperty("app-properties.description"));
        log.info("app-properties.author: {}", env.getProperty("app-properties.author"));
        log.info("app-properties.email: {}", env.getProperty("app-properties.email"));
        log.info("------------------------------------");

        log.warn("App Roles");
        log.info("app-roles[0]: {}", env.getProperty("app-roles[0]"));
        log.info("app-roles[1]: {}", env.getProperty("app-roles[1]"));
        log.info("app-roles[2]: {}", env.getProperty("app-roles[2]"));
        log.info("app-roles[3]: {}", env.getProperty("app-roles[3]"));
        log.info("------------------------------------");

        log.warn("App Paths");
        log.info("app-paths[0].method: {}", env.getProperty("app-paths[0].method"));
        log.info("app-paths[0].roles[0]: {}", env.getProperty("app-paths[0].roles[0]"));
        log.info("app-paths[0].roles[1]: {}", env.getProperty("app-paths[0].roles[1]"));
        log.info("app-paths[0].roles[2]: {}", env.getProperty("app-paths[0].roles[2]"));
        log.info("app-paths[0].roles[3]: {}", env.getProperty("app-paths[0].roles[3]"));
        log.info("app-paths[0].roles[4]: {}", env.getProperty("app-paths[0].roles[4]"));
        log.info("------------------------------------");

        log.info("App Loaded!");
    }

    // Calling java -jar with parameters
    //java -jar '-Dapp-properties.name=overridden-name' '-Dapp-roles[0]=overridden-role-0' '-Dapp-paths[0].roles[4]=overridden-path-0-role-0' target/*.jar

}
