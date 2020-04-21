package br.com.mind5.business.materialText.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatextSetterCreatedBy extends InfoSetterTemplate<MatextInfo> {
	
	@Override protected MatextInfo setAttrHook(MatextInfo recordInfo) {		
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
