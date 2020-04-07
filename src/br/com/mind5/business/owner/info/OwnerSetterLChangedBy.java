package br.com.mind5.business.owner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OwnerSetterLChangedBy extends InfoSetterTemplate<OwnerInfo> {
	
	@Override protected OwnerInfo setAttrHook(OwnerInfo recordInfo) {
		recordInfo.lastChangedBy = recordInfo.codUser;		
		return recordInfo;
	}
}
