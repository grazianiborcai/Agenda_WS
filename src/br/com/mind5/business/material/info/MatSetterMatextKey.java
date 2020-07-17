package br.com.mind5.business.material.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatSetterMatextKey extends InfoSetterTemplate<MatInfo> {
	
	@Override protected MatInfo setAttrHook(MatInfo recordInfo) {
		if (recordInfo.matextes == null)
			return recordInfo;
		
		for (MatextInfo eachMatext : recordInfo.matextes) {
			eachMatext.codOwner = recordInfo.codOwner;
			eachMatext.codMat = recordInfo.codMat;
			eachMatext.username = recordInfo.username;
		}
		
		return recordInfo;
	}
}
