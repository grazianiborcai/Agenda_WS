package br.com.mind5.business.refundPolicyStore.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class RefuporeSetterCreatedBy extends InfoSetterTemplate<RefuporeInfo> {
	
	@Override protected RefuporeInfo setAttrHook(RefuporeInfo recordInfo) {		
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
