package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StusorygeSetterLChanged extends InfoSetterTemplate<StusorygeInfo> {
	
	@Override protected StusorygeInfo setAttrHook(StusorygeInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
