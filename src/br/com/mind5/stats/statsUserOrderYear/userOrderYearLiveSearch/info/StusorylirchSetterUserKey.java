package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StusorylirchSetterUserKey extends InfoSetterTemplate<StusorylirchInfo> {
	
	@Override protected StusorylirchInfo setAttrHook(StusorylirchInfo recordInfo) {
		StusorylirchInfo result = new StusorylirchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codUser = recordInfo.codUser;
		result.username = recordInfo.username;
		
		return result;
	}
}
