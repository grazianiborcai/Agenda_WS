package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowusarchSetterCalmonth extends InfoSetterTemplate<SowusarchInfo> {
	
	@Override protected SowusarchInfo setAttrHook(SowusarchInfo recordInfo) {
		SowusarchInfo result = new SowusarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.calmonth = recordInfo.calmonth;
		result.username = recordInfo.username;

		return result;
	}
}
