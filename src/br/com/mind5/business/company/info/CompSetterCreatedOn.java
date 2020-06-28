package br.com.mind5.business.company.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CompSetterCreatedOn extends InfoSetterTemplate<CompInfo> {
	
	@Override protected CompInfo setAttrHook(CompInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
