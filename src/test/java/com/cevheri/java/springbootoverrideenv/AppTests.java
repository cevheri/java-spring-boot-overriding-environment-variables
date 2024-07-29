package com.cevheri.java.springbootoverrideenv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

// java -jar '-Dapp-properties.name=overridden-name' '-Dapp-roles[0]=overridden-role-0' '-Dapp-paths[0].roles[4]=overridden-path-0-role-0' target/*.jar

@SpringBootTest
@TestPropertySource(properties = {
        "app-properties.name=overridden-name",
        "app-roles[0]=overridden-role-0",
        "app-paths[0].roles[4]=overridden-path-0-role-0"
})
class AppTests {

    @Value("${app-properties.name:default-name}")
    private String appName;

    @Value("${app-roles[0]:default-role-0}")
    private String appRole0;

    @Value("${app-paths[0].roles[4]:default-path-0-role-4}")
    private String appPath0Role4;

    @Test
    void contextLoads() {
        System.out.println("Context Load");
    }

   @Test
    void whenOverrideAppPropertiesName_thenCorrect() {
        assert appName.equals("overridden-name");
    }

    @Test
    void whenOverrideAppRoles0_thenCorrect() {
        assert appRole0.equals("overridden-role-0");
    }

    @Test
    void whenOverrideAppPaths0Roles4_thenCorrect() {
        assert appPath0Role4.equals("overridden-path-0-role-0");
    }


}
