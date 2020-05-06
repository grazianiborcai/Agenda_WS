package br.com.mind5.business.refundPolicyOwner.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.Refupo;

public final class RefupownSetterDefault extends InfoSetterTemplate<RefupownInfo> {
	
	@Override protected RefupownInfo setAttrHook(RefupownInfo recordInfo) {
		recordInfo.codRefundPolicy = Refupo.BEFORE_24_HOURS.getRefundPolicy();
		return recordInfo;
	}
}
