CREATE TABLE item_do_pedido (
  id SERIAL PRIMARY KEY NOT NULL,
  descricao VARCHAR(255) DEFAULT NULL,
  quantidade INT NOT NULL,
  pedido_id BIGINT NOT NULL,
  FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
);