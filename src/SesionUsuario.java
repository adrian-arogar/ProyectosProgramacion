/** 
 * Proyecto: Juego de la vida.
 *  Implementa el concepto de SesionUsuario según el modelo1.0
 *  En esta versión no se han aplicado la mayoría de los estándares 
 *  de diseño OO dirigidos a conseguir un "código limpio". 
 *  La implementación es la más básica posible con el fin ilustrar 
 *  cómo se evoluciona desde una versión con mal diseño.
 *  Se pueden detectar varios defectos y antipatrones de diseño:
 *  	- Ausencia de encapsulación.
 *  	- Clase sólo de datos.
 *  @since: prototipo1.0
 *  @source: SesionUsuario.java 
 *  @version: 1.0 - 2017/11/29 
 *  @author: ajp
 */

public class SesionUsuario {	
	// Atributos	
	private Usuario usr;   //materializa la relación de composición del modelo UML
	private String fecha;
	
	//Apartado 3
	/**
	 * Constructor convencional. Utiliza métodos Set...()
	 * @param usr
	 * @param fecha
	 */
	//Constructor
	public SesionUsuario(Usuario usr, String fecha) {
		setUsr(usr);
		setFecha(fecha);
	}
	
	//Apartado 3 - Constructor por defecto. Utiliza el convencional
	public SesionUsuario() {
		this(new Usuario(), "05/02/2018");
	}
	
	//Constructor copia
	public SesionUsuario(SesionUsuario sesion) {
		usr = new Usuario(sesion.usr);
		fecha = new String(sesion.fecha);
	}
	
	public Usuario getUsr() {
		return usr;
	}
	
	public void setUsr(Usuario usr) {
		this.usr = usr;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado (valores de atributos) 
	 * de objeto de la clase SesionUsuario  
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" 			// Incluye identificador de objeto
				+ "\n" + usr  					// usr.toString()
				+ "\n fecha:" + fecha;
	}

} // class
