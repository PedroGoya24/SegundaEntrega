Create database ADois;

use ADois;
Create table clientes(
	idCli INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nomeCli Varchar(255),
    idadeCli INT,
    enderecoCli Varchar(255),
    rgCli varchar(12),
    telefoneCli varchar(16)
);

Create table destinos(
	idDes INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nomeDest varchar(50)
);


Create table pacotes(
	idPac INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    tipoPac varchar(20),
    precoPac FLOAT,
    idDes INT,
    promocao BOOLEAN,
    foreign key(idDes) references destinos(idDes)    
);

Create table compras(
	idComp INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    idCli INT,
    idPac INT, 
    dataIda DATETIME,
    dataVolta DATETIME,
    foreign key(idCli) references clientes(idCli),    
    foreign key(idPac) references pacotes(idPac)
);


