package day02;

public class BasicCommandModule extends CommandModule implements Instructable{
    public BasicCommandModule() {
    }

    @Override
    public void executeMovement(Submarine submarine, String instruction) {
        int horizontalPosition = submarine.getHorizontalPosition();
        int depth = submarine.getDepth();
        super.parseInstruction(instruction);
        switch (super.command) {
            case "forward" -> submarine.setHorizontalPosition(horizontalPosition + super.movement);
            case "up" -> submarine.setDepth(depth - super.movement);
            case "down" -> submarine.setDepth(depth + super.movement);
        }
    }
}
