package br.com.mind5.business.refundPolicyOwner.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class RefupownSetterCreatedOn extends InfoSetterTemplate<RefupownInfo> {
	
	@Override protected RefupownInfo setAttrHook(RefupownInfo recordInfo) {	
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
