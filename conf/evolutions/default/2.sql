# expense schema

# --- !Ups

CREATE TABLE expense
(
  id BIGINT(11) NOT NULL AUTO_INCREMENT,
  title_id integer(10),
  item_name varchar(20),
  price integer(10),
  ex_check integer(1),
  ex_order integer(2),
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE expense;