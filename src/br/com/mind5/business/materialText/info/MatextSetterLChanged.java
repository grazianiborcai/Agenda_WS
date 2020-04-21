package br.com.mind5.business.materialText.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatextSetterLChanged extends InfoSetterTemplate<MatextInfo> {
	
	@Override protected MatextInfo setAttrHook(MatextInfo recordInfo) {	
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
