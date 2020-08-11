package br.com.mind5.security.jwtToken.info;

import java.time.format.DateTimeFormatter;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class JwtokenSetterCreatedOn extends InfoSetterTemplate<JwtokenInfo> {
	
	@Override protected JwtokenInfo setAttrHook(JwtokenInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss"); 
		recordInfo.createdOnStr = formatter.format(recordInfo.createdOn);  
		
		return recordInfo;
	}
}
