package Enums;

public enum BasedUrls {

    BASE_URL_UAT("digital-uat15.cicada.cs.ctc/");


    private String basedUrl;

    BasedUrls(String basedUrl) {
        this.basedUrl = basedUrl;
    }

    public String getBasedUrl() {
        return basedUrl;
    }

}
