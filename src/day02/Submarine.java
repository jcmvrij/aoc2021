package day02;

public class Submarine {
    private int horizontalPosition;
    private int depth;
    private int aim;
    private Instructable commandmodule;

    public void executeInstructions(String[] multipleInstructions) {
        for (String instruction : multipleInstructions) {
            commandmodule.executeMovement(this, instruction);
        }
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public void setHorizontalPosition(int horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }

    public Submarine(int horizontalPosition, int depth) {
        this.horizontalPosition = horizontalPosition;
        this.depth = depth;
        this.commandmodule = new BasicCommandModule();
    }

    public Submarine(int horizontalPosition, int depth, int aim) {
        this.horizontalPosition = horizontalPosition;
        this.depth = depth;
        this.aim = aim;
        this.commandmodule = new AdvancedCommandModule();
    }
}
