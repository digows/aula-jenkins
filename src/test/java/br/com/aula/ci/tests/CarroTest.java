package br.com.aula.ci.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.aula.ci.Cambio;
import br.com.aula.ci.Carro;

public class CarroTest {
	
	@Test
	public void validaEstadoInicialDevePassar() {
		final Carro carro = new Carro();
		
		Assert.assertEquals( 0, carro.getDirecao(), 0 );
		Assert.assertEquals( 0, carro.getVelocidade(), 0 );
		Assert.assertEquals( 0, carro.getGirosMotor(), 0 );
		Assert.assertEquals( Cambio.NEUTRO, carro.getMarcha());
	}
	
	@Test
	public void calculaGirosMotorDevePassar() {
		Cambio c = Cambio.PRIMEIRA_MARCHA;
		c.calculaGiros(10);
		Assert.assertEquals(0, c.calculaGiros(10), 100);
	}
	
	@Test
	public void validaFreia() {
		final Carro carro = new Carro();
		
		carro.acelerar(100);
		carro.freiar(0);

		Assert.assertEquals( 0, carro.getVelocidade(), 0 );
		Assert.assertEquals( 0, carro.getGirosMotor(), 0 );
		Assert.assertEquals( Cambio.NEUTRO, carro.getMarcha());
	}

	public void calculaGirosMotorSegundaMarchaDevePassar() {
		Cambio cambio = Cambio.SEGUNDA_MARCHA;
		float forca = 20;
		cambio.calculaGiros(forca);
		Assert.assertEquals(40, cambio.calculaGiros(forca), 0.1);
	}
}
