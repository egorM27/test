public class Human implements Team{

    private String name;
    private int maxDist;
    private int maxHeight;

    public Human(String name, int maxDist, int maxHeight) {
        this.name = name;
        this.maxDist = maxDist;
        this.maxHeight = maxHeight;
    }

    public int getMaxDist() {
        return maxDist;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void info(){
        System.out.println("Human " + name + " can runs " + maxDist + " and jumps " + maxHeight);
    }
}
