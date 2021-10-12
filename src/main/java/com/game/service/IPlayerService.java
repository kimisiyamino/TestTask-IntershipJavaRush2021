package com.game.service;

import com.game.entity.Player;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IPlayerService {

    List<Player> getAllPlayers(int pageNumber, int pageSize, String order);
    //List<Player> getCountPlayers(Integer pageNumber, Integer pageSize, String order);
    Player getPlayerById(long playerId);
    boolean addPlayer(Player player);
    void updatePlayer(Player player);
    void deletePlayer(int playerId);
    Integer count();
}
