package com.andrem.junit5.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Test
    void testNomeConta() {
        Conta conta = new Conta("Andre",new BigDecimal(1000.12345));
        String esperado = "Andre";
        String real = conta.getPessoa();
        assertEquals(esperado,real);
        assertTrue(real.equals("Andre"));
    }

    @Test
    void testSaldoConta() {
        Conta conta = new Conta("Andre", new BigDecimal("1000.12345"));
        assertEquals(1000.12345,conta.getSaldo().doubleValue());
        assertFalse(conta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(conta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenciaConta() {
        Conta conta =  new Conta("John Doe", new BigDecimal("8900.9997"));
        Conta conta2 = new Conta("John Doe", new BigDecimal("8900.9997"));
        //valida instancias a não ser que equals seja sobrescrito
        assertEquals(conta2,conta);

    }

    @Test
    void testDebitoConta() {
        Conta conta =  new Conta("John Doe", new BigDecimal("8900.9997"));
        conta.debito(new BigDecimal(100));
        assertNotNull(conta.getSaldo());
        assertEquals(900,conta.getSaldo().intValue());
        assertEquals("8900.9997",conta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoConta() {
        Conta conta =  new Conta("John Doe", new BigDecimal("8900.9997"));
        conta.credito(new BigDecimal(100));
        assertNotNull(conta.getSaldo());
        assertEquals(1100,conta.getSaldo().intValue());
        assertEquals("8900.9997",conta.getSaldo().toPlainString());
    }
}