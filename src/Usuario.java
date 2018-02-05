/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Usuario según el modelo1.
 *  En esta versión no se han aplicado la mayoría de los estándares 
 *  de diseño OO dirigidos a conseguir un "código limpio". 
 *  La implementación es la más básica posible con el fin ilustrar 
 *  cómo se evoluciona desde una versión con mal diseño.
 *  Se pueden detectar varios defectos y antipatrones de diseño:
 *  	- Ausencia de encapsulación.
 *  	- Clase sólo de datos.
 *  	- Obsesión por los tipos primitivos.  
 *  @since: prototipo1.0
 *  @source: Usuario.java 
 *  @version: 1.0 - 2017/11/29 
 *  @author: ajp
 */

public class Usuario {	
	// Atributos	
	private String nif;
	private String nombre;
	private String apellidos;
	private String idUsr;
	private String domicilio;
	private String correo;
	private String fechaNacimiento;
	private String fechaAlta;
	private String claveAcceso;
	private String rol;
	
	//Apartado 2
	/**
	 * Constructor convencional. Utiliza métodos Set...()
	 * @param nif
	 * @param nombre
	 * @param apellidos
	 * @param domicilio
	 * @param correo
	 * @param fechaNacimiento
	 * @param fechaAlta
	 * @param claveAcceso
	 * @param rol
	 */
	//Constructor
	public Usuario(String nif, String nombre, String apellidos, String domicilio, 
			String correo, String fechaNacimiento,
			String fechaAlta, String claveAcceso, String rol) {
		
		setNif(nif);
		setNombre(nombre);
		setApellidos(apellidos);
		generarIdUsr();
		setDomicilio(domicilio);
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
		setFechaAlta(fechaAlta);
		setClaveAcceso(claveAcceso);
		setRol(rol);
	}
	
	//Apartado 4
	private void generarIdUsr() {
		StringBuilder textoId = new StringBuilder();
		textoId.append(nombre.charAt(0));
		textoId.append(apellidos.charAt(0));
		textoId.append(apellidos.charAt(apellidos.indexOf(" ")+1));
		textoId.append(nif.substring(7,9));
		
		idUsr = textoId.toString();
	}
	
	//Apartado 2
	//Constructor por defecto. Utiliza el convencional.
	
	public Usuario() {
		this("00000000K", "Nombre", "Apellido Apellido", "Domicilio", "correo@correo.com", 
				"30/01/2000", "30/01/2018", "Miau#0", "UsuarioNormal");
	}
	
	//apartado 2
		//constructor copia. Usar siempre "new"

		public Usuario(Usuario usuario) {

			nif = new String (usuario.nif);
			nombre = new String (usuario.nombre); 
			apellidos = new String (usuario.apellidos); 
			domicilio = new String (usuario.domicilio); 
			correo = new String (usuario.correo);
			fechaNacimiento = new String (usuario.fechaNacimiento); 
			fechaAlta = new String (usuario.fechaAlta);
			claveAcceso = new String (usuario.claveAcceso); 
			rol = new String (usuario.rol);

		}
		
	public String getClaveAcceso() {
		return claveAcceso;
	}	
	
	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = encriptarCesar(claveAcceso);
	}
	
	private String encriptarCesar(String claveAcceso) {
		
		String alfabetoNormal = "abcdefghijklmnñopqrstuvwxyz"
				+ "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
				+ "0123456789"
				+"$%*+-_#";
		
		String alfabetoDesplazado = "jklmnñopqrstuvwxyz"
				+ "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
				+ "0123456789"
				+"$%*+-_#"
				+ "abcdefghi";
		
		StringBuilder ClaveEncriptada = new StringBuilder();
		
		for (int i = 0; i < claveAcceso.length(); i++) {
			ClaveEncriptada.append(alfabetoDesplazado.charAt(
					alfabetoNormal.indexOf(claveAcceso.charAt(i))));
		}
		return ClaveEncriptada.toString();
	}
	
	public String getNif() {
		return nif;
	}
	
	public void setNif (String nif) {
		if(NifValido(nif)) {
		this.nif = nif;
		}
	}
	
	private boolean NifValido(String nif) {
		assert nif != null;
		return nif.matches("[0-9]{8}[ABCDEFGHJKLMNOPQRSTVW]");
	}
	
		public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		if(NombreValido(nombre)) {
			this.nombre = nombre;
			}
	}
	
	private boolean NombreValido(String nombre) {
		assert nombre != null;
		return nombre.matches("[A-ZÑÁ][a-zñáéíóú]+ [A-ZÑÁ][a-zñáéíóú]+");
	}

	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		if(ApellidosValidos(apellidos)) {	
		this.apellidos = apellidos;
		}
	}
	
	private boolean ApellidosValidos(String apellidos) {
		return false;
	}
	
	public String getidUsr() {
		return idUsr;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio (String domicilio) {
		this.domicilio = domicilio;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo (String correo) {
		this.correo = correo;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado -valores de atributos- de objeto de la clase Usuario.  
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" 			// Incluye identificador de objeto.
				+"\n nif: \t\t" + nif 
				+ "\n nombre: \t" + nombre 
				+ "\n apellidos: \t" + apellidos 
				+ "\n domicilio: \t" + domicilio 
				+ "\n correo: \t" + correo 
				+ "\n fechaNacimiento:" + fechaNacimiento
				+ "\n fechaAlta: \t" + fechaAlta 
				+ "\n claveAcceso: \t" + claveAcceso
				+ "\n rol: \t\t" + rol ;
	}

} // class
