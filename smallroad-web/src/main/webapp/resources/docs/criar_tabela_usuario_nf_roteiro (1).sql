CREATE DATABASE  IF NOT EXISTS `smallroad_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `smallroad_db`;

-- ------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--


DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `nickname` varchar(45) NOT NULL,
  `perfil` varchar(45) NOT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `roteiro`;
CREATE TABLE `roteiro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `finalizado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `nf`;
CREATE TABLE `nf` (
  `numero` int(11) NOT NULL ,
  `cep_origem` int(8) NOT NULL,
  `end_origem` varchar(45) NOT NULL,
  `cep_destino` int(8) NOT NULL,
  `end_destino` varchar(45) NOT NULL,
  `distancia` decimal(5,2) DEFAULT NULL,
  `entregue` varchar(45) NOT NULL,
  `roteiro_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  FOREIGN KEY  (`roteiro_id`) 
  REFERENCES roteiro(`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;

-----

INSERT INTO `usuario` VALUES 
	(1,'Rodrigo Carvalho','rodrigodoe','ADMIN','rodrigo123','rodrigo@alunofg.com.br'),
	(2,'Gil Rodrigues','gil','ADMIN','gil123','gil@alunofg.com.br'),
    (3,'Gabriel Alves','gabriel','ADMIN','gabriel123','gabriel@alunofg.com.br'),
    (4,'Fabio Oliveira','fabinho','ADMIN','fabio123','fabio@alunofg.com.br');

/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

LOCK TABLES `nf` WRITE;
/*!40000 ALTER TABLE `nf` DISABLE KEYS */;

INSERT INTO `nf` (numero,cep_origem,end_origem,cep_destino,end_destino) VALUES 
	(32404,54315010,'Estrada da batalha, 461',54400620,'Ulysses Montarroyos, 2330'),
	(13243,54315010,'Estrada da batalha, 461',54400450,'Rua Severino Jose de Paula, 44'),
	(42352,54315010,'Estrada da batalha, 461',51020030,'Av. Eng. Domingos Ferreira, 4140'),
	(97542,54315010,'Estrada da batalha, 461',54410390,'Rua Jose Braz Moscow, 521'),
	(78912,54315010,'Estrada da batalha, 461',51030090,'R. Alm. Tamandaré, 170');

/*!40000 ALTER TABLE `nf` ENABLE KEYS */;

LOCK TABLES `roteiro` WRITE;
/*!40000 ALTER TABLE `roteiro` DISABLE KEYS */;
INSERT INTO `roteiro`(id,nome) VALUES 
	(1,'Roteiro_JBO'),
	(2,'Roteiro_REC'),
	(3,'Roteiro_Areias'),
	(4,'Roteiro_Paulista'),
	(5,'Roteiro_Caruaru');  
    
/*!40000 ALTER TABLE `roteiro` ENABLE KEYS */;


UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


