package tests.local;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTestsLocal extends TestBase {

    @Test
    @Tag("emulator")
    @Tag("real")
    void checkChapters() {
        step("Закрыть экран авторизации", () ->
                homepagePage.buttonClick(homepagePage.closeLoginScreenButton));
        step("Проверить наличие раздела 'Автомобили'", () ->
                homepagePage.chapterExistCheck(homepagePage.chapters, homepagePage.nameChapterAuto));
        step("Проверить наличие раздела 'Спецтехника'", () ->
                homepagePage.chapterExistCheck(homepagePage.chapters, homepagePage.nameChapterSpecial));
        step("Проверить наличие раздела 'Запчасти'", () ->
                homepagePage.chapterExistCheck(homepagePage.chapters, homepagePage.nameChapterSpareParts));
        step("Проверить наличие раздела 'Мотоциклы'", () ->
                homepagePage.chapterExistCheck(homepagePage.chapters, homepagePage.nameChapterMoto));
    }

    @Test
    @Tag("emulator")
    @Tag("real")
    void checkMenu() {
        step("Закрыть экран авторизации", () ->
                homepagePage.buttonClick(homepagePage.closeLoginScreenButton));
        step("Нажать на кнопку 'Меню'", () ->
                homepagePage.buttonClick(homepagePage.menuButton));
        step("Проверить наличие пункта меню 'Вход и регистрация'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.registrationSubmenuText));
        step("Проверить наличие пункта меню 'Отчеты по VIN'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.reportVINText));
        step("Проверить наличие пункта меню 'Оценить автомобиль'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.rateACar));
        step("Проверить наличие пункта меню 'Отзывы об автомобилях'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.carReviews));
        step("Проверить наличие пункта меню 'Статистика аукционов'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.auctionStatistics));
        step("Проверить наличие пункта меню 'Помощь и обратная связь'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.helpAndFeedback));
        step("Проверить наличие пункта меню 'Дром Штрафы'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.dromFines));
        step("Проверить наличие пункта меню 'Дром ПДД'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.dromPDD));
    }

    @Test
    @Tag("emulator")
    @Tag("real")
    void checkAddPage() {
        step("Закрыть экран авторизации", () ->
                homepagePage.buttonClick(homepagePage.closeLoginScreenButton));
        step("Нажать на кнопку 'Добавить'", () ->
                homepagePage.buttonClick(homepagePage.addButton));
        step("Проверить наличие раздела 'Легковые авто'", () ->
                homepagePage.elementVisibleCheck(homepagePage.elementCars));
        step("Проверить наличие раздела 'Грузовики и спецтехника'", () ->
                homepagePage.elementVisibleCheck(homepagePage.elementTrucksAndSpecialVehicles));
        step("Проверить наличие кнопки закрытия шторки", () ->
                homepagePage.elementVisibleCheck(homepagePage.elementCloseButton));
    }
}