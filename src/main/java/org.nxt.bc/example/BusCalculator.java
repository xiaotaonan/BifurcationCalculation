package org.nxt.bc.example;

import org.nxt.bc.core.BifurcationCalculationCalculator;
import org.nxt.bc.dto.ParameterDTO;
import org.nxt.bc.dto.ResultDTo;

import java.util.ArrayList;
import java.util.List;

public class BusCalculator extends BifurcationCalculationCalculator {

    public BusCalculator(List<ParameterDTO> msses, int startIndex, int endIndex) {
        super(BusCalculator.class,msses, startIndex, endIndex);
    }

    public BusCalculator(){
        super();
    }

    @Override
    public List<ResultDTo> businessLogic(ParameterDTO mss) throws RuntimeException {
        List<ResultDTo> list=new ArrayList<ResultDTo>();
        BusParameterDTo parameter=(BusParameterDTo)mss;
        BusResultDTo r=new BusResultDTo(parameter.getN()+13);
        list.add(r);
        return list;
    }
}
