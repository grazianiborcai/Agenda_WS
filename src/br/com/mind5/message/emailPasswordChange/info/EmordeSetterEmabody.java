package br.com.mind5.message.emailPasswordChange.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmordeSetterEmabody extends InfoSetterTemplate<EmordeInfo> {
	
	@Override protected EmordeInfo setAttrHook(EmordeInfo recordInfo) {	
		recordInfo.bodyData = new EmabodyInfo();
		
		recordInfo.recipientAddr = recordInfo.persolisData.email;
		recordInfo.bodyData.codLanguage = recordInfo.codLanguage;		
		recordInfo.bodyData.username = recordInfo.username;			
		recordInfo.bodyData.param01 = recordInfo.persolisData.name;
		
		return recordInfo;
	}
}
