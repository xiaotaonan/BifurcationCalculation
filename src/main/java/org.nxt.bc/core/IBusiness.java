package org.nxt.bc.core;

import org.nxt.bc.dto.ParameterDTO;
import org.nxt.bc.dto.ResultDTo;

import java.util.List;

/**
 * Business logic processing interface
 *
 * @author nxt
 * @since 2019-07-24 14:22:54
 */
public interface IBusiness {

    /**
     * Business logic processing
     * @param mss
     * @return
     * @throws RuntimeException
     */
    public List<ResultDTo> businessLogic(ParameterDTO mss)throws RuntimeException;


}
