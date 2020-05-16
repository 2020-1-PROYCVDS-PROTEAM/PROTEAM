function confirmDelete(){
    var opcion = confirm("¿Esta seguro que quiere cerrar sesión?");
    if (opcion === true) {
	cierreSesion();    	
    }	
}


