package day02;

public class AdvancedCommandModule extends CommandModule implements Instructable{
    public AdvancedCommandModule() {
    }

    public void parseInstruction(String instruction) {
        String[] splitInstruction = instruction.split("\\s+");
        command = splitInstruction[0];
        movement = Integer.parseInt(splitInstruction[1]);
    }

    @Override
    public void executeMovement(Submarine submarine, String instruction) {
        int horizontalPosition = submarine.getHorizontalPosition();
        int depth = submarine.getDepth();
        int aim = submarine.getAim();
        parseInstruction(instruction);
        switch (command) {
            case "forward" -> {
                submarine.setHorizontalPosition(horizontalPosition + movement);
                submarine.setDepth(depth + (movement * aim));
            }
            case "up" -> submarine.setAim(aim - movement);
            case "down" -> submarine.setAim(aim + movement);
        }
    }
}
