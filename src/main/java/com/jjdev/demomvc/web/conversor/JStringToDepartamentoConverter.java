package com.jjdev.demomvc.web.conversor;

import com.jjdev.demomvc.domain.JDepartamento;
import com.jjdev.demomvc.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author jgilson
 */
@Component
public class JStringToDepartamentoConverter implements Converter<String, JDepartamento> {

    @Autowired
    private IDepartamentoService service;

    @Override
    public JDepartamento convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }

}
