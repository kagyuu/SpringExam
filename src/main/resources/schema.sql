DROP TABLE piece_tbl;

CREATE TABLE IF NOT EXISTS piece_tbl (
  id BIGINT PRIMARY KEY auto_increment,
  number INT,
  name VARCHAR(255),
  color VARCHAR(255),
  shape VARCHAR(255)
);