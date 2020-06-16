package br.com.mind5.message.emailUserOtp.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmusotpSetterEmabody extends InfoSetterTemplate<EmusotpInfo> {
	
	@Override protected EmusotpInfo setAttrHook(EmusotpInfo recordInfo) {	
		recordInfo.bodyData = new EmabodyInfo();
		
		recordInfo.bodyData.codLanguage = recordInfo.codLanguage;		
		recordInfo.bodyData.username = recordInfo.username;			
		recordInfo.bodyData.param01 = recordInfo.password;
		
		return recordInfo;
	}
}
