package br.com.mind5.business.materialMovement.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatmovSetterCreatedOn extends InfoSetterTemplate<MatmovInfo> {
	
	@Override protected MatmovInfo setAttrHook(MatmovInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
