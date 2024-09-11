import java.util.ArrayList;
import java.util.List;

public class Horseman {
    private int x, y;

    public List<Position> eat() {
        int[] sign = {-1, 1};
        Position result;
        boolean[] isDirect = {true, false};
        List<Position> results = new ArrayList<>();
        for (int xSign: sign) {
            for (int ySign: sign) {
                for (boolean order: isDirect) {
                    if (order &&
                            ((this.x + xSign) < 8) && ((this.x + xSign) >= 0) &&
                            ((this.y + ySign * 2) < 8) && ((this.y + ySign * 2) >= 0)) {
                        result = new Position();
                        result.first = this.x + xSign;
                        result.second = this.y + ySign * 2;
                        results.add(result);
                    }
                    else if (!order &&
                            ((this.x + xSign * 2) < 8) && ((this.x + xSign * 2) >= 0) &&
                            ((this.y + ySign) < 8) && ((this.y + ySign) >= 0)) {
                        result = new Position();
                        result.first = this.x + xSign * 2;
                        result.second = this.y + ySign;
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