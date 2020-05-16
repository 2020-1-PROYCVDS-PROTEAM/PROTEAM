# ECI Banco de proyectos
_ECI Banco de proyectos proyecto final de la materia Ciclos de Vida de Desarrollo del software para el periodo 2020-1._

## Decripción del producto

### Decripción general

_La Plataforma banco de iniciativas de proyectos, es una herramienta donde la comunidad universitaria de la Escuela Colombiana de Ingenieria Julio Garavito pueden registrar sus iniciativas e ideas de proyectos para ser desarrollados o gestionados por la PMO de la Escuela._

_El sistema, mas alla de facilitar el registro de las iniciativas e ideas de proyectos, es una valiosa base de conocimiento donde los diferentes actores pueden revisar si hay iniciativas, ideas o intereses similares y aunar esfuerzos para la materializacion._

### Manual de usuario

_El presente manual lo ayudará a gestionar de manera ágil y sencilla nuestro proyecto. 
Sígalo paso a paso para lograr una utilización correcta y eficiente de nuestro servicio._

_**Página de inicio:** Al ingresar al proyecto [ECI-BANK-PRO](https://eci-bank-pro.herokuapp.com/faces/login.xhtml) ._
_Se encontrara con la pagina inicial, la cual le permite dos opciones:_

* Loguearse
* Registrarse

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Inicio.png)
_Para registarse lo único que tiene que hacer es rellenar los campos que se le piden._
![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Registro.png)
_Una vez registrado, puede iniciar sesion y dependiendo el rol que haya escogido entre los cuales estan:_

* Administrador
* PMO
* Proponente
* Publico

_Sera dirigido a la pagina correspondiente a su rol._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/PaginaRol.png)

_Las principales funcionalidades que manejamos dependiendo del rol se encuentran las siguientes:_

_**Relacionar iniciativas:** donde al seleccionar cualquier número de iniciativas se pueden relacionar_

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Relacionar.png)

_En la pestaña **Buscar Iniciativas relacionadas ** al agregar el nombre de cualquier iniciativa se pueden ver las que estan relacionadas con la misma_

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/BuscarR.png)

_**Registar Iniciativa** con el rol de proponente el usuario puede cliclear en la pestaña iniciativa y luego registar iniciativa._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/RegistrarIni1.png)

_Será dirigido a la pagina correspondiente y podrá registar cualquier iniciativa a la fecha de hoy, rellenando los campos mostrados a continuacion._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/RegistrarIni2.png)

_**Mostrar interes por una iniciativa** al seleccionar la iniciativa puede votar y comentar por cualquier iniciativa dado click en la pestaña comentar _

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Voto.png)

_Será dirigido a la pagina correspondiente donde además de observar información adicional sobre la iniciativa y el proponente podrá mostrar su interes de diferentes formas._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Comentar.png)

_**Perfil Usuario** Cada usuario contara con una pagina de perfil.Donde se veran sus iniciativas, por las cuales ha votado y comentado ._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Perfil.png)

_**Cambiar rol usuario** Como administrador podra asignarle y cambiar roles a los usuarios, además de modificar los estados de las iniciativas._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Rol.png)	

_**Graficas y datos de iniciativas** Se proporcionaran los datos de cada iniciativa, separadas por area y estado._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Grafica1.png)
![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Grafica2.png)

_**Tablas y busquedas** Se proporcionaran los datos de las respectivas tablas, además de poder ordenar las columnas y realizar busqueda por cada dato que el usuario desee consultar_

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/TablasB.png)

_**Páginas control errores** Se manejaron los errores típicos de HTTP tipo "401","404" y "500"._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Error1.png)



## Aquitectura y Diseño detallado

_**Modelo ER**_

_A continuación se presenta el diagrama:_

![Modelo ET](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/ModeloER.png)

_**Diagrama de clases**_

_A continuación se presenta el diagrama:_

![Diagrama de clases ](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/DiagramaClass.png)

_**Descripción de la arquitectura**_




_**Enlace a la aplicación en Heroku.**_

