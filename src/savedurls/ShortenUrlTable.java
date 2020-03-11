package savedurls;

import savedurls.entity.UrlDTO;
import savedurls.entity.UrlVisitMetadata;

import java.util.HashMap;

public class ShortenUrlTable {

    private static ShortenUrlTable singleInstance = null;

    private HashMap<String, UrlDTO> shortUrlToFullUrlTable;

    private ShortenUrlTable() {
        this.shortUrlToFullUrlTable = new HashMap<>();
    }

    public static ShortenUrlTable getInstance() {
        if (singleInstance == null) {
            singleInstance = new ShortenUrlTable();
        }
        return singleInstance;
    }

    public void addNewShortUrl(String shortUrl, String realUrl) {
        shortUrlToFullUrlTable.put(shortUrl, new UrlDTO(shortUrl, realUrl));
    }

    public String getFullUrl(String shortUrl) {
        if (shortUrlToFullUrlTable.containsKey(shortUrl)) {
            UrlDTO urlDTO = shortUrlToFullUrlTable.get(shortUrl);
            updateUrlMetadata(urlDTO);
            return urlDTO.getFullUrl();
        }
        return "Short URL does not exist";
    }

    public UrlVisitMetadata getUrlMetadata(String shortUrl) {
        if (shortUrlToFullUrlTable.containsKey(shortUrl)) {
            return shortUrlToFullUrlTable.get(shortUrl).getUrlVisitMetadata();
        }
        return null;
    }

    private void updateUrlMetadata(UrlDTO urlDTO) {
        UrlVisitMetadata metadata = urlDTO.getUrlVisitMetadata();
        metadata.addVisit();
    }
}
