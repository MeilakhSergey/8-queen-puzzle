import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static List<List<Point>> result = new LinkedList<List<Point>>();

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            List<Point> root = new ArrayList<Point>(8);
            root.add(new Point(0, i));
            backtracking(root);
        }

        for (List<Point> points : result) {
            System.out.println(points.toString());
        }
    }

    private static void backtracking(List<Point> buffer) {
        if (buffer.size() > 7) {
            List<Point> solution = new ArrayList<Point>();
            solution.addAll(buffer);
            result.add(solution);
            buffer.remove(buffer.size() - 1);

            return;
        }

        for (int j = 0; j < 8; j++) {
            if (accept(buffer, j)) {
                int i = buffer.size();
                buffer.add(new Point(i, j));
                backtracking(buffer);
            }
        }
        buffer.remove(buffer.size() - 1);
    }

    private static boolean accept(List<Point> buffer, int j) {
        int i = buffer.size();
        for (Point point : buffer) {
            int differenceX = Math.abs(point.x - i);
            int differenceY = Math.abs(point.y - j);

            if (point.y == j || differenceX == differenceY) {
                return false;
            }
        }

        return true;
    }
}
