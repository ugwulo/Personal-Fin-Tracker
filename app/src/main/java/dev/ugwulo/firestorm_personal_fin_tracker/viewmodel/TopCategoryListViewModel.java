package dev.ugwulo.firestorm_personal_fin_tracker.viewmodel;

import dev.ugwulo.firestorm_personal_fin_tracker.model.Category;
import dev.ugwulo.firestorm_personal_fin_tracker.model.Currency;

public class TopCategoryListViewModel {
    private long money;
    private final Currency currency;
    private final Category category;
    private String categoryName;

    public TopCategoryListViewModel(Category category, String categoryName, Currency currency, long money) {
        this.category = category;
        this.categoryName = categoryName;
        this.currency = currency;
        this.money = money;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public long getMoney() {
        return money;
    }

    public Category getCategory() {
        return category;
    }
}

