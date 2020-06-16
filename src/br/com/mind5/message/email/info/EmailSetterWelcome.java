package br.com.mind5.message.email.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.EmailBody;

public final class EmailSetterWelcome extends InfoSetterTemplate<EmailInfo> {
	
	@Override protected EmailInfo setAttrHook(EmailInfo recordInfo) {	
		recordInfo.bodyData.codBody = EmailBody.WELCOME.getCodBody();		
		return recordInfo;
	}
}
