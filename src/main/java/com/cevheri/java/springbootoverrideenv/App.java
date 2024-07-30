package com.cevheri.java.springbootoverrideenv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

@EnableConfigurationProperties({AppProperties.class, AppRoles.class, AppPaths.class})
@SpringBootApplication
public class App implements CommandLineRunner {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(App.class);
    private final AppPaths appPaths;
    private final AppRoles appRoles;
    private final AppProperties appProperties;

    public App(AppPaths appPaths, AppRoles appRoles, AppProperties appProperties) {
        this.appPaths = appPaths;
        this.appRoles = appRoles;
        this.appProperties = appProperties;
    }


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        Environment env = app.run(args).getEnvironment();
        initTreditionalWay(env);
    }


    @Override
    public void run(String... args) {
        log.info("********************************************************************");
        log.warn("Config Read Started with constructor injection!");
        log.warn("____________________________________________________________________");
        log.info("appProperties values with constructor injection");
        log.info("appProperties.getName: {}", appProperties.getName());
        log.info("appProperties.getVersion: {}", appProperties.getVersion());
        log.info("appProperties.getDescription: {}", appProperties.getDescription());
        log.info("appProperties.getAuthor: {}", appProperties.getAuthor());
        log.info("appProperties.getEmail: {}", appProperties.getEmail());
        log.warn("____________________________________________________________________");

        log.warn("AppRoles values with constructor injection");
        for (int i = 0; i < appRoles.getRoles().size(); i++) {
            log.info("appRoles.getRoles{}: {}", i, appRoles.getRoles().get(i));
        }

        log.warn("____________________________________________________________________");
        log.warn("AppPaths values with constructor injection");
        for (int i=0; i<appPaths.getPaths().size(); i++) {
            log.info("appPaths.getPaths{}.getMethod: {}", i, appPaths.getPaths().get(i).getMethod());
            for (int j=0; j<appPaths.getPaths().get(i).getRoles().size(); j++) {
                log.info("appPaths.getPaths{}.getRoles{}: {}", i, j, appPaths.getPaths().get(i).getRoles().get(j));
            }
        }
    }

    private static void initTreditionalWay(Environment env) {
        log.info("####################################################################");
        log.warn("Config Read Started with treditional way!");

        log.warn("--------------------------------------------------------------------");
        log.warn("App Properties With @Value Annotation");
        log.info("app-object.name: {}", env.getProperty("app-object.name"));
        log.info("app-object.version: {}", env.getProperty("app-object.version"));
        log.info("app-object.description: {}", env.getProperty("app-object.description"));
        log.info("app-object.author: {}", env.getProperty("app-object.author"));
        log.info("app-object.email: {}", env.getProperty("app-object.email"));
        log.info("--------------------------------------------------------------------");

        log.warn("App Roles With @Value Annotation");
        log.info("app-arrays.roles[0]: {}", env.getProperty("app-arrays.roles[0]"));
        log.info("app-arrays.roles[1]: {}", env.getProperty("app-arrays.roles[1]"));
        log.info("app-arrays.roles[2]: {}", env.getProperty("app-arrays.roles[2]"));
        log.info("app-arrays.roles[3]: {}", env.getProperty("app-arrays.roles[3]"));
        log.warn("--------------------------------------------------------------------");

        log.warn("App Paths With @Value Annotation");
        log.info("app-multiple.paths[0].method: {}", env.getProperty("app-multiple.paths[0].method"));
        log.info("app-multiple.paths[0].roles[0]: {}", env.getProperty("app-multiple.paths[0].roles[0]"));
        log.info("app-multiple.paths[0].roles[1]: {}", env.getProperty("app-multiple.paths[0].roles[1]"));
        log.info("app-multiple.paths[0].roles[2]: {}", env.getProperty("app-multiple.paths[0].roles[2]"));
        log.info("app-multiple.paths[0].roles[3]: {}", env.getProperty("app-multiple.paths[0].roles[3]"));
        log.info("app-multiple.paths[0].roles[4]: {}", env.getProperty("app-multiple.paths[0].roles[4]"));
    }

    // Calling java -jar with parameters
    //java -jar '-Dapp-object.name=overridden-name' '-Dapp-arrays.roles[0]=overridden-role-0' '-Dapp-multiple.paths[0].roles[0]=overridden-path-0-role-0' target/*.jar

}
