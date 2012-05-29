package pe.sbs;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ValidaIntegracionTest {
	
	@Autowired
	private Valida valida;
	
	@Test
	public void testSaludar() {
		String respuesta = valida.validarSeguroUsuario("41645302");
		System.out.println("La respuesta es "+respuesta);
		//Assert.assertEquals("Hola Pepe", );
	}

}
