package ru.hh.web.data;

public enum CategorySpecializations {

    AUTO("Автомобильный бизнес", "19", new String[]{"Автомойщик",
            "Автослесарь, автомеханик", "Мастер-приемщик", "Менеджер по продажам, менеджер по работе с клиентами"
    }),
    ADMINISTRATIVE_STAFF("Административный персонал", "5", new String[]{"Администратор",
            "Делопроизводитель, архивариус", "Курьер", "Менеджер/руководитель АХО", "Оператор ПК, оператор базы данных",
            "Офис-менеджер", "Переводчик", "Секретарь, помощник руководителя, ассистент"
    }),
    SECURITY("Безопасность", "15", new String[]{"Военнослужащий", "Охранник", "Полицейский",
            "Специалист по информационной безопасности", "Специалист службы безопасности"
    });

    private String category;
    private String id;
    private String[] specializations;

    CategorySpecializations(String category, String id, String[] specializations) {
        this.category = category;
        this.id = id;
        this.specializations = specializations;
    }

    public String getCategory() {
        return category;
    }

    public static String getId(String category) {
        for (CategorySpecializations categorySpecializations : CategorySpecializations.values()) {
            if (categorySpecializations.category.equals(category)) {
                return categorySpecializations.id;
            }
        }
        throw new IllegalArgumentException();
    }

    public static String[] getSpecializations(String category) {
        for (CategorySpecializations categorySpecializations : CategorySpecializations.values()) {
            if (categorySpecializations.category.equals(category)) {
                return categorySpecializations.specializations;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return category;
    }
}