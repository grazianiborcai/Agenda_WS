package br.com.mind5.message.emailProspectStore.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmaproreSetterEmabody extends InfoSetterTemplate<EmaproreInfo> {
	
	@Override protected EmaproreInfo setAttrHook(EmaproreInfo recordInfo) {	
		recordInfo.bodyData = new EmabodyInfo();
		
		recordInfo.bodyData.codLanguage = recordInfo.codLanguage;		
		recordInfo.bodyData.username = recordInfo.username;			
		recordInfo.bodyData.param01 = recordInfo.password;
		
		return recordInfo;
	}
}
