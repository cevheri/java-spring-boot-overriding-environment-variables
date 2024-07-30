package com.cevheri.java.springbootoverrideenv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

// java -jar '-Dapp-object.name=overridden-name' '-Dapp-arrays.roles[0]=overridden-role-0' '-Dapp-multiple.paths[0].roles[0]=overridden-path-0-role-0' target/*.jar

@SpringBootTest
@TestPropertySource(properties = {
        "app-object.name=overridden-name",
        "app-arrays.roles[0]=overridden-role-0",
        "app-multiple.paths[0].roles[0]=overridden-path-0-role-0"
})
class AppTests {

    @Value("${app-object.name:default-name}")
    private String appName;

    @Value("${app-arrays.roles[0]:default-role-0}")
    private String appRole0;

    @Value("${app-multiple.paths[0].roles[0]:default-path-0-role-0}")
    private String appPath0Role0;

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private AppRoles appRoles;

    @Autowired
    private AppPaths appPaths;

    @Test
    void contextLoads() {
        System.out.println("Context Load");
    }

    //region traditional way
    @Test
    void whenAppPropertiesNameOverridden_thenSuccess() {
        assert appName.equals("overridden-name");
    }

    @Test
    void whenAppRolesRole0Overridden_thenSuccess() {
        assert appRole0.equals("overridden-role-0");
    }

    @Test
    void whenAppPathsPath0Role0Overridden_thenSuccess() {
        assert appPath0Role0.equals("overridden-path-0-role-0");
    }
    //endregion traditional way

    //region modern way
    @Test
    void whenAppPropertiesNameOverridden_thenSuccessModern() {
        assert appProperties.getName().equals("overridden-name");
    }

    @Test
    void whenAppRolesRole0Overridden_thenSuccessModern() {
        assert appRoles.getRoles().get(0).equals("overridden-role-0");
    }

    @Test
    void whenAppPathsPath0Role0Overridden_thenSuccessModern() {
        assert appPaths.getPaths().get(0).getRoles().get(0).equals("overridden-path-0-role-0");
    }
    //endregion modern way


}
