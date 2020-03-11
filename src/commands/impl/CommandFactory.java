package commands.impl;

import commands.ICommand;

public class CommandFactory {

    private final String getStatus = "?showStatus=true";

    public ICommand getCommand(String param) {
        String[] commandParams = param.split(" ");

        if (commandParams[0].equals("create")) {
            return new CreateShortUrl(commandParams[1]);
        } else {
            if (commandParams[0].endsWith(getStatus)) {
                return new GetShortUrlStatus(commandParams[0].substring(0, commandParams[0].length() - getStatus.length()));
            } else {
                return new GetFullUrl(commandParams[0]);
            }
        }
    }
}
