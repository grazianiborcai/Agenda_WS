package br.com.mind5.masterData.refundPolicyGroup.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.Refugrader;

public final class RefugroupSetterDefault extends InfoSetterTemplate<RefugroupInfo> {
	
	@Override protected RefugroupInfo setAttrHook(RefugroupInfo recordInfo) {
		recordInfo.codRefundPolicyGroup = Refugrader.BEFORE_24_HOURS.getCodRefundPolicyGroup();
		return recordInfo;
	}
}
