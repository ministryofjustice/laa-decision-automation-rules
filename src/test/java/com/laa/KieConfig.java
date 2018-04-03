package com.laa;

import java.io.IOException;

import org.drools.core.SessionConfigurationImpl;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.spring.KModuleBeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KieConfig {


	

	@Bean
	@ConditionalOnMissingBean(KieContainer.class)
	public KieContainer kieContainer() throws IOException {
		
		return KieServices.Factory.get().getKieClasspathContainer();
	}

	@Bean(name="civilDecision")
	public StatelessKieSession decisionSession() throws IOException {
		return kieContainer().newStatelessKieSession("civilDecision");
	}
	


	@Bean
	@ConditionalOnMissingBean(KModuleBeanFactoryPostProcessor.class)
	public KModuleBeanFactoryPostProcessor kiePostProcessor() {
		return new KModuleBeanFactoryPostProcessor();
	}

}
