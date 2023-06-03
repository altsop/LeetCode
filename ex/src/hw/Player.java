package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    Random random = new Random();

    final String name;
    final String symbol;
    List<Pawn> pawns = new ArrayList<>();
    Integer place;
    final Coordinate start;
    final int initialOffset;

    public Player(String name, List<Coordinate> houses, String symbol, List<Coordinate> storages, Coordinate start, int initialOffset) {
        this.name = name;
        this.symbol = symbol;
        this.start = start;
        this.initialOffset = initialOffset;

        initTokens(
                houses,
                storages
        );
    }

    public int rollDice() {
        return random.nextInt(6) + 1;
    }

    public void putTokenToStorage(Pawn pawn) {
        pawn.pathCoordinate = null;
        pawn.currentShift = initialOffset;
        pawn.coordinateType = CoordinateType.STORAGE;
    }

    public void putTokenToHouse(Pawn pawn) {
        pawn.pathCoordinate = null;
        pawn.coordinateType = CoordinateType.HOUSE;
    }

    public void putTokenOnPath(Pawn pawn) {
        pawn.coordinateType = CoordinateType.PATH;
    }

    public Pawn findTokenInStorage() {
        for (Pawn pawn : pawns) {
            if (pawn.coordinateType == CoordinateType.STORAGE) {
                return pawn;
            }
        }

        return null;
    }

    public List<Pawn> findTokensInHouse() {
        List<Pawn> inHouse = new ArrayList<>();
        for (Pawn pawn : pawns) {
            if (pawn.coordinateType == CoordinateType.HOUSE) {
                inHouse.add(pawn);
            }
        }
        return inHouse;
    }

    public List<Pawn> findTokensOnPath() {
        List<Pawn> availablePawns = new ArrayList<>();
        for (Pawn pawn : pawns) {
            if (pawn.coordinateType == CoordinateType.PATH) {
                availablePawns.add(pawn);
            }
        }
        return availablePawns;
    }

    private void initTokens(List<Coordinate> houses, List<Coordinate> storages) {
        for (int i = 0; i < 4; i++) {
            Pawn pawn = new Pawn(
                    this,
                    i + 1
            );

            pawn.houseCoordinate = houses.get(i);
            pawn.storageCoordinate = storages.get(i);
            pawn.coordinateType = CoordinateType.STORAGE;
            pawn.currentShift = initialOffset;

            pawns.add(pawn);
        }
    }

}
