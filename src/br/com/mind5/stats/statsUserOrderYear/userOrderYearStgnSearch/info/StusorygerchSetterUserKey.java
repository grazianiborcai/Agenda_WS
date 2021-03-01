package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StusorygerchSetterUserKey extends InfoSetterTemplate<StusorygerchInfo> {
	
	@Override protected StusorygerchInfo setAttrHook(StusorygerchInfo recordInfo) {
		StusorygerchInfo result = new StusorygerchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codUser = recordInfo.codUser;
		result.username = recordInfo.username;
		
		return result;
	}
}
