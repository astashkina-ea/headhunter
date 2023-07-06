package ru.hh.web.pages.components;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import ru.hh.web.data.CategorySpecializations;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SpecializationsModalComponent {

    ElementsCollection specializationsList = $$("[data-qa*='bloko-tree-selector-items-category-'] span");

    @Step("Выбрать категорию")
    public SpecializationsModalComponent clickCategory(String id) {
        $(String.format("[data-qa*='bloko-tree-selector-toogle-node-category-%s']", id)).click();
        return this;
    }

    @Step("Проверить специализации в категории")
    public SpecializationsModalComponent checkSpecializationsList(String category) {
        specializationsList.shouldHave(texts(CategorySpecializations.getSpecializations(category)));
        return this;
    }
}