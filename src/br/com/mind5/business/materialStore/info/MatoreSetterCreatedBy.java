package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoreSetterCreatedBy extends InfoSetterTemplate<MatoreInfo> {
	
	@Override protected MatoreInfo setAttrHook(MatoreInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
	
}
