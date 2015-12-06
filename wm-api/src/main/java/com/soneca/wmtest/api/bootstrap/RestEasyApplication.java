/*
 *
 *  *
 *  *  *
 *  *  *  * Copyright (c) 2015, 2016, Reclameaqui e/ou seus afiliados. Todos os direitos reservados.
 *  *  *  *
 *  *  *  * Redistribuicao e uso do codigo fonte e/ou  binarios, com ou sem
 *  *  *  * modificacoes, nao estao autorizados
 *  *  *
 *  *
 *
 */

package com.soneca.wmtest.api.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Classe de inicialização do resteasy
 * @author andre
 * @since 23/06/2015 18:33
 */
@ApplicationPath("/")
public class RestEasyApplication extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(RestEasyApplication.class);

    public RestEasyApplication() {
        LOG.debug("RestEasyApplication starts...");
    }



}

