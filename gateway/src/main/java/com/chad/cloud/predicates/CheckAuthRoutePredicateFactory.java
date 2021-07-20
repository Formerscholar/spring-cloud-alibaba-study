package com.chad.cloud.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {
	public CheckAuthRoutePredicateFactory() {
		super(CheckAuthRoutePredicateFactory.Config.class);
	}
	
	public List<String> shortcutFieldOrder() {
		return Arrays.asList("name");
	}
	
	public Predicate<ServerWebExchange> apply(CheckAuthRoutePredicateFactory.Config config) {
		return new GatewayPredicate() {
			public boolean test(ServerWebExchange exchange) {
				if (config.getName().equals("chad")) {
					return true;
				}
				return false;
			}
			
		};
	}
	
	@Validated
	public static class Config {
		private String name;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
}
