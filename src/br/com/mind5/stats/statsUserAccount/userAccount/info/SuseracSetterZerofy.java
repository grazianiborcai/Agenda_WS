package br.com.mind5.stats.statsUserAccount.userAccount.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SuseracSetterZerofy extends InfoSetterTemplate<SuseracInfo> {
	
	@Override protected SuseracInfo setAttrHook(SuseracInfo recordInfo) {
		recordInfo.countUserCreatedMonth = 0;
		recordInfo.countUserActiveMonth = 0;
		recordInfo.countUserInactiveMonth = 0;
		recordInfo.countOrderMonth = 0;
		recordInfo.userEngagementMonth = 0;	
		recordInfo.countUserCreatedMonthLastYear = 0;
		recordInfo.countUserActiveMonthLastYear = 0;
		recordInfo.countUserInactiveMonthLastYear = 0;
		recordInfo.userEngagementMonthLastYear = 0;	
		recordInfo.countOrderMonthLastYear = 0;
		recordInfo.countUserCreatedVar = 0;
		recordInfo.countUserActiveVar = 0;
		recordInfo.countUserInactiveVar = 0;	
		recordInfo.countOrderVar = 0;
		recordInfo.userEngagementVar = 0;	
		recordInfo.countUserCreatedCumulative = 0;
		recordInfo.countUserActiveCumulative = 0;
		recordInfo.countUserInactiveCumulative = 0;	
		recordInfo.countOrderCumulative = 0;
		recordInfo.userEngagementCumulative = 0;

		return recordInfo;
	}
}
