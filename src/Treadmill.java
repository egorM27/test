public class Treadmill implements Obstacle{

    private int distTreadmill;

    public Treadmill(int distTreadmill) {
        this.distTreadmill = distTreadmill;
    }

    @Override
    public void run(int dist) {
        if(dist < distTreadmill){
            System.out.println("Didn't run distance " + distTreadmill);

        } else {
            System.out.println("Ran distance " + distTreadmill);

        }
    }

    @Override
    public void jump(int value) { }
}

