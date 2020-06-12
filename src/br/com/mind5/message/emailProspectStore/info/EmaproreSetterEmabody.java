package br.com.mind5.message.emailProspectStore.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmaproreSetterEmabody extends InfoSetterTemplate<EmaproreInfo> {
	
	@Override protected EmaproreInfo setAttrHook(EmaproreInfo recordInfo) {	
		recordInfo.bodyData = new EmabodyInfo();
		
		recordInfo.bodyData.codLanguage = recordInfo.codLanguage;		
		recordInfo.bodyData.username = recordInfo.username;			
		recordInfo.bodyData.param01 = "1";
		recordInfo.bodyData.param02 = recordInfo.password;
		recordInfo.bodyData.param03 = recordInfo.username;
		recordInfo.bodyData.param04 = "2";
		
		return recordInfo;
	}
}
