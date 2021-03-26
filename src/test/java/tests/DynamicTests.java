package tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DynamicTests {
    private final String BASE_URL = "https://github.com";

    @Test
    public void testDynamic() {
        open(BASE_URL);

        Allure.label("owner", "ebalakina");
        Allure.feature("Main menu");
        Allure.story("Menu Issue");
        Allure.description("Dynamic test");
    }
}

