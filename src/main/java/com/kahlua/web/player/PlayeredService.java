package com.kahlua.web.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayeredService {
    @Autowired PlayeredRepository playeredRepository;
}
