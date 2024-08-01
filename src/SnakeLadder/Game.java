package SnakeLadder;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static void main(String[] args) {

        List<Snakes> snakes = new ArrayList<>();
        List<Ladder> ladders = new ArrayList<>();
        List<Player> players = new ArrayList<>();

        snakes.add(new Snakes(99,60));
        snakes.add(new Snakes(98,80));
        snakes.add(new Snakes(64,60));
        snakes.add(new Snakes(87,36));
        snakes.add(new Snakes(62,19));
        snakes.add(new Snakes(54,34));

        ladders.add(new Ladder(4,14));
        ladders.add(new Ladder(28,84));
        ladders.add(new Ladder(1,38));
        ladders.add(new Ladder(21,42));
        ladders.add(new Ladder(51,67));
        ladders.add(new Ladder(80,99));

        players.add(new Player("John"));
        players.add(new Player("Chan"));
        players.add(new Player("Abby"));
        players.add(new Player("Bill"));

        Board board = new Board(snakes,ladders,players);

        while(board.gameStatus != GameStatus.WIN){
            board.start();
        }


    }
}
