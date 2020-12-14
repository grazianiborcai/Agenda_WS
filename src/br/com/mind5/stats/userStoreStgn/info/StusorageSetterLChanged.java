package br.com.mind5.stats.userStoreStgn.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StusorageSetterLChanged extends InfoSetterTemplate<StusorageInfo> {
	
	@Override protected StusorageInfo setAttrHook(StusorageInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
