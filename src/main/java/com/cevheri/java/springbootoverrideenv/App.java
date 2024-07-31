package com.cevheri.java.springbootoverrideenv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

@EnableConfigurationProperties({AppProperties.class, AppArrays.class, AppMultiple.class})
@SpringBootApplication
public class App implements CommandLineRunner {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(App.class);
    private final AppMultiple appMultiple;
    private final AppArrays appArrays;
    private final AppProperties appProperties;

    public App(AppMultiple appMultiple, AppArrays appArrays, AppProperties appProperties) {
        this.appMultiple = appMultiple;
        this.appArrays = appArrays;
        this.appProperties = appProperties;
    }


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        Environment env = app.run(args).getEnvironment();
        //initTreditionalWay(env);
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
        for (int i = 0; i < appArrays.getRoles().size(); i++) {
            log.info("appRoles.getRoles{}: {}", i, appArrays.getRoles().get(i));
        }

        log.warn("____________________________________________________________________");
        log.warn("AppPaths values with constructor injection");
        for (int i = 0; i< appMultiple.getPaths().size(); i++) {
            log.info("appPaths.getPaths{}.getMethod: {}", i, appMultiple.getPaths().get(i).getMethod());
            for (int j = 0; j< appMultiple.getPaths().get(i).getRoles().size(); j++) {
                log.info("appPaths.getPaths{}.getRoles{}: {}", i, j, appMultiple.getPaths().get(i).getRoles().get(j));
            }
        }
    }

    private static void initTreditionalWay(Environment env) {
        log.info("####################################################################");
        log.warn("Config Read Started with treditional way!");

        log.warn("--------------------------------------------------------------------");
        log.warn("App Properties With Environment Object");
        log.info("app-object.name: {}", env.getProperty("app-object.name"));
        log.info("app-object.version: {}", env.getProperty("app-object.version"));
        log.info("app-object.description: {}", env.getProperty("app-object.description"));
        log.info("app-object.author: {}", env.getProperty("app-object.author"));
        log.info("app-object.email: {}", env.getProperty("app-object.email"));
        log.info("--------------------------------------------------------------------");

        log.warn("App Roles With Environment Object");
        log.info("app-arrays.roles[0]: {}", env.getProperty("app-arrays.roles[0]"));
        log.info("app-arrays.roles[1]: {}", env.getProperty("app-arrays.roles[1]"));
        log.info("app-arrays.roles[2]: {}", env.getProperty("app-arrays.roles[2]"));
        log.info("app-arrays.roles[3]: {}", env.getProperty("app-arrays.roles[3]"));
        log.warn("--------------------------------------------------------------------");

        log.warn("App Paths With Environment Object");
        log.info("app-multiple.paths[0].method: {}", env.getProperty("app-multiple.paths[0].method"));
        log.info("app-multiple.paths[0].roles[0]: {}", env.getProperty("app-multiple.paths[0].roles[0]"));
        log.info("app-multiple.paths[0].roles[1]: {}", env.getProperty("app-multiple.paths[0].roles[1]"));
        log.info("app-multiple.paths[0].roles[2]: {}", env.getProperty("app-multiple.paths[0].roles[2]"));
        log.info("app-multiple.paths[0].roles[3]: {}", env.getProperty("app-multiple.paths[0].roles[3]"));
        log.info("app-multiple.paths[0].roles[4]: {}", env.getProperty("app-multiple.paths[0].roles[4]"));
        log.info("app-multiple.paths[0].roles[5]: {}", env.getProperty("app-multiple.paths[0].roles[5]"));
    }

    // Calling java -jar with parameters
    //java -jar '-Dapp-object.name=overridden-name' '-Dapp-arrays.roles[0]=overridden-role-0' '-Dapp-multiple.paths[0].roles[0]=overridden-path-0-role-0' target/*.jar

    //    java -jar \
    //            '-Dapp-object.name=overridden-name' \
    //            '-Dapp-arrays.roles[0]=new-array-role' \
    //            '-Dapp-multiple.paths[0].method=new-post' \
    //            '-Dapp-multiple.paths[0].roles[0]=new-method-role' \
    //    target/*.jar

    // docker run -p 8080:8080 \
    // -e APP_OBJECT_NAME=overridden-name \
    // -e APP_ARRAYS_ROLES_0=new-array-role \
    // -e APP_MULTIPLE_PATHS_0_METHOD=new-post \
    // -e APP_MULTIPLE_PATHS_0_ROLES_0=new-method-role \




}
