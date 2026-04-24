CREATE TABLE consertos (
    id          BIGINT NOT NULL AUTO_INCREMENT,
    data_entrada VARCHAR(10) NOT NULL,
    data_saida   VARCHAR(10),
    nome         VARCHAR(100) NOT NULL,
    anos_experiencia INT,
    marca        VARCHAR(100) NOT NULL,
    modelo       VARCHAR(100) NOT NULL,
    ano          VARCHAR(4) NOT NULL,
    PRIMARY KEY (id)
);
