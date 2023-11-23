package pages;

import api.requests.ActualOfferAggregate;
import api.requests.BrandList;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utils.TestData;

import java.util.ArrayList;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class MainPageCatalog {

    private final SelenideElement

            breadCrumbsContainerSvg = $("[data-test-id = 'bread-crumbs-container'] svg"),
            mainTitleH1 = $(By.xpath("//div[contains(@class, 'main_titlesBlock')]/h1")),
            mainTitleH4 = $(By.xpath("//div[contains(@class, 'main_titlesBlock')]/h4")),
            mainBackgroundImage = $(By.xpath("//div[contains(@class, 'main_backgroundImage')]")),
            searchBar = $(By.xpath("//div[contains(@class, 'search-bar')]")),
            filterCity = $("[data-test-id = 'catalog-main-city'] input"),
            filterType = $("[data-test-id = 'catalog-main-vehicle-type'] input"),
            filterBrand = $("[data-test-id = 'catalog-main-brand'] input"),
            filterModel = $("[data-test-id = 'catalog-main-models'] input"),
            filterSearchButton = $("[data-test-id = 'catalog-main-search-button']"),
            popularBrandContainer = $("[data-test-id = 'popular-brands-container']"),
            brandListContainer = $("[data-test-id = 'brands-list-container']"),
            marketingBanner = $(By.xpath("//div[contains(@class, 'marketing-banner')]")),
            markeningBannerH3 = $(By.xpath("//div[contains(@class, 'marketing-banner')]/h3")),
            marketingBannerH3Sub = $(By.xpath("//div[contains(@class, 'marketing-banner_bannerSubtitle')]")),
            marketingBannerButton = $("[data-test-id = 'marketing-banner-button']"),
            cityLinkBlockContainer = $("[data-test-id = 'city-links-block-container']"),
            pageTitleContainerH1 = $("[data-test-id = 'page-title-container'] h1"),
            brand_select_desktop_input = $("[data-test-id = 'brand-select-desktop_0'] input"),
            model_select_desktop_input = $("[data-test-id = 'model-select-desktop_0'] input"),
            citySelectionContainer = $("[data-test-id = 'city-selection-container'] button span").sibling(0),
            catalog_main_city_input = $("[data-test-id = 'catalog-main-city'] input"),
            catalog_main_city_option_list = $("[data-test-id = 'catalog-main-city-options-list'] "),
            catalog_main_brand_input = $("[data-test-id = 'catalog-main-brand'] input"),
            catalog_main_brand_option_list = $("[data-test-id = 'catalog-main-brand-options-list'] "),
            catalog_main_models_input = $("[data-test-id = 'catalog-main-models'] input"),
            model_links_block_container = $("[data-test-id = 'models-links-block-container']");


    private final ElementsCollection

            bread_crumbs = $$("[data-test-id = 'bread-crumbs-container'] span"),
            popular_brand_item = $$("[data-test-id = 'popular-brands-container'] a"),
            logo_brand = $$("[data-test-id = 'popular-brands-container'] a"),
            logo_name = $$x("//div[@data-test-id = 'popular-brands-container']//a//div//span[contains(@class, 'styles_brandName')]"),
            bread_crumbs_at_search_page = $$("[data-test-id = 'bread-crumbs-container'] li a"),
            brand_list_item = $$("[data-test-id = 'brands-list-container'] a"),
            brand_list_name = $$("[data-test-id = 'brands-list-container'] a span"),
            city_list_item = $$("[data-test-id = 'city-links-block-container'] a"),
            city_list_name = $$("[data-test-id = 'city-links-block-container'] a span"),
            catalog_main_city_option_list_div = $$("[data-test-id = 'catalog-main-city-options-list'] div div"),
            catalog_main_brand_option_list_div = $$("[data-test-id = 'catalog-main-brand-options-list'] div div"),
            catalog_main_models_option_list = $$("[data-test-id = 'catalog-main-models-options-list'] label"),
            clearButtonOnFilters = $$("div[title='Очистить'] svg");


    TestData data = new TestData();


    @Step("Открытие главной страницы каталога")
    public MainPageCatalog openMainPage() {

        open("/");

        return this;

    }

    @Step("Проверка видимости элементов главной страницы каталога")
    public MainPageCatalog checkMainPageElementsVisible() {

        breadCrumbsContainerSvg.shouldBe(visible);
        mainBackgroundImage.shouldBe(visible);
        searchBar.shouldBe(visible);
        mainTitleH1.shouldBe(visible);
        mainTitleH4.shouldBe(visible);
        popularBrandContainer.shouldBe(visible);
        brandListContainer.shouldBe(visible);
        marketingBanner.shouldBe(visible);
        markeningBannerH3.shouldBe(visible);
        marketingBannerH3Sub.shouldBe(visible);
        marketingBannerButton.shouldBe(visible);
        cityLinkBlockContainer.shouldBe(visible);

        filterCity.shouldBe(visible);
        filterType.shouldBe(visible);
        filterBrand.shouldBe(visible);
        filterModel.shouldBe(visible);
        filterSearchButton.shouldBe(visible);


        return this;

    }

    @Step("Проверка текстовок на главной странице")
    public void checkMainPageText() {

        bread_crumbs.get(0).shouldHave(text(data.breadCrumbsAlfa));
        bread_crumbs.get(1).shouldHave(text(data.getBreadCrumbsCatalog));

        mainTitleH1.shouldHave(text(data.mainTitleH1Text));
        mainTitleH4.shouldHave(text(data.mainTitleH4Text));

        filterSearchButton.shouldHave(text(data.mainButtonText));

        Assertions.assertEquals(popular_brand_item.size(), 9);

        int offer = ActualOfferAggregate.reqOfferWithReservation();

        if (offer > 0) {

            markeningBannerH3.shouldHave(text(data.marketingBannerH3Text));
            marketingBannerH3Sub.shouldHave(text(data.marketingBannerH3SubText));
            marketingBannerButton.shouldHave(attribute("href", data.urlIsReservationOnline));


        }

    }

    @Step("Получение ссылки")
    public String getLogoHref(int i) {

        return logo_brand.get(i).getAttribute("href");

    }

    @Step("Получение имени марки из логотипа")
    public String getLogoName(int i) {

        return logo_name.get(i).innerText();

    }

    @Step("Получение ссылки из общего списка марок")
    public String getBrandListHref(int i) {

        return brand_list_item.get(i).getAttribute("href");

    }

    @Step("Получение имени марки из списка")
    public String getBrandListName(int i) {

        return brand_list_name.get(i).innerText();

    }

    @Step("Получение ссылки города")
    public String getCityHref(int i) {

        return city_list_item.get(i).getAttribute("href");

    }

    @Step("Получение имени города из списка")
    public String getCityListName(int i) {

        return city_list_name.get(i).innerText();

    }

    @Step("Переход на поисковую выдачу из логотипов и проверка поля ввода/хлебных крошек")
    public void checkMainPageBrand() {

        int brand_logo_temp = logo_brand.size();

        for (int i = 0; i < brand_logo_temp; i++) {

            String logo_href_temp = getLogoHref(i);
            String logo_name_temp = getLogoName(i);

            logo_brand.get(i).shouldBe(visible).click();

            sleep(1500);

            Assertions.assertEquals(url(), logo_href_temp);

            pageTitleContainerH1.shouldHave(text("Автомобили " + logo_name_temp + " в лизинг"));
            brand_select_desktop_input.shouldHave(value(logo_name_temp));

            model_links_block_container.shouldBe(visible);

            bread_crumbs_at_search_page.get(2).shouldHave(text(logo_name_temp));
            bread_crumbs_at_search_page.get(1).shouldBe(visible).click();

            sleep(1500);

        }

    }

    @Step("Переход на поисковую выдачу из списка марок и проверка поля ввода/хлебных крошек")
    public void checkMainPageBrandList() {

        int brand_list_item_temp = brand_list_item.size();

        //вручную ограничено, чтобы не затягивать тест (без ограничения бегает всему массиву)

        for (int i = 0; i < 5; i++) {

            String brandList_href_temp = getBrandListHref(i);
            String brandList_name_temp = getBrandListName(i);

            brand_list_item.get(i).shouldBe(visible).click();

            sleep(1500);

            Assertions.assertEquals(url(), brandList_href_temp);

            pageTitleContainerH1.shouldHave(text("Автомобили " + brandList_name_temp + " в лизинг"));
            brand_select_desktop_input.shouldHave(value(brandList_name_temp));

            model_links_block_container.shouldBe(visible);

            bread_crumbs_at_search_page.get(2).shouldHave(text(brandList_name_temp));
            bread_crumbs_at_search_page.get(1).shouldBe(visible).click();

            sleep(1500);

        }

    }

    @Step("Переход на посковую выдачу из списка городов и проверка хлебных крошек, наличия города в контейнере города")
    public void checkMainPageCityList() {

        int city_list_item_temp = city_list_name.size();

        //вручную ограничено, чтобы не затягивать тест (без ограничения бегает всему массиву)

        for (int i = 0; i < 5; i++) {

            String cityList_href_temp = getCityHref(i);
            String cityList_name_temp = getCityListName(i);

            city_list_item.get(i).shouldBe(visible).click();

            sleep(1500);

            Assertions.assertEquals(url(), cityList_href_temp);

            citySelectionContainer.shouldHave(text(cityList_name_temp));

            bread_crumbs_at_search_page.get(2).shouldHave(text(cityList_name_temp));
            bread_crumbs_at_search_page.get(1).shouldBe(visible).click();

            sleep(1500);

        }

    }

    @Step("Установка города в поле фильтра")
    public void setCityInFilter(String value) {

        catalog_main_city_input.setValue(value);
        sleep(1000);
        catalog_main_city_option_list_div.findBy(text(value)).click();

    }

    @Step("Установка марки в поле фильтра")
    public void setBrandInFilter(String value) {

        catalog_main_brand_input.setValue(value);
        sleep(1000);
        catalog_main_brand_option_list_div.findBy(text(value)).click();

    }

    @Step("Установка модели в поле фильтра")
    public void setModelInFilter(String value) {

        catalog_main_models_input.setValue(value);

    }

    @Step("Получение марки из поля фильтра")
    public String getBrandInput() {

        return catalog_main_brand_input.getValue();

    }

    @Step("Получение моделей из поля фильтра")
    public String getModelInput() {

        return catalog_main_models_input.getValue();
    }

    @Step("Подготовка фильтров для теста")
    public void filterTest() {

        setCityInFilter(data.city);

        setBrandInFilter(getRandomBrandMainPage());

        sleep(1000);

        setModelOption(catalog_main_models_option_list);

        String brand = getBrandInput();
        String models = getModelInput();

        if (catalog_main_models_option_list.size() == 1) {

            filterSearchButton.click();

            sleep(2000);

            assert brand != null;
            assert models != null;

            bread_crumbs.get(2).shouldHave(text(data.city));
            bread_crumbs.get(3).shouldHave(text(brand));
            bread_crumbs.get(4).shouldHave(text(models));

            pageTitleContainerH1.shouldHave((Condition.text("Автомобили " + brand + " " + models + " в лизинг в " + data.cityAtSearch)));

        } else {

            filterSearchButton.click();

            assert brand != null;
            assert models != null;

            bread_crumbs.get(2).shouldHave(text(data.city));
            bread_crumbs.get(3).shouldHave(text(brand));

            pageTitleContainerH1.shouldHave((Condition.text("Автомобили " + brand + " в лизинг в " + data.cityAtSearch)));


            citySelectionContainer.shouldHave(text(data.city));
            brand_select_desktop_input.shouldHave(value(brand));
            model_select_desktop_input.shouldHave(value(models));

            model_links_block_container.shouldBe(visible);

        }

        bread_crumbs.get(1).shouldHave(text(data.getBreadCrumbsCatalog)).click();


    }

    @Step("Проверка фильтров (пустые)")
    public void filterEmptyTest() {

        filterSearchButton.shouldHave(text(data.mainButtonText)).click();
        pageTitleContainerH1.shouldHave(text(data.textTitleH1AtSearch));
        bread_crumbs.get(2).shouldHave(text(data.textBreadCrumbsAtSearch));
        model_links_block_container.shouldNotBe(visible);

    }

    @Step("Ховер и нажатие кнопки очищения фильтра")
    public void clearFilterOnButton(ElementsCollection value1, int value2) {

        value1.get(value2).hover().click();

    }

    @Step("Выбор моделей марки")
    public void setModelOption(ElementsCollection value) {

        catalog_main_models_input.click();

        if (value.size() == 1) {

            value.get(0).click();

        } else {

            for (int i = 0; i < value.size(); i++) {

                value.get(i).click();

                sleep(500);

            }
        }

    }

    @Step("Проверка очищения фильтров")
    public MainPageCatalog checkFilterClear() {

        setCityInFilter(data.city);
        setBrandInFilter(getRandomBrandMainPage());

        sleep(1000);

        catalog_main_models_input.click();
        setModelOption(catalog_main_models_option_list);


        for (int i = 0; i <= clearButtonOnFilters.size(); i++) {

            clearFilterOnButton(clearButtonOnFilters, i);

        }

        sleep(1500);

        filterSearchButton.click();

        bread_crumbs.get(2).shouldHave(text(data.textBreadCrumbsAtSearch));
        citySelectionContainer.shouldHave(text(data.defaultCity));

        return this;

    }

    @Step("Получение случайной марки через API")
    public String getRandomBrandMainPage() {

        ArrayList<String> list_brand = new ArrayList<>(new BrandList().ActualBrandList());

        Random random = new Random();

        return list_brand.get(random.nextInt(list_brand.size()));

    }

}
