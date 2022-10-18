package graph4;

public class EntryPoint {
    public static void main(String[] arg) {
        Grid myGrid = new Grid(4,4);
        myGrid.print();
        System.out.println("=====================");
        myGrid.fillGrid(0.7);
        myGrid.print();
        System.out.println("Creating connections");
        myGrid.makeConnections(0.9);
        System.out.println("=====================");
        myGrid.tellMe();
    }
}
