package br.com.mind5.message.emailWelcome.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmacomeSetterEmabody extends InfoSetterTemplate<EmacomeInfo> {
	
	@Override protected EmacomeInfo setAttrHook(EmacomeInfo recordInfo) {	
		recordInfo.bodyData = new EmabodyInfo();
		
		recordInfo.recipientAddr = recordInfo.persolisData.email;
		recordInfo.bodyData.codLanguage = recordInfo.codLanguage;		
		recordInfo.bodyData.username = recordInfo.username;			
		recordInfo.bodyData.param01 = recordInfo.persolisData.name;
		recordInfo.bodyData.param02 = recordInfo.password;
		recordInfo.bodyData.param03 = recordInfo.username;
		recordInfo.bodyData.param04 = recordInfo.ownelisData.codOwner + " - " + recordInfo.ownelisData.complisData.name;
		
		return recordInfo;
	}
}
