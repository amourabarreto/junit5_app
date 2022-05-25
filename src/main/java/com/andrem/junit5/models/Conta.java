package com.andrem.junit5.models;

import java.math.BigDecimal;


public class Conta {
    private String pessoa;
    private BigDecimal saldo;

    public Conta(String pessoa, BigDecimal saldo) {
        this.pessoa = pessoa;
        this.saldo = saldo;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    public void debito(BigDecimal valor){
        this.saldo = this.saldo.subtract(valor);
    }
    public void credito(BigDecimal valor){

    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Conta)) {
            return false;
        }
        Conta conta = (Conta)obj;
        if(this.pessoa == null || this.saldo == null){
            return false;
        }

        return this.pessoa.equals(conta.getPessoa()) && this.saldo.equals(conta.getSaldo());
    }
}