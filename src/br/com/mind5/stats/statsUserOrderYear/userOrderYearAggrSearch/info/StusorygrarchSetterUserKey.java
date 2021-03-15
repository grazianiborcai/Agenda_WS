package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StusorygrarchSetterUserKey extends InfoSetterTemplate<StusorygrarchInfo> {
	
	@Override protected StusorygrarchInfo setAttrHook(StusorygrarchInfo recordInfo) {
		StusorygrarchInfo result = new StusorygrarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codUser = recordInfo.codUser;
		result.username = recordInfo.username;
		
		return result;
	}
}
