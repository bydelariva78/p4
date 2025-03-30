const API_URL = "http://localhost:8080/api/ballenas"; // URL de la API

// Función para obtener ballenas y actualizar la tabla
async function obtenerBallenas() {
    try {
        const response = await fetch(API_URL);
        const ballenas = await response.json();
		
		 console.log(ballenas);
        
        const tabla = document.getElementById("tabla-ballenas");
        tabla.innerHTML = ""; // Limpiar tabla antes de insertar nuevas filas
        
        ballenas.forEach(ballena => {
            const fila = document.createElement("tr");
            fila.innerHTML = `
				<td>${ballena.id}</td>
                <td>${ballena.nombre}</td>
                <td>${ballena.alimentacion}</td>
                <td>${ballena.tamaño}</td>
            `;
            tabla.appendChild(fila);
        });

    } catch (error) {
        console.error("Error obteniendo ballenas:", error);
    }
}
//Funcion para añadir ballenas a la tabla
document.getElementById("formBallena").addEventListener("submit", async function(event) {
	event.preventDefault(); //Evitar que el formulario recargue la pagina
	
	let nombre = document.getElementById("nombre").value;
	let alimentacion = document.getElementById("alimentacion").value;
	let tamano = document.getElementById("tamano").value;
	

	
	let ballena = {
		nombre : nombre,	
		alimentacion : alimentacion,
		tamaño : tamano
	};
	try {
		let response = await fetch(API_URL, {
			method : "POST",
			headers: {
				"Content-Type":"application/json"
			},
			body: JSON.stringify(ballena)
		});
		
		if(response.ok){
			console.log("Ballena añadida con exito");
			document.getElementById("formBallena").reset()
			obtenerBallenas();
		}
		else{
			console.log("Error al añadir la ballena");
		}	
	}catch (error){
		console.error("Error en la solicitud: ",error);
	}
	
	
});
//Funcion para borrar ballenas del servidor y de la tabla
document.getElementById("borrarBallena").addEventListener("submit", async function(event) {
	event.preventDefault(); //Evitar que el formulario recargue la pagina
	
	let id = document.getElementById("id").value;
	
	try{
		
		let response = await fetch(API_URL+"/"+id, {
			
			method: "DELETE",
			headers : {
				"Content-Type":"application/json"
			},
			
		});
		if(response.ok){
			console.log("Se ha borrado correctamente la ballena");
			document.getElementById("borrarBallena").reset()
			obtenerBallenas();
		}
		else{
			console.log("No se ha borrado correctamente la ballena");
		}
		
	}catch(error){
		console.log("Error en la solicitud: ",error)
		
	}
	
	
});


//Funcion para actualizar una ballena por el id

document.getElementById("actualizarBallena").addEventListener("submit", async function(event){
	event.preventDefault(); //Evitar que el formulario recargue la pagina
	
	let nombre = document.getElementById("nombreNuevo").value;
	let alimentacion = document.getElementById("alimentacionNueva").value;
	let tamano = document.getElementById("tamanoNuevo").value;
	
	let id  = document.getElementById("idActualizado").value;

	
	let ballena = {
		nombre : nombre,	
		alimentacion : alimentacion,
		tamaño : tamano
	};
	try {
		let response = await fetch(API_URL+"/"+id, {
			method : "PUT",
			headers: {
				"Content-Type":"application/json"
			},
			body: JSON.stringify(ballena)
		});
		
		if(response.ok){
			console.log("Ballena añadida con exito");
			document.getElementById("actualizarBallena").reset()
			obtenerBallenas();
		}
		else{
			console.log("Error al añadir la ballena");
		}	
	}catch (error){
		console.error("Error en la solicitud: ",error);
	}
	
		



});





// Ejecutar fetch al cargar la página
document.addEventListener("DOMContentLoaded", () => {
    obtenerBallenas();
    
    // Actualizar tabla cada 5 segundos para detectar nuevos POSTs
    setInterval(obtenerBallenas, 5000);
});
