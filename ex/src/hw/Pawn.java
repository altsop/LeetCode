package hw;

public class Pawn {

    final Player player;
    final int index;
    Coordinate houseCoordinate;
    Coordinate storageCoordinate;
    Coordinate pathCoordinate;

    CoordinateType coordinateType;

    int currentShift = 0;

    public Pawn(Player player, int index) {
        this.player = player;
        this.index = index;
    }

    public Coordinate getCoordinate() {
        switch (coordinateType){
            case PATH -> {
                return pathCoordinate;
            }
            case HOUSE -> {
                return houseCoordinate;
            }
            case STORAGE -> {
                return storageCoordinate;
            }
        }

        return null;
    }

    public String getValue() {
        return String.format("%s%s", player.symbol, index);
    }

}
