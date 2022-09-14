package com.example.springexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RestController
public class PieceRestController {

    @Autowired
    private PieceDao pieceDao;

    @GetMapping("/findall")
    public List<PieceItem> findAll() {
        log.info("REST /findall START");
        List<PieceItem> res = pieceDao.findAll();
        log.info("REST /findall END");
        return res;
    }
}
