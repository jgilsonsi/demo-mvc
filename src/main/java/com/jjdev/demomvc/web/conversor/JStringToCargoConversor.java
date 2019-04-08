package com.jjdev.demomvc.web.conversor;

import com.jjdev.demomvc.domain.JCargo;
import com.jjdev.demomvc.service.ICargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author jgilson
 */
@Component
public class JStringToCargoConversor implements Converter<String, JCargo> {

    @Autowired
    private ICargoService service;

    @Override
    public JCargo convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long id = Long.parseLong(text);
        return service.buscarPorId(id);
    }

}
