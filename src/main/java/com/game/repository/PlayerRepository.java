package com.game.repository;

import com.game.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    Page<Player> findAll(Pageable pageable);
}
