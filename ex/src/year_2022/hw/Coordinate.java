package year_2022.hw;

public class Coordinate {

    final int x;
    final int y;
    final CoordinateType type;
    Pawn pawn;

    public Coordinate(int y, int x, CoordinateType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
