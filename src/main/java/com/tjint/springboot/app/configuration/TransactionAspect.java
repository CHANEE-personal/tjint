package com.tjint.springboot.app.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@RequiredArgsConstructor
public class TransactionAspect {

	private final PlatformTransactionManager platformTransactionManager;

	@Bean
	public TransactionInterceptor transactionAdvice() {
		NameMatchTransactionAttributeSource txAttributeSource = new NameMatchTransactionAttributeSource();
		RuleBasedTransactionAttribute txAttribute = new RuleBasedTransactionAttribute();

		txAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		txAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		ConcurrentHashMap<String, TransactionAttribute> txMethods = new ConcurrentHashMap<String, TransactionAttribute>();
		txMethods.put("*", txAttribute);
		txAttributeSource.setNameMap(txMethods);

		return new TransactionInterceptor(platformTransactionManager, txAttributeSource);
	}

	@Bean
	public Advisor transactionAdviceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* com.tjint.springboot..service.*.*(..))");
		return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
	}
}
