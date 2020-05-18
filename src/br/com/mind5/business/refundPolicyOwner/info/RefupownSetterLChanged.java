package br.com.mind5.business.refundPolicyOwner.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class RefupownSetterLChanged extends InfoSetterTemplate<RefupownInfo> {
	
	@Override protected RefupownInfo setAttrHook(RefupownInfo recordInfo) {	
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
