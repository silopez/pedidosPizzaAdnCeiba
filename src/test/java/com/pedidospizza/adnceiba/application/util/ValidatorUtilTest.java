package com.pedidospizza.adnceiba.application.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
public class ValidatorUtilTest {
	
	@Test
    public void validarValorDineroMenosCeroTest(){

		try {
			ValidatorUtil.validarValorDinero("-1");
		} catch (Exception e) {
			assertEquals(MessageUtil.VALOR_MENOR_CERO.getMensaje(),e.getMessage());
		}
    }
	
	@Test
    public void validarValorDineroNoNumericoTest(){

		try {
			ValidatorUtil.validarValorDinero("E");
		} catch (Exception e) {
			assertEquals(MessageUtil.FORMATO_VALOR_DINERO.getMensaje(),e.getMessage());
		}
    }
	
}
