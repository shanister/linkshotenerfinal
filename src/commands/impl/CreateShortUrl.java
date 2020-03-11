package commands.impl;

import commands.ICommand;
import savedurls.ShortenUrlTable;

public class CreateShortUrl implements ICommand {

    private ShortenUrlTable shortenUrlTable = ShortenUrlTable.getInstance();

    private String fullUrl;

    public CreateShortUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    @Override
    public String execute() {
        String shortUrl = String.valueOf(fullUrl.hashCode() & 0x7FFFFFFF);
        shortenUrlTable.addNewShortUrl(shortUrl, fullUrl);
        return shortUrl;
    }

}
