package br.com.mind5.masterData.materialGroupOwner.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatoupowSetterCreatedOn extends InfoSetterTemplate<MatoupowInfo> {
	
	@Override protected MatoupowInfo setAttrHook(MatoupowInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
