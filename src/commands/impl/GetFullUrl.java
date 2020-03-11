package commands.impl;

import commands.ICommand;
import savedurls.ShortenUrlTable;

public class GetFullUrl implements ICommand {

    private ShortenUrlTable shortenUrlTable = ShortenUrlTable.getInstance();

    private String shortUrl;

    public GetFullUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String execute() {
        return shortenUrlTable.getFullUrl(shortUrl);
    }
}
