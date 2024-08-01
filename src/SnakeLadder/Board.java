package SnakeLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    List<Snakes> snakes = new ArrayList<>();
    List<Ladder> ladders = new ArrayList<>();
    List<Player> players = new ArrayList<>();

    HashMap<Integer,Integer> boardEntity = new HashMap<>();

    GameStatus gameStatus;

    int game_end = 100;

    static int turn = 0;

    Board(List<Snakes> snakes, List<Ladder> ladders, List<Player> players){
        this.snakes.addAll(snakes);
        this.ladders.addAll(ladders);
        this.players.addAll(players);

        processBoard();

    }

    public void processBoard(){
        for(Snakes snake : snakes){
            boardEntity.put(snake.head,snake.tail);
        }

        for(Ladder ladder : ladders){
            boardEntity.put(ladder.head,ladder.tail);
        }
    }

    void start(){
        int player = turn++;

        turn = turn %  players.size();

        int new_pos = players.get(player).pos + Dice.rollDice();

        if(new_pos <= game_end){
            if(new_pos == game_end){
                gameStatus = GameStatus.WIN;
                System.out.println(players.get(player).name + " wins!");
                return;
            }

            if(boardEntity.containsKey(new_pos)){
                new_pos = boardEntity.get(new_pos);
                System.out.println("bad luck / good luck");
            }

            players.get(player).pos = new_pos;
            System.out.println(players.get(player).name +" moved to "+players.get(player).pos);
        }
    }
}
