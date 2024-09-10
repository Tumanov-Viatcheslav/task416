import java.util.ArrayList;
import java.util.List;

public class Horseman {
    private int x, y;

    public List<int[]> eat() {
        int[] sign = {-1, 1}, result;
        boolean[] isDirect = {true, false};
        List<int[]> results = new ArrayList<>();
        for (int xSign: sign) {
            for (int ySign: sign) {
                for (boolean order: isDirect) {
                    if (order &&
                            ((this.x + xSign) < 8) && ((this.x + xSign) >= 0) &&
                            ((this.y + ySign * 2) < 8) && ((this.y + ySign * 2) >= 0)) {
                        result = new int[2];
                        result[0] = this.x + xSign;
                        result[1] = this.y + ySign * 2;
                        results.add(result);
                    }
                    else if (!order &&
                            ((this.x + xSign * 2) < 8) && ((this.x + xSign * 2) >= 0) &&
                            ((this.y + ySign) < 8) && ((this.y + ySign) >= 0)) {
                        result = new int[2];
                        result[0] = this.x + xSign * 2;
                        result[1] = this.y + ySign;
                        results.add(result);
                    }
                }
            }
        }
        return results;
    }
    public Horseman(int x, int y) {
        this.x = x;
        this.y = y;
    }
}