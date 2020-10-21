package br.com.mind5.message.emailWelcome.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmacomeSetterEmabody extends InfoSetterTemplate<EmacomeInfo> {
	
	@Override protected EmacomeInfo setAttrHook(EmacomeInfo recordInfo) {	
		recordInfo.bodyData = new EmabodyInfo();
		
		recordInfo = addGeneralData(recordInfo);
		recordInfo = addUserData(recordInfo);
		recordInfo = addOwnerData(recordInfo);		
		
		return recordInfo;
	}
	
	
	
	private EmacomeInfo addGeneralData(EmacomeInfo recordInfo) {
		recordInfo.recipientAddr = recordInfo.persolisData.email;
		recordInfo.bodyData.codLanguage = recordInfo.codLanguage;		
		recordInfo.bodyData.username = recordInfo.username;		
		
		return recordInfo;
	}
	
	
	
	private EmacomeInfo addUserData(EmacomeInfo recordInfo) {
		recordInfo.bodyData.param01 = recordInfo.persolisData.name;
		recordInfo.bodyData.param02 = recordInfo.password;
		recordInfo.bodyData.param03 = recordInfo.username;
		
		return recordInfo;
	}
	
	
	
	private EmacomeInfo addOwnerData(EmacomeInfo recordInfo) {
		recordInfo.bodyData.param04 = recordInfo.ownelisData.codOwner + " - " + recordInfo.ownelisData.complisData.name;
		recordInfo.bodyData.param05 = recordInfo.ownelisData.complisData.name;
		
		if (recordInfo.ownelisData.fimistData != null)
			recordInfo.bodyData.param06 = recordInfo.ownelisData.fimistData.fileImgUriExternal;
		
		return recordInfo;
	}
}
