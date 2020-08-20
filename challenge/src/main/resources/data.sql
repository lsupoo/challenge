DROP TABLE IF EXISTS exchange_rate;
DROP TABLE IF EXISTS usuario;

CREATE TABLE exchange_rate (
  symbol VARCHAR(3) NOT NULL PRIMARY KEY,
  change DECIMAL NOT NULL
);

CREATE TABLE usuario (
  id bigint NOT NULL PRIMARY KEY,
  activo bit(1) DEFAULT NULL,
  contrasena VARCHAR(255) DEFAULT NULL,
  rol tinyint DEFAULT NULL,
  usuario VARCHAR(255) NOT NULL
);

INSERT INTO exchange_rate (symbol, change) VALUES
  ('USD', 3.54),
  ('SOL', 1.00),
  ('EUR', 4.01),
  ('CAD', 2.88);

INSERT INTO usuario (id, activo, contrasena, rol, usuario) VALUES
(1, 1, 'challenge', 2, 'lsupoo');