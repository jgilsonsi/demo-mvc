package com.jjdev.demomvc.web.error;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jgilson
 */
public class JMyErrorView implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
        // map.forEach((k, v) -> System.out.println(k + ":" + v + '\n'));

        ModelAndView model = new ModelAndView("/error");
        model.addObject("status", status.value());
        switch (status.value()) {
            case 404:
                model.addObject("error", "Página não encontrada.");
                model.addObject("message", "A URL da página '" + map.get("path") + "' não existe.");
                break;

            case 500:
                model.addObject("error", "Ocorreu um erro interno no servidor.");
                model.addObject("message", "Ocorreu um erro inesperado, entre mais tarde.");
                break;

            default:
                model.addObject("error", map.get("error"));
                model.addObject("message", map.get("message"));
                break;
        }

        return model;
    }
}
