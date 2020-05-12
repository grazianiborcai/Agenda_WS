package br.com.mind5.message.email.info;

import br.com.mind5.business.masterData.info.common.EmailBody;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmailSetterWelcome extends InfoSetterTemplate<EmailInfo> {
	
	@Override protected EmailInfo setAttrHook(EmailInfo recordInfo) {	
		recordInfo.bodyData.codBody = EmailBody.WELCOME.getCodBody();		
		return recordInfo;
	}
}
