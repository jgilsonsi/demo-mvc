package com.jjdev.demomvc.web.conversor;

import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author jgilson
 */
public class JStringToInteger implements Converter<String, Integer> {

    @Override
    public Integer convert(String text) {
        text = text.trim();
        if (text.matches("[0-9]+")) {
            return Integer.valueOf(text);
        }
        return null;
    }

}
