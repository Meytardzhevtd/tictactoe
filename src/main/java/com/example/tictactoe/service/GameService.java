package com.example.tictactoe.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.Player;

public class GameService {
    // Game-id -> Game
    private Map<Long, Game> activGames = new ConcurrentHashMap<>();

    private static final AtomicLong idCounter = new AtomicLong(0);

    private static long getNextId() {
        return idCounter.getAndIncrement();
    }

    public Long createGame(Player creator) {
        if (creator == null) {
            return null;
        }
        Game game = new Game();
        if (game.joinPlayer(creator)) {
            Long newId = getNextId();
            activGames.put(newId, game);
            return newId;
        } else {
            return null;
        }
    }

    /**
     * Returns true if player was joined the game
     * 
     * @param gameId
     * @param player
     * @return
     */
    public boolean joinGame(Long gameId, Player player) {
        if (activGames.containsKey(gameId)) {
            if (activGames.get(gameId).joinPlayer(player)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean makeMove(Long gameId, Player player, int row, int col) {
        // return true if move was made
        if (activGames.containsKey(gameId)) {
            if (activGames.get(gameId).makeMove(player, row, col)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Game findGame(Long gameId) {
        if (activGames.containsKey(gameId)) {
            return activGames.get(gameId);
        } else {
            return null;
        }
    }
}
