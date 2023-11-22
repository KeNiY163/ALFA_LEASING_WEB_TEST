package tests.elementsPageTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPageCatalog;
import pages.components.HeaderAndFooter;
import utils.BaseTest;

@Epic("Тестирование каталога Альфа-Лизинг (UI)")
@Feature("Тесты элементов на главной странице каталога")
public class MainPageElementsTest extends BaseTest {

    MainPageCatalog mainPageCatalog = new MainPageCatalog();
    HeaderAndFooter headerAndFooter = new HeaderAndFooter();

    @Story("Главная каталога")
    @Tag("SMOKE")
    @Tag("MAINPAGE")
    @Tag("ELEMENTSTEST")
    @Owner("Keniy163")
    @DisplayName("Проверка наличия элементов страницы и текстовок")
    @Test
    public void mainPage_element_test() {

        mainPageCatalog.openMainPage()
                .checkMainPageElementsVisible()
                .checkMainPageText();

    }

    @Story("Главная каталога")
    @Tag("SMOKE")
    @Tag("MAINPAGE")
    @Tag("ELEMENTSTEST")
    @Owner("Keniy163")
    @DisplayName("Проверка наличия всех элементов хедера/проверка правильности текстовок в элементах/проверка корректности ссылок в элементах")
    @Test
    public void headertest() {


        mainPageCatalog.openMainPage();
        headerAndFooter.checkHeaderElements()
                .checkFooterElements()
                .checkTextAndHrefHeader()
                .checkTextFooter();

    }

    @Story("Главная каталога")
    @Tag("SMOKE")
    @Tag("MAINPAGE")
    @Tag("ELEMENTSTEST")
    @Owner("Keniy163")
    @DisplayName("Проверка наличия всех элементов футера/проверка правильности текстовок в элементах/проверка корректности ссылок в элементах")
    @Test
    public void footertest() {

        mainPageCatalog.openMainPage();
        headerAndFooter.checkHeaderElements()
                .checkFooterElements()
                .checkTextAndHrefHeader()
                .checkTextFooter();

    }


}
