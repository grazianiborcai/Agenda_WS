package br.com.mind5.business.materialStock.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatockSetterLChanged extends InfoSetterTemplate<MatockInfo> {
	
	@Override protected MatockInfo setAttrHook(MatockInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
