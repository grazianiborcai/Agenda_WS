package br.com.mind5.business.material.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatSetterCreatedBy extends InfoSetterTemplate<MatInfo> {
	
	@Override protected MatInfo setAttrHook(MatInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
