package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowotarchSetterCalmonth extends InfoSetterTemplate<SowotarchInfo> {
	
	@Override protected SowotarchInfo setAttrHook(SowotarchInfo recordInfo) {
		SowotarchInfo result = new SowotarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.calmonth = recordInfo.calmonth;
		result.username = recordInfo.username;

		return result;
	}
}
