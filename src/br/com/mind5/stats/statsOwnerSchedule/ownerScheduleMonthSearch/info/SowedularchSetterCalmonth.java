package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowedularchSetterCalmonth extends InfoSetterTemplate<SowedularchInfo> {
	
	@Override protected SowedularchInfo setAttrHook(SowedularchInfo recordInfo) {
		SowedularchInfo result = new SowedularchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.calmonth = recordInfo.calmonth;
		result.username = recordInfo.username;

		return result;
	}
}
