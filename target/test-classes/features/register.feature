#language:es
@Register
Característica: Nuevo Registro de empleado
	como usuario logueado en el sitio web
	quiero registrar un nuevo empleado

Antecedentes:
	Dado el usuario está logueado en la página "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"	

Esquema del escenario: Registro de un nuevo empleado
	Dado el usuario está en la página de registro de nuevo empleado
	Cuando el usuario ingresa la información: "<Image>" "<FirstName>" "<MiddleName>" "<LastName>" "<EmploiID>" "<LoginDetails>" "<UserName>" "<Status>" "<Password>" "<RePass>"
	Y cuando el usuario hace clic en el botón Save
	Entonces el nuevo empleado es registrado correctamente
	
	Ejemplos:
	|Image|FirstName|MiddleName|LastName|EmploiID|LoginDetails|UserName|Status|Password|RePass|
	|Image|Empleado|Prueba|Pruebita|Emp|Login|Empleadito|Disabled|Pass1234|Pass1234|

