package Enums;

public enum UrlParams {
    LANGUAGE_ENGLISH("Language", "E"),
    BANNER_CTR("Banner","CTR"),
    STORE_0987("Store", "0987"),
    IS_KIOSK("isKiosk","FALSE")
    ;

    private String property;

    private String value;

    UrlParams(String property, String value) {
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }
}
