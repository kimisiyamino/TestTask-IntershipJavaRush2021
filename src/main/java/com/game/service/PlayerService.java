package com.game.service;

import com.game.entity.Player;
import com.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService{

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers(int pageNumber, int pageSize, String order) {
        List<Player> players = new ArrayList<>();
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(order));
        Page<Player> pagedResult = playerRepository.findAll(paging);
        //playerRepository.findAll(paging).forEach(e -> players.add(e));
        return pagedResult.getContent();
    }


    public List<Player> getCountPlayers() {
        return null;
    }

    @Override
    public Player getPlayerById(long playerId) {
        Optional<Player> playerOpt = playerRepository.findById(playerId);
        return playerOpt.get();
    }

    @Override
    public synchronized boolean addPlayer(Player player) {
        return false;
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void deletePlayer(int playerId) {
        playerRepository.delete(getPlayerById(playerId));
    }

    public Integer count() {
        return Long.valueOf(playerRepository.count()).intValue();
    }
}
