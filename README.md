# ECI Banco de proyectos
_ECI Banco de proyectos proyecto final de la materia Ciclos de Vida de Desarrollo del software para el periodo 2020-1. 

## Decripción del producto

### Decripción general

_La Plataforma banco de iniciativas de proyectos, es una herramienta donde la comunidad universitaria de la Escuela Colombiana de Ingenieria Julio Garavito pueden registrar sus iniciativas e ideas de proyectos para ser desarrollados o gestionados por la PMO de la Escuela.

El sistema, mas alla de facilitar el registro de las iniciativas e ideas de proyectos, es una valiosa base de conocimiento donde los diferentes actores pueden revisar si hay iniciativas, ideas o intereses similares y aunar esfuerzos para la materializacion._




El objetivo del sistema es permitir el registro y seguimiento de las iniciativas e ideas de proyectos que han sido propuestas por la comunidad universitaria de la Escuela. El banco de iniciativas debe contar con una interfaz de usuario bonita y amigable con los usuarios.
### Manual de usuario

_El presente manual lo ayudará a gestionar de manera ágil y sencilla nuestro Sistema UBITrack®. 
Sígalo paso a paso para lograr una utilización correcta y eficiente de nuestro servicio._

_**Página de inicio:** Al ingresar al proyecto [ECI-BANK-PRO](https://eci-bank-pro.herokuapp.com/faces/login.xhtml) .
Se encontrara con la pagina inicial, la cual le permite dos opciones:
*Loguearse
*Registrarse_
![image]()
_Para registarse lo único que tiene que hacer es rellenar los campos que se le piden._
![image]()
_Una vez registrado, puede iniciar sesion y dependiendo el rol que haya escogido entre los cuales estan:
*Administrador
*PMO
*Proponente
*Publico
Sera dirigido a la pagina correspondiente a su rol._
![image]()

_Las principales funcionalidades que manejamos dependiendo del rol se encuentran las siguientes:_

_**Relacionar iniciativas y consultar iniciativas relacionadas:** donde al seleccionar cual quier numero de iniciativas se pueden relacionar_
![image]()
_En la pestaña **Buscar Iniciativas relacionadas ** al agregar el nombre de cualquier iniciativa se pueden ver las que estan relacionadas con la misma_
![image]()
_**Registar Iniciativa** con el rol de proponente el usuario puede cliclear en la pestaña iniciativa y luego registar iniciativa._
![image]()
_Será dirigido a la pagina correspondiente y podrá registar cualquier iniciativa a la fecha de hoy, rellenando los campos mostrados a continuacion._
![image]()
_**Mostrar interes por una iniciativa ** al seleccionar la iniciativa puede votar y comentar por cualquier iniciativa dado click en la pestaña comentar _
![image]()
_Será dirigido a la pagina correspondiente donde además de observar información adicional sobre la iniciativa y el proponente podrá mostrar su interes de diferentes formas._
![image]()
_**Perfil Usuario **Cada usuario contara con una pagina de perfil.Donde se veran sus iniciativas, por las cuales ha votado y comentado ._
![image]()
_**Cambiar rol usuario **Como administrador podra asignarle y cambiar roles a los usuarios, además de modificar los estados de las iniciativas._
![image]()	
![image]()
_**Graficas y datos de iniciativas ** Se proporcionaran los datos de cada iniciativa, separadas por area y estado._
![image]()
_**Tablas y busquedas ** Se proporcionaran los datos de las respectivas tablas, además de poder ordenar las columnas y realizar busqueda por cada dato que el usuario desee consultar_




## Aquitectura y Diseño detallado

_**Modelo ER**_

_**Diagrama de clases**_

_**Descripción de la arquitectura **_

_**Enlace a la aplicación en Heroku.
Enlace al sistema de integración continua.
**_
Mira **Deployment** para conocer como desplegar el proyecto.


## Descripción del proceso
### Autores 

_El equipo PROTEAM fue el encargado de desarrollar este proyecto._

* **César González** - *Team Developer* - [csarssj](https://github.com/csarssj)
* **Eduard Jimenez** - *Team Developer* - [EdKillah](https://github.com/EdKillah)
* **Jose Gutierrez** - *Team Developer* - [kirilka97](https://github.com/kirilka97)
* **Jonathan Pulido** - *Team Developer* - [Arlais](https://github.com/Arlais)

_Presentado a:_
* **Oscar Ospina** - *Product Owner* 
* **Julián Velasco** - *Product Owner* 

También puedes mirar la lista de todos los [contribuyentes](https://github.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/graphs/contributors) quíenes han participado en este proyecto. 
### Modelo ER.

![Modelo ET](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/ModeloER.png)
### Diagrama de clases (hacerlo mediante ingeniería inversa)
![Diagrama de clases ](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/DiagramaClass.png)

### Descripción de la arquitectura (capas) y del Stack de tecnologías utilizado (PrimeFaces, Guice, QuickTheories, PostgreSQL).
![Diagrama de paquetes]()

## Ejecutando las pruebas ⚙️

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/baf8244e49784d8799ab8bccba65d7b5)](https://www.codacy.com/gh/2020-1-PROYCVDS-PROTEAM/PROTEAM?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=2020-1-PROYCVDS-PROTEAM/PROTEAM&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/2020-1-PROYCVDS-PROTEAM/PROTEAM.svg?style=svg)](https://circleci.com/gh/2020-1-PROYCVDS-PROTEAM/PROTEAM)

### Analice las pruebas end-to-end 🔩

_Explica que verifican estas pruebas y por qué_



### Y las pruebas de estilo de codificación ⌨️

_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```

## Despliegue 📦

_Agrega notas adicionales sobre como hacer deploy_

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [ROME](https://rometools.github.io/rome/) - Usado para generar RSS


## Versionado 📌

Usamos [SemVer](http://semver.org/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/tu/proyecto/tags).
