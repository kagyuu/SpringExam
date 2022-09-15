package com.example.springexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class PieceRestController {

    @Autowired
    private PieceDao pieceDao;

    @GetMapping("/findall")
    @ResponseBody
    public List<PieceItem> findAll() {
        log.info("REST /findall START");
        List<PieceItem> res = pieceDao.findAll();
        log.info("REST /findall END");
        return res;
    }

    @GetMapping("/findByNumber")
    @ResponseBody
    public PieceItem getPiece(@RequestParam int number) {
        log.info("REST /getPiece {} START", number);
        PieceItem res = pieceDao.findByNumber(number);
        log.info("REST /getPiece {} END", number);
        return res;
    }
}
