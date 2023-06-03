package hw;

import java.util.ArrayList;
import java.util.List;

public class BoardState {

    private static final int ROWS = 12;
    private static final int COLUMNS = 12;

    public String[][] state = {
//            0    1    2    3    4    5    6    7    8    9   10    11
            {" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "1"}, // 0
            {"0", " ", " ", " ", " ", "X", "X", "X", " ", " ", " ", " "}, // 1
            {"1", " ", " ", " ", " ", "X", "o", "X", " ", " ", " ", " "}, // 2
            {"2", " ", " ", " ", " ", "X", "o", "X", " ", " ", " ", " "}, // 3
            {"3", " ", " ", " ", " ", "X", "o", "X", " ", " ", " ", " "}, // 4
            {"4", "X", "X", "X", "X", "X", "o", "X", "X", "X", "X", "X"}, // 5
            {"5", "X", "o", "o", "o", "o", " ", "o", "o", "o", "o", "X"}, // 6
            {"6", "X", "X", "X", "X", "X", "o", "X", "X", "X", "X", "X"}, // 7
            {"7", " ", " ", " ", " ", "X", "o", "X", " ", " ", " ", " "}, // 8
            {"8", " ", " ", " ", " ", "X", "o", "X", " ", " ", " ", " "}, // 9
            {"9", " ", " ", " ", " ", "X", "o", "X", " ", " ", " ", " "}, // 10
            {"1", " ", " ", " ", " ", "X", "X", "X", " ", " ", " ", " "}  // 11
    };

    List<Coordinate> path = new ArrayList<>();

    List<List<Coordinate>> houses = new ArrayList<>();
    List<List<Coordinate>> storages = new ArrayList<>();
    List<Coordinate> starts = new ArrayList<>();
    List<Integer> offsets = List.of(1, 11, 21, 31);

    public BoardState() {
        path.add(new Coordinate(1,
                                5,
                                CoordinateType.PATH
        ));
        Coordinate startA = new Coordinate(
                1,
                6,
                CoordinateType.PATH
        );
        path.add(startA);
        path.add(new Coordinate(1,
                                7,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(2,
                                7,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(3,
                                7,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(4,
                                7,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(5,
                                7,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(5,
                                8,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(5,
                                9,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(5,
                                10,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(5,
                                11,
                                CoordinateType.PATH
        ));
        Coordinate startB = new Coordinate(
                6,
                11,
                CoordinateType.PATH
        );
        path.add(startB);
        path.add(new Coordinate(7,
                                11,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(7,
                                10,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(7,
                                9,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(
                7,
                8,
                CoordinateType.PATH
        ));
        path.add(new Coordinate(7,
                                7,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(8,
                                7,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(9,
                                7,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(10,
                                7,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(11,
                                7,
                                CoordinateType.PATH
        ));
        Coordinate startC = new Coordinate(
                11,
                6,
                CoordinateType.PATH
        );
        path.add(startC);
        path.add(new Coordinate(11,
                                5,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(10,
                                5,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(9,
                                5,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(
                8,
                5,
                CoordinateType.PATH
        ));
        path.add(new Coordinate(7,
                                5,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(7,
                                4,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(7,
                                3,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(7,
                                2,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(7,
                                1,
                                CoordinateType.PATH
        ));
        Coordinate startD = new Coordinate(
                6,
                1,
                CoordinateType.PATH
        );
        path.add(startD);
        path.add(new Coordinate(5,
                                1,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(5,
                                2,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(5,
                                3,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(5,
                                3,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(5,
                                4,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(5,
                                5,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(4,
                                5,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(3,
                                5,
                                CoordinateType.PATH
        ));
        path.add(new Coordinate(2,
                                5,
                                CoordinateType.PATH
        ));

        List<Coordinate> houseA = new ArrayList<>();
        List<Coordinate> houseB = new ArrayList<>();
        List<Coordinate> houseC = new ArrayList<>();
        List<Coordinate> houseD = new ArrayList<>();

        houseA.add(new Coordinate(2,
                                  6,
                                  CoordinateType.HOUSE
        ));
        houseA.add(new Coordinate(3,
                                  6,
                                  CoordinateType.HOUSE
        ));
        houseA.add(new Coordinate(4,
                                  6,
                                  CoordinateType.HOUSE
        ));
        houseA.add(new Coordinate(5,
                                  6,
                                  CoordinateType.HOUSE
        ));

        houseB.add(new Coordinate(6,
                                  10,
                                  CoordinateType.HOUSE
        ));
        houseB.add(new Coordinate(6,
                                  9,
                                  CoordinateType.HOUSE
        ));
        houseB.add(new Coordinate(6,
                                  8,
                                  CoordinateType.HOUSE
        ));
        houseB.add(new Coordinate(6,
                                  7,
                                  CoordinateType.HOUSE
        ));

        houseC.add(new Coordinate(10,
                                  6,
                                  CoordinateType.HOUSE
        ));
        houseC.add(new Coordinate(9,
                                  6,
                                  CoordinateType.HOUSE
        ));
        houseC.add(new Coordinate(8,
                                  6,
                                  CoordinateType.HOUSE
        ));
        houseC.add(new Coordinate(7,
                                  6,
                                  CoordinateType.HOUSE
        ));

        houseD.add(new Coordinate(6,
                                  2,
                                  CoordinateType.HOUSE
        ));
        houseD.add(new Coordinate(6,
                                  3,
                                  CoordinateType.HOUSE
        ));
        houseD.add(new Coordinate(6,
                                  4,
                                  CoordinateType.HOUSE
        ));
        houseD.add(new Coordinate(6,
                                  5,
                                  CoordinateType.HOUSE
        ));

        houses.add(houseA);
        houses.add(houseB);
        houses.add(houseD);
        houses.add(houseC);

        List<Coordinate> storageA = new ArrayList<>();
        storageA.add(new Coordinate(1,
                                    1,
                                    CoordinateType.STORAGE
        ));
        storageA.add(new Coordinate(1,
                                    2,
                                    CoordinateType.STORAGE
        ));
        storageA.add(new Coordinate(2,
                                    1,
                                    CoordinateType.STORAGE
        ));
        storageA.add(new Coordinate(2,
                                    2,
                                    CoordinateType.STORAGE
        ));

        List<Coordinate> storageB = new ArrayList<>();
        storageB.add(new Coordinate(1,
                                    10,
                                    CoordinateType.STORAGE
        ));
        storageB.add(new Coordinate(1,
                                    11,
                                    CoordinateType.STORAGE
        ));
        storageB.add(new Coordinate(2,
                                    10,
                                    CoordinateType.STORAGE
        ));
        storageB.add(new Coordinate(2,
                                    11,
                                    CoordinateType.STORAGE
        ));

        List<Coordinate> storageC = new ArrayList<>();
        storageC.add(new Coordinate(10,
                                    1,
                                    CoordinateType.STORAGE
        ));
        storageC.add(new Coordinate(10,
                                    2,
                                    CoordinateType.STORAGE
        ));
        storageC.add(new Coordinate(11,
                                    1,
                                    CoordinateType.STORAGE
        ));
        storageC.add(new Coordinate(11,
                                    2,
                                    CoordinateType.STORAGE
        ));

        List<Coordinate> storageD = new ArrayList<>();
        storageD.add(new Coordinate(10,
                                    10,
                                    CoordinateType.STORAGE
        ));
        storageD.add(new Coordinate(10,
                                    11,
                                    CoordinateType.STORAGE
        ));
        storageD.add(new Coordinate(11,
                                    10,
                                    CoordinateType.STORAGE
        ));
        storageD.add(new Coordinate(11,
                                    11,
                                    CoordinateType.STORAGE
        ));

        storages.add(storageA);
        storages.add(storageB);
        storages.add(storageD);
        storages.add(storageC);

        starts.add(startA);
        starts.add(startB);
        starts.add(startC);
        starts.add(startD);
    }

    public void display() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                String symbol = state[row][column];
                builder.append("  ").append(symbol);
                if (symbol.length() == 1) {
                    builder.append(" ");
                }
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    public void initWithPlayers(List<Player> players) {
        for (Player player : players) {
            displayStorage(player);
        }
    }

    private void displayStorage(Player player) {
        for (int i = 0; i < player.pawns.size(); i++) {
            Pawn pawn = player.pawns.get(i);
            Coordinate coordinate = pawn.storageCoordinate;
            updatedBoardState(
                    coordinate,
                    pawn.getValue()
            );
        }
    }

    public void putToHouse(Pawn pawn) {
        pawn.player.putTokenToHouse(pawn);

        Coordinate houseCoordinate = pawn.houseCoordinate;
        updatedBoardState(
                houseCoordinate,
                pawn.getValue()
        );
    }

    public void putToStart(Coordinate start, Pawn pawn) {
        // eat
        if (start.pawn != null) {
            updatedBoardState(start.pawn.storageCoordinate, start.pawn.getValue());
            start.pawn.player.putTokenToStorage(start.pawn);
            updatedBoardState(start, pawn.getValue());
        }

        start.pawn = pawn;
        pawn.player.putTokenOnPath(pawn);
        pawn.pathCoordinate = start;

        updatedBoardState(start, pawn.getValue());
    }

    public Pawn takeFromStorage(Player player) {
        Pawn pawn = player.findTokenInStorage();
        updatedBoardState(pawn.storageCoordinate, " ");
        return pawn;
    }

    public void cleanCurrentPosition(Pawn pawn) {
        Coordinate current = path.get(pawn.currentShift % path.size());
        current.pawn = null;

        updatedBoardState(
                current,
                "X"
        );
    }

    public Coordinate moveToPosition(Player player, Pawn pawn, Integer stepsToMake) {
        if (stepsToMake + pawn.currentShift - player.initialOffset >= path.size()) {
            return null;
        }


        Coordinate coordinate = path.get((stepsToMake + pawn.currentShift) % path.size());

        // eat
        if (coordinate.pawn != null) {
            updatedBoardState(coordinate.pawn.storageCoordinate, coordinate.pawn.getValue());
            coordinate.pawn.player.putTokenToStorage(coordinate.pawn);

            updatedBoardState(coordinate, pawn.getValue());
        }

        coordinate.pawn = pawn;
        updatedBoardState(
                coordinate,
                pawn.getValue()
        );
        pawn.currentShift+=stepsToMake;

        return coordinate;
    }

    private void updatedBoardState(Coordinate coordinate, String value) {
        state[coordinate.y][coordinate.x] = value;
    }

    public void putToStorage(Pawn pawn) {
        Coordinate emptyStorage = pawn.storageCoordinate;
        updatedBoardState(
                emptyStorage,
                pawn.getValue()
        );
    }

}
