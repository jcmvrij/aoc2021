package day02;

public class AdvancedCommandModule extends CommandModule implements Instructable{
    public AdvancedCommandModule() {
    }

    @Override
    public void executeMovement(Submarine submarine, String instruction) {
        int horizontalPosition = submarine.getHorizontalPosition();
        int depth = submarine.getDepth();
        int aim = submarine.getAim();
        super.parseInstruction(instruction);
        switch (super.command) {
            case "forward" -> {
                submarine.setHorizontalPosition(horizontalPosition + super.movement);
                submarine.setDepth(depth + (super.movement * aim));
            }
            case "up" -> submarine.setAim(aim - super.movement);
            case "down" -> submarine.setAim(aim + super.movement);
        }
    }
}
