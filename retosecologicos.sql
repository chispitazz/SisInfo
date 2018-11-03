CREATE DATABASE  IF NOT EXISTS `retosecologicos` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `retosecologicos`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: retosecologicos
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumno` (
  `idalumno` int(7) NOT NULL,
  `correo` varchar(16) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `Password` tinytext NOT NULL COMMENT 'password de 747325 = 21234',
  `ano_matricula` year(4) NOT NULL,
  `Carrera` int(4) NOT NULL,
  PRIMARY KEY (`idalumno`),
  UNIQUE KEY `alumnocol_UNIQUE` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (747325,NULL,'eaao','$31$16$eI_oFK4K_hE27_eEwB7f64j4nge4mcgWIu06_m_7ObU',0000,412);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anonimo`
--

DROP TABLE IF EXISTS `anonimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `anonimo` (
  `idAnonimo` int(11) NOT NULL AUTO_INCREMENT,
  `Nick` varchar(45) NOT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  `Password` tinytext,
  `Ocupacion` varchar(45) DEFAULT NULL,
  `AnoNacimiento` year(4) DEFAULT NULL,
  `Puntos` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAnonimo`,`Nick`),
  UNIQUE KEY `Correo_UNIQUE` (`Correo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anonimo`
--

LOCK TABLES `anonimo` WRITE;
/*!40000 ALTER TABLE `anonimo` DISABLE KEYS */;
INSERT INTO `anonimo` VALUES (1,'Ass','unCorreo@correo.es','$31$16$eI_oFK4K_hE27_eEwB7f64j4nge4mcgWIu06_m_7ObU','NINI',1990,0),(3,'ASS','Ass@correo.es','$31$16$eI_oFK4K_hE27_eEwB7f64j4nge4mcgWIu06_m_7ObU','NINI',1990,0),(4,'OSS','Oss@correo.es','$31$16$eI_oFK4K_hE27_eEwB7f64j4nge4mcgWIu06_m_7ObU','NINI',1990,0);
/*!40000 ALTER TABLE `anonimo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apoyadoen`
--

DROP TABLE IF EXISTS `apoyadoen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `apoyadoen` (
  `ID_cartel` int(11) NOT NULL,
  `ID_link` int(11) NOT NULL,
  PRIMARY KEY (`ID_cartel`,`ID_link`),
  KEY `Apoyado_Cartel_idx` (`ID_link`),
  CONSTRAINT `Apoyado_Cartel` FOREIGN KEY (`ID_link`) REFERENCES `referencias` (`idreferencias`),
  CONSTRAINT `Referencias_Cartel` FOREIGN KEY (`ID_cartel`) REFERENCES `carteles` (`idcarteles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apoyadoen`
--

LOCK TABLES `apoyadoen` WRITE;
/*!40000 ALTER TABLE `apoyadoen` DISABLE KEYS */;
/*!40000 ALTER TABLE `apoyadoen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carteles`
--

DROP TABLE IF EXISTS `carteles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `carteles` (
  `idCarteles` int(11) NOT NULL AUTO_INCREMENT,
  `grupo_Autor` int(11) NOT NULL,
  `Titulo` varchar(45) NOT NULL,
  `Texto` text NOT NULL,
  `Nota` double DEFAULT NULL,
  `Reto` text,
  `FechaPublicacion` datetime DEFAULT NULL,
  `Votos` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCarteles`,`grupo_Autor`),
  KEY `grupo_idx` (`grupo_Autor`),
  CONSTRAINT `grupo` FOREIGN KEY (`grupo_Autor`) REFERENCES `grupotrabajo` (`idgrupotrabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carteles`
--

LOCK TABLES `carteles` WRITE;
/*!40000 ALTER TABLE `carteles` DISABLE KEYS */;
/*!40000 ALTER TABLE `carteles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupotrabajo`
--

DROP TABLE IF EXISTS `grupotrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grupotrabajo` (
  `idGrupoTrabajo` int(11) NOT NULL,
  `Alumno_1` int(7) NOT NULL,
  `Alumno_2` int(7) NOT NULL,
  `Alumno_3` int(7) NOT NULL,
  `Alumno_4` int(7) NOT NULL,
  PRIMARY KEY (`idGrupoTrabajo`),
  KEY `Alumno_1_idx` (`Alumno_1`),
  KEY `Alumno_2_idx` (`Alumno_2`),
  KEY `Alumno_3_idx` (`Alumno_3`),
  KEY `Alumno_4_idx` (`Alumno_4`),
  CONSTRAINT `Alumno_1` FOREIGN KEY (`Alumno_1`) REFERENCES `alumno` (`idalumno`),
  CONSTRAINT `Alumno_2` FOREIGN KEY (`Alumno_2`) REFERENCES `alumno` (`idalumno`),
  CONSTRAINT `Alumno_3` FOREIGN KEY (`Alumno_3`) REFERENCES `alumno` (`idalumno`),
  CONSTRAINT `Alumno_4` FOREIGN KEY (`Alumno_4`) REFERENCES `alumno` (`idalumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupotrabajo`
--

LOCK TABLES `grupotrabajo` WRITE;
/*!40000 ALTER TABLE `grupotrabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupotrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noticias`
--

DROP TABLE IF EXISTS `noticias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `noticias` (
  `idNoticias` int(11) NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(45) NOT NULL,
  `Noticia` text NOT NULL,
  `Imagen` varchar(45) DEFAULT NULL,
  `Talternativo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idNoticias`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticias`
--

LOCK TABLES `noticias` WRITE;
/*!40000 ALTER TABLE `noticias` DISABLE KEYS */;
INSERT INTO `noticias` VALUES (1,'primera noticia publicada','esto es una noticia publicada y no hay mucho más que decir','./css/imagenes/box-image1.gif','imagen de una noticia');
/*!40000 ALTER TABLE `noticias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `preguntas` (
  `id_Cartel` int(11) NOT NULL,
  `Pregunta` tinytext NOT NULL,
  PRIMARY KEY (`id_Cartel`),
  CONSTRAINT `Cartel` FOREIGN KEY (`id_Cartel`) REFERENCES `carteles` (`idcarteles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profesor` (
  `idProfesor` int(11) NOT NULL AUTO_INCREMENT,
  `Correo` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Password` tinytext NOT NULL,
  `Departamento` varchar(45) DEFAULT NULL,
  `SitioWeb` varchar(45) DEFAULT NULL,
  `Despacho` varchar(45) DEFAULT NULL,
  `Administrador` tinyint(1) NOT NULL,
  PRIMARY KEY (`idProfesor`),
  UNIQUE KEY `Correo_UNIQUE` (`Correo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'UNO@unizar.es','Perico el de los palotes','$31$16$eI_oFK4K_hE27_eEwB7f64j4nge4mcgWIu06_m_7ObU','ataques biologicos','unSitioWeb.com','44.0b',0);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntua`
--

DROP TABLE IF EXISTS `puntua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `puntua` (
  `ID_profesor` int(11) NOT NULL,
  `ID_cartel` int(11) NOT NULL,
  `FechaEvaluacion` date DEFAULT NULL,
  `Puntos` double DEFAULT NULL,
  `Votos` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_profesor`,`ID_cartel`),
  KEY `puntaA_idx` (`ID_cartel`),
  CONSTRAINT `cartel_puntoado_por` FOREIGN KEY (`ID_profesor`) REFERENCES `profesor` (`idProfesor`),
  CONSTRAINT `puntaA` FOREIGN KEY (`ID_cartel`) REFERENCES `carteles` (`idcarteles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntua`
--

LOCK TABLES `puntua` WRITE;
/*!40000 ALTER TABLE `puntua` DISABLE KEYS */;
/*!40000 ALTER TABLE `puntua` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `puntua_BEFORE_INSERT` BEFORE INSERT ON `puntua` FOR EACH ROW BEGIN
	update carteles set puntuacion=NEW.puntos, votos=new.Votos where carteles.idCarteles=new.id_cartel;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `puntua_BEFORE_UPDATE` BEFORE UPDATE ON `puntua` FOR EACH ROW BEGIN
	update carteles set puntuacion=NEW.puntos, votos=new.Votos where carteles.idCarteles=new.id_cartel;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `referencias`
--

DROP TABLE IF EXISTS `referencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `referencias` (
  `idReferencias` int(11) NOT NULL AUTO_INCREMENT,
  `Link` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idReferencias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referencias`
--

LOCK TABLES `referencias` WRITE;
/*!40000 ALTER TABLE `referencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `referencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responde`
--

DROP TABLE IF EXISTS `responde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `responde` (
  `ID_anonimo` int(11) NOT NULL,
  `ID_Pregunta` int(11) NOT NULL,
  `Acierto` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_anonimo`,`ID_Pregunta`),
  KEY `contestoA_idx` (`ID_Pregunta`),
  CONSTRAINT `contestoA` FOREIGN KEY (`ID_Pregunta`) REFERENCES `preguntas` (`id_cartel`),
  CONSTRAINT `responde` FOREIGN KEY (`ID_anonimo`) REFERENCES `anonimo` (`idAnonimo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responde`
--

LOCK TABLES `responde` WRITE;
/*!40000 ALTER TABLE `responde` DISABLE KEYS */;
/*!40000 ALTER TABLE `responde` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `responde_BEFORE_INSERT` BEFORE INSERT ON `responde` FOR EACH ROW BEGIN
	if(new.acierto) then 
		update anonimo set puntos=puntos+2 where idAnonimo=ID_anonimo;
	end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `respuestas`
--

DROP TABLE IF EXISTS `respuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `respuestas` (
  `ID_cartel` int(11) NOT NULL,
  `NumPreg` int(11) NOT NULL,
  `Respuestascol` varchar(45) NOT NULL,
  `Correcta` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_cartel`,`NumPreg`),
  CONSTRAINT `Pregunta` FOREIGN KEY (`ID_cartel`) REFERENCES `preguntas` (`id_cartel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas`
--

LOCK TABLES `respuestas` WRITE;
/*!40000 ALTER TABLE `respuestas` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtemas`
--

DROP TABLE IF EXISTS `subtemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subtemas` (
  `OrdenTema` int(11) NOT NULL,
  `ID_Cartel` int(11) NOT NULL,
  `SubTitulo` varchar(45) NOT NULL,
  `Cuerpo` text NOT NULL,
  PRIMARY KEY (`OrdenTema`,`ID_Cartel`),
  KEY `subtitulo_De_idx` (`ID_Cartel`),
  CONSTRAINT `subtitulo_De` FOREIGN KEY (`ID_Cartel`) REFERENCES `carteles` (`idcarteles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtemas`
--

LOCK TABLES `subtemas` WRITE;
/*!40000 ALTER TABLE `subtemas` DISABLE KEYS */;
/*!40000 ALTER TABLE `subtemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'retosecologicos'
--

--
-- Dumping routines for database 'retosecologicos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-03 10:57:12
