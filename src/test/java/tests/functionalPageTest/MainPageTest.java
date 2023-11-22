package tests.functionalPageTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPageCatalog;
import utils.BaseTest;

@Epic("Тестирование каталога Альфа-Лизинг (UI)")
@Feature("Тестирование функционала на главной странице каталога")
public class MainPageTest extends BaseTest {

    MainPageCatalog mainPageCatalog = new MainPageCatalog();

    @Story("Главная каталога")
    @Tag("SMOKE")
    @Tag("MAINPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка корректных переходов по списку городов на поисковую выдачу/проверка правильного отображения выбранного города из списка в хлебных крошках, поле город")
    @Test
    public void cityListTest() {

        mainPageCatalog.openMainPage()
                .checkMainPageCityList();

    }

    @Story("Главная каталога")
    @Tag("SMOKE")
    @Tag("MAINPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка корректных переходов по логотипам марок на поисковую выдачу/проверка правильного отображения выбранной марки из списка в хлебных крошках, заголовке, поле ввода")
    @Test
    public void brandTest() {

        mainPageCatalog.openMainPage()
                .checkMainPageBrand();

    }

    @Story("Главная каталога")
    @Tag("SMOKE")
    @Tag("MAINPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка корректных переходов по списку марок на поисковую выдачу/проверка правильного отображения выбранной марки из списка в хлебных крошках, заголовке, поле ввода марки")
    @Test
    public void brandListTest() {

        mainPageCatalog.openMainPage()
                .checkMainPageBrandList();

    }

    @Story("Главная каталога")
    @Tag("SMOKE")
    @Tag("MAINPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка корректного заполнения полей блока фильтров/переход на поисковую выдачу с выбранными параментрами/проверка отображения выбранных параметров")
    @Test
    public void filtersTest() {

        mainPageCatalog.openMainPage()
                .filterTest();
        mainPageCatalog.openMainPage()
                .filterEmptyTest();


    }

    @Story("Главная каталога")
    @Tag("SMOKE")
    @Tag("MAINPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка очищения фильтров и корректного перехода на поисковую выдачу")
    @Test
    public void filterClearTest() {

        mainPageCatalog.openMainPage()
                .checkFilterClear();

    }

}
