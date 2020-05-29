package com.kahlua.web.soccer;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SoccerController {
}
