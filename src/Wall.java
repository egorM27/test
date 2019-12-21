public class Wall implements Obstacle{
    private int heightWall;

    public Wall(int heightWall) {
        this.heightWall = heightWall;
    }

    public void jump(int height){

        if(height < heightWall){
            System.out.println("Didn't jump over wall " + heightWall);

        } else {
            System.out.println("Jumped over wall " + heightWall);
        }
    }

    @Override
    public void run(int value) { }

}
