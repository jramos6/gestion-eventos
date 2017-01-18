package Data;

/**
 * Clase que almacena toda la información de los usuarios
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class Usuario {
		private String dni;
		private String nombre;
		private String usuario;
		private int edad;
		private String contras;
		public boolean esAdmin=false;
		
		
		public Usuario(String nom, String dni, String txtUsu, String contras, int edad) {
			super();
			this.dni = dni;
			this.nombre = nombre;
			this.edad = edad;
			this.contras = contras;
			this.usuario = txtUsu;
		}
		
		

		public Usuario(){
			
		}

		
		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getContras() {
			return contras;
		}

		public void setContras(String contras) {
			this.contras = contras;
		}



		public boolean isEsAdmin() {
			return esAdmin;
		}



		public void setEsAdmin(boolean esAdmin) {
			this.esAdmin = esAdmin;
		}



		@Override
		public String toString() {
			return "Usuario [Nom=" + nombre + ", Usuario=" + usuario + ",  DNI=" + dni + ",  Edad=" + edad + ", Contraseña=" + contras + "]";
		}

	
}
