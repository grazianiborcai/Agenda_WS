package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedineSetterOrderKey extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		SchedineInfo enforcedInfo = new SchedineInfo();
		
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.codOrder = recordInfo.codOrder;
		enforcedInfo.codLanguage = recordInfo.codLanguage;
		enforcedInfo.username = recordInfo.username;
		
		return enforcedInfo;
	}
}
