package graph4;

public class Cell {
    int i;
    int j;
    boolean[] connections =       {false, false, false, false};
    static String[] connNames =  {"up", "right", "down", "left"};

    public Cell (int ii, int jj) {
        i = ii;
        j = jj;
    }

    public boolean hasConnection (Direction d) {
        return connections[d.id];
    }

    public String toString() {
        String  connStr = "";
        for (int c = 0; c < 4; c++) {
            if (connections[c]) {
                connStr += connNames[c] + " ";
            }
        }
        return ("(" + i + "," + j + ")" + "connections: " + connStr);
    }
}
