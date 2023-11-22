package pages;

import api.requests.BrandList;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import config.WebDriverConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.TestData;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AggregatePageCatalog {

    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    TestData data = new TestData();


    private final SelenideElement
            breadCrumbsContainer = $("[data-test-id = 'bread-crumbs-container']"),
            pageTitleContainer = $("[data-test-id = 'page-title-container']"),
            citySelectionContainer = $("[data-test-id = 'city-selection-container']"),
            citySelectionButton = $("[data-test-id = 'city-selection-container'] button"),
            modalCityCloser = $(By.xpath("//div[contains(@class, 'navigation-bar__closer')]")),
            pageTitleContainerH1 = $("[data-test-id = 'page-title-container'] h1"),
            brandSelectInput = $("[data-test-id = 'brand-select-desktop_0'] input"),
            brandSelectInput_1 = $("[data-test-id = 'brand-select-desktop_1'] input"),
            modelSelectInput = $("[data-test-id = 'model-select-desktop_0'] input"),
            modelSelect = $("[data-test-id = 'model-select-desktop_0']"),
            bodyTypeSelectInput = $("[data-test-id = 'bodytype-select-desktop'] input"),
            fuelTypeSelectInput = $("[data-test-id = 'fueltype-select-desktop'] input"),
            transmissionTypeSelectInput = $("[data-test-id = 'transmission-select-desktop']"),
            driveUnitTypeSelectInput = $("[data-test-id = 'driveunit-select-desktop']"),
            powerInput = $("[data-test-id = 'form-power-from-input']"),
            powerFromInput = $("[data-test-id = 'form-power-from-input']"),
            powerToInput = $("[data-test-id = 'form-power-to-input']"),
            priceFromInput = $("[data-test-id = 'form-price-from-input']"),
            priceToInput = $("[data-test-id = 'form-price-to-input']"),
            colorsPaletteContainer = $("[data-test-id = 'colors-palette-container']"),
            clearAllButton = $("[data-test-id = 'clear-all-button']"),
            offerLoaderButton = $("[data-test-id = 'offers-loader-button-container']"),
            sortingFilterContainer = $("[data-test-id = 'sorting-filter-container']"),
            tagFilterContainer = $("[data-test-id = 'tag-filters-container']"),
            searchCityInput = $("[data-test-id = 'search-city']"),
            popularCityContainer = $("[data-test-id = 'popular-cities-tags-container']"),
            applyCityButton = $("[data-test-id = 'apply-city-selection-button'] button"),
            modelLinksBlockContainer = $("[data-test-id = 'models-links-block-container']"),
            citySelectionContainer_aggregatePage = $("[data-test-id = 'city-selection-container'] button span").sibling(0),
            offercard_0_title = $("[data-test-id = 'offer-card-title']"),
            model_offercard_title = $("[data-test-id = 'model-offer-card-title']"),
            offercard_0_fuel_type = $("[data-test-id = 'offer-card-fuel-type']"),
            offercard_0_body_type = $("[data-test-id = 'offer-card-body-type']"),
            offercard_0_transmission = $("[data-test-id = 'offer-card-transmission']"),
            offercard_0_drive_unit = $("[data-test-id = 'offer-card-drive-unit']"),
            suggestions_banner = $("[data-test-id = 'suggestions-banner']"),
            suggestions_banner_title = $("[data-test-id = 'suggestions-banner'] div div"),
            suggestions_banner_subtitle = $("[data-test-id = 'suggestions-banner'] div span"),
            suggestions_banner_filterCity = $("[data-test-id = 'suggestions-tag-filter-city']"),
            suggestions_banner_filterColor = $("[data-test-id = 'suggestions-tag-filter-color']"),
            addBrandButton = $("[data-test-id = 'form-add-brand-button']");

    private final ElementsCollection
            popularCity = $$("[data-test-id = 'popular-cities-tags-container'] button"),
            cityOptionList = $$("[data-test-id = 'search-city-options-list'] span"),
            breadCrumbsItem = $$("[data-test-id = 'bread-crumbs-container'] span"),
            aggregate_model_option_list = $$("[data-test-id = 'model-select-desktop_0-options-list'] label"),
            catalog_aggregate_brand_option_list_div = $$("[data-test-id = 'brand-select-desktop_0-options-list'] div div"),
            catalog_aggregate_brand_option_list_1_div = $$("[data-test-id = 'brand-select-desktop_1-options-list'] div div"),
            catalog_aggregate_bodytype_option_list = $$("[data-test-id = 'bodytype-select-desktop-options-list'] div div div"),
            catalog_aggregate_fuel_option_list = $$("[data-test-id = 'fueltype-select-desktop-options-list'] div div div"),
            catalog_aggregate_transmission_option_list = $$("[data-test-id = 'transmission-select-desktop-options-list'] div div div"),
            color_pallete_button = $$("[data-test-id = 'colors-palette-container'] button"),
            catalog_aggregate_driveunit_option_list = $$("[data-test-id = 'driveunit-select-desktop-options-list'] div div div");


    @Step("Открытие страницы поисковой выдачи")
    public AggregatePageCatalog openPageSearch() {

        open(config.getBaseUrl() + "/search");

        return this;

    }

    @Step("Проверка видимости элементов на странице")
    public AggregatePageCatalog checkAggregatePageElementsVisible() {

        breadCrumbsContainer.shouldBe(Condition.visible);
        pageTitleContainer.shouldBe(Condition.visible);

        citySelectionContainer.shouldBe(Condition.visible);
        citySelectionButton.click();
        searchCityInput.shouldBe(visible);
        popularCityContainer.shouldBe(visible);
        applyCityButton.shouldBe(visible);
        modalCityCloser.shouldBe(visible).click();


        pageTitleContainer.shouldBe(Condition.visible);
        brandSelectInput.shouldBe(Condition.visible);
        modelSelect.shouldBe(Condition.visible);
        bodyTypeSelectInput.shouldBe(Condition.visible);
        fuelTypeSelectInput.shouldBe(Condition.visible);
        transmissionTypeSelectInput.shouldBe(Condition.visible);
        driveUnitTypeSelectInput.shouldBe(Condition.visible);
        powerInput.shouldBe(Condition.visible);
        powerFromInput.shouldBe(Condition.visible);
        powerToInput.shouldBe(Condition.visible);
        priceFromInput.shouldBe(Condition.visible);
        priceToInput.shouldBe(Condition.visible);
        colorsPaletteContainer.shouldBe(Condition.visible);
        clearAllButton.shouldBe(Condition.visible);
        offerLoaderButton.shouldBe(Condition.visible);
        sortingFilterContainer.shouldBe(Condition.visible);
        tagFilterContainer.shouldNotBe(Condition.visible);
        modelLinksBlockContainer.shouldNotBe(visible);

        return this;
    }

    @Step("Проверка текстовок на странице")
    public AggregatePageCatalog checkAggregateListText() {

        breadCrumbsItem.get(0).shouldHave(text(data.breadCrumbsAlfa));
        breadCrumbsItem.get(1).shouldHave(text(data.getBreadCrumbsCatalog));
        breadCrumbsItem.get(2).shouldHave(text(data.textBreadCrumbsAtSearch));

        pageTitleContainerH1.shouldHave(text(data.textTitleH1AtSearch));

        citySelectionContainer.shouldHave(text(data.defaultCity));

        return this;

    }

    @Step("Получение случайной марки автомобиля")
    public String getRandomBrandAtAggregatePage() {

        ArrayList<String> list_brand = new ArrayList<>(new BrandList().ActualBrandList());

        Random random = new Random();

        return list_brand.get(random.nextInt(list_brand.size()));

    }

    @Step("Установка в фильтрах случайной марки автомобиля и выбор (установка) моделей")
    public void setBrandAndModelAtAggregatePage(String value) {

        brandSelectInput.setValue(value);

        sleep(1000);

        catalog_aggregate_brand_option_list_div.findBy(text(value)).click();

        sleep(1000);

        modelSelectInput.click();

        setModelOption(aggregate_model_option_list);

        sleep(500);

        escapeInput(modelSelectInput);

        sleep(1000);

    }

    @Step("Установка моделей в фильтр")
    public void setModelOption(ElementsCollection value) {

        if (value.size() == 1) {

            value.get(0).click();

        } else {

            for (int i = 0; i < value.size(); i++) {

                value.get(i).click();

                sleep(500);

            }
        }
    }

    @Step("Выход из поля фильтра")
    public void escapeInput(SelenideElement value) {

        value.sendKeys(Keys.ESCAPE);

    }

    @Step("Проверка видимости блока перелинковки")
    public void checkVisibleBrandsLink() {

        setBrandAndModelAtAggregatePage(getRandomBrandAtAggregatePage());

        modelLinksBlockContainer.shouldBe(visible);

    }

    @Step("Проверка добавления 2-х и более марок авто и корректного отображения блока перелинковки")
    public AggregatePageCatalog checkAddBrand() {


        String brand = getRandomBrandAtAggregatePage();
        String brand_1 = getRandomBrandAtAggregatePage();

        setBrandAndModelAtAggregatePage(brand);

        addBrandButton.shouldBe(visible).click();

        brandSelectInput_1.setValue(brand_1);

        sleep(1000);

        catalog_aggregate_brand_option_list_1_div.findBy(text(brand_1)).click();

        sleep(1000);


        addBrandButton.shouldBe(visible);
        modelLinksBlockContainer.shouldNotBe(visible);

        return this;

    }

    @Step("Выбор случайного города в блоке городов (через рандомайзер)")
    public AggregatePageCatalog selectCityInModal() {

        String city = new Faker(new Locale("ru")).address().city();

        citySelectionContainer.click();
        searchCityInput.setValue(city);
        cityOptionList.findBy(text(city)).click();

        sleep(1000);

        applyCityButton.click();

        sleep(3000);

        citySelectionContainer_aggregatePage.shouldHave(text(city));

        return this;

    }

    @Step("Выбор табов Москва и Санкт - Петербург из блока популятрных городов в модальном окне")
    public AggregatePageCatalog setCitiesTabs() {

        citySelectionContainer.click();
        popularCity.findBy(text("Москва")).click();
        popularCity.findBy(text("Санкт-Петербург")).click();

        sleep(1000);

        applyCityButton.click();

        sleep(3000);

        return this;

    }

    @Step("Проверка заголовка карточки оффера")
    public void checkTitleOfferCardAtAggregate(String value) {

        offercard_0_title.shouldHave(text(value));

    }

    @Step("Проверка заголовка карточки оффера на странице поиска по модели")
    public void checkTitleOfferCardAtSearch(String value) {

        model_offercard_title.shouldHave(text(value));

    }

    @Step("Выбор и установка случайной марки и модели по ней, проверка наличия в карточках офферов выбранной марки")
    public void checkOfferCard() {

        String brand = getRandomBrandAtAggregatePage();

        setBrandAndModelAtAggregatePage(brand);

        modelSelectInput.click();

        if (aggregate_model_option_list.size() == 1) {

            escapeInput(modelSelectInput);

            offerLoaderButton.click();

            sleep(2000);

            checkTitleOfferCardAtSearch(brand);
        } else {

            escapeInput(modelSelectInput);

            offerLoaderButton.click();

            sleep(2000);

            checkTitleOfferCardAtAggregate(brand);

        }

    }

    @Step("Установка значения в фильтр")
    public void setFIlterValue(SelenideElement element, ElementsCollection collection, String value) {

        element.click();
        collection.findBy(text(value)).click();
        escapeInput(element);

    }

    @Step("Выбор типа кузова")
    public AggregatePageCatalog setBodyType() {

        setFIlterValue(bodyTypeSelectInput, catalog_aggregate_bodytype_option_list, "Седан");

        return this;

    }

    @Step("Выбор типа двигателя")
    public AggregatePageCatalog setFuel() {

        setFIlterValue(fuelTypeSelectInput, catalog_aggregate_fuel_option_list, "Бензиновый");

        return this;

    }

    @Step("Выбор типа привода")
    public AggregatePageCatalog setDriveUnit() {

        setFIlterValue(driveUnitTypeSelectInput, catalog_aggregate_driveunit_option_list, "Передний");

        return this;
    }

    @Step("Выбор типа коробки передач")
    public AggregatePageCatalog setTransmission() {

        setFIlterValue(transmissionTypeSelectInput, catalog_aggregate_transmission_option_list, "Автомат");

        return this;

    }

    @Step("Выбор типа кузова и проверка наличия выбранного кузова в карточках офферов")
    public AggregatePageCatalog setAndCheckBodyTypeInOffers() {

        setBodyType();
        offerLoaderButton.click();
        offercard_0_body_type.shouldHave(text("Седан"));

        return this;

    }

    @Step("Выбор типа двигателя и проверка наличия выбранного двигателя в карточках офферов")
    public AggregatePageCatalog setAndCheckFuelInOffers() {

        setFuel();
        offerLoaderButton.click();
        offercard_0_fuel_type.shouldHave(text("Бензиновый"));

        return this;

    }

    @Step("Выбор типа привода и проверка наличия выбранного привода в карточках офферов")
    public AggregatePageCatalog setAndCheckDriveUnitInOffers() {

        setDriveUnit();
        offerLoaderButton.click();
        offercard_0_drive_unit.shouldHave(text("Передний"));

        return this;

    }

    @Step("Выбор типа коробки передач и проверка наличия выбранной коробки передач в карточках офферов")
    public AggregatePageCatalog setAndCheckTransmissionInOffers() {

        setTransmission();
        offerLoaderButton.click();
        offercard_0_transmission.shouldHave(text("Автомат"));

        return this;

    }

    @Step("Проверка типа кузова в карточках офферов")
    public AggregatePageCatalog checkBodyType() {

        offercard_0_body_type.shouldHave(text("Седан"));

        return this;

    }

    @Step("Проверка типа двигателя в карточках офферов")
    public AggregatePageCatalog checkFuel() {

        offercard_0_fuel_type.shouldHave(text("Бензиновый"));

        return this;

    }

    @Step("Проверка типа коробки передач в карточках офферов")
    public AggregatePageCatalog checkTransmission() {

        offercard_0_transmission.shouldHave(text("Автомат"));

        return this;

    }

    @Step("Проверка типа привода в карточках офферов")
    public AggregatePageCatalog checkDriveUnit() {

        offercard_0_drive_unit.shouldHave(text("Передний"));

        return this;

    }

    @Step("Установка мощности от")
    public AggregatePageCatalog setPowerFrom() {

        powerFromInput.setValue("10");

        return this;

    }

    @Step("Установка мощности до")
    public AggregatePageCatalog setPowerTo() {

        powerToInput.setValue("200");

        return this;

    }

    @Step("Установка цены от")
    public AggregatePageCatalog setPriceFrom() {

        priceFromInput.setValue("1000000");

        return this;

    }

    @Step("Установка цены до")
    public AggregatePageCatalog setPriceTo() {

        priceToInput.setValue("15000000");

        return this;

    }

    @Step("Применение фильтров")
    public AggregatePageCatalog applyFilters() {

        offerLoaderButton.click();

        return this;

    }

    @Step("Выбор цвета")
    public AggregatePageCatalog setColor(int value) {

        color_pallete_button.get(value).click();
        applyFilters();

        return this;

    }

    @Step("Выбор цвета и города/перезагрузка страницы с применёнными фильтрами")
    public AggregatePageCatalog setColorAndCity() {

        selectCityInModal();
        setColor(2);

        return this;

    }

    @Step("Проверка наличия банера \"Из других городов\" при выборе города и цвета")
    public AggregatePageCatalog checkBannerDiffCityAndColor() {

        setColorAndCity();

        suggestions_banner.shouldBe(visible);
        suggestions_banner_title.shouldHave(text("Не нашли ничего подходящего?"));
        suggestions_banner_subtitle.shouldHave(text("Попробуйте сбросить фильтры, и мы покажем вам больше подходящих предложений"));

        suggestions_banner_filterCity.shouldBe(visible);

        return this;

    }

    @Step("Проверка наличия банера \"Из других городов\" при выборе 2 городов")
    public AggregatePageCatalog checkBannerDiffCity() {

        setCitiesTabs();

        suggestions_banner.shouldBe(visible);
        suggestions_banner_title.shouldHave(text("Не нашли ничего подходящего?"));
        suggestions_banner_subtitle.shouldHave(text("Попробуйте сбросить фильтры, и мы покажем вам больше подходящих предложений"));

        suggestions_banner_filterCity.shouldBe(visible);

        return this;

    }

    @Step("Проверка наличия банера \"Из других городов\" при выборе 2 цветов")
    public AggregatePageCatalog checkBannerDiffColor() {

        setColor(2);
        setColor(4);

        suggestions_banner.shouldBe(visible);
        suggestions_banner_title.shouldHave(text("Не нашли ничего подходящего?"));
        suggestions_banner_subtitle.shouldHave(text("Попробуйте сбросить фильтры, и мы покажем вам больше подходящих предложений"));

        suggestions_banner_filterColor.shouldBe(visible);

        return this;

    }


}
