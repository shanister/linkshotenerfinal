package commands.impl;

import commands.ICommand;
import savedurls.ShortenUrlTable;
import savedurls.entity.UrlVisitMetadata;

public class GetShortUrlStatus implements ICommand {

    private ShortenUrlTable shortenUrlTable = ShortenUrlTable.getInstance();

    private String shortUrl;

    public GetShortUrlStatus(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String execute() {
        UrlVisitMetadata metadata = shortenUrlTable.getUrlMetadata(shortUrl);
        if (metadata != null)
            return metadata.toString();
        return "Error url does not exist";
    }
}
