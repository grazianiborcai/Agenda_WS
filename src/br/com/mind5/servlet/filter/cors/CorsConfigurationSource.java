package br.com.mind5.servlet.filter.cors;

import javax.ws.rs.HttpMethod;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public final class CorsConfigurationSource extends UrlBasedCorsConfigurationSource {
	public CorsConfigurationSource() {
		super();
		
		registerCorsConfiguration("/**", getCorsConfig());
	}
	
	
	
	private CorsConfiguration getCorsConfig() {
		long maxAge = 3600;
		CorsConfiguration config = new CorsConfiguration();		
		
		config.addAllowedHeader("*"); 					// Exemplo: Origin, X-Requested-With, Content-Type, Accept, Key, Authorization
		config.addAllowedMethod(HttpMethod.GET);
		config.addAllowedMethod(HttpMethod.POST);
		config.addAllowedMethod(HttpMethod.DELETE);
		config.addAllowedOrigin("*");					// Exemplo: http://localhost:3000
		config.setAllowCredentials(true);
		config.setMaxAge(maxAge);
		
		return config;
	}
}
