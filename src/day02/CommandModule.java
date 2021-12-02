package day02;

abstract class CommandModule {
    protected String command;
    protected int movement;

    public void parseInstruction(String instruction) {
        String[] splitInstruction = instruction.split("\\s+");
        command = splitInstruction[0];
        movement = Integer.parseInt(splitInstruction[1]);
    }
}