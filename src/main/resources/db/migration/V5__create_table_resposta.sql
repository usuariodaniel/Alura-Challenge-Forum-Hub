CREATE TABLE Resposta (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          mensagem TEXT NOT NULL,
                          topico INT NOT NULL,
                          dataCriacao DATETIME NOT NULL,
                          autor INT NOT NULL,
                          FOREIGN KEY (topico) REFERENCES Topico(id),
                          FOREIGN KEY (autor) REFERENCES Usuario(id)
);