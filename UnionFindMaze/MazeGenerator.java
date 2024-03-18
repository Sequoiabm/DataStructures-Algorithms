import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeGenerator {
    private final int rows, cols;
    private final UF uf;
    private final int[][] maze;
    private final List<Wall> walls;

    private static class Wall {
        int cell1, cell2;

        public Wall(int cell1, int cell2) {
            this.cell1 = cell1;
            this.cell2 = cell2;
        }
    }

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.uf = new UF(rows * cols);
        this.maze = new int[rows][cols];
        this.walls = new ArrayList<>();
        initializeWalls();
    }

    private void initializeWalls() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int cell = i * cols + j;
                if (i > 0) walls.add(new Wall(cell, cell - cols)); // Up
                if (j > 0) walls.add(new Wall(cell, cell - 1));   // Left
            }
        }
        Collections.shuffle(walls); // Randomize wall list for removal
    }

    public void generateMaze() {
        for (Wall wall : walls) {
            int cell1 = wall.cell1;
            int cell2 = wall.cell2;

            // Check if these cells are not already connected
            if (!uf.connected(cell1, cell2)) {
                uf.union(cell1, cell2); // Knock down the wall
                System.out.println("Wall removed between " + cell1 + " and " + cell2);
            }
        }
    }

    public static void main(String[] args) {
        int size = 15; // 15x15 grid
        MazeGenerator mazeGenerator = new MazeGenerator(size, size);
        mazeGenerator.generateMaze();
    }
}
