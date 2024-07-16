CREATE TABLE Usuario (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         nome VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         senha VARCHAR(255) NOT NULL,
                         categoria VARCHAR(100) NOT NULL,
                         FOREIGN KEY (categoria) REFERENCES Perfil(categoria)
);