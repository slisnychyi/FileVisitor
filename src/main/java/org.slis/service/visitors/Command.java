package org.slis.service.visitors;

public enum Command {
    PRINT("print"),
    COPY("copy"), HELP("help"), EXIT("exit"), CHECK("check");

    private final String command;
            
    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Command getCommand(String command){
        for (Command command1 : Command.values()) {
            if(command1.getCommand().equals(command)) return command1;
        }
        System.out.printf("There's no such command = %s", command);
        return null;
    }


}
