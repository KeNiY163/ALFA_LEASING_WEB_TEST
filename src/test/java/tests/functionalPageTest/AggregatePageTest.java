package tests.functionalPageTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AggregatePageCatalog;
import pages.components.HeaderAndFooter;
import utils.BaseTest;

@Epic("Тестирование каталога Альфа-Лизинг (UI)")
@Feature("Тестирование функционала на странице поисковой выдачи")
public class AggregatePageTest extends BaseTest {


    AggregatePageCatalog aggregatePageCatalog = new AggregatePageCatalog();

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка видимости блока перелинковки")
    @Test
    public void aggregateLinkBlockTest() {

        aggregatePageCatalog.openPageSearch().checkVisibleBrandsLink();

    }

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка добавления марки и корректности отображения блока перелиноквки")
    @Test
    public void aggregateAddBrandTest() {

        aggregatePageCatalog.openPageSearch().checkAddBrand();

    }

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка выбора города в модальном окне")
    @Test
    public void aggregateAddCityTest() {

        aggregatePageCatalog.openPageSearch().selectCityInModal();

    }

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка наличия офферов по выбранной марке после поиска")
    @Test
    public void aggregateSelectBrandTest() {

        aggregatePageCatalog.openPageSearch().checkOfferCard();

    }

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка добавления 2-х марок")
    @Test
    public void aggregateAddMoreBrandTest() {

        aggregatePageCatalog.openPageSearch().checkAddBrand();

    }

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверки блока фильтров. В них входят: выбор кузова, коробки, двигателя, привода, мощность, цена, цвет. Проверки наличия в карточках оффера выбранных фильтров.")
    @Test
    public void filterBlockTest() {

        aggregatePageCatalog.openPageSearch()
                .setTransmission()
                .setFuel()
                .setBodyType()
                .setDriveUnit()
                .setPowerFrom()
                .setPowerTo()
                .setPriceFrom()
                .setPriceTo()
                .setPowerTo()

                .applyFilters()

                .checkBodyType()
                .checkDriveUnit()
                .checkFuel()
                .checkTransmission();

    }

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка появления баннера \"Из других городов\" (кейс с городом и цветом), соответствие заголовка и подзаголовка, наличие табов города и цвета.")
    @Test
    public void checkBannerAtAggregatePageWithCityAndColor() {

        aggregatePageCatalog.openPageSearch()
                .checkBannerDiffCityAndColor();


    }

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка появления баннера \"Из других городов\" (кейс с 2-мя городами), соответствие заголовка и подзаголовка, наличие табов города и цвета.")
    @Test
    public void checkBannerAtAggregatePageWithCity() {

        aggregatePageCatalog.openPageSearch()
                .checkBannerDiffCity();


    }

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Owner("Keniy163")
    @DisplayName("Проверка появления баннера \"Из других городов\" (кейс с 2-мя городами), соответствие заголовка и подзаголовка, наличие табов 2-х цветов.")
    @Test
    public void checkBannerAtAggregatePageWithColorX2() {

        aggregatePageCatalog.openPageSearch()
                .checkBannerDiffColor();


    }

}
