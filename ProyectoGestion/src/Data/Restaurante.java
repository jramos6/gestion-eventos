package Data;

/**
 * Clase que almacena la informacion de los restaurantes
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class Restaurante {

	protected String titulo;

	protected String desc;

	protected String imagen;

	public Restaurante() {

		super();

	}

	public Restaurante(String titulo, String desc, String imagen) {

		super();

		this.titulo = titulo;

		this.desc = desc;

		this.imagen = imagen;

	}

	public String getTitulo() {

		return titulo;

	}

	public void setTitulo(String titulo) {

		this.titulo = titulo;

	}

	public String getDesc() {

		return desc;

	}

	public void setDesc(String desc) {

		this.desc = desc;

	}

	public String getImagen() {

		return imagen;

	}

	public void setImagen(String imagen) {

		this.imagen = imagen;

	}

}