package com.chad.cloud.filters;

import com.alibaba.cloud.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class CheckAuthGatewayFilterFactory extends AbstractGatewayFilterFactory<CheckAuthGatewayFilterFactory.Config> {
	public CheckAuthGatewayFilterFactory() {
		super(CheckAuthGatewayFilterFactory.Config.class);
	}
	
	public GatewayFilter apply(CheckAuthGatewayFilterFactory.Config config) {
		return new GatewayFilter() {
			public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
				String name = exchange.getRequest().getQueryParams().getFirst("name");
				if (StringUtils.isNotBlank(name)) {
					System.out.println(config.name);
					if (config.getName().equals(name)) {
						System.out.println("if");
						return chain.filter(exchange);
					} else {
						System.out.println("else");
						exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
						return exchange.getResponse().setComplete();
					}
				}
				return chain.filter(exchange);
			}
		};
	}
	
	public static class Config {
		private String name;
		
		public Config() {
		}
		
		public String getName() {
			return this.name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
}

