# live_title schema

# --- !Ups

CREATE TABLE liveTitle
(
  id BIGINT(11) NOT NULL AUTO_INCREMENT,
  user_id integer(10),
  title varchar(20),
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE liveTitle;