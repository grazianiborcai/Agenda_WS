package br.com.mind5.business.refundPolicyOwner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class RefupownSetterCreatedBy extends InfoSetterTemplate<RefupownInfo> {
	
	@Override protected RefupownInfo setAttrHook(RefupownInfo recordInfo) {		
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
