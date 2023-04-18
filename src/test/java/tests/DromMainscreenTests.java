package tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DromMainscreenTests extends TestBase {

    @Test
    @Tag("emulator")
    @Tag("browserstack")
    void checkChapters() {
        Allure.step("Закрыть экран авторизации", () ->
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
    @Tag("browserstack")
    void checkMenu() {
        Allure.step("Закрыть экран авторизации", () ->
                homepagePage.buttonClick(homepagePage.closeLoginScreenButton));
        Allure.step("Нажать на кнопку 'Меню'", () ->
                homepagePage.buttonClick(homepagePage.menuButton));
        Allure.step("Проверить наличие пункта меню 'Вход и регистрация'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.registrationSubmenuText));
        Allure.step("Проверить наличие пункта меню 'Отчеты по VIN'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.reportVINText));
        Allure.step("Проверить наличие пункта меню 'Оценить автомобиль'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.rateACar));
        Allure.step("Проверить наличие пункта меню 'Отзывы об автомобилях'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.carReviews));
        Allure.step("Проверить наличие пункта меню 'Статистика аукционов'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.auctionStatistics));
        Allure.step("Проверить наличие пункта меню 'Помощь и обратная связь'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.helpAndFeedback));
        Allure.step("Проверить наличие пункта меню 'Дром Штрафы'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.dromFines));
        Allure.step("Проверить наличие пункта меню 'Дром ПДД'", () ->
                homepagePage.chapterExistCheck(homepagePage.submenu, homepagePage.dromPDD));
    }

    @Test
    @Tag("emulator")
    @Tag("browserstack")
    void checkAddPage() {
        Allure.step("Закрыть экран авторизации", () ->
                homepagePage.buttonClick(homepagePage.closeLoginScreenButton));
        Allure.step("Нажать на кнопку 'Добавить'", () ->
                homepagePage.buttonClick(homepagePage.addButton));
        Allure.step("Проверить наличие раздела 'Легковые авто'", () ->
                homepagePage.elementVisibleCheck(homepagePage.elementCars));
        Allure.step("Проверить наличие раздела 'Грузовики и спецтехника'", () ->
                homepagePage.elementVisibleCheck(homepagePage.elementTrucksAndSpecialVehicles));
        Allure.step("Проверить наличие кнопки закрытия шторки", () ->
                homepagePage.elementVisibleCheck(homepagePage.elementCloseButton));
    }
}