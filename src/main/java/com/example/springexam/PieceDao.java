package com.example.springexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class
PieceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public List<PieceItem> findAll() {
        String query = "SELECT * FROM piece_tbl";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
        List<PieceItem> pieceItems = result.stream().map((Map<String, Object> row) ->
            pieceItemFactory(row)
        ).toList();

        return pieceItems;
    }

    @Transactional
    public PieceItem findByNumber(int number) {
        String query = "SELECT * FROM piece_tbl WHERE number = ?";
        Map<String, Object> result = jdbcTemplate.queryForMap(query, number);
        PieceItem pieceItem = pieceItemFactory(result);

        return pieceItem;
    }

    private PieceItem pieceItemFactory(Map<String, Object> row) {
        return new PieceItem(
                (Long)row.get("id"),
                (Integer)row.get("number"),
                (String)row.get("name"),
                (String)row.get("color"),
                (String)row.get("shape"));
    }
}


