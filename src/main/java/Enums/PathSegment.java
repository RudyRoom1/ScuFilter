package Enums;

public enum PathSegment {
    PRICE_AVAILABILITY("PriceAvailability");

    private String pathSegment;

    PathSegment(String pathSegment) {
        this.pathSegment = pathSegment;
    }

    public String getPathSegment() {
        return pathSegment;
    }
}
