package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

public class HomepagePage {
    public String nameChapterAuto = "Автомобили",
            nameChapterSpecial = "Спецтехника",
            nameChapterSpareParts = "Запчасти",
            nameChapterMoto = "Мотоциклы",
            registrationSubmenuText = "Вход и регистрация",
            reportVINText = "Отчеты по VIN",
            rateACar = "Оценить автомобиль",
            carReviews = "Отзывы об автомобилях",
            auctionStatistics = "Статистика аукционов",
            helpAndFeedback = "Помощь и обратная связь",
            dromFines = "Дром Штрафы",
            dromPDD = "Дром ПДД";

    public SelenideElement
            closeLoginScreenButton = $(id("ru.farpost.dromfilter:id/later_button")),
            menuButton = $(id("ru.farpost.dromfilter:id/menu_page")),
            addButton = $(id("ru.farpost.dromfilter:id/add_page")),
            elementCars = $(id("ru.farpost.dromfilter:id/car_section")),
            elementTrucksAndSpecialVehicles = $(id("ru.farpost.dromfilter:id/spec_section")),
            elementCloseButton = $(id("ru.farpost.dromfilter:id/cancel_button"));

    public ElementsCollection
            chapters = $$(id("ru.farpost.dromfilter:id/title")),
            submenu = $$(id("ru.farpost.dromfilter:id/main_text_view"));

    public HomepagePage buttonClick(SelenideElement buttonName) {
        buttonName.click();

        return this;
    }

    public HomepagePage chapterExistCheck(ElementsCollection chapters, String nameChapter) {
        chapters.findBy(text(nameChapter)).should(exist);

        return this;
    }

    public HomepagePage elementVisibleCheck(SelenideElement element) {
        element.shouldBe(visible);

        return this;
    }
}