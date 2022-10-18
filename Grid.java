package graph4;

import java.util.Random;

public class Grid {
    int rows;
    int columns;
    Cell[][] cells;

    static Direction[] dir = new Direction[4];
    static void createStandardDirections () {
        dir[0] = new Direction("up");
        dir[1] = new Direction("right");
        dir[2] = new Direction("down");
        dir[3] = new Direction("left");
    } 

    // costruttore a due argomenti
    public Grid(int r, int c) {
        rows = r;
        columns = c;
        cells = new Cell[r][c];
    }

    // costruttore a 1 argomento
    public Grid(int n) {
        rows = columns = n;
        cells = new Cell[n][n];
    }

    // fills grid with a probabilty fillP (0.5 - 0.77) of creating a cell at each
    // spot in the grid
    void fillGrid(double fillP) {
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (rand.nextDouble() < fillP) {
                    cells[i][j] = new Cell(i, j);
                }
            }
        }
    }

    // given a cell, a direction and a probability fillP, this checks from the given
    // cell
    // in the given direction and if it finds another cell it makes a connection
    // with
    // a chance of fillP
    void checkInDirection(Cell c, Direction d, double fillP) {
        if (!c.hasConnection(d)) {
            System.out.println("No already established connection found");
            Random rand = new Random();
            if (rand.nextDouble() < fillP) {
                System.out.println("Random number determined to make a connection");
                int il = c.i; // the coordinates of the cell we're looking at
                int jl = c.j;

                while (il + d.coord[0] >= 0 && il + d.coord[0] <= rows - 1 && jl + d.coord[1] >= 0
                        && jl + d.coord[1] <= columns - 1) {
                    System.out.println("Direction is " + d.name);
                    System.out.println("il is " + il + ", now adding " + d.coord[0]);
                    System.out.println("jl is " + jl + ", now adding " + d.coord[1]);
                    il += d.coord[0]; // moves us in the given direction
                    jl += d.coord[1];
                    System.out.println("Looking at cell " + il + ", " + jl);
                    if (cells[il][jl] != null) {
                        System.out.println("Found a cell");
                        c.connections[d.id] = true;
                        cells[il][jl].connections[(d.id + 2) % 4] = true; // the equation here reverses the direction
                                                                          // (up gives down and so on)
                        break;
                    }
                }
            } else {
                System.out.println("Random number not successful");
            }
        }
    }

    void makeConnections(double connP) {
        createStandardDirections();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cells[i][j] != null) {
                    System.out.println("Found a cell in " + i + ", " + j);
                    for (int k = 0; k < 4; k++) {
                        System.out.println("Checking direction: " + dir[k].name);
                        checkInDirection(cells[i][j], dir[k], connP);
                    }
                }
            }
        }
    }

    void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(cells[i][j] == null ? "  " : "X ");
            }
            System.out.print("\n");
            for (int c = 0; c < columns; c++) {
                // System.out.print("+ ");
            }
            System.out.print("\n");
        }
    }

    void tellMe() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cells[i][j] != null) {
                    System.out.println(cells[i][j]);
                }
            }
        }
    }
}
