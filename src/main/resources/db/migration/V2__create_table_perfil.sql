CREATE TABLE Perfil (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        categoria VARCHAR(100) NOT NULL,
                        UNIQUE KEY categoria(categoria)
);