package org.nxt.bc.core;

import org.nxt.bc.dto.ParameterDTO;
import org.nxt.bc.dto.ResultDTo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Calculation class
 *
 * @author nxt
 * @since 2019-07-24 14:22:54
 */
public class BifurcationCalculationCalculator extends RecursiveTask<List<ResultDTo>> implements IBusiness{

    //The number of tasks executed by one thread
    private static final int THREAD_HOLD=1;

    //parameters
    List<ParameterDTO> msses;

    //The index of start
    private int startIndex;

    //The index of end
    private int endIndex;

    BifurcationCalculationCalculator subClass;

    private Class subClazz;

    public BifurcationCalculationCalculator(){

    }

    public BifurcationCalculationCalculator(Class subClazz,List<ParameterDTO> msses, int startIndex, int endIndex){
        this.subClazz=subClazz;
        this.msses=msses;
        this.startIndex=startIndex;
        this.endIndex=endIndex;

        try {
            subClass=(BifurcationCalculationCalculator)subClazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }



    @Override
    protected List<ResultDTo> compute() {

        if((endIndex-startIndex)<=THREAD_HOLD){
            return subClass.businessLogic(msses.get(0));
        }else{
            //fork
            int splitCount=((endIndex%THREAD_HOLD)==0)?(endIndex/THREAD_HOLD):((endIndex/THREAD_HOLD)+1);
            BifurcationCalculationCalculator[] sssbcs=new BifurcationCalculationCalculator[splitCount];
            //Register the tasks you need to perform
            for(int t=0;t<sssbcs.length;t++){
                int start=THREAD_HOLD*t;
                int end=THREAD_HOLD*(t+1);
                end=(end>endIndex)?endIndex:end;
                List<ParameterDTO> mssdata=new ArrayList<ParameterDTO>();
                mssdata.add(msses.get(t));
                BifurcationCalculationCalculator task=new BifurcationCalculationCalculator(subClazz,mssdata,start,end);
                task.fork();
                sssbcs[t]=task;
            }
            //execute
            List<ResultDTo> list=new ArrayList<ResultDTo>();
            for(int i=0;i<sssbcs.length;i++){
                List<ResultDTo> datalist=sssbcs[i].join();
                //Combined execution result
                list.addAll(datalist);
            }
            return list;
        }
    }

    @Override
    public  List<ResultDTo> businessLogic(ParameterDTO mss) throws RuntimeException{
        return new ArrayList<ResultDTo>();
    }

}
