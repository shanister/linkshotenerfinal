package savedurls.entity;

public class UrlDTO {

    private String shortenUrl;
    private String fullUrl;
    private UrlVisitMetadata urlVisitMetadata = new UrlVisitMetadata();

    public UrlDTO(String shortenUrl, String fullUrl) {
        this.shortenUrl = shortenUrl;
        this.fullUrl = fullUrl;
    }

    public String getShortenUrl() {
        return shortenUrl;
    }

    public void setShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public UrlVisitMetadata getUrlVisitMetadata() {
        return urlVisitMetadata;
    }

    public void setUrlVisitMetadata(UrlVisitMetadata urlVisitMetadata) {
        this.urlVisitMetadata = urlVisitMetadata;
    }
}
