package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowedularchSetterCalmonth extends InfoSetterTemplate<SowedularchhInfo> {
	
	@Override protected SowedularchhInfo setAttrHook(SowedularchhInfo recordInfo) {
		SowedularchhInfo result = new SowedularchhInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.calmonth = recordInfo.calmonth;
		result.username = recordInfo.username;

		return result;
	}
}
