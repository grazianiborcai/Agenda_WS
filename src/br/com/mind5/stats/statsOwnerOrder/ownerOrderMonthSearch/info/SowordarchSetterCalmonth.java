package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowordarchSetterCalmonth extends InfoSetterTemplate<SowordarchInfo> {
	
	@Override protected SowordarchInfo setAttrHook(SowordarchInfo recordInfo) {
		SowordarchInfo result = new SowordarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.calmonth = recordInfo.calmonth;
		result.username = recordInfo.username;

		return result;
	}
}
