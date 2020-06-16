package br.com.mind5.message.email.info;

import br.com.mind5.business.masterData.info.common.EmailBody;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmailSetterUserOtp extends InfoSetterTemplate<EmailInfo> {
	
	@Override protected EmailInfo setAttrHook(EmailInfo recordInfo) {	
		recordInfo.bodyData.codBody = EmailBody.OTP_USER_PASSWORD.getCodBody();		
		return recordInfo;
	}
}
