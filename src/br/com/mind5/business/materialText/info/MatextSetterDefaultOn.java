package br.com.mind5.business.materialText.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatextSetterDefaultOn extends InfoSetterTemplate<MatextInfo> {
	
	@Override protected MatextInfo setAttrHook(MatextInfo recordInfo) {	
		recordInfo.isDefault = true;
		return recordInfo;
	}
}
