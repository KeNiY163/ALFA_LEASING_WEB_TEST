package tests.elementsPageTest;

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
@Feature("Тесты элементов на странице поиск по модели")
public class AggregatePageElementsTest extends BaseTest {

    AggregatePageCatalog aggregatePageCatalog = new AggregatePageCatalog();
    HeaderAndFooter headerAndFooter = new HeaderAndFooter();

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Tag("ELEMENTSTEST")
    @Owner("Keniy163")
    @DisplayName("Проверка наличия элементов на странице/модального окна городов/аггрегированной выдачи + проверка текстовок")
    @Test
    public void aggregatePageElementTest() {

        aggregatePageCatalog.openPageSearch()
                .checkAggregatePageElementsVisible()
                .checkAggregateListText();

    }

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Tag("ELEMENTSTEST")
    @Owner("Keniy163")
    @DisplayName("Проверка наличия всех элементов хедера/проверка правильности текстовок в элементах/проверка корректности ссылок в элементах")
    @Test
    public void headertest() {


        aggregatePageCatalog.openPageSearch();
        headerAndFooter.checkHeaderElements()
                .checkFooterElements()
                .checkTextAndHrefHeader()
                .checkTextFooter();

    }

    @Story("Поисковая выдача")
    @Tag("SMOKE")
    @Tag("AGGREGATEPAGE")
    @Tag("ELEMENTSTEST")
    @Owner("Keniy163")
    @DisplayName("Проверка наличия всех элементов футера/проверка правильности текстовок в элементах/проверка корректности ссылок в элементах")
    @Test
    public void footertest() {

        aggregatePageCatalog.openPageSearch();
        headerAndFooter.checkHeaderElements()
                .checkFooterElements()
                .checkTextAndHrefHeader()
                .checkTextFooter();

    }


}
