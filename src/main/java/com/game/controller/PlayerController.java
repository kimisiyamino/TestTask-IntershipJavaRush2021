package com.game.controller;

import com.game.entity.Player;
import com.game.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PlayerController {

    private IPlayerService playerService;

    @Autowired
    public PlayerController(IPlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayers(@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
                                                      @RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize,
                                                      @RequestParam(value = "order", required = false, defaultValue = "id") String order){
        List<Player> players = playerService.getAllPlayers(pageNumber, pageSize, order.toLowerCase());
        return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Integer id){
        Player player = playerService.getPlayerById(id);
        return new ResponseEntity<Player>(player, HttpStatus.OK);
    }

    @GetMapping("/players/count")
    public Integer getPlayersCount(){
        return playerService.count();
    }
}
