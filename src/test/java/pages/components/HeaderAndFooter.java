package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.BaseTest;
import utils.TestData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HeaderAndFooter extends BaseTest {

    TestData data = new TestData();


// --------- HEADER --------- //

    SelenideElement
            alfa_logo = $("[data-test-id = 'alfa-logo']"),
            header_top_block = $("[data-test-id = 'header-top-block']"),
            header_links_arrow = $("[data-test-id = 'header-links-arrow']"),
            header_bottom_block = $("[data-test-id = 'header-bottom-block']"),
            header_finance = $("[data-test-id = 'header-finance']"),
            header_catalog = $("[data-test-id = 'header-catalog']"),
            header_aktsii = $("[data-test-id = 'header-aktsii']"),
            header_services = $("[data-test-id = 'header-services']"),
            header_more = $("[data-test-id = 'header-more']"),
            header_finance_dropdown = $("[data-test-id = 'header-finance-dropdown']"),
            header_catalog_dropdown = $("[data-test-id = 'header-catalog-dropdown']"),
            header_services_dropdown = $("[data-test-id = 'header-services-dropdown']"),
            header_more_dropdown = $("[data-test-id = 'header-more-dropdown']"),
            header_right_block = $("[data-test-id = 'header-right-block']"),
            header_favorites_button = $("[data-test-id = 'header-favorites-button']"),
            header_comparison_button = $("[data-test-id = 'header-comparison-button']"),
            header_call_button = $("[data-test-id = 'header-call-button']"),
            header_call_button_number = $("[data-test-id = 'header-call-button'] span"),

    // --------- FOOTER --------- //

            footer_menu_links = $("[data-test-id = 'footer-menu-links']"),
            footer_geo = $("[data-test-id = 'footer-geo']"),
            footer_geo_city = $("[data-test-id = 'footer-geo'] span"),
            footer_contact_phone = $("[data-test-id = 'footer-contact-phone']"),
            footer_contact_phone_number = $("[data-test-id = 'footer-contact-phone'] span"),
            footer_contact_phone_Centre = $("[data-test-id = 'footer-contact-phone'] span").sibling(0),
            footer_logo = $("[data-test-id = 'footer-logo']"),
            footer_lk_block = $("[data-test-id = 'footer-lk-block']"),
            footer_lk_link = $("[data-test-id = 'footer-lk-link']"),
            footer_lk_blockText = $("[data-test-id = 'footer-lk-block'] span"),
            footer_promotion_block = $("[data-test-id = 'footer-promotions-block']");

    // --------- HEADER --------- //

    ElementsCollection
            header_top_block_list = $$("[data-test-id = 'header-top-block'] a");

    @Step("Проверка видимости элементов хедера")
    public HeaderAndFooter checkHeaderElements() {

        alfa_logo.shouldBe(visible);
        header_top_block.shouldBe(visible);
        header_links_arrow.shouldBe(visible);
        header_bottom_block.shouldBe(visible);
        header_finance.shouldBe(visible);
        header_catalog.shouldBe(visible);
        header_aktsii.shouldBe(visible);
        header_services.shouldBe(visible);
        header_more.shouldBe(visible);
        header_right_block.shouldBe(visible);
        header_favorites_button.shouldBe(visible);
        header_comparison_button.shouldBe(visible);
        header_call_button.shouldBe(visible);
        header_call_button_number.shouldBe(visible);

        header_links_arrow.click();
        header_links_arrow.click();
        header_links_arrow.click();

        header_top_block_list.get(2).shouldBe(visible);
        header_top_block_list.get(3).shouldBe(visible);
        header_top_block_list.get(4).shouldBe(visible);

        header_bottom_block.shouldBe(visible);

        header_finance.hover();
        header_finance_dropdown.shouldBe(visible);

        header_catalog.hover();
        header_catalog_dropdown.shouldBe(visible);

        header_services.hover();
        header_services_dropdown.shouldBe(visible);

        header_more.hover();
        header_more_dropdown.shouldBe(visible);

        return this;

    }

    @Step("Проверка текстовок и ссылок элементов хедера")
    public HeaderAndFooter checkTextAndHrefHeader() {

        header_top_block_list.get(0).shouldHave(text(data.headerTopBlockIP));

        header_top_block_list.get(1).shouldHave(text(data.headerTopBlockCORP));
        header_links_arrow.click();

        header_top_block_list.get(2).shouldHave(text(data.headerTopBlockCOMP));
        header_top_block_list.get(3).shouldHave(text(data.headerTopBlockCONT));
        header_top_block_list.get(4).shouldHave(text(data.headerTopBlockNEWS));

        header_call_button_number.shouldHave(text(data.numberHeader));
        header_finance.shouldHave(text(data.headerBottomBlockFIN));
        header_catalog.shouldHave(text(data.headerBottomBlockCAT));
        header_aktsii.shouldHave(text(data.headerBottomBlockAKT));
        header_services.shouldHave(text(data.headerBottomBlockSER));
        header_more.shouldHave(text(data.headerBottomBlockMORE));
        header_call_button_number.shouldHave(text(data.numberHeader));

        header_links_arrow.click();
        header_top_block_list.get(0).shouldHave(href(data.baseUrl));
        header_top_block_list.get(1).shouldHave(href(data.urlSite_KorporativBiz));
        header_top_block_list.get(2).shouldHave(href(data.urlSite_Company));
        header_top_block_list.get(3).shouldHave(href(data.urlSite_Contact));
        header_top_block_list.get(4).shouldHave(href(data.urlSite_News));

        return this;

    }

    @Step("Проверка видимости элементов футера")
    public HeaderAndFooter checkFooterElements() {

        footer_menu_links.shouldBe(visible);
        footer_geo.shouldBe(visible);
        footer_contact_phone.shouldBe(visible);
        footer_logo.shouldBe(visible);
        footer_lk_block.shouldBe(visible);
        footer_promotion_block.shouldBe(visible);

        return this;

    }

    @Step("Проверка текстовок элементов футера")
    public HeaderAndFooter checkTextFooter() {

        footer_geo_city.shouldHave(text(data.city));
        footer_contact_phone_number.shouldHave(text(data.footerContactPhone));
        footer_contact_phone_Centre.shouldHave(text(data.footerContactText));
        footer_lk_link.shouldHave(text(data.footerLkLinkText));
        footer_lk_blockText.shouldHave(text(data.foterLkBlockText));

        return this;

    }

}




