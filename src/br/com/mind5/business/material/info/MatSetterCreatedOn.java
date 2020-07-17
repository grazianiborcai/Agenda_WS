package br.com.mind5.business.material.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatSetterCreatedOn extends InfoSetterTemplate<MatInfo> {
	
	@Override protected MatInfo setAttrHook(MatInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
