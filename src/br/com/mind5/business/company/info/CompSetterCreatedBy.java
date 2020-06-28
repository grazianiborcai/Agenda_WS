package br.com.mind5.business.company.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CompSetterCreatedBy extends InfoSetterTemplate<CompInfo> {
	
	@Override protected CompInfo setAttrHook(CompInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
