import java.util.Scanner;

//1表示存活，0表示死亡
public class Game {
    public static int max = 6;//细胞矩阵大小

    //判断周围是否为合法区域
    private boolean judge(int a, int b) {
        if (a > -1 && b > -1 && a < max && b < max) {
            return true;
        }
        return false;
    }

    //细胞变化
    public int[][] grow(int[][] cells) {
        int[][] temp = new int[max][max];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                temp[i][j] = cells[i][j];
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                int n = 0;
                if (judge(i - 1, j - 1) && temp[i - 1][j - 1] == 1) n++;
                if (judge(i - 1, j) && temp[i - 1][j] == 1) n++;
                if (judge(i - 1, j + 1) && temp[i - 1][j + 1] == 1) n++;
                if (judge(i, j - 1) && temp[i][j - 1] == 1) n++;
                if (judge(i, j + 1) && temp[i][j + 1] == 1) n++;
                if (judge(i + 1, j - 1) && temp[i + 1][j - 1] == 1) n++;
                if (judge(i + 1, j) && temp[i + 1][j] == 1) n++;
                if (judge(i + 1, j + 1) && temp[i + 1][j + 1] == 1) n++;
                if (temp[i][j] == 1) {
                    if (n < 2 || n > 3) cells[i][j] = 0;
                } else {
                    if (n == 3) cells[i][j] = 1;
                }
            }
        }
        return cells;
    }

    //打印细胞矩阵
    private void print(int[][] cells) {
        System.out.print("--------------------------------\n");
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (cells[i][j] == 1) {
                    System.out.print("■ ");
                } else {
                    System.out.print("□ ");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]) {
        Game game = new Game();
        int[][] cells = new int[max][max];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                cells[i][j] = in.nextInt();
            }
        }
        game.print(cells);
        for (int i = 0; i < 10; i++) {
            cells = game.grow(cells);
            game.print(cells);
        }
    }
}
