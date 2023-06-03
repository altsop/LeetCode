package hw;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final BoardState boardState;
    private final PlayersState playersState;
    private final Scanner scanner;

    int currentPlayerIndex = 0;
    int place = 0;

    List<String> symbols = List.of(
            "a",
            "b",
            "c",
            "d"
    );

    public Game() {
        this.boardState = new BoardState();
        this.playersState = new PlayersState();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int numberOfPlayers = askNumberOfPlayers();

        for (int i = 0; i < numberOfPlayers; i++) {
            playersState.add(new Player(
                    String.valueOf(i),
                    boardState.houses.get(i),
                    symbols.get(i),
                    boardState.storages.get(i),
                    boardState.starts.get(i),
                    boardState.offsets.get(i)
            ));
        }

        boardState.initWithPlayers(playersState.getPlayers());


        scanner.nextLine();
        while (true) {
            Player finisher = makeStep();
            if (finisher != null) {
                place++;
                finisher.place = place;
            }

            if (place == numberOfPlayers - 1) {
                for (Player player : playersState.getPlayers()) {
                    if (player.place == null) {
                        player.place = numberOfPlayers;
                    }
                }

                playersState.getPlayers().sort(Comparator.comparing(player -> player.place));

                playersState.getPlayers().forEach(player -> System.out.println(
                        String.format(
                                "Player (%s): %d",
                                player.symbol.toUpperCase(),
                                player.place
                        )
                ));
                break;
            }
            boardState.display();
        }
    }

    public Player makeStep() {
        Player player = getNextPlayer();

        int value = player.rollDice();
        System.out.println(
                String.format(
                        "Player (%s) has rolled %d",
                        player.symbol.toUpperCase(),
                        value
                )
        );

        List<Pawn> availablePawns = player.findTokensOnPath();
        if (availablePawns.isEmpty() && value != 6) {
            for (int i = 0; i < 2; i++) {
                value = player.rollDice();
                System.out.println("retry: " + value);
                if (value == 6) {
                    break;
                }
            }
        }


        if (value == 6) {
            // can take from storage
            if (availablePawns.size() < 4) {
                int takeNew = -1;

                if (!availablePawns.isEmpty() && player.findTokenInStorage() != null) {
                    while (takeNew != 0 && takeNew != 1) {
                        System.out.print("Enter [1] if you want to take new (or [0] if you want to move): ");
                        takeNew = scanner.nextInt();
                    }
                }

                if (availablePawns.isEmpty() || takeNew == 1) {
                    Pawn pawn = boardState.takeFromStorage(player);
                    boardState.putToStart(
                            player.start,
                            pawn
                    );
                } else {
                    // move token
                    move(
                            player,
                            value
                    );
                }
            } else {
                // move token
                move(
                        player,
                        value
                );
            }

            // allow to do one step more
            currentPlayerIndex--;
        } else if (availablePawns.isEmpty()) {
            // can do nothing -> skip
            System.out.println(
                    String.format(
                            "Player (%s) skips the turn",
                            player.symbol.toUpperCase()
                    )
            );
            return null;
        } else {
            // just move token
            move(
                    player,
                    value
            );
        }

        // it means that all tokens are in own houses
        if (player.findTokenInStorage() == null && player.findTokensOnPath().isEmpty()) {
            return player;
        }

        return null;
    }

    public void move(Player player, int value) {
        Pawn pawn = chooseToken(player);

        // can just move
        boardState.cleanCurrentPosition(pawn);
        Coordinate coordinate = boardState.moveToPosition(
                player,
                pawn,
                value
        );

        // cannot move further
        if (coordinate == null) {
            boardState.putToHouse(pawn);
        }
    }


//        for (int i = 0; i < playersState.getPlayers().size(); i++) {
//            Player player = playersState.getPlayers().get(i);
//
//            int value;
//            do {
//                value = player.rollDice();
//                player.addStepsToMake(value);
//            } while (value != 6);
//
//            boardState.makeSteps(player);
//            player.resetSteps();
//        }

    public int askNumberOfPlayers() {
        int numberOfPlayers;
        do {
            System.out.print("Enter the number of players (2-4): ");
            numberOfPlayers = scanner.nextInt();
        } while (numberOfPlayers < 2 || numberOfPlayers > 4);
        return numberOfPlayers;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the game!");

        Game game = new Game();
        game.start();
    }

    public Player getNextPlayer() {
        return playersState.getPlayers().get(currentPlayerIndex++ % playersState.getPlayers().size());
    }

    public Pawn chooseToken(Player player) {
        List<Integer> available = player.findTokensOnPath().stream().map(pawn -> pawn.index).toList();

        int index = -1;
        while (!available.contains(index)) {
            System.out.print("Enter token number : ");
            index = scanner.nextInt();
        }

        for (Pawn pawn : player.pawns) {
            if (pawn.index == index) {
                return pawn;
            }
        }

        return null;
    }

}
