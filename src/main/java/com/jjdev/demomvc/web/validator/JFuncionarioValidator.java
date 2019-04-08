package com.jjdev.demomvc.web.validator;

import com.jjdev.demomvc.domain.JFuncionario;
import java.time.LocalDate;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author jgilson
 */
public class JFuncionarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return JFuncionario.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        JFuncionario f = (JFuncionario) obj;

        LocalDate entrada = f.getDataEntrada();

        if (f.getDataSaida() != null) {
            if (f.getDataSaida().isBefore(entrada)) {
                errors.rejectValue("dataSaida", "PosteriosDataEntrada.funcionario.dataSaida");
            }
        }
    }
}
