package pe.com.clinicaesb.util.components;


public class BotonParametro extends BotonOpcion {
	
	public BotonParametro(String opDepartamento, long consumeClick) {
		super(opDepartamento, consumeClick);		
	}
	
	public BotonParametro(String label, long consumeClick, int backGround) {
		super(label, consumeClick, backGround);		
	}

	private Object parametro;

	public Object getParametro() {
		return parametro;
	}

	public void setParametro(Object parametro) {
		this.parametro = parametro;
	}
	
	

}
