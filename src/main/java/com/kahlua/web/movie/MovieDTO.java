package com.kahlua.web.movie;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class MovieDTO {
    private String title,  seq,  rankDate;
}
