CREATE TABLE IF NOT EXISTS USUARIOS(
	USUARIO VARCHAR(10) NOT NULL,
	PASSW VARCHAR(20) NOT NULL,
	CORREO VARCHAR(30) UNIQUE NOT NULL ,
	NOMBRE VARCHAR(20) NOT NULL,
	APELLIDO VARCHAR(20) NOT NULL,
	ROL VARCHAR (10) NOT NULL,
	PRIMARY KEY (USUARIO))
;

/*CREATE TABLE IF NOT EXISTS ECI_ADMINISTRADORES (
  USUARIO_A VARCHAR(10) NOT NULL,
  PRIMARY KEY (USUARIO_A),
  CONSTRAINT FK_USUARIOS_ADMINISTRADORES
    FOREIGN KEY (USUARIO_A)
    REFERENCES ECI_USUARIOS (USUARIO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE TABLE IF NOT EXISTS ECI_PROPONENTES (
  USUARIO_P VARCHAR(10) NOT NULL,
  INICIATIVA VARCHAR(45) NOT NULL,
  PRIMARY KEY (USUARIO_P),
    CONSTRAINT FK_USUARIOS_PROPONENTES
    FOREIGN KEY (USUARIO_P)
    REFERENCES ECI_USUARIOS (USUARIO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE TABLE IF NOT EXISTS ECI_PERSONAL_PMO_ODI (
  USUARIO_P VARCHAR(10) NOT NULL,
  PRIMARY KEY (USUARIO_P),
  CONSTRAINT FK_USUARIOS_PERSONAL
  FOREIGN KEY (USUARIO_P)
  REFERENCES ECI_USUARIOS (USUARIO)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)  
;

/*CREATE TABLE IF NOT EXISTS ECI_PUBLICO (
 	USUARIO_P VARCHAR(10) NOT NULL,
 	 PRIMARY KEY (USUARIO_P),
    CONSTRAINT FK_USUARIOS_PUBLICO
    FOREIGN KEY (USUARIO_P)
    REFERENCES ECI_USUARIOS (USUARIO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;*/

CREATE TABLE  IF NOT EXISTS INICIATIVAS(
	ID INT UNIQUE NOT NULL,
	VOTOS INT NOT NULL,
	PALABRACLAVE VARCHAR (10) UNIQUE NOT null,
	NOMBRE VARCHAR(20) NOT NULL,
	ESTADO VARCHAR(20) NOT NULL,
	DESCRIPCION VARCHAR(45) NOT NULL,
	AREA VARCHAR(20) NOT NULL,
	USUARIO_I VARCHAR(10) NOT NULL,
	CORREO_I VARCHAR(30) UNIQUE NOT NULL,
	FECHAR_INI DATE NOT NULL,
	PRIMARY KEY (ID),
	CONSTRAINT FK_INICIATIVA 
	FOREIGN KEY (USUARIO_I)
	REFERENCES USUARIOS (USUARIO)
	ON UPDATE NO ACTION 
	ON DELETE NO ACTION)
;

drop table eci_publico ;
drop table administradores  ;
drop table eci_personal_pmo_odi ;
drop table eci_usuarios ;
drop table eci_proponentes ;
drop table iniciativas ;
