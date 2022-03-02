package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowusSetterZerofy extends InfoSetterTemplate<SowusInfo> {
	
	@Override protected SowusInfo setAttrHook(SowusInfo recordInfo) {
		recordInfo.countUserCreatedMonth = 0;
		recordInfo.countUserActiveMonth = 0;
		recordInfo.countUserInactiveMonth = 0;
		recordInfo.countUserCreatedLastYear = 0;
		recordInfo.countUserActiveLastYear = 0;	
		recordInfo.countUserInactiveLastYear = 0;

		return recordInfo;
	}
}
