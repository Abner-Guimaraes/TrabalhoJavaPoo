CREATE TABLE produtos_table(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  short_description VARCHAR(100),
  brand VARCHAR(64),
  category VARCHAR(64),
  list_price DECIMAL(5,2) NOT NULL,
  cost DECIMAL(5,2)
);