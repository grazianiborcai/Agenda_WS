package br.com.mind5.business.refundPolicyStore.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class RefuporeSetterLChanged extends InfoSetterTemplate<RefuporeInfo> {
	
	@Override protected RefuporeInfo setAttrHook(RefuporeInfo recordInfo) {	
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
