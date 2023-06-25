package year_2022.hw;

import java.util.ArrayList;
import java.util.List;

public class PlayersState {

    private List<Player> players = new ArrayList<>();

    public void add(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

}
