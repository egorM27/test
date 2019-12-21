public class Main {
    public static void main(String[] args) {

        Team[] team = new Team[3];
        team[0] = new Human("Jhon", 1000, 3);
        team[1] = new Cat("Barsik", 300, 1);
        team[2] = new Robot("IO",5,0);

        Obstacle[] obstacle = new Obstacle[2];
        obstacle[0] = new Treadmill(200);
        obstacle[1] = new Wall(3);

        for (Team t: team){
            t.info();

            for (Obstacle o: obstacle){
                o.run(t.getMaxDist());
                o.jump(t.getMaxHeight());
            }
        }

    }
}
