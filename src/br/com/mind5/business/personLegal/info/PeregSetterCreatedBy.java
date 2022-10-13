package br.com.mind5.business.personLegal.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PeregSetterCreatedBy extends InfoSetterTemplate<PeregInfo> {
	
	@Override protected PeregInfo setAttrHook(PeregInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
