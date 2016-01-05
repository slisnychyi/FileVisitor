package org.slis.service.visitors;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileVisitorUtils {

    //in case command needed
    private static final String HELP_INFO = "File visitor app. \n" +
            "0. Print help: help \n" +
            "1. Print files: print fileSourceDirectory \n" +
            "2. Copy files: copy fileSourceDirectory fileDestinationDirectory \n" +
            "3. Check file: check fileSourceDirectory\n" +
            "4. Exit: exit";

    public void traversFileTree(Path source, FileVisitor<Path> visitor) {
        try {
            Files.walkFileTree(source, visitor);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isExist(Path destination){
        return Files.exists(destination);
    }

    public static String getHelpInformatoin(){
        return HELP_INFO;
    }

    private String replaceCommand(String userCommand) {
        String result = userCommand.replaceAll(" ", userCommand);
        for (Command command : Command.values()) {
            result = userCommand.replaceAll(command.getCommand(), userCommand);
        }
        return result;
    }

}