_A continuación se presenta el link:_

[ECI-BANK-PRO](https://eci-bank-pro.herokuapp.com/faces/login.xhtml)

_**Enlace al sistema de integración continua**_

_A continuación se presenta el link:_

[![CircleCI](https://circleci.com/gh/2020-1-PROYCVDS-PROTEAM/PROTEAM.svg?style=svg)](https://circleci.com/gh/2020-1-PROYCVDS-PROTEAM/PROTEAM)



## Descripción del proceso

_Descripción del proceso que se llevo a cabó._

### Autores 

_El equipo PROTEAM fue el encargado de desarrollar este proyecto._

_* **César González**  *Team Developer*  [csarssj](https://github.com/csarssj)_
_* **Eduard Jimenez**  *Team Developer*  [EdKillah](https://github.com/EdKillah)_
_* **Jose Gutierrez**  *Team Developer*  [kirilka97](https://github.com/kirilka97)_
_* **Jonathan Pulido**  *Team Developer*  [Arlais](https://github.com/Arlais)_

_Presentado a:_
_* **Oscar Ospina** *Product Owner*_
_* **Julián Velasco** *Product Owner*_

_También puedes mirar la lista de todos los [contribuyentes](https://github.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/graphs/contributors) quíenes han participado en este proyecto._

### Metodología

_Scrum es una metodología ágil y flexible para gestionar el desarrollo de software, cuyo principal objetivo es maximizar el retorno de la inversión para su empresa (ROI). Se basa en construir primero la funcionalidad de mayor valor para el cliente y en los principios de inspección continua, adaptación, auto-gestión e innovación._


### Enlace Taiga

_A continuación se presenta el link:_

[TAIGA PROTEAM](https://tree.taiga.io/project/csarssj-plataforma-banco-de-iniciativas-de-proyectos/backlog)

### Sprint 1

_Iniciamos demasiado mal, primero heroku nos generó problemas en la creación de la base de datos y su acceso. Nos demoramos mucho tiempo en SQuirrel
más del que debíamos y lo mejor fue cambiar a dbeaver. Nuestra falta de orden y no dividirnos las tareas y asignarnos los roles como debíamos desde un comienzo
fue el detonante de este desastre._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Sprint1.png)

### Sprint 2

_El mayor problema de este Sprint fue el tiempo debido a que como tuvimos retraso con el Sprint 1 nuestro deber era estar al día, otra cosa que vale mencionar es 
que heroku hizo "mantenimiento" y actualización de datos en dos bases de datos que creamos para el proyecto, negandonos el acceso y por lo tanto haciendonos crear una tercera.
Además tampoco manejamos la actualización de tareas de taiga como era debido._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Sprint2.png)

### Sprint 3

_Finalmente para este ultimo Sprint logramos ponernos a la "par" de nuestros compañeros con una serie de correcciones pendientes pero por fin nos sentiamos en igualdad de condiciones
(siendo desde un comienzo nuestra culpa) logramos completar todas las funcionalidades pedidas y arreglar los errores visuales y requerimientos para cada rol. En el taiga se ve reflejado
por fin que lo manejamos como tenía que ser desde el primer Sprint. lo único que no nos quedo completo fue la implementación de buenas pruebas y la documentación del código._

![image](https://raw.githubusercontent.com/2020-1-PROYCVDS-PROTEAM/PROTEAM/master/Imagenes/Sprint3.png)

### Reporte de pruebas y de cubrimiento de las mismas (sólo la foto del reporte principal). Para la cobertura, pueden usar los plugins disponibles (EclEmma, Jacoco, etc.)

_Menciona las herramientas que utilizaste para crear tu proyecto_

### Reporte de análisis estático de código.

_A continuación se presenta el link:_

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/baf8244e49784d8799ab8bccba65d7b5)](https://www.codacy.com/gh/2020-1-PROYCVDS-PROTEAM/PROTEAM?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=2020-1-PROYCVDS-PROTEAM/PROTEAM&amp;utm_campaign=Badge_Grade)

