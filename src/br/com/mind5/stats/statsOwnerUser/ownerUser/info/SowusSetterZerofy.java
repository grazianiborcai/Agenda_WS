package br.com.mind5.stats.statsOwnerUser.ownerUser.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowusSetterZerofy extends InfoSetterTemplate<SowusInfo> {
	
	@Override protected SowusInfo setAttrHook(SowusInfo recordInfo) {
		recordInfo.countUserCreatedMonth = 0;
		recordInfo.countUserActiveMonth = 0;
		recordInfo.countUserInactiveMonth = 0;
		recordInfo.countOrderMonth = 0;
		recordInfo.userEngagementMonth = 0;	
		recordInfo.countUserCreatedLastYear = 0;
		recordInfo.countUserActiveLastYear = 0;
		recordInfo.countUserInactiveLastYear = 0;
		recordInfo.userEngagementLastYear = 0;	
		recordInfo.countOrderLastYear = 0;
		recordInfo.countUserCreatedVar = 0;
		recordInfo.countUserActiveVar = 0;
		recordInfo.countUserInactiveVar = 0;	
		recordInfo.countOrderVar = 0;
		recordInfo.userEngagementVar = 0;	

		return recordInfo;
	}
}
