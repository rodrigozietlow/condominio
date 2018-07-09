CREATE TABLE `Morador` (
	`id` int NOT NULL,
	`nome` varchar(50) NOT NULL,
	`cpf` varchar(14) NOT NULL,
	`rg` varchar(10) NOT NULL,
	`sexo` char(1) NOT NULL,
	`idade` smallint NOT NULL,
	`renda` float(5,2) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Edificio` (
	`id` int NOT NULL,
	`andares` smallint NOT NULL,
	`cor` varchar(7) NOT NULL,
	`idCondominio` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Condominio` (
	`id` int NOT NULL,
	`nome` varchar(50) NOT NULL,
	`cidade` varchar(50) NOT NULL,
	`bairro` varchar(50) NOT NULL,
	`numero` varchar(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Apartamento` (
	`id` int NOT NULL,
	`numero` smallint NOT NULL,
	`andar` smallint NOT NULL,
	`tipo` smallint NOT NULL,
	`idEdificio` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Luxo` (
	`idApartamento` int NOT NULL,
	`luminarias` boolean NOT NULL,
	`geladeira` boolean NOT NULL,
	`fogao` boolean NOT NULL
);

CREATE TABLE `Padrão` (
	`idApartamento` int NOT NULL,
	`tipoArmarios` varchar(50) NOT NULL,
	`tipoPisos` varchar(50) NOT NULL
);

CREATE TABLE `Morador_Apartamento` (
	`idMorador` int NOT NULL,
	`idApartamento` int NOT NULL,
	`data` Date NOT NULL
);

ALTER TABLE `Apartamento` ADD FOREIGN KEY (`idEdificio`) REFERENCES `Edificio`(`id`);
ALTER TABLE `Luxo` ADD FOREIGN KEY (`idApartamento`) REFERENCES `Apartamento`(`id`);
ALTER TABLE `Padrão` ADD FOREIGN KEY (`idApartamento`) REFERENCES `Apartamento`(`id`);
ALTER TABLE `Morador_Apartamento` ADD FOREIGN KEY (`idMorador`) REFERENCES `Morador`(`id`);
ALTER TABLE `Morador_Apartamento` ADD FOREIGN KEY (`idApartamento`) REFERENCES `Apartamento`(`id`);