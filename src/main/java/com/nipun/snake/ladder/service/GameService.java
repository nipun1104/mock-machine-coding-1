package com.nipun.snake.ladder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nipun.snake.ladder.model.Dice;
import com.nipun.snake.ladder.model.Ladder;
import com.nipun.snake.ladder.model.Player;
import com.nipun.snake.ladder.model.Snake;

public class GameService {

    Map<Integer, Integer> ladderMap = new HashMap();
    Map<Integer, Integer> snakeMap = new HashMap();
    Map<Integer, Integer> playerMap = new HashMap();

    public void start(List<Snake> snakes, List<Ladder> ladders, List<Player> players) {
        setup(snakes, ladders, players);
        Dice dice = new Dice();
        boolean notWon = true;
        while (notWon) {
            for (int i = 0; i < players.size(); i++) {
                int move = dice.roll();
                int position = playerMap.get(i);
                if (position + move <= 100) {
                    position = playerMap.get(i) + move;
                }
                if (ladderMap.containsKey(position)) {
                    position = ladders.get(ladderMap.get(position)).getEnd();
                }
                if (snakeMap.containsKey(position)) {
                    position = snakes.get(snakeMap.get(position)).getTail();
                }
                System.out.println(
                        players.get(i).getName() + " rolled a " + move + " and moved from " + playerMap.get(i) +
                                " to " + position);
                playerMap.put(i, position);

                if (position == 100) {
                    System.out.println("Player " + players.get(i).getName() + " have won!");
                    notWon = false;
                    break;
                }
            }
        }
    }

    private void setup(List<Snake> snakes, List<Ladder> ladders, List<Player> players) {
        for (int i = 0; i < snakes.size(); i++) {
            snakeMap.put(snakes.get(i).getHead(), i);
        }
        for (int i = 0; i < ladders.size(); i++) {
            ladderMap.put(ladders.get(i).getStart(), i);
        }
        for (int i = 0; i < players.size(); i++) {
            playerMap.put(i, 0);
        }
    }
}
