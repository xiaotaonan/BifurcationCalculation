package org.nxt.bc.example;

import org.nxt.bc.dto.ParameterDTO;

public class BusParameterDTo extends ParameterDTO {

    private int n;

    public BusParameterDTo(int n){
        this.n=n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
