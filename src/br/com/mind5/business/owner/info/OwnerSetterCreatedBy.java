package br.com.mind5.business.owner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OwnerSetterCreatedBy extends InfoSetterTemplate<OwnerInfo> {
	
	@Override protected OwnerInfo setAttrHook(OwnerInfo recordInfo) {
		recordInfo.createdBy = recordInfo.codUser;		
		return recordInfo;
	}
}
