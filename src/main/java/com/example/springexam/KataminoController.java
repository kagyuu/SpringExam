package com.example.springexam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Katamino")
public class KataminoController {

    private static final Block[] BLOCKS = new Block[]{
        new Block( 1 ,"purple"  ,new int[][]{{0,1,1,1},{1,1,0,0}}),
        new Block( 2 ,"pink"    ,new int[][]{{0,1,1},{1,1,1}}),
        new Block( 3 ,"yellow"  ,new int[][]{{1,0,1},{1,1,1}}),
        new Block( 4 ,"green"   ,new int[][]{{1,0,0},{1,1,0},{0,1,1}}),
        new Block( 5 ,"orange"  ,new int[][]{{1,0,0,0},{1,1,1,1}}),
        new Block( 6 ,"brawn"   ,new int[][]{{0,1,0,0},{1,1,1,1}}),
        new Block( 7 ,"cyan"    ,new int[][]{{1,1,1,1,1}}),
        new Block( 8 ,"gray"    ,new int[][]{{1,1,0},{0,1,1},{0,1,0}}),
        new Block( 9 ,"cyan"    ,new int[][]{{1,0,0},{1,0,0},{1,1,1}}),
        new Block(10 ,"cyan"    ,new int[][]{{1,1,0},{0,1,0},{0,1,1}}),
        new Block(11 ,"red"     ,new int[][]{{0,1,0},{1,1,1},{0,1,0}}),
        new Block(12 ,"green"   ,new int[][]{{1,1,1},{0,1,0},{0,1,0}})
    };

    @GetMapping("pieces")
    public Block[] getPieces(){
        return BLOCKS;
    }

    @GetMapping("piece/{id}")
    public Block getPiece(@PathVariable int id) {
        return BLOCKS[id - 1];
    }

    @GetMapping("variation/{id}")
    public List<int[][]> getVariation(@PathVariable int id) {
        return BLOCKS[id - 1].variation();
    }
}
