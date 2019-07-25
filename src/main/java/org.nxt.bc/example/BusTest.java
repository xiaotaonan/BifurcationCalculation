package org.nxt.bc.example;

import com.alibaba.fastjson.JSON;
import org.nxt.bc.core.BifurcationCalculationCalculator;
import org.nxt.bc.dto.ParameterDTO;
import org.nxt.bc.dto.ResultDTo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class BusTest {

    public static void main(String [] args){
        long start=System.currentTimeMillis();
        List<ParameterDTO> list=new ArrayList<ParameterDTO>();
        BusParameterDTo bp1=new BusParameterDTo(10);
        BusParameterDTo bp2=new BusParameterDTo(20);
        BusParameterDTo bp3=new BusParameterDTo(30);
        BusParameterDTo bp4=new BusParameterDTo(40);
        BusParameterDTo bp5=new BusParameterDTo(50);
        BusParameterDTo bp6=new BusParameterDTo(60);
        BusParameterDTo bp7=new BusParameterDTo(70);
        BusParameterDTo bp8=new BusParameterDTo(80);
        BusParameterDTo bp9=new BusParameterDTo(90);
        BusParameterDTo bp10=new BusParameterDTo(100);
        list.add(bp1);
        list.add(bp2);
        list.add(bp3);
        list.add(bp4);
        list.add(bp5);
        list.add(bp6);
        list.add(bp7);
        list.add(bp8);
        list.add(bp9);
        list.add(bp10);
        ForkJoinPool pool=new  ForkJoinPool();
        ForkJoinTask<List<ResultDTo>> rsult=pool.submit(new BusCalculator(list,0,list.size()));
        List<ResultDTo> resultlist=rsult.invoke();
        long stop= System.currentTimeMillis();
        System.out.println(((stop-start)/1000)+"s,"+JSON.toJSONString(resultlist));
    }
}
