package com.interceptor.interceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TestInterceptor implements HandlerInterceptor {

    /* Questo metodo viene chiamato prima che il controller inizi a elaborare la richiesta.
     * Viene utilizzato per eseguire azioni come la validazione o la gestione di autorizzazioni prima che la richiesta venga gestita dal controller. */

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Controlla se l'URL della richiesta contiene "/test"
        if (request.getRequestURL().toString().contains("/test")) {
            // Se l'URL contiene "/test", imposta lo status della risposta a 400 (Bad Request)
            response.setStatus(400);
            // Ritorna false per indicare che la richiesta non deve essere gestita ulteriormente
            return false;
        }
        // Ritorna true per indicare che la richiesta può essere gestita normalmente
        return true;
    }

    /* Questo metodo viene chiamato dopo che il controller ha elaborato la richiesta API,
     * ma prima che la risposta venga effettivamente inviata al client. */

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        // Questo metodo può essere utilizzato per modificare il modello e la visualizzazione prima di renderizzare la risposta
    }

    /* Questo metodo viene chiamato dopo che la risposta API è stata inviata al client.
     * È utile per eseguire azioni come il rilascio di risorse o il logging. */

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        // Questo metodo viene chiamato dopo che la richiesta è stata completamente elaborata
    }
}