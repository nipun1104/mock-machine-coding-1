package com.nipun.snake.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nipun.snake.ladder.model.Ladder;
import com.nipun.snake.ladder.model.Player;
import com.nipun.snake.ladder.model.Snake;
import com.nipun.snake.ladder.service.GameService;

public class Application {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter snakes");
        int numSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList();
        for(int i=0; i< numSnakes; i++){
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            snakes.add(new Snake(head, tail));
        }

        System.out.println("Enter ladders");
        int numLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList();
        for(int i=0; i< numLadders; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            ladders.add(new Ladder(start, end));
        }

        System.out.println("Enter players");
        int numPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        for (int i=0; i<numPlayers; i++){
            String name = scanner.next();
            players.add(new Player(name));
        }

        GameService game = new GameService();
        game.start(snakes, ladders, players);
    }
}

