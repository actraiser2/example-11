package com.santalucia.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.Generated;
import lombok.extern.slf4j.Slf4j;

/**
 * Application
 * Hay que incluir @Generated para evitar que compute en cobertura
 */
@Generated
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class Application {

    /**
     * Carga del aplicativo
     *
     * @param String[] args
     */
	
	static {
		//System.setProperty("javax.net.debug", "all");
		//System.setProperty("jdk.tls.client.protocols", "TLSv1.3");
	}
    public static void main(String[] args) {
        log.info("jdk.tracePinnedThreads: {}", System.getProperty("jdk.tracePinnedThreads"));
        log.info("jdk.fileEncoding: {}", System.getProperty("file.encoding"));
    	new SpringApplicationBuilder(Application.class)
                //.applicationStartup(new BufferingApplicationStartup(ByteSizeConstants.TWO_KB.intValue()))
                .run(args);
    }
}
