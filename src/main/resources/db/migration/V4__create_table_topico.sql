CREATE TABLE Topico (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        titulo VARCHAR(255) NOT NULL,
                        mensagem TEXT NOT NULL,
                        dataCriacao DATETIME NOT NULL,
                        status VARCHAR(100) NOT NULL,
                        autor INT NOT NULL,
                        curso INT NOT NULL,
                        FOREIGN KEY (autor) REFERENCES Usuario(id),
                        FOREIGN KEY (curso) REFERENCES Curso(id)
);