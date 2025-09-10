// lab3b.java
// fall 2025
// Lukas Finch
// Demonstrates recursive algorithm to "flood fill"
// an ASCII graphic// Student: [Your First and Last Name]

class lab3b {
    public static void main(String[] args) {

        // grid represents a graphic image
        char grid[][] = {
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' },
            { 'g', 'g', ' ', 'g', 'g', ' ', ' ', ' ', 'g' },
            { 'g', 'g', ' ', ' ', ' ', ' ', 'g', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', 'g', ' ', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', 'g', ' ', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'g' },
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' }
        };

        System.out.println("Original\n");
        display(grid);

        // fill inside with 'r'
        System.out.println("After flood fill with r\n");
        floodFill(grid, 5, 3, 'r', 'g');
        display(grid);

        // fill border with 'i'
        System.out.println("After flood filling border with i\n");
        floodFill(grid, 0, 0, 'i', 'r');
        display(grid);
    }

    // flood fill 2D char array
    public static void floodFill(char temp[][], int row, int col, char fillColor, char borderColor) {

        // base case: stop if out of bounds
        if (row < 0 || col < 0 || row >= temp.length || col >= temp[0].length) {
            return;
        }

        // stop if current is border or already filled
        if (temp[row][col] == borderColor || temp[row][col] == fillColor) {
            return;
        }

        // set current to fill color
        temp[row][col] = fillColor;

        // recursive calls in 8 directions
        floodFill(temp, row - 1, col, fillColor, borderColor);     // up
        floodFill(temp, row + 1, col, fillColor, borderColor);     // down
        floodFill(temp, row, col - 1, fillColor, borderColor);     // left
        floodFill(temp, row, col + 1, fillColor, borderColor);     // right
        floodFill(temp, row - 1, col - 1, fillColor, borderColor); // up-left
        floodFill(temp, row - 1, col + 1, fillColor, borderColor); // up-right
        floodFill(temp, row + 1, col - 1, fillColor, borderColor); // down-left
        floodFill(temp, row + 1, col + 1, fillColor, borderColor); // down-right
    }

    // display array
    public static void display(char temp[][]) {
        for (int r = 0; r < temp.length; r++) {
            for (int c = 0; c < temp[r].length; c++) {
                System.out.print(temp[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
