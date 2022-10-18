package graph4;

public class Direction {
    int[] coord = { 0, 0 };
    int id;
    String name;

    static String[] names = { "up", "right", "down", "left" };

    // (-1,0), (0,1), (1,0), (0,-1)
    public Direction(String d) {
        name = d;
        switch (d) {
            case "up": {
                coord[0] = -1;
                coord[1] = 0;
                id = 0;
                break;
            }
            case "right": {
                coord[0] = 0;
                coord[1] = 1;
                id = 1;
                break;
            }
            case "down": {
                coord[0] = 1;
                coord[1] = 0;
                id = 2;
                break;
            }
            case "left": {
                coord[0] = 0;
                coord[1] = -1;
                id = 3;
                break;
            }
        }
    }
}
