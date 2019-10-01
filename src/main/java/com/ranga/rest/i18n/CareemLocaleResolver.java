package com.ranga.rest.i18n;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author RANGA
 */
public class CareemLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getHeader("DefaultLanguage");
        return (StringUtils.isEmpty(language)) ? Locale.ENGLISH : Locale.forLanguageTag(language);
    }


    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        throw new UnsupportedOperationException("Can not change locale. locale is set as part of ApiContext");
    }
}
