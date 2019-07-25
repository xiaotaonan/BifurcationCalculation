package org.nxt.bc.example;

import org.nxt.bc.dto.ParameterDTO;
import org.nxt.bc.dto.ResultDTo;

public class BusResultDTo extends ResultDTo {

    private int n;

    public BusResultDTo(int n){
        this.n=n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
