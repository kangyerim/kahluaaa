package com.kahlua.web.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayeredRepository extends JpaRepository<Playered, Long> {
}
