package Data;

/**
 * Clase que almacena los espacios disponibles
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class Espacios {

	public boolean comedorGrande;
	public boolean comedorMediano;
	public boolean comedorPequenio;
	public boolean reunionGrande;
	public boolean reunionPequenio;
	public boolean musicaGrande;
	public boolean musicaPequenio;
	
	
	public Espacios(boolean comedorGrande, boolean comedorMediano, boolean comedorPequenio, boolean reunionGrande,
			boolean reunionPequenio, boolean musicaGrande, boolean musicaPequenio) {
		super();
		this.comedorGrande = comedorGrande;
		this.comedorMediano = comedorMediano;
		this.comedorPequenio = comedorPequenio;
		this.reunionGrande = reunionGrande;
		this.reunionPequenio = reunionPequenio;
		this.musicaGrande = musicaGrande;
		this.musicaPequenio = musicaPequenio;
	}
	
	public Espacios(){
		comedorGrande=false;
		comedorMediano=false;
		comedorPequenio=false;
		reunionGrande=false;
		reunionPequenio=false;
		musicaGrande=false;
		musicaPequenio=false;
	}

	public boolean isComedorGrande() {
		return comedorGrande;
	}

	public void setComedorGrande(boolean comedorGrande) {
		this.comedorGrande = comedorGrande;
	}

	public boolean isComedorMediano() {
		return comedorMediano;
	}

	public void setComedorMediano(boolean comedorMediano) {
		this.comedorMediano = comedorMediano;
	}

	public boolean isComedorPequenio() {
		return comedorPequenio;
	}

	public void setComedorPequenio(boolean comedorPequenio) {
		this.comedorPequenio = comedorPequenio;
	}

	public boolean isReunionGrande() {
		return reunionGrande;
	}

	public void setReunionGrande(boolean reunionGrande) {
		this.reunionGrande = reunionGrande;
	}

	public boolean isReunionPequenio() {
		return reunionPequenio;
	}

	public void setReunionPequenio(boolean reunionPequenio) {
		this.reunionPequenio = reunionPequenio;
	}

	public boolean isMusicaGrande() {
		return musicaGrande;
	}

	public void setMusicaGrande(boolean musicaGrande) {
		this.musicaGrande = musicaGrande;
	}

	public boolean isMusicaPequenio() {
		return musicaPequenio;
	}

	public void setMusicaPequenio(boolean musicaPequenio) {
		this.musicaPequenio = musicaPequenio;
	}
	
	
}
