package br.com.mind5.message.email.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmailSetterEmabody extends InfoSetterTemplate<EmailInfo> {
	
	@Override protected EmailInfo setAttrHook(EmailInfo recordInfo) {	
		recordInfo.bodyData.codLanguage = recordInfo.codLanguage;		
		recordInfo.bodyData.username = recordInfo.username;	
		
		return recordInfo;
	}
}
