package br.com.mind5.business.materialMovement.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatmovSetterCreatedBy extends InfoSetterTemplate<MatmovInfo> {
	
	@Override protected MatmovInfo setAttrHook(MatmovInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
